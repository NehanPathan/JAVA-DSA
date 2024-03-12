import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] numbers = { 3, 5, 2, 1, 9, 7 };
        var selectionSort = new SelectionSort();
        selectionSort.sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
