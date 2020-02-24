package terminalwriter;

import java.util.concurrent.Semaphore;

public class TerminalWriter extends Thread {
    private String symbol;
    private int linesCount;
    private Semaphore semaphore;

    public TerminalWriter(String symbol, int linesCount, Semaphore semaphore) {
        this.symbol = symbol;
        this.linesCount = linesCount;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < linesCount; i++) {
            try {
                semaphore.acquire();
                System.out.println(symbol);
                semaphore.release();
                Thread.currentThread().sleep(1); // Hack to force thread to wait until another one will take the
                // semaphore
            }
            catch (InterruptedException exc) {}
        }
    }
}
