public abstract class Multiplication {
    private Matrix left;
    private Matrix right;
    private int threadsNum;

    public abstract Matrix multiply() throws Exception;

    public void checkDimensions() throws Exception {
        if (left.y_size != right.x_size)
            throw new Exception("Matrix sizes must correspond each other");
    }
}
