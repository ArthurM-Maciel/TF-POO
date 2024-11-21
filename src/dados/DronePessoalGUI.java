import javax.swing.*;
import java.awt.*;

public class DronePessoalGUI extends JFrame {
    private final Drones droneService = new Drones();
    private final JTextField codigoField = new JTextField(10);
    private final JTextField modeloField = new JTextField(20);
    private final JTextArea mensagensArea = new JTextArea(10, 30);

    public DronePessoalGUI() {
        setTitle("Cadastro de Drone Pessoal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());


        ImageIcon icon = new ImageIcon("src/droneIcon.png");
        setIconImage(icon.getImage());


        panel.add(new JLabel("Código:"));
        panel.add(codigoField);

        panel.add(new JLabel("Modelo:"));
        panel.add(modeloField);

        JButton cadastrarButton = new JButton("Cadastrar");
        JButton limparButton = new JButton("Limpar");
        JButton mostrarButton = new JButton("Mostrar Drones");
        JButton sairButton = new JButton("Sair");

        panel.add(cadastrarButton);
        panel.add(limparButton);
        panel.add(mostrarButton);
        panel.add(sairButton);

        panel.setBackground(Color.lightGray);
        add(panel);

        mensagensArea.setEditable(false);
        panel.add(new JScrollPane(mensagensArea));

        cadastrarButton.addActionListener(e -> cadastrarDrone());

        limparButton.addActionListener(e -> limparCampos());

        mostrarButton.addActionListener(e -> mostrarDrones());

        sairButton.addActionListener(e -> System.exit(0));


        setLocationRelativeTo(null);
        setResizable(false);
        setSize(500,300);
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
            if(codigoField.getText().isBlank())
                mensagensArea.setText("Erro: O código do drone não pode estar vazio.");
        }
    }

    private void limparCampos() {
        codigoField.setText(" ");
        modeloField.setText(" ");
        mensagensArea.setText(" ");
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

}
