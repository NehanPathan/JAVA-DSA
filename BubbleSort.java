public class BubbleSort {

    public void sort(int[] array) {
        int n = array.length;
        boolean isSorted;
        for (int i = 0; i < n; i++) {
            isSorted = true;
            for (int j = 1; j < n - i; j++) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                    isSorted = false;
                }
            }
            if (isSorted)
                return;
        }
    }

    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}

// public class BubbleSort {
//     public void sort(int[] array) {
//         int n = array.length;
//         boolean swapped;
//         for (int i = 0; i < n - 1; i++) {
//             swapped = false;
//             for (int j = 0; j < n - i - 1; j++) {
//                 if (array[j] > array[j + 1]) {
//                     swap(array, j, j + 1);
//                     swapped = true;
//                 }
//             }
//             if (!swapped) {
//                 // If no two elements were swapped in the inner loop, array is already sorted
//                 break;
//             }
//         }
//     }

//     private void swap(int[] array, int index1, int index2) {
//         int temp = array[index1];
//         array[index1] = array[index2];
//         array[index2] = temp;
//     }
// }

