package dados;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class Tela extends JFrame {
    private final CadastroTransporte cadastroTransporte;
    JTextField capacidadeDroneField = new JTextField(20);
    JComboBox<String> protegidoComboBox = new JComboBox<>(new String[]{"Sim", "Não"});
    JTextField pesoMaximoDroneField = new JTextField(20);
    JComboBox<String> climatizadoComboBox = new JComboBox<>(new String[]{"Sim", "Não"});

    public Tela() {
        setTitle("ACMEAirDrones - Sistema de Gerenciamento");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        cadastroTransporte = new CadastroTransporte();

        JLabel tituloLabel = new JLabel("MENU PRINCIPAL", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 24));
        tituloLabel.setForeground(Color.BLUE);
        add(tituloLabel, BorderLayout.NORTH);

        CardLayout cardLayout = new CardLayout();
        JPanel contentPanel = new JPanel(cardLayout);
        contentPanel.setBackground(Color.WHITE);
        add(contentPanel, BorderLayout.CENTER);

        JPanel menuPanel = new JPanel(new GridBagLayout());
        menuPanel.setBackground(Color.LIGHT_GRAY);
        menuPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        GridBagConstraints gbcMenu = new GridBagConstraints();
        gbcMenu.insets = new Insets(5, 5, 5, 5);
        gbcMenu.fill = GridBagConstraints.HORIZONTAL;

        // Botões do menu principal
        JButton cadastrarDroneButton = new JButton("Cadastrar Novo Drone");
        gbcMenu.gridx = 0;
        gbcMenu.gridy = -1;
        menuPanel.add(cadastrarDroneButton, gbcMenu);

        JComboBox<String> tipoDroneComboBox = new JComboBox<>(new String[]{"Pessoal", "Carga Viva", "Carga Inanimada"});
        gbcMenu.gridx = 1;
        gbcMenu.gridy = -1;
        menuPanel.add(tipoDroneComboBox, gbcMenu);

        JButton cadastrarTransporteButton = new JButton("Cadastrar Novo Transporte");
        gbcMenu.gridy = 1;
        gbcMenu.gridx = 0;
        menuPanel.add(cadastrarTransporteButton, gbcMenu);

        JComboBox<String> tipoTransporteComboBox = new JComboBox<>(new String[]{"Pessoal", "Carga Viva", "Carga Inanimada"});
        gbcMenu.gridx = 1;
        gbcMenu.gridy = 1;
        menuPanel.add(tipoTransporteComboBox, gbcMenu);

        gbcMenu.gridx = 0;

        JButton processarTransportesButton = new JButton("Processar Transportes Pendentes");
        gbcMenu.gridy = 2;
        menuPanel.add(processarTransportesButton, gbcMenu);

        JButton relatorioGeralButton = new JButton("Mostrar Relatório Geral");
        gbcMenu.gridy = 3;
        menuPanel.add(relatorioGeralButton, gbcMenu);

        JButton mostrarTransportesButton = new JButton("Mostrar Todos os Transportes");
        gbcMenu.gridy = 4;
        menuPanel.add(mostrarTransportesButton, gbcMenu);

        JButton alterarSituacaoButton = new JButton("Alterar Situação de Transporte");
        gbcMenu.gridy = 5;
        menuPanel.add(alterarSituacaoButton, gbcMenu);

        JButton leituraSimulacaoButton = new JButton("Leitura de Simulação");
        gbcMenu.gridy = 6;
        menuPanel.add(leituraSimulacaoButton, gbcMenu);

        JButton salvarDadosButton = new JButton("Salvar Dados");
        gbcMenu.gridy = 7;
        menuPanel.add(salvarDadosButton, gbcMenu);

        JButton carregarDadosButton = new JButton("Carregar Dados");
        gbcMenu.gridy = 8;
        menuPanel.add(carregarDadosButton, gbcMenu);

        JButton sairButton = new JButton("Finalizar Sistema");
        gbcMenu.gridy = 9;
        menuPanel.add(sairButton, gbcMenu);

        add(menuPanel, BorderLayout.CENTER);

        // Ações dos botões
        cadastrarDroneButton.addActionListener(_ -> {
            JFrame droneFrame = new JFrame("Cadastro de Drone");
            droneFrame.setSize(500, 500);
            droneFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            droneFrame.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.fill = GridBagConstraints.HORIZONTAL;

            if(Objects.equals(tipoDroneComboBox.getSelectedItem(), "Pessoal")){
                gbc.gridx = -1;
                gbc.gridy = 8;
                droneFrame.add(new JLabel("Qtd. Máx. Pessoas:"), gbc);
                JTextField capacidadeDroneField = new JTextField(20);
                droneFrame.add(capacidadeDroneField, gbc);
            }

            if(Objects.equals(tipoDroneComboBox.getSelectedItem(), "Carga Inanimada")){
                gbc.gridx = 0;
                gbc.gridy = 8;
                droneFrame.add(new JLabel("Protegido:"), gbc);
                JComboBox<String> protegidoComboBox = new JComboBox<>(new String[]{"Sim", "Não"});
                gbc.gridx = 1;
                droneFrame.add(protegidoComboBox, gbc);

                // Peso Máximo do Drone
                gbc.gridx = 0;
                gbc.gridy = 3;
                droneFrame.add(new JLabel("Peso Máximo:"), gbc);
                JTextField pesoMaximoDroneField = new JTextField(20);
                gbc.gridx = 1;
                droneFrame.add(pesoMaximoDroneField, gbc);
            }
            if(Objects.equals(tipoDroneComboBox.getSelectedItem(), "Carga Viva")){
                gbc.gridx = 0;
                gbc.gridy = 3;
                droneFrame.add(new JLabel("Peso Máximo:"), gbc);
                JTextField pesoMaximoDroneField = new JTextField(20);
                gbc.gridx = 1;
                droneFrame.add(pesoMaximoDroneField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 4;
                droneFrame.add(new JLabel("Climatizado:"), gbc);
                JComboBox<String> climatizadoComboBox = new JComboBox<>(new String[]{"Sim", "Não"});
                gbc.gridx = 1;
                droneFrame.add(climatizadoComboBox, gbc);
            }

            // Código do Drone
            gbc.gridx = 0;
            gbc.gridy = 0;
            droneFrame.add(new JLabel("Código do Drone:"), gbc);
            JTextField codigoDroneField = new JTextField(20);
            gbc.gridx = 1;
            droneFrame.add(codigoDroneField, gbc);

            // Custo Fixo do Drone
            gbc.gridx = 0;
            gbc.gridy = 1;
            droneFrame.add(new JLabel("Custo Fixo:"), gbc);
            JTextField custoFixoDroneField = new JTextField(20);
            gbc.gridx = 1;
            droneFrame.add(custoFixoDroneField, gbc);

            // Autonomia do Drone
            gbc.gridx = 0;
            gbc.gridy = 2;
            droneFrame.add(new JLabel("Autonomia:"), gbc);
            JTextField autonomiaDroneField = new JTextField(20);
            gbc.gridx = 1;
            droneFrame.add(autonomiaDroneField, gbc);

            // Botão para Cadastrar Drone
            JButton cadastrarDroneButtonInner = new JButton("Cadastrar Drone");
            gbc.gridx = 0;
            gbc.gridy = 9;
            gbc.gridwidth = 2;
            droneFrame.add(cadastrarDroneButtonInner, gbc);

            // Limpar campos
            JButton limparCamposButton = new JButton("Limpar Campos");
            gbc.gridx = 0;
            gbc.gridy = 10;
            gbc.gridwidth = 2;
            droneFrame.add(limparCamposButton, gbc);

            limparCamposButton.addActionListener(_ -> {
                codigoDroneField.setText("");
                custoFixoDroneField.setText("");
                autonomiaDroneField.setText("");
                pesoMaximoDroneField.setText("");
                climatizadoComboBox.setSelectedIndex(0);
                tipoDroneComboBox.setSelectedIndex(0);
            });

            droneFrame.setVisible(true);

            cadastrarDroneButtonInner.addActionListener(_ -> {
                String codigo = codigoDroneField.getText();
                String custoFixo = custoFixoDroneField.getText();
                String autonomia = autonomiaDroneField.getText();
                String pesoMaximo = pesoMaximoDroneField.getText();
                String climatizado = Objects.requireNonNull(climatizadoComboBox.getSelectedItem()).toString();
                String tipoDrone = Objects.requireNonNull(tipoDroneComboBox.getSelectedItem()).toString();
                String capacidade = capacidadeDroneField.getText();
                String protegido = Objects.requireNonNull(protegidoComboBox.getSelectedItem()).toString();

                if (!codigo.isEmpty() && !custoFixo.isEmpty() && !autonomia.isEmpty() && !pesoMaximo.isEmpty() && !climatizado.isEmpty()) {
                    String mensagem;
                    if (tipoDrone.equals("Pessoal")) {
                        DronePessoal dronePessoal = new DronePessoal(codigo, Double.parseDouble(custoFixo), Double.parseDouble(autonomia), Integer.parseInt(capacidade));
                        mensagem = cadastroTransporte.cadastrarDrone(dronePessoal);
                    } else if (tipoDrone.equals("Carga Viva")) {
                        DroneCargaViva droneCargaViva = new DroneCargaViva(codigo, Double.parseDouble(custoFixo), Double.parseDouble(autonomia), Double.parseDouble(pesoMaximo), climatizado.equals("Sim"));
                        mensagem = cadastroTransporte.cadastrarDrone(droneCargaViva);
                    } else {
                        DroneCargaInanimada droneCargaInanimada = new DroneCargaInanimada(codigo, Double.parseDouble(custoFixo), Double.parseDouble(autonomia), Double.parseDouble(pesoMaximo), protegido.equals("Sim"));
                        mensagem = cadastroTransporte.cadastrarDrone(droneCargaInanimada);
                    }
                    JOptionPane.showMessageDialog(droneFrame, mensagem);
                } else {
                    JOptionPane.showMessageDialog(droneFrame, "Por favor, preencha todos os campos.");
                }
            });

            droneFrame.setVisible(true);
        });

        cadastrarTransporteButton.addActionListener(_ -> {
            JFrame transporteFrame = new JFrame("Cadastro de Transporte");
            transporteFrame.setSize(500, 600);
            transporteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            transporteFrame.setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.fill = GridBagConstraints.HORIZONTAL;

            if(Objects.equals(tipoTransporteComboBox.getSelectedItem(), "Pessoal")){
                gbc.gridx = -1;
                gbc.gridy = 9;
                transporteFrame.add(new JLabel("Qtd. Máx. Pessoas:"), gbc);
                JTextField capacidadeTransporteField = new JTextField(20);
                transporteFrame.add(capacidadeTransporteField, gbc);
            }
            if(Objects.equals(tipoTransporteComboBox.getSelectedItem(), "Carga Inanimada")){
                gbc.gridx = 0;
                gbc.gridy = 9;
                transporteFrame.add(new JLabel("Carga Perigosa:"), gbc);
                JComboBox<String> protegidoComboBox = new JComboBox<>(new String[]{"Sim", "Não"});
                gbc.gridx = 1;
                transporteFrame.add(protegidoComboBox, gbc);
            }
            if(Objects.equals(tipoTransporteComboBox.getSelectedItem(), "Carga Viva")){
                gbc.gridx = 0;
                gbc.gridy = 9;
                transporteFrame.add(new JLabel("Temperatura mínima:"), gbc);
                JTextField temperaturaMinimaField = new JTextField(20);
                gbc.gridx = 1;
                transporteFrame.add(temperaturaMinimaField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 10;
                transporteFrame.add(new JLabel("Temperatura máxima:"), gbc);
                JTextField temperaturaMaximaField = new JTextField(20);
                gbc.gridx = 1;
                transporteFrame.add(temperaturaMaximaField, gbc);

            }

            // Número do Transporte
            gbc.gridx = 0;
            gbc.gridy = 0;
            transporteFrame.add(new JLabel("Número do Transporte:"), gbc);
            JTextField numeroTransporteField = new JTextField(20);
            gbc.gridx = 1;
            transporteFrame.add(numeroTransporteField, gbc);

            // Nome do Cliente
            gbc.gridx = 0;
            gbc.gridy = 1;
            transporteFrame.add(new JLabel("Nome do Cliente:"), gbc);
            JTextField nomeClienteField = new JTextField(20);
            gbc.gridx = 1;
            transporteFrame.add(nomeClienteField, gbc);

            // Descrição do Transporte
            gbc.gridx = 0;
            gbc.gridy = 2;
            transporteFrame.add(new JLabel("Descrição do Transporte:"), gbc);
            JTextField descricaoTransporteField = new JTextField(20);
            gbc.gridx = 1;
            transporteFrame.add(descricaoTransporteField, gbc);

            // Peso do Transporte
            gbc.gridx = 0;
            gbc.gridy = 3;
            transporteFrame.add(new JLabel("Peso:"), gbc);
            JTextField pesoTransporteField = new JTextField(20);
            gbc.gridx = 1;
            transporteFrame.add(pesoTransporteField, gbc);

            // Latitude Origem
            gbc.gridx = 0;
            gbc.gridy = 4;
            transporteFrame.add(new JLabel("Latitude Origem:"), gbc);
            JTextField latitudeOrigemField = new JTextField(20);
            gbc.gridx = 1;
            transporteFrame.add(latitudeOrigemField, gbc);

            // Latitude Destino
            gbc.gridx = 0;
            gbc.gridy = 5;
            transporteFrame.add(new JLabel("Latitude Destino:"), gbc);
            JTextField latitudeDestinoField = new JTextField(20);
            gbc.gridx = 1;
            transporteFrame.add(latitudeDestinoField, gbc);

            // Longitude Origem
            gbc.gridx = 0;
            gbc.gridy = 6;
            transporteFrame.add(new JLabel("Longitude Origem:"), gbc);
            JTextField longitudeOrigemField = new JTextField(20);
            gbc.gridx = 1;
            transporteFrame.add(longitudeOrigemField, gbc);

            // Longitude Destino
            gbc.gridx = 0;
            gbc.gridy = 7;
            transporteFrame.add(new JLabel("Longitude Destino:"), gbc);
            JTextField longitudeDestinoField = new JTextField(20);
            gbc.gridx = 1;
            transporteFrame.add(longitudeDestinoField, gbc);

//            // Situação
//            gbc.gridx = 0;
//            gbc.gridy = 8;
//            transporteFrame.add(new JLabel("Situação:"), gbc);
//            JComboBox<String> situacaoComboBox = new JComboBox<>(new String[]{"PENDENTE", "EM ANDAMENTO", "TERMINADO", "CANCELADO"});
//            gbc.gridx = 1;
//            transporteFrame.add(situacaoComboBox, gbc);

            // Botão para Cadastrar Transporte
            JButton cadastrarTransporteButtonInner = new JButton("Cadastrar Transporte");
            gbc.gridx = 0;
            gbc.gridy = 11;
            gbc.gridwidth = 2;
            transporteFrame.add(cadastrarTransporteButtonInner, gbc);

            // Limpar campos
            JButton limparCamposButton = new JButton("Limpar Campos");
            gbc.gridx = 0;
            gbc.gridy = 12;
            gbc.gridwidth = 2;
            transporteFrame.add(limparCamposButton, gbc);

            limparCamposButton.addActionListener(_ -> {
                numeroTransporteField.setText("");
                nomeClienteField.setText("");
                descricaoTransporteField.setText("");
                pesoTransporteField.setText("");
                latitudeOrigemField.setText("");
                latitudeDestinoField.setText("");
                longitudeOrigemField.setText("");
                longitudeDestinoField.setText("");
//                situacaoComboBox.setSelectedIndex(0);
                tipoTransporteComboBox.setSelectedIndex(0);
            });

            cadastrarTransporteButtonInner.addActionListener(_ -> {
                String numero = numeroTransporteField.getText();
                String nomeCliente = nomeClienteField.getText();
                String descricao = descricaoTransporteField.getText();
                String peso = pesoTransporteField.getText();
                String latitudeOrigem = latitudeOrigemField.getText();
                String latitudeDestino = latitudeDestinoField.getText();
                String longitudeOrigem = longitudeOrigemField.getText();
                String longitudeDestino = longitudeDestinoField.getText();
                String situacao = "PENDENTE";
                String tipoTransporte = Objects.requireNonNull(tipoTransporteComboBox.getSelectedItem()).toString();

                if (!numero.isEmpty() && !nomeCliente.isEmpty() && !descricao.isEmpty() && !peso.isEmpty() && !latitudeOrigem.isEmpty() && !latitudeDestino.isEmpty() && !longitudeOrigem.isEmpty() && !longitudeDestino.isEmpty()) {
                    String mensagem;
                    if (tipoTransporte.equals("Pessoal")) {
                        TransportePessoal transportePessoal = new TransportePessoal(Integer.parseInt(numero), nomeCliente, descricao, Double.parseDouble(peso), Double.parseDouble(latitudeOrigem), Double.parseDouble(latitudeDestino), Double.parseDouble(longitudeOrigem), Double.parseDouble(longitudeDestino), Estado.valueOf(situacao), 0);
                        mensagem = cadastroTransporte.cadastrarTransporte(transportePessoal);
                    } else if (tipoTransporte.equals("Carga Viva")) {
                        TransporteCargaViva transporteCargaViva = new TransporteCargaViva(Integer.parseInt(numero), nomeCliente, descricao, Double.parseDouble(peso), Double.parseDouble(latitudeOrigem), Double.parseDouble(latitudeDestino), Double.parseDouble(longitudeOrigem), Double.parseDouble(longitudeDestino), Estado.valueOf(situacao), 0, 0);
                        mensagem = cadastroTransporte.cadastrarTransporte(transporteCargaViva);
                    } else {
                        TransporteCargaInanimada transporteCargaInanimada = new TransporteCargaInanimada(Integer.parseInt(numero), nomeCliente, descricao, Double.parseDouble(peso), Double.parseDouble(latitudeOrigem), Double.parseDouble(latitudeDestino), Double.parseDouble(longitudeOrigem), Double.parseDouble(longitudeDestino), Estado.valueOf(situacao), false);
                        mensagem = cadastroTransporte.cadastrarTransporte(transporteCargaInanimada);
                    }
                    JOptionPane.showMessageDialog(transporteFrame, mensagem);
                } else {
                    JOptionPane.showMessageDialog(transporteFrame, "Por favor, preencha todos os campos.");
                }
            });

            transporteFrame.setVisible(true);
        });

        processarTransportesButton.addActionListener(_ -> JOptionPane.showMessageDialog(this, cadastroTransporte.processarTransportesPendentes()));

        relatorioGeralButton.addActionListener(_ -> {
            StringBuilder relatorio = new StringBuilder();

            relatorio.append("Relatório de Drones:\n");
            for (Drone drone : cadastroTransporte.getDronesCadastrados()) {
                relatorio.append(drone.toString()).append("\n");
                relatorio.append("\n");
            }

            relatorio.append("\nRelatório de Transportes:\n");
            for (Transporte transporte : cadastroTransporte.getTransportesCadastrados()) {
                relatorio.append(transporte.toString()).append("\n");
                relatorio.append("\n");
            }

            if (relatorio.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Não há dados cadastrados.");
            } else {
                JOptionPane.showMessageDialog(this, relatorio.toString());
            }
        });

        mostrarTransportesButton.addActionListener(_ -> {
            String transportes = cadastroTransporte.mostrarTransportes();
            if (transportes.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Não há transportes cadastrados.");
            } else {
                JOptionPane.showMessageDialog(this, transportes);
            }
        });

        alterarSituacaoButton.addActionListener(_ -> {
            String numero = JOptionPane.showInputDialog(this, "Digite o número do transporte:");

            if (numero != null && !numero.trim().isEmpty()) {
                Transporte transporte = cadastroTransporte.buscarTransporte(Integer.parseInt(numero));
                if (transporte == null) {
                    JOptionPane.showMessageDialog(this, "Erro: Transporte não encontrado.");
                } else if (transporte.getSituacao() == Estado.TERMINADO || transporte.getSituacao() == Estado.CANCELADO) {
                    JOptionPane.showMessageDialog(this, "Erro: Transporte não pode ser alterado.");
                } else {
                    String novaSituacao = JOptionPane.showInputDialog(this, "Digite a nova situação: (PENDENTE, ALOCADO, TERMINADO, CANCELADO)");
                    cadastroTransporte.alterarSituacaoTransporte(Integer.parseInt(numero), novaSituacao);
                    JOptionPane.showMessageDialog(this, "Situação alterada com sucesso!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Número do transporte inválido.");
            }
        });

        leituraSimulacaoButton.addActionListener(e -> {
            String nomeArquivo = JOptionPane.showInputDialog(this, "Digite o nome do arquivo de simulação (sem extensão):");
            if (nomeArquivo != null && !nomeArquivo.trim().isEmpty()) {
                String mensagem = leituraSimulacao(nomeArquivo);
                JOptionPane.showMessageDialog(this, mensagem);
            } else {
                JOptionPane.showMessageDialog(this, "Nome do arquivo inválido.");
            }
        });
//
//        salvarDadosButton.addActionListener(e -> {
//            String nomeArquivo = JOptionPane.showInputDialog(this, "Digite o nome do arquivo para salvar os dados (sem extensão):");
//            if (nomeArquivo != null && !nomeArquivo.trim().isEmpty()) {
//                String mensagem = salvarDados(nomeArquivo);
//                JOptionPane.showMessageDialog(this, mensagem);
//            } else {
//                JOptionPane.showMessageDialog(this, "Nome do arquivo inválido.");
//            }
//        });
//
//        carregarDadosButton.addActionListener(e -> {
//            String nomeArquivo = JOptionPane.showInputDialog(this, "Digite o nome do arquivo para carregar os dados (sem extensão):");
//            if (nomeArquivo != null && !nomeArquivo.trim().isEmpty()) {
//                String mensagem = carregarDados(nomeArquivo);
//                JOptionPane.showMessageDialog(this, mensagem);
//            } else {
//                JOptionPane.showMessageDialog(this, "Nome do arquivo inválido.");
//            }
//        });

        sairButton.addActionListener(_ -> System.exit(0));


    }

    public String leituraSimulacao(String nomeArquivo) {
        StringBuilder mensagem = new StringBuilder();
        String delimiter = ";";
        String dronesFile = "src/dados/" + nomeArquivo + "-DRONES.CSV";
        String transportesFile = "src/dados/" + nomeArquivo + "-TRANSPORTES.CSV";

        // Read drones data
        try (BufferedReader br = new BufferedReader(new FileReader(dronesFile))) {
            br.readLine();
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(delimiter);
                try {
                    int tipo = Integer.parseInt(dados[0]);
                    String codigo = dados[1];
                    double custoFixo = Double.parseDouble(dados[2]);
                    double autonomia = Double.parseDouble(dados[3]);
                    double pesoMaximo = Double.parseDouble(dados[4]);
                    boolean climatizado = Boolean.parseBoolean(dados[5]);

                    Drone drone;
                    if (tipo == 1) {
                        drone = new DronePessoal(codigo, custoFixo, autonomia, Integer.parseInt(dados[4]));
                    } else if (tipo == 2) {
                        drone = new DroneCargaInanimada(codigo, custoFixo, autonomia, pesoMaximo, Boolean.parseBoolean(dados[5]));
                    } else {
                        drone = new DroneCargaViva(codigo, custoFixo, autonomia, pesoMaximo, climatizado);
                    }
                    mensagem.append(cadastroTransporte.cadastrarDrone(drone)).append("\n");
                } catch (Exception e) {
                    mensagem.append("Erro ao processar linha de drone: ").append(linha).append("\n");
                }
            }
        } catch (IOException e) {
            mensagem.append("Erro ao ler o arquivo de drones: ").append(e.getMessage()).append("\n");
        }

        // Read transportes data
        try (BufferedReader br = new BufferedReader(new FileReader(transportesFile))) {
            br.readLine();
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(delimiter);
                try {
                    int tipo = Integer.parseInt(dados[0]);
                    int numero = Integer.parseInt(dados[1]);
                    String nomeCliente = dados[2];
                    String descricao = dados[3];
                    double peso = Double.parseDouble(dados[4]);
                    double latitudeOrigem = Double.parseDouble(dados[5]);
                    double longitudeOrigem = Double.parseDouble(dados[6]);
                    double latitudeDestino = Double.parseDouble(dados[7]);
                    double longitudeDestino = Double.parseDouble(dados[8]);
                    Estado situacao = Estado.PENDENTE;

                    Transporte transporte;
                    if (tipo == 1) {
                        transporte = new TransportePessoal(numero, nomeCliente, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, situacao, Integer.parseInt(dados[9]));
                    } else if (tipo == 2) {
                        transporte = new TransporteCargaInanimada(numero, nomeCliente, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, situacao, Boolean.parseBoolean(dados[9]));
                    } else {
                        transporte = new TransporteCargaViva(numero, nomeCliente, descricao, peso, latitudeOrigem, latitudeDestino, longitudeOrigem, longitudeDestino, situacao, Double.parseDouble(dados[9]), Double.parseDouble(dados[10]));
                    }
                    cadastroTransporte.getTransportesPendentes().add(transporte);
                    mensagem.append(cadastroTransporte.cadastrarTransporte(transporte)).append("\n");
                } catch (Exception e) {
                    mensagem.append("Erro ao processar linha de transporte: ").append(linha).append("\n");
                }
            }
        } catch (IOException e) {
            mensagem.append("Erro ao ler o arquivo de transportes: ").append(e.getMessage()).append("\n");
        }

        mensagem.append("\nDrones cadastrados:\n");
        for (Drone drone : cadastroTransporte.getDronesCadastrados()) {
            mensagem.append(drone).append("\n");
        }

        mensagem.append("\nTransportes cadastrados:\n");
        for (Transporte transporte : cadastroTransporte.getTransportesCadastrados()) {
            mensagem.append(transporte).append("\n");
        }

        return mensagem.toString();
    }
    }