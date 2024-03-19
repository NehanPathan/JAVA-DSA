import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Search {
    public int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == target)
                return i;

        return -1;
    }

    public int binarySearchRec(int[] array, int target) {
        return binarySearchRec(array, target, 0, array.length - 1);
    }

    private int binarySearchRec(int[] array, int target, int left, int right) {

        if (left > right)
            return -1;

        var middle = (left + right) / 2;

        if (array[middle] == target)
            return middle;

        if (target < array[middle])
            return binarySearchRec(array, target, left, middle - 1);

        return binarySearchRec(array, target, middle + 1, right);

    }

    public int binarySearchIteretive(int[] array, int target) {
        var left = 0;
        var right = array.length - 1;

        while (left <= right) {
            var middle = (left + right) / 2;

            if (array[middle] == target)
                return middle;

            if (target < array[middle])
                right = middle - 1;
            if (target > array[middle])
                left = middle + 1;

        }
        return -1;
    }

}
