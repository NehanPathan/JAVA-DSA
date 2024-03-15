import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] numbers = { 4, 3, 5, 2, 1 };

        var quickSort = new QuickSort();

        quickSort.sort(numbers);

        System.out.println(Arrays.toString(numbers));
    }
}
