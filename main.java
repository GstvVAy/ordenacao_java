import java.util.Random;

public class main{
    public static void main(String[] args) {
        int[] vetoresArray = {50, 500, 1000, 5000, 10000};
        Random random = new Random(123);

        for (int i = 0; i < vetoresArray.length; i++) {
            int[] array = new int[vetoresArray[i]];
            for (int j = 0; j < vetoresArray[i]; j++) {
                array[j] = random.nextInt();
            }
        }

        Sort.Bubble.bubbleSort(vetoresArray);
        Sort.Selection.selectionSort(vetoresArray);
        Sort.Merge.mergeSort(vetoresArray);
        Sort.Quick.quickSort(vetoresArray);
        Sort.Heap.heapSort(vetoresArray);
    }
}
