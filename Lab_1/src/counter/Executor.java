package counter;

public class Executor {
    public static void main(String[] args) {
        final int NUM_OF_OPERATIONS = 100000;
        Counter counter = new Counter();
        CounterThread count1 = new CounterThread(counter, NUM_OF_OPERATIONS, true);
        CounterThread count2 = new CounterThread(counter, NUM_OF_OPERATIONS, false);
        count1.start();
        count2.start();
        try {
            count1.join();
            count2.join();
        } catch (InterruptedException exc) {}
        System.out.println(counter.countRes);
        System.out.println(counter.countMethods);
        System.out.println(counter.countBlocks);
    }
}
