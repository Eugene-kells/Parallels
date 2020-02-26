public class BlockStripedMult extends Thread {
    private final int x_index;
    private final int y_index;
    private final Matrix left;
    private final Matrix right;
    private final Matrix result;

    public BlockStripedMult(int x_index, int y_index, Matrix result, Matrix left, Matrix right) {
        this.x_index = x_index;
        this.y_index = y_index;
        this.result = result;
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        int sum = 0;

        int multiply_steps = left.y_size; // or right.x_size, doesn't matter, sice left.y_size == right.x_size
        for (int i = 0; i < multiply_steps; i++) {
            // would be great to implement matrix transpose to make right.get(...) execute faster (access on array
            // instead of all the arrays one by one)
            sum += left.get(x_index, i) * right.get(i, y_index);
        }

        synchronized (result) {
            result.set(x_index, y_index, sum);
        }
    }
}
