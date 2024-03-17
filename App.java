import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] numbers = { 4, 3, 5, 2, 1 };

        var bucketSort = new BucketSort();

        bucketSort.sort(numbers, 3);

        System.out.println(Arrays.toString(numbers));
    }
}
