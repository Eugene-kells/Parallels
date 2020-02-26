import sun.jvm.hotspot.opto.Block;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockStripedMultiplication extends Multiplication {
    private Matrix left;
    private Matrix right;
    private int threadsNum;


    public BlockStripedMultiplication(Matrix left, Matrix right, int threadsNum) {
        this.left = left;
        this.right = right;
        this.threadsNum = threadsNum;
    }

    public Matrix multiply() throws Exception {
//        checkDimensions();  // null pointer wtf?
        Matrix result = new Matrix(left.x_size, left.y_size);

        ExecutorService executor = Executors.newFixedThreadPool(threadsNum);
        for (int i = 0; i < left.x_size; i++) {
            for (int j = 0; j < right.y_size; j++) {
                BlockStripedMult thread = new BlockStripedMult(i, j, result, left, right);
                executor.execute(thread);
            }
        }
        executor.shutdown();

        return result;
    }
}
