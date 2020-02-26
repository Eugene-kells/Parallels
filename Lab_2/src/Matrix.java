//import com.sun.tools.javac.util.List;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Matrix {
//    private ArrayList<Float> data;
//    private ArrayList<Integer> factors;
//    private ArrayList<Integer> sizes;
//
//    public Matrix(String filePath) throws Exception {
//        data = new ArrayList<>();
//        try {
//            Scanner input = new Scanner(new File(filePath));
//            int previous_row_size = -1;
//            int num_of_rows = 0;
//            while (input.hasNextLine()) {
//                Scanner colReader = new Scanner(input.nextLine());
//                ArrayList<Float> col = new ArrayList<>();
//                while (colReader.hasNextInt()) {
//                    col.add(colReader.nextFloat());
//                }
//                if (previous_row_size >= 0 && previous_row_size != col.size())
//                    throw new Exception("All rows should have the same number of items");
//                previous_row_size = col.size();
//                num_of_rows++;
//                data.addAll(col);
//            }
//            sizes = new ArrayList<>(List.of(num_of_rows, previous_row_size));
//            factors = new ArrayList<>(List.of(previous_row_size, 1));
//        } catch (FileNotFoundException exc) {
//            System.out.println("No file " + filePath);
//        }
//    }
//
//    public Matrix(Integer... dim_sizes) {
//        checkDimensions(dim_sizes);
//        factors = calculateFactors(dim_sizes);
//        sizes = new ArrayList<Integer>(Arrays.asList(dim_sizes));
//    }
//
//    private ArrayList<Integer> calculateFactors(Integer... indexes) {
//
//    }
//
//    private void checkDimensions(Integer... indexes) {
//        assert indexes.length > 0;
//        for (int index: indexes)
//            assert index > 0;
//    }
//
//    private void checkIndexes(Integer... indexes) {
//        assert indexes.length == sizes.size();
//        for (int i = 0; i < indexes.length; i++)
//            assert 0 <= indexes[i] && indexes[i] < sizes.get(i);
//    }
//
//    private int calculateIndex(Integer... indexes) {
//        checkIndexes();
//        int index_sum = 0;
//        for (int i = 0; i < indexes.length; i++) {
//            index_sum += indexes[i] * factors.get(i);
//        }
//        return index_sum;
//    }
//
//    public Float get(Integer... indexes) {
//        int index = calculateIndex(indexes);
//        return data.get(index);
//    }
//}

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Matrix {
    private ArrayList<ArrayList<Integer>> data;
    public int x_size;
    public int y_size;

    public Matrix(String filePath) throws Exception {
        data = new ArrayList<>();
        File file = new File(filePath);
        Scanner input = new Scanner(file);
        int previous_row_size = -1;
        while (input.hasNextLine()) {
            Scanner colReader = new Scanner(input.nextLine());
            ArrayList<Integer> row = new ArrayList<>();
            while (colReader.hasNextInt()) {
                row.add(colReader.nextInt());
            }
            if (previous_row_size >= 0 && previous_row_size != row.size())
                throw new Exception("All rows should have the same number of items");
            previous_row_size = row.size();
            data.add(row);
        }
        x_size = data.size();
        y_size = previous_row_size;
    }

    public Matrix(int x, int y) {
        assert x > 0 && y > 0;
        data = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < x; j++) {
                row.add(0);
            }
            data.add(row);
        }
    }

    public Integer get(int x, int y) {
        return data.get(x).get(y);
    }

    public void set(int x, int y, int value) {
        data.get(x).set(y, value);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (ArrayList<Integer> row: data)
            result.append(row);
        return result.toString();
    }
}
