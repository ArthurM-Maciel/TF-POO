package dados;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroDrone extends JPanel {
    private JTextField codigoField;
    private JTextField custoField;
    private JTextField pesoField;
    private JTextField quantidadeMaximaField;
    private JButton salvarButton;
    private JButton limparCamposButton;
    private JButton sairButton;

    public CadastroDrone(CardLayout cardLayout, JPanel contentPanel) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Código:"), gbc);
        codigoField = new JTextField(20);
        gbc.gridx = 1;
        add(codigoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Custo:"), gbc);
        custoField = new JTextField(20);
        gbc.gridx = 1;
        add(custoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Peso:"), gbc);
        pesoField = new JTextField(20);
        gbc.gridx = 1;
        add(pesoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Quantidade Máxima de Pessoas:"), gbc);
        quantidadeMaximaField = new JTextField(20);
        gbc.gridx = 1;
        add(quantidadeMaximaField, gbc);

        salvarButton = new JButton("Salvar");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(salvarButton, gbc);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = codigoField.getText();
                String custo = custoField.getText();
                String peso = pesoField.getText();
                String quantidadeMaxima = quantidadeMaximaField.getText();

                // Logic to save drone data
                JOptionPane.showMessageDialog(CadastroDrone.this, "Drone cadastrado com sucesso!");
            }
        });

        limparCamposButton = new JButton("Limpar Campos");
        gbc.gridy = 5;
        add(limparCamposButton, gbc);

        limparCamposButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });

        sairButton = new JButton("Sair");
        gbc.gridy = 6;
        add(sairButton, gbc);

        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(contentPanel, "Main Menu");
            }
        });
    }

    private void limparCampos() {
        codigoField.setText("");
        custoField.setText("");
        pesoField.setText("");
        quantidadeMaximaField.setText("");
    }
}