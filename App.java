import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] numbers = { 1, 4, 7, 9, 10 };
        var search = new Search();

        // var index = search.linearSearch(numbers, 10);

        var index = search.binarySearchIteretive(numbers, 11); // work for sorted array
        System.out.println(index);
    }

}
