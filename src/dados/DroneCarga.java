package dados;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DroneCarga {
    private ArrayList<CadastroDrone> drones = new ArrayList<>();

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

    public JPanel getPanel1() {
        return panel1;
    }

    public DroneCarga() {
        doisBotoes = new ButtonGroup();
        doisBotoes.add(cargaInanimadaRadioButton);
        doisBotoes.add(cargaVivaRadioButton);
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String codigo = textField1.getText();
                    String custo = textField2.getText();
                    String autonomia = textField3.getText();
                    String peso = textField4.getText();
                    String protecao = textField5.getText();
                    String tipoCarga = cargaInanimadaRadioButton.isSelected() ? "CARGA INANIMADA" : "CARGA VIVA";

                    boolean codigoExiste = false;
                    for (CadastroDrone drone : drones) {
                        if (drone.codigo.equals(codigo)) {
                            codigoExiste = true;
                            break;
                        }
                    }
                    if (codigoExiste) {
                        areaDeTexto.setText("Já existe um drone com este código!");
                    } else {
                        CadastroDrone drone = new CadastroDrone(codigo, custo, autonomia, peso, protecao, tipoCarga);
                        drones.add(drone);
                        Collections.sort(drones, new Comparator<CadastroDrone>() {
                            @Override
                            public int compare(CadastroDrone drone1, CadastroDrone drone2) {
                                return drone1.codigo.compareTo(drone2.codigo);
                            }
                        });
                        areaDeTexto.setText("Drone cadastrado com sucesso!");
                    }
                } catch (Exception ex) {
                    areaDeTexto.setText("Erro no cadastro do drone");
                }
            }
        });
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    textField1.setText("");
                    textField2.setText("");
                    textField3.setText("");
                    textField4.setText("");
                    textField5.setText("");
                    areaDeTexto.setText("");
                    doisBotoes.clearSelection();
                } catch (Exception ex) {
                    areaDeTexto.setText("Erro ao limpar");
                }
            }
        });
        mostrarDadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    StringBuilder dados = new StringBuilder("Dados dos drones cadastrados: \n");
                    for (CadastroDrone drone : drones) {
                        dados.append(drone.toString()).append("\n");
                    }
                    areaDeTexto.setText(dados.toString());
                } catch (Exception ex) {
                    areaDeTexto.setText("Erro ao mostrar dados");
                }
            }
        });
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.exit(0);
                } catch (Exception ex) {
                    areaDeTexto.setText("Erro ao sair");
                }
            }
        });
    }
}