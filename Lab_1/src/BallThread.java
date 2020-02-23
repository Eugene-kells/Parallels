public class BallThread extends Thread {
    private Ball b;
    private BallCanvas canvas;

    public BallThread(Ball ball, BallCanvas canvas) {
        b = ball;
        this.canvas = canvas;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i < 500; i++) {
                b.move();
                b.updateInfo();
                Thread.sleep(5);
            }
        } catch (InterruptedException ex) {
            System.out.println("The ball is in the hole! Thread " + Thread.currentThread());
            canvas.remove(b);
        }
    }
}
