package counter;

public class Counter {
    public int countRes;
    public int countMethods;
    public int countBlocks;

    public void increment() {
        countRes++;
    }

    public void decrement() {
        countRes--;
    }

    public synchronized void applyMethod(boolean toIncrement) {
        if (toIncrement)
            countMethods++;
        else
            countMethods--;
    }

    public void applyBlock(boolean toIncrement) {
        synchronized (this) {
            if (toIncrement)
                countBlocks++;
            else
                countBlocks--;
        }
    }
}
