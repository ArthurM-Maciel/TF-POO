package dados;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Tela extends JFrame {
    private JTextField nomeClienteField;
    private JTextField numeroTransporteField;
    private JTextField descricaoTransporteField;
    private JTextField pesoField;
    private JTextArea mensagensArea;
    private CadastroTransporte cadastroTransporte;
    private CardLayout cardLayout;
    private JPanel contentPanel;
    private JLabel tituloLabel;

    public Tela() {
        setTitle("Cadastro de Novo Transporte");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        cadastroTransporte = new CadastroTransporte();

        tituloLabel = new JLabel("MENU", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tituloLabel.setForeground(Color.BLUE);
        add(tituloLabel, BorderLayout.NORTH);

        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);
        contentPanel.setBackground(Color.WHITE);
        add(contentPanel, BorderLayout.CENTER);

        JPanel menuPanel = new JPanel(new GridBagLayout());
        menuPanel.setBackground(Color.LIGHT_GRAY);
        menuPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        GridBagConstraints gbcMenu = new GridBagConstraints();
        gbcMenu.insets = new Insets(5, 5, 5, 5);
        gbcMenu.fill = GridBagConstraints.HORIZONTAL;

        JButton cadastrarButton = new JButton("Cadastrar Novo Transporte");
        gbcMenu.gridx = 0;
        gbcMenu.gridy = 0;
        menuPanel.add(cadastrarButton, gbcMenu);

        JButton cadastrarDroneButton = new JButton("Cadastrar Drone Pessoal");
        gbcMenu.gridx = 0;
        gbcMenu.gridy = 1;
        menuPanel.add(cadastrarDroneButton, gbcMenu);

        JButton cadastrarDroneCargaVivaButton = new JButton("Cadastrar Drone de Carga Viva");
        gbcMenu.gridx = 0;
        gbcMenu.gridy = 2;
        menuPanel.add(cadastrarDroneCargaVivaButton, gbcMenu);

        JButton cadastrarDroneCargaInanimadaButton = new JButton("Cadastrar Drone de Carga Inanimada");
        gbcMenu.gridx = 0;
        gbcMenu.gridy = 3;
        menuPanel.add(cadastrarDroneCargaInanimadaButton, gbcMenu);

        JButton pendentesButton = new JButton("Transportes Pendentes");
        gbcMenu.gridx = 0;
        gbcMenu.gridy = 4;
        menuPanel.add(pendentesButton, gbcMenu);

        JButton cadastradosButton = new JButton("Transportes Cadastrados");
        gbcMenu.gridx = 0;
        gbcMenu.gridy = 5;
        menuPanel.add(cadastradosButton, gbcMenu);

        JButton processarButton = new JButton("Processar Transportes");
        gbcMenu.gridx = 0;
        gbcMenu.gridy = 6;
        menuPanel.add(processarButton, gbcMenu);

        JButton relatorioGeralButton = new JButton("Mostrar Relatório Geral");
        gbcMenu.gridx = 0;
        gbcMenu.gridy = 7;
        menuPanel.add(relatorioGeralButton, gbcMenu);

        JButton alterarSituacaoButton = new JButton("Alterar Situação de Transporte");
        gbcMenu.gridx = 0;
        gbcMenu.gridy = 9;
        menuPanel.add(alterarSituacaoButton, gbcMenu);

        JButton sairButton = new JButton("Sair");
        gbcMenu.gridx = 0;
        gbcMenu.gridy = 8;
        menuPanel.add(sairButton, gbcMenu);

        JPanel mainMenuPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcMain = new GridBagConstraints();
        gbcMain.insets = new Insets(10, 10, 10, 10);
        gbcMain.fill = GridBagConstraints.BOTH;
        gbcMain.gridx = 0;
        gbcMain.gridy = 0;
        gbcMain.weightx = 1;
        gbcMain.weighty = 1;
        gbcMain.anchor = GridBagConstraints.CENTER;
        mainMenuPanel.add(menuPanel, gbcMain);

        contentPanel.add(mainMenuPanel, "Main Menu");

        JPanel painelCadastro = new JPanel(new GridBagLayout());
        painelCadastro.setBackground(Color.WHITE);
        GridBagConstraints gbcCadastro = new GridBagConstraints();
        gbcCadastro.insets = new Insets(10, 10, 10, 10);
        gbcCadastro.fill = GridBagConstraints.HORIZONTAL;

        gbcCadastro.gridx = 0;
        gbcCadastro.gridy = 0;
        painelCadastro.add(new JLabel("Nome do Cliente:"), gbcCadastro);
        nomeClienteField = new JTextField(20);
        gbcCadastro.gridx = 1;
        painelCadastro.add(nomeClienteField, gbcCadastro);

        gbcCadastro.gridx = 0;
        gbcCadastro.gridy = 1;
        painelCadastro.add(new JLabel("Número do Transporte:"), gbcCadastro);
        numeroTransporteField = new JTextField(20);
        gbcCadastro.gridx = 1;
        painelCadastro.add(numeroTransporteField, gbcCadastro);

        gbcCadastro.gridx = 0;
        gbcCadastro.gridy = 2;
        painelCadastro.add(new JLabel("Descrição do Transporte:"), gbcCadastro);
        descricaoTransporteField = new JTextField(20);
        gbcCadastro.gridx = 1;
        painelCadastro.add(descricaoTransporteField, gbcCadastro);

        gbcCadastro.gridx = 0;
        gbcCadastro.gridy = 3;
        painelCadastro.add(new JLabel("Peso:"), gbcCadastro);
        pesoField = new JTextField(20);
        gbcCadastro.gridx = 1;
        painelCadastro.add(pesoField, gbcCadastro);

        JButton limparCamposButton = new JButton("Limpar Campos");
        gbcCadastro.gridx = 0;
        gbcCadastro.gridy = 4;
        gbcCadastro.gridwidth = 2;
        painelCadastro.add(limparCamposButton, gbcCadastro);

        JButton cadastrarTransporteButton = new JButton("Cadastrar Transporte");
        gbcCadastro.gridy = 5;
        painelCadastro.add(cadastrarTransporteButton, gbcCadastro);

        JButton sairCadastroButton = new JButton("Sair");
        gbcCadastro.gridy = 6;
        painelCadastro.add(sairCadastroButton, gbcCadastro);

        contentPanel.add(painelCadastro, "Cadastrar Novo Transporte");

        JPanel painelPendentes = new JPanel(new BorderLayout());
        painelPendentes.setBackground(Color.WHITE);
        JTextArea pendentesArea = new JTextArea();
        pendentesArea.setEditable(false);
        painelPendentes.add(new JScrollPane(pendentesArea), BorderLayout.CENTER);

        JButton confirmarButton = new JButton("Confirmar Cadastramento");
        painelPendentes.add(confirmarButton, BorderLayout.NORTH);

        JButton sairPendentesButton = new JButton("Sair");
        painelPendentes.add(sairPendentesButton, BorderLayout.SOUTH);

        contentPanel.add(painelPendentes, "Transportes Pendentes");

        JPanel painelCadastrados = new JPanel(new BorderLayout());
        painelCadastrados.setBackground(Color.WHITE);
        JTextArea cadastradosArea = new JTextArea();
        cadastradosArea.setEditable(false);
        painelCadastrados.add(new JScrollPane(cadastradosArea), BorderLayout.CENTER);

        // Crie o painel para alterar a situação do transporte
        JPanel painelAlterarSituacao = new JPanel(new GridBagLayout());
        painelAlterarSituacao.setBackground(Color.WHITE);
        GridBagConstraints gbcAlterar = new GridBagConstraints();
        gbcAlterar.insets = new Insets(10, 10, 10, 10);
        gbcAlterar.fill = GridBagConstraints.HORIZONTAL;

        gbcAlterar.gridx = 0;
        gbcAlterar.gridy = 0;
        painelAlterarSituacao.add(new JLabel("Número do Transporte:"), gbcAlterar);
        JTextField numeroTransporteAlterarField = new JTextField(20);
        gbcAlterar.gridx = 1;
        painelAlterarSituacao.add(numeroTransporteAlterarField, gbcAlterar);

        gbcAlterar.gridx = 0;
        gbcAlterar.gridy = 1;
        painelAlterarSituacao.add(new JLabel("Nova Situação:"), gbcAlterar);
        JTextField novaSituacaoField = new JTextField(20);
        gbcAlterar.gridx = 1;
        painelAlterarSituacao.add(novaSituacaoField, gbcAlterar);

        JButton alterarSituacaoConfirmarButton = new JButton("Alterar Situação");
        gbcAlterar.gridx = 0;
        gbcAlterar.gridy = 2;
        gbcAlterar.gridwidth = 2;
        painelAlterarSituacao.add(alterarSituacaoConfirmarButton, gbcAlterar);

        JButton sairAlterarSituacaoButton = new JButton("Sair");
        gbcAlterar.gridy = 3;
        painelAlterarSituacao.add(sairAlterarSituacaoButton, gbcAlterar);

        contentPanel.add(painelAlterarSituacao, "Alterar Situacao Transporte");


        JPanel botoesCadastradosPanel = new JPanel(new FlowLayout());
        JButton cancelarButton = new JButton("Cancelar Pedido");
        JButton confirmarTerminoButton = new JButton("Confirmar Termino");
        botoesCadastradosPanel.add(cancelarButton);
        botoesCadastradosPanel.add(confirmarTerminoButton);
        painelCadastrados.add(botoesCadastradosPanel, BorderLayout.NORTH);

        JButton sairCadastradosButton = new JButton("Sair");
        painelCadastrados.add(sairCadastradosButton, BorderLayout.SOUTH);

        contentPanel.add(painelCadastrados, "Transportes Cadastrados");

        CadastroDrone cadastroDrone = new CadastroDrone(cardLayout, contentPanel);
        contentPanel.add(cadastroDrone, "Cadastro de Drone");

        CadastroDroneCargaViva cadastroDroneCargaViva = new CadastroDroneCargaViva(cardLayout, contentPanel);
        contentPanel.add(cadastroDroneCargaViva, "Cadastro de Drone de Carga Viva");

        CadastroDroneCargaInanimada cadastroDroneCargaInanimada = new CadastroDroneCargaInanimada(cardLayout, contentPanel);
        contentPanel.add(cadastroDroneCargaInanimada, "Cadastro de Drone de Carga Inanimada");

        cadastrarButton.addActionListener(e -> {
            updateTitle("TRANSPORTE");
            cardLayout.show(contentPanel, "Cadastrar Novo Transporte");
        });
        cadastrarDroneButton.addActionListener(e -> {
            updateTitle("DRONE PESSOAL");
            cardLayout.show(contentPanel, "Cadastro de Drone");
        });
        cadastrarDroneCargaVivaButton.addActionListener(e -> {
            updateTitle("DRONE DE CARGA VIVA");
            cardLayout.show(contentPanel, "Cadastro de Drone de Carga Viva");
        });
        cadastrarDroneCargaInanimadaButton.addActionListener(e -> {
            updateTitle("DRONE DE CARGA INANIMADA");
            cardLayout.show(contentPanel, "Cadastro de Drone de Carga Inanimada");
        });
        pendentesButton.addActionListener(e -> {
            updateTitle("TRANSPORTE");
            String pendentes = cadastroTransporte.mostrarTransportesPendentes();
            pendentesArea.setText(pendentes);
            cardLayout.show(contentPanel, "Transportes Pendentes");
        });
        cadastradosButton.addActionListener(e -> {
            updateTitle("TRANSPORTE");
            String cadastrados = cadastroTransporte.mostrarTransportes();
            cadastradosArea.setText(cadastrados);
            cardLayout.show(contentPanel, "Transportes Cadastrados");
        });
        processarButton.addActionListener(e -> {
            String mensagem = cadastroTransporte.processarTransportesPendentes();
            JOptionPane.showMessageDialog(this, mensagem);
        });

        relatorioGeralButton.addActionListener(e -> mostrarRelatorioGeral());

        sairButton.addActionListener(e -> System.exit(0));
        sairCadastroButton.addActionListener(e -> {
            updateTitle("MENU");
            cardLayout.show(contentPanel, "Main Menu");
        });
        sairPendentesButton.addActionListener(e -> {
            updateTitle("MENU");
            cardLayout.show(contentPanel, "Main Menu");
        });
        sairCadastradosButton.addActionListener(e -> {
            updateTitle("MENU");
            cardLayout.show(contentPanel, "Main Menu");
        });
        alterarSituacaoButton.addActionListener(e -> {
            updateTitle("ALTERAR SITUAÇÃO");
            cardLayout.show(contentPanel, "Alterar Situacao Transporte");
        });

        alterarSituacaoConfirmarButton.addActionListener(e -> {
            String numeroStr = numeroTransporteAlterarField.getText();
            String novaSituacao = novaSituacaoField.getText();
            if (numeroStr != null && !numeroStr.isEmpty() && novaSituacao != null && !novaSituacao.isEmpty()) {
                try {
                    int numero = Integer.parseInt(numeroStr);
                    Transporte transporte = cadastroTransporte.buscarTransporte(numero);
                    if (transporte == null) {
                        JOptionPane.showMessageDialog(this, "Erro: Transporte não encontrado.");
                    } else if (transporte.getSituacao().equals(Estado.TERMINADO.toString()) || transporte.getSituacao().equals(Estado.CANCELADO.toString())) {
                        JOptionPane.showMessageDialog(this, "Erro: Não é possível alterar a situação de um transporte terminado ou cancelado.");
                    } else {
                        cadastroTransporte.alterarSituacaoTransporte(numero, novaSituacao);
                        JOptionPane.showMessageDialog(this, "Situação do transporte alterada com sucesso.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Erro: Número inválido.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Erro: Preencha todos os campos.");
            }

        });
        sairAlterarSituacaoButton.addActionListener(e -> {
            updateTitle("MENU");
            cardLayout.show(contentPanel, "Main Menu");
        });


        cadastrarTransporteButton.addActionListener(e -> {
            String nomeCliente = nomeClienteField.getText();
            String numero = numeroTransporteField.getText();
            String descricao = descricaoTransporteField.getText();
            String peso = pesoField.getText();
            String mensagem = cadastroTransporte.cadastrarTransporte(nomeCliente, numero, descricao, peso);
            JOptionPane.showMessageDialog(this, mensagem);
            if (mensagem.equals("Transporte cadastrado com sucesso!")) {
                limparCampos();
            }
        });



        limparCamposButton.addActionListener(e -> limparCampos());
        confirmarButton.addActionListener(e -> {
            String numeroStr = JOptionPane.showInputDialog(this, "Digite o número do transporte a confirmar:");
            if (numeroStr != null) {
                try {
                    int numero = Integer.parseInt(numeroStr);
                    cadastroTransporte.confirmarTransporte(numero);
                    String pendentes = cadastroTransporte.mostrarTransportesPendentes();
                    pendentesArea.setText(pendentes);
                    String cadastrados = cadastroTransporte.mostrarTransportes();
                    cadastradosArea.setText(cadastrados);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Número inválido.");
                }
            }
        });

        cancelarButton.addActionListener(e -> {
            String numeroStr = JOptionPane.showInputDialog(this, "Digite o número do transporte a cancelar:");
            if (numeroStr != null) {
                try {
                    int numero = Integer.parseInt(numeroStr);
                    cadastroTransporte.cancelarTransporte(numero);
                    String cadastrados = cadastroTransporte.mostrarTransportes();
                    cadastradosArea.setText(cadastrados);
                    JOptionPane.showMessageDialog(this, "Transporte cancelado.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Número inválido.");
                }
            }
        });

        confirmarTerminoButton.addActionListener(e -> {
            String numeroStr = JOptionPane.showInputDialog(this, "Digite o número do transporte a confirmar término:");
            if (numeroStr != null) {
                try {
                    int numero = Integer.parseInt(numeroStr);
                    cadastroTransporte.terminarTransporte(numero);
                    String cadastrados = cadastroTransporte.mostrarTransportes();
                    cadastradosArea.setText(cadastrados);
                    JOptionPane.showMessageDialog(this, "Transporte finalizado.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Número inválido.");
                }
            }
        });
    }

    private void limparCampos() {
        nomeClienteField.setText("");
        numeroTransporteField.setText("");
        descricaoTransporteField.setText("");
        pesoField.setText("");
    }

    private void updateTitle(String title) {
        tituloLabel.setText(title);
    }

    private void mostrarRelatorioGeral() {
        StringBuilder relatorio = new StringBuilder();
        List<Drone> drones = cadastroTransporte.getDronesDisponiveis();
        List<Transporte> transportes = cadastroTransporte.getTransportesCadastrados();

        if (drones.isEmpty() && transportes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Não há dados cadastrados.");
            return;
        }

        relatorio.append("Drones Disponíveis:\n");
        for (Drone drone : drones) {
            relatorio.append(drone.toString()).append("\n");
        }

        relatorio.append("\nTransportes Cadastrados:\n");
        for (Transporte transporte : transportes) {
            relatorio.append(transporte.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(this, relatorio.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Tela frame = new Tela();
            frame.setVisible(true);
        });
    }
}