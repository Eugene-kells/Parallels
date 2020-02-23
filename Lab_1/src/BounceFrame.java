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
                Ball b = new Ball(canvas, holes);
                canvas.add(b);
                BallThread thread = new BallThread(b, canvas);
                thread.start();
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
