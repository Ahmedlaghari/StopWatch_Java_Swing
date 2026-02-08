import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

class StopWatch {
    private int centiseconds = 0;
    private int sec = 0;
    private int min = 0;
    private int hour = 0;
    private boolean running = false;
    private ArrayList<String> history = new ArrayList<>();

    private final JLabel timeLabel = new JLabel(formatTime());
    private Timer timer;
    private JButton startButton;
    private JButton resetButton;

    // Use DefaultListModel for dynamic updates
    private DefaultListModel<String> historyModel = new DefaultListModel<>();
    private JList<String> historyList = new JList<>(historyModel);

    private String formatTime() {
        return String.format("%02d:%02d:%02d:%02d", hour, min, sec, centiseconds);
    }

    void createAndShowGui() {
        timer = new Timer(10, e -> {
            if (!running) return;
            centiseconds++;
            if (centiseconds == 60) { centiseconds = 0; sec++; }
            if (sec == 60) { sec = 0; min++; }
            if (min == 60) { min = 0; hour++; }
            timeLabel.setText(formatTime());
        });

        JFrame frame = new JFrame("Stopwatch");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout(10, 10));
        startButton = new JButton();
        resetButton = new JButton("Reset");

        // Scrollable history list
        JScrollPane scrollPane = new JScrollPane(historyList);
        scrollPane.setPreferredSize(new Dimension(150, 200));
        historyList.setFont(new Font("Monospaced", Font.PLAIN, 16));

        // Apply styling
        ButtonStyler.styleStartButton(startButton);
        ButtonStyler.styleResetButton(resetButton);
        timeLabel.setFont(timeLabel.getFont().deriveFont((float) UIConfig.LABEL_FONT_SIZE));
        timeLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panel.add(timeLabel);
        panel.add(startButton);
        panel.add(resetButton);
        panel.add(scrollPane);

        frame.add(panel);
        frame.setSize(500, 250); // give a little more room for history
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        startButton.addActionListener(e -> {
            running = !running;
            if (running) {
                timer.start();
                ButtonStyler.styleStopButton(startButton);
            } else {
                timer.stop();
                ButtonStyler.styleStartButton(startButton);
            }
        });

        resetButton.addActionListener(e -> {
            running = false;
            // Save current time to history when resetting
            String currentTime = formatTime();
            history.add(currentTime);
            historyModel.addElement(currentTime);
            centiseconds = sec = min = hour = 0;
            timeLabel.setText(formatTime());
            timer.stop();
        });

        timer.start();
    }
}

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StopWatch().createAndShowGui());
    }
}
