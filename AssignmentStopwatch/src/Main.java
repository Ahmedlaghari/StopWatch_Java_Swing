import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

class StopWatch {
    static int sec;
    static int min;
    static int hour;
    boolean start = false;
    Thread stopWatchThread;
    JLabel timeLabel  = new JLabel("Time");
    StopWatch() {
        sec = min = hour = 0;
    }
    void start() throws InterruptedException {
        while (true) {
            TimeUnit.SECONDS.sleep(1);
            if (!start) {stopWatchThread.sleep(100);continue;}
            sec++;
            if (sec == 60) {
                sec = 0;
                min++;
            }
            if (min == 60) {
                min = 0;
                hour++;
            }
            setTimeLabel( hour + " / " + min + " / " + sec);
        }
    }
    void stop() {
        start = false;
    }
    String showinfo() {
        String info = "";
        info += hour + " / " + min + " / " + sec;
        return info;
    }

    void gui() {
        JFrame frame = new JFrame("Swing Test");
        JButton startButton = new JButton("Start/Stop");
        JButton resetButton = new JButton("reset");
        JPanel panel = new JPanel();
        panel.add(timeLabel);
        panel.add(startButton);
        panel.add(resetButton);
        frame.add(panel);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //setting the label
        // Start button action
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start = !start;

                // only start a new thread if none exists or it has finished
                if (stopWatchThread == null || !stopWatchThread.isAlive()) {
                    stopWatchThread = new Thread(() -> {
                        try {
                            start();  // this is your stopwatch loop
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    });
                    stopWatchThread.start();  // actually start the thread
                }
            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sec = 0;
                hour = 0;
                min = 0;
                setTimeLabel( hour + " / " + min + " / " + sec);

            }
        });
    }
    void setTimeLabel(String text){
        timeLabel.setText(text);
    }
}
public class Main {
    public static void main(String[] args) throws InterruptedException {
        StopWatch t1 = new StopWatch();
        t1.gui();
    }
}
