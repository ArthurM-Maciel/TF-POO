package dados;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Tela frame = new Tela();
            frame.setVisible(true);
        });
    }
}