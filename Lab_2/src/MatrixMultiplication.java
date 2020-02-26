public class MatrixMultiplication {
    public static void main(String[] args) throws Exception {
        Matrix matrix_1 = new Matrix("matrixes/matrix_1.txt");
        Matrix matrix_2 = new Matrix("matrixes/matrix_2.txt");
        BlockStripedMultiplication algo_1 = new BlockStripedMultiplication(matrix_1, matrix_2, 3);
        Matrix res_1 = algo_1.multiply();
    }
}
