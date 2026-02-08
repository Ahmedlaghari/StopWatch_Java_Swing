//import javax.swing.*;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import java.util.concurrent.TimeUnit;
//import java.util.Scanner;
//import javax.swing.*;
//import java.awt.event.*;
//import java.awt.*;
//import java.util.Objects;
//
//class StopWatch {
//    private int sec = 0;
//    private int min = 0;
//    private int hour = 0;
//    private boolean running = false;
//
//    private final JLabel timeLabel = new JLabel(formatTime());
//    private Timer timer;
//    private JButton startButton;
//    private JButton resetButton;
//    private String formatTime() {
//        return String.format("%02d:%02d:%02d", hour, min, sec);
//    }
//
//    void createAndShowGui() {
//        // Timer fires on the EDT every 1000ms; it only advances time when `running` is true.
//        timer = new Timer(1000, e -> {
//            if (!running) return;
//            sec++;
//            if (sec == 60) { sec = 0; min++; }
//            if (min == 60) { min = 0; hour++; }
//            timeLabel.setText(formatTime());
//        });
//
//        JFrame frame = new JFrame("Stopwatch");
//        JButton startButton = new JButton("Start/Stop");
//        JButton resetButton = new JButton("reset");
//        JPanel panel = new JPanel();
//        panel.add(timeLabel);
//        panel.add(startButton);
//        panel.add(resetButton);
//        frame.add(panel);
//        frame.setSize(400, 200);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//        //setting the label
//        // Start button action
//        startButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (running) {
//                    timer.stop();
//                } else {
//                    timer.start();
//                }
//                running = !running;
//            }
//
//        });
//        resetButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                sec = 0;
//                hour = 0;
//                min = 0;
//                timeLabel.setText(formatTime());;
//
//            }
//        });
//    }
//    void setTimeLabel(String text){
//        timeLabel.setText(text);
//    }
//}
//public class Main {
//    public static void main(String[] args) throws InterruptedException {
//        StopWatch t1 = new StopWatch();
//        t1.createAndShowGui();
//    }
//}
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class StopWatch {
    private int centiseconds = 0;
    private int sec = 0;
    private int min = 0;
    private int hour = 0;
    private boolean running = false;
    private String History = new string[10];

    private final JLabel timeLabel = new JLabel(formatTime());
    private Timer timer;
    private JButton startButton;
    private JButton resetButton;

    private String formatTime() {
        return String.format("%02d:%02d:%02d:%02d", hour, min, sec,centiseconds);
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
        startButton = new JButton();
        resetButton = new JButton("Reset");

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

        frame.add(panel);
        frame.setSize(400, 200);
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
            centiseconds= sec = min = hour = 0;
            timeLabel.setText(formatTime());
            timer.stop();
        });
        timer.start();
    }
}

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StopWatch().createAndShowGui());// Ensure GUI is created on the Event Dispatch Thread
    }
}
//i have to update gui . change so that when its running the button goes red and changes to
//stop and when its stopped it goes blue and changes to start. also the reset button should
// only be enabled when the stopwatch is running. when its stopped it should be disabled.
//and make some pretty changes to the ui. make the time label bigger and center it. also add some padding between the buttons and the label.