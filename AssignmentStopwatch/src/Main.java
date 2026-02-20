//SERIAL NUMBER IS 06
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class StopWatch {
    private int centiseconds = 0;
    private int sec = 0;
    private int min = 0;
    private int hour = 0;
    private boolean running = false;
    private JLabel timeLabel = new JLabel(formatTime());
    private Timer timer;
    private JButton startButton;
    private JButton resetButton;
    private JButton closeButton;
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
        JMenuBar menuBar = new JMenuBar();
        JPanel panel = new JPanel();
        startButton = new JButton();
        closeButton = new JButton("Close");
        resetButton = new JButton("Reset");
        JScrollPane scrollPane = new JScrollPane(historyList);
        scrollPane.setPreferredSize(new Dimension(200, 50));
        historyList.setFont(new Font("Monospaced", Font.PLAIN, 16));
        ButtonStyler.styleFrame(frame);
        ButtonStyler.styleTimeLabel(timeLabel);
        ButtonStyler.styleStartButton(startButton);
        ButtonStyler.styleCloseButton(closeButton);
        ButtonStyler.styleResetButton(resetButton);
        ButtonStyler.styleList(historyList);
        ButtonStyler.styleJscrollPane(scrollPane);
        ButtonStyler.styleMenuBar(menuBar);
        ButtonStyler.stylePanelWithBorder(panel);
        panel.add(timeLabel);
        panel.add(startButton);
        panel.add(closeButton);
        panel.add(resetButton);
        panel.add(scrollPane);
        frame.add(panel);
        frame.setJMenuBar(menuBar);
        frame.setSize(500, 250);
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
            String currentTime = formatTime();
            historyModel.addElement(currentTime);
            centiseconds = sec = min = hour = 0;
            ButtonStyler.styleStartButton(startButton);
            timeLabel.setText(formatTime());
            timer.stop();
        });
        closeButton.addActionListener(e -> {
            frame.dispose();
        });
        timer.start();
    }
}
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StopWatch().createAndShowGui());
    }
}
