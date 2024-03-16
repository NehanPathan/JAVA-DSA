public class CountingSort {
    public void sort(int[] array, int max) {
        int[] counts = new int[max + 1];

        for (int item : array)
            counts[item]++;

        var k = 0;
        // for (int i = 1; i < counts.length; i++) {
        // if (counts[i] != 0) {
        // while (counts[i] != 0) {
        // array[k++] = i;
        // counts[i]--;
        // }
        // }
        // }
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                array[k++] = i;
            }
        }
    }
}
