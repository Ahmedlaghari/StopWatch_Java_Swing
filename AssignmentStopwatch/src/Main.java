import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import java.awt.event.ActionEvent;

class StopWatch {
    Scanner input;

    {
        input = new Scanner(System.in);
    }

    static int sec;
    static int min;
    static int hour;
    boolean start = true;
    StopWatch(){
        sec=min=hour=0;
    }
    int start() throws InterruptedException {
        if (!start || hour == 24) {
            System.out.println(hour + " / " + min + " / " + sec);
            return 1;
        }

        TimeUnit.SECONDS.sleep(1);
        System.out.println("hello");

        sec++;
        if (sec == 60) {
            sec = 0;
            min++;
        }
        if (min == 60) {
            min = 0;
            hour++;
        }

        System.out.println(hour + " / " + min + " / " + sec);
        return start();
    }




    void stop(){
        start = false;

    }
    String showinfo(){
        return (hour+" / "+min+" / "+sec);
    }

}

class TestSwing implements ActionListener {
    public void actionPerformed(ActionEvent e)

    StopWatch swp = new StopWatch();
    void gui() {
        JFrame frame = new JFrame("Swing Test");
        JButton button = new JButton("start");
        JButton button2 = new JButton("stop");
        button.addActionListener(this);
//        button2.addActionListener(this);

        frame.setSize(1920, 1080);
        JPanel panel = new JPanel();
        panel.setSize(300, 500);
        JLabel hello = new JLabel();
        hello.setText(swp.showinfo());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        panel.add(hello);
        panel.add(button);
        frame.add(panel);
    }
        button.addActionListener(e -> {
        swp.start = true;

        Thread t = new Thread(() -> {
            try {
                swp.start();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        t.start();
    });
    }



}
public class Main  {
    public static void main(String[] args) throws InterruptedException {
    TestSwing t1 = new TestSwing();
    t1.gui();


    }
}
