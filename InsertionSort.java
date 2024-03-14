public class InsertionSort {
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            var current = array[i];
            var j = i - 1;

            // Shift elements greater than current to the right
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }

            // Place current in its correct position
            array[j + 1] = current;
        }
    }
}
