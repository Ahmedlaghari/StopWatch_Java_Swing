import javax.swing.*;
import java.awt.*;

class ButtonStyler {
    static void styleStartButton(JButton button) {
        button.setBackground(UIConfig.BUTTON_START_BG);
        button.setForeground(UIConfig.BUTTON_FG);
        button.setFont(new Font("Arial", Font.BOLD, UIConfig.BUTTON_FONT_SIZE));
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(UIConfig.BUTTON_WIDTH, UIConfig.BUTTON_HEIGHT));
        button.setOpaque(true);
    }

    static void styleResetButton(JButton button) {
        button.setBackground(UIConfig.BUTTON_RESET_BG);
        button.setForeground(UIConfig.BUTTON_FG);
        button.setFont(new Font("Arial", Font.BOLD, UIConfig.BUTTON_FONT_SIZE));
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(UIConfig.BUTTON_WIDTH, UIConfig.BUTTON_HEIGHT));
        button.setOpaque(true);

    }}
