package counter;

public class Executor {
    public static void main(String[] args) {
        final int NUM_OF_OPERATIONS = 100;
        Counter counter = new Counter();
        CounterThread count1 = new CounterThread(counter, NUM_OF_OPERATIONS, true);
        CounterThread count2 = new CounterThread(counter, NUM_OF_OPERATIONS, false);
        count1.start();
        count2.start();
        System.out.println(counter.countRes);
    }
}
