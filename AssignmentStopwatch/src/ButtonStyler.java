import javax.swing.*;
import java.awt.*;

class ButtonStyler {
    static void styleStartButton(JButton button) {
        button.setText("Start");
        button.setBackground(UIConfig.BUTTON_START_BG);
        button.setForeground(UIConfig.BUTTON_FG);
        button.setFont(new Font("Arial", Font.BOLD, UIConfig.BUTTON_FONT_SIZE));
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(UIConfig.BUTTON_WIDTH, UIConfig.BUTTON_HEIGHT));
        button.setOpaque(true);
    }
    static void styleStopButton(JButton button) {
        button.setText("Stop");
        button.setBackground(UIConfig.BUTTON_STOP_BG);
        button.setForeground(UIConfig.BUTTON_FG);
        button.setFont(new Font("Arial", Font.BOLD, UIConfig.BUTTON_FONT_SIZE));
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(UIConfig.BUTTON_WIDTH, UIConfig.BUTTON_HEIGHT));
        button.setOpaque(true);
    }

    static void styleFrame(JFrame frame) {
        frame.setBackground(Color.black);
        frame.getContentPane().setBackground(new Color(18, 18, 18));
        frame.setLayout(new BorderLayout(30, 10));
    }
    static void styleMenuBar(JMenuBar menuBar) {
        menuBar.setBackground(Color.black);
    }
    static void stylePanel(JPanel panel) {
        panel.setBackground(new Color(25, 25, 25)); // dark background
    }
    static void styleTimeLabel(JLabel label) {
        label.setFont(new Font("Monospaced", Font.BOLD, 48));
        label.setForeground(new Color(135, 134, 129));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
    }
    static void styleList(JList<String> list) {
        list.setBackground(new Color(35, 35, 35));
        list.setForeground(Color.WHITE);
        list.setSelectionBackground(new Color(0, 120, 215));
        list.setFont(new Font("Monospaced", Font.PLAIN, 14));
        list.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }





    static void styleResetButton(JButton button) {
        button.setBackground(UIConfig.BUTTON_RESET_BG);
        button.setForeground(UIConfig.BUTTON_FG);
        button.setFont(new Font("Arial", Font.BOLD, UIConfig.BUTTON_FONT_SIZE));
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(UIConfig.BUTTON_WIDTH, UIConfig.BUTTON_HEIGHT));
        button.setOpaque(true);

    }}

