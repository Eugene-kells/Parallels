package terminalwriter;


import java.util.concurrent.Semaphore;

public class Executor {
    public static void main(String[] args) {
        final int NUM_OF_LINES = 50;
        Semaphore semaphore = new Semaphore(1);
        TerminalWriter writer_1 = new TerminalWriter("-", NUM_OF_LINES, semaphore);
        TerminalWriter writer_2 = new TerminalWriter("|", NUM_OF_LINES, semaphore);
        writer_1.start();
        writer_2.start();
    }
}
