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

    public int binarySearch(int[] array, int target) {
        var left = 0;
        var right = array.length - 1;

        while (left <= right) {
            var middle = (left + right) / 2;

            if (array[middle] == target)
                return middle;

            if (target < array[middle])
                right = middle - 1;
            else
                left = middle + 1;

        }
        return -1;
    }

    public int ternarySearch(int[] array, int target) {
        return ternarySearch(array, target, 0, array.length - 1);
    }

    private int ternarySearch(int[] array, int target, int left, int right) {

        if (left > right)
            return -1;

        var partitionSize = (right - left) / 3;
        var mid1 = left + partitionSize;
        var mid2 = right - partitionSize;

        if (array[mid2] == target)
            return mid2;

        if (array[mid1] == target)
            return mid1;

        if (target < array[mid2])
            return ternarySearch(array, target, left, mid1 - 1);

        if (target > array[mid2])
            return ternarySearch(array, target, mid2 + 1, right);

        return ternarySearch(array, target, mid1 + 1, mid2 - 1);

    }

    public int jumpSearch(int[] array, int target) {
        int blockSize = (int) Math.sqrt(array.length);
        var start = 0;
        var next = blockSize;

        while (start < array.length && array[next - 1] < target) {

            start = next;
            next += blockSize;

            if (next > array.length)
                next = array.length;

        }

        for (var i = start; i < next; i++)
            if (array[i] == target)
                return i;

        return -1;
    }

}
