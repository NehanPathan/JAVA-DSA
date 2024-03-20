import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] numbers = { 1, 4, 7, 9, 10 };
        var search = new Search();

        // var index = search.linearSearch(numbers, 10);

        // var index = search.binarySearchRec(numbers, 10); work for sorted
        // array(recursive Method)

        // var index = search.binarySearch(numbers, 4); (Iterative Method)

        var index = search.ternarySearch(numbers, 4); // it is less efficient then binarySearch

        System.out.println(index);
    }

}
