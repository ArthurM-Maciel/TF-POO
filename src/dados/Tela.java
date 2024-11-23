package dados;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela extends JFrame {
    private CadastroTransporte cadastroTransporte;
    private JTextArea displayArea;

    public Tela() {
        cadastroTransporte = new CadastroTransporte();
        setTitle("Sistema de Transporte");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JButton cadastrarTransporteButton = new JButton("Cadastrar Transporte");
        cadastrarTransporteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarTransporte();
            }
        });
        panel.add(cadastrarTransporteButton);

        JButton mostrarTransportesButton = new JButton("Mostrar Transportes");
        mostrarTransportesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarTransportes();
            }
        });
        panel.add(mostrarTransportesButton);

        add(panel, BorderLayout.SOUTH);
    }

    private void cadastrarTransporte() {
        String nomeCliente = JOptionPane.showInputDialog(this, "Nome do Cliente:");
        String numero = JOptionPane.showInputDialog(this, "Número:");
        String descricao = JOptionPane.showInputDialog(this, "Descrição:");
        String peso = JOptionPane.showInputDialog(this, "Peso:");

        String resultado = cadastroTransporte.cadastrarTransporte(nomeCliente, numero, descricao, peso);
        displayArea.setText(resultado);
    }

    private void mostrarTransportes() {
        String pendentes = cadastroTransporte.mostrarTransportesPendentes();
        String cadastrados = cadastroTransporte.mostrarTransportes();
        displayArea.setText(pendentes + "\n" + cadastrados);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }
}