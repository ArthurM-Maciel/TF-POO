package dados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Tela extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JLabel codDrone;
    private JLabel custoDrone;
    private JLabel autonomiaDrone;
    private JLabel pesoDrone;
    private JLabel protecaoDrone;
    private JTextArea areaDeTexto;
    private JButton cadastrarButton;
    private JButton limparButton;
    private JButton mostrarDadosButton;
    private JButton sairButton;
    private JRadioButton cargaInanimadaRadioButton;
    private JRadioButton cargaVivaRadioButton;
    private ButtonGroup doisBotoes;

    private final Drones droneService = new Drones();
    private final JTextField codigoField = new JTextField(10);
    private final JTextField modeloField = new JTextField(20);
    private final JTextArea mensagensArea = new JTextArea(10, 30);

    private ArrayList<CadastroDrone> drones = new ArrayList<>();

    public Tela() {
        setTitle("Cadastro de Drone Pessoal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());

        ImageIcon icon = new ImageIcon("src/droneIcon.png");
        setIconImage(icon.getImage());

        panel1.add(new JLabel("Código:"));
        panel1.add(codigoField);

        panel1.add(new JLabel("Modelo:"));
        panel1.add(modeloField);

        cadastrarButton = new JButton("Cadastrar");
        limparButton = new JButton("Limpar");
        mostrarDadosButton = new JButton("Mostrar Drones");
        sairButton = new JButton("Sair");

        panel1.add(cadastrarButton);
        panel1.add(limparButton);
        panel1.add(mostrarDadosButton);
        panel1.add(sairButton);

        panel1.setBackground(Color.lightGray);
        add(panel1);

        mensagensArea.setEditable(false);
        panel1.add(new JScrollPane(mensagensArea));

        cadastrarButton.addActionListener(e -> cadastrarDrone());
        limparButton.addActionListener(e -> limparCampos());
        mostrarDadosButton.addActionListener(e -> mostrarDrones());
        sairButton.addActionListener(e -> System.exit(0));

        setLocationRelativeTo(null);
        setResizable(false);
        setSize(500, 300);
    }

    private void cadastrarDrone() {
        try {
            int codigo = Integer.parseInt(codigoField.getText());
            String modelo = modeloField.getText().trim();

            if (modelo.isEmpty()) {
                mensagensArea.setText("Erro: O modelo do drone não pode estar vazio.");
                return;
            }

            DronePessoal novoDrone = new DronePessoal(codigo, modelo);
            if (droneService.cadastrarDrone(novoDrone)) {
                mensagensArea.setText("Drone cadastrado com sucesso!\n" + novoDrone);
            } else {
                mensagensArea.setText("Erro: Já existe um drone com o código " + codigo + ".");
            }
        } catch (NumberFormatException e) {
            mensagensArea.setText("Erro: O código deve ser um número inteiro.");
            if (codigoField.getText().isBlank())
                mensagensArea.setText("Erro: O código do drone não pode estar vazio.");
        }
    }

    private void limparCampos() {
        codigoField.setText("");
        modeloField.setText("");
        mensagensArea.setText("");
    }

    private void mostrarDrones() {
        if (droneService.isVazio()) {
            mensagensArea.setText("Nenhum drone cadastrado.");
        } else {
            StringBuilder sb = new StringBuilder("Drones cadastrados:\n");
            for (DronePessoal drone : droneService.listarDrones()) {
                sb.append(drone).append("\n");
            }
            mensagensArea.setText(sb.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Tela frame = new Tela();
            frame.setVisible(true);
        });
    }
}