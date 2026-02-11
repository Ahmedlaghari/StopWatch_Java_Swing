import javax.swing.*;
import java.awt.*;

class ButtonStyler {

    private static final Font BUTTON_FONT = new Font("Arial", Font.BOLD, UIConfig.BUTTON_FONT_SIZE);
    private static final Color BUTTON_TEXT_COLOR = UIConfig.BUTTON_FG;
    private static final Dimension BUTTON_SIZE = new Dimension(UIConfig.BUTTON_WIDTH, UIConfig.BUTTON_HEIGHT);

    private static void styleButton(JButton button, Color bgColor, String text) {
        button.setText(text);
        button.setBackground(bgColor);
        button.setForeground(BUTTON_TEXT_COLOR);
        button.setFont(BUTTON_FONT);
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 60), 2)); // subtle border for all buttons
        button.setPreferredSize(BUTTON_SIZE);
    }

    static void styleStartButton(JButton button) {
        styleButton(button, UIConfig.BUTTON_START_BG, "Start");
    }

    static void styleStopButton(JButton button) {
        styleButton(button, UIConfig.BUTTON_STOP_BG, "Stop");
    }

    static void styleResetButton(JButton button) {
        styleButton(button, UIConfig.BUTTON_RESET_BG, "Reset");
    }

    static void styleFrame(JFrame frame) {
        frame.setBackground(new Color(18, 18, 18));
        frame.getContentPane().setBackground(new Color(18, 18, 18));
        frame.setLayout(new BorderLayout(20, 10)); // unified spacing
    }

    static void styleMenuBar(JMenuBar menuBar) {
        menuBar.setBackground(new Color(25, 25, 25));
        menuBar.setForeground(Color.WHITE);
        menuBar.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(60, 60, 60)));
    }


    static void styleTimeLabel(JLabel label) {
        label.setFont(new Font("Monospaced", Font.BOLD, 48));
        label.setForeground(new Color(200, 200, 200));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
    }
    static void stylePanelWithBorder(JPanel panel) {
        panel.setBackground(new Color(25, 25, 25)); // dark background
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(50, 50, 50), 3, true), // thick, rounded border
                BorderFactory.createEmptyBorder(10, 10, 10, 10) // inner padding
        ));
    }
    static void styleJscrollPane(JScrollPane scrollPane) {
        scrollPane.setBackground(new Color(25, 25, 25));
        scrollPane.setBorder(BorderFactory.createCompoundBorder());
    }

    static void styleList(JList<String> list) {
        list.setBackground(new Color(35, 35, 35));
        list.setForeground(Color.WHITE);
        list.setSelectionBackground(new Color(0, 120, 215));
        list.setSelectionForeground(Color.WHITE);
        list.setFont(new Font("Monospaced", Font.PLAIN, 14));
        list.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(60, 60, 60)),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
    }
}
