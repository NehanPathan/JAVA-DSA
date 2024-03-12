public class SelectionSort {
    public void sort(int[] array) {
        for (int i = 0; i < (array.length - 1); i++) {
            var minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex])
                    minIndex = j;
                swap(array, minIndex, i);
            }
        }
    }

    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
