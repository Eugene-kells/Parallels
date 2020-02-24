import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class BounceFrame extends JFrame {

    private BallCanvas canvas;
    public static final int WIDTH = 450;
    public static final int HEIGHT = 350;

    private ArrayList<Hole> getDefaultHoles() {
        return new ArrayList<>(Arrays.asList(
                new Hole(0, 0),
                new Hole(0, HEIGHT),
                new Hole(WIDTH, HEIGHT),
                new Hole(WIDTH, 0)
//                new Hole(40, 40) // for testing purposes only
        ));
    }

    public BounceFrame() {
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce app");

        this.canvas = new BallCanvas();
        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);

        JButton buttonStart = new JButton("Start");
        JButton buttonStop = new JButton("Stop");

        ArrayList<Hole> holes = getDefaultHoles();

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int NUM_OF_BLUE_BALLS = 100;
                // Create ball threads without starting them to get more accurate results
                Ball red_ball = new Ball(canvas, holes, Color.red);
                canvas.add(red_ball);
                BallThread red_thread = new BallThread(red_ball, canvas);
                red_thread.setPriority(2);

                ArrayList<BallThread> blue_threads = new ArrayList<>();
                for(int i = 0; i < NUM_OF_BLUE_BALLS; i++) {
                    Ball blue_ball = new Ball(canvas, holes, Color.blue);
                    canvas.add(blue_ball);
                    BallThread blue_thread = new BallThread(blue_ball, canvas);
                    blue_thread.setPriority(1);
                    blue_threads.add(blue_thread);
                }
                // Start all the threads at once
                red_thread.start();
                for (BallThread thread: blue_threads) {
                    thread.start();
                }
            }
        });

        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }

        });

        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonStop);

        content.add(buttonPanel, BorderLayout.SOUTH);
    }
}
