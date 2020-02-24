package counter;

public class CounterThread extends Thread {
    private Counter counter;
    private boolean isIncrement;
    private int operationNum;

    public CounterThread(Counter counter, int operationNum, boolean isIncrement) {
        this.counter = counter;
        this.operationNum = operationNum;
        this.isIncrement = isIncrement;
    }

    @Override
    public void run() {
        for (int i = 0; i < operationNum; i++) {
            if (isIncrement)
                counter.increment();
            else
                counter.decrement();
        }
    }
}
