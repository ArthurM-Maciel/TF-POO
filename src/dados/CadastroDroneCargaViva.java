package dados;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroDroneCargaViva extends JPanel {
    private JTextField codigoField;
    private JTextField custoFixoField;
    private JTextField autonomiaField;
    private JTextField pesoMaximoField;
    private JRadioButton climatizadoSimButton;
    private JRadioButton climatizadoNaoButton;
    private JButton salvarButton;
    private JButton limparCamposButton;
    private JButton sairButton;

    public CadastroDroneCargaViva(CardLayout cardLayout, JPanel contentPanel) {
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
        add(new JLabel("Custo Fixo:"), gbc);
        custoFixoField = new JTextField(20);
        gbc.gridx = 1;
        add(custoFixoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Autonomia:"), gbc);
        autonomiaField = new JTextField(20);
        gbc.gridx = 1;
        add(autonomiaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Peso Máximo:"), gbc);
        pesoMaximoField = new JTextField(20);
        gbc.gridx = 1;
        add(pesoMaximoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Climatizado:"), gbc);
        JPanel climatizadoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        climatizadoSimButton = new JRadioButton("Sim");
        climatizadoNaoButton = new JRadioButton("Não");
        ButtonGroup climatizadoGroup = new ButtonGroup();
        climatizadoGroup.add(climatizadoSimButton);
        climatizadoGroup.add(climatizadoNaoButton);
        climatizadoPanel.add(climatizadoSimButton);
        climatizadoPanel.add(climatizadoNaoButton);
        gbc.gridx = 1;
        add(climatizadoPanel, gbc);

        salvarButton = new JButton("Salvar");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        add(salvarButton, gbc);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = codigoField.getText();
                String custoFixo = custoFixoField.getText();
                String autonomia = autonomiaField.getText();
                String pesoMaximo = pesoMaximoField.getText();
                boolean climatizado = climatizadoSimButton.isSelected();

                // Logic to save drone data
                JOptionPane.showMessageDialog(CadastroDroneCargaViva.this, "Drone de Carga Viva cadastrado com sucesso!");
            }
        });

        limparCamposButton = new JButton("Limpar Campos");
        gbc.gridy = 6;
        add(limparCamposButton, gbc);

        limparCamposButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });

        sairButton = new JButton("Sair");
        gbc.gridy = 7;
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
        custoFixoField.setText("");
        autonomiaField.setText("");
        pesoMaximoField.setText("");
        climatizadoSimButton.setSelected(false);
        climatizadoNaoButton.setSelected(false);
    }
}
