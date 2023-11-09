import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sort{
    

    public static class Bubble{
        public static void bubbleSort(int[] vetoresArray){
            
            long inicio = System.nanoTime();
            long fim;
    
            int e = vetoresArray.length;
            int temp = 0;
            for(int i=0; i < e; i++){
                for(int j=1; j < (e-1); j++){
                    if (vetoresArray[j-1] > vetoresArray[j]){
                        temp = vetoresArray[j-1];
                        vetoresArray[j-1] = vetoresArray[j];
                        vetoresArray[j] = temp;
                    }
                }
            fim = System.nanoTime();
            }
            fim = System.nanoTime();
            System.out.println("Lista ordenada por BubbleSort: " +  Arrays.toString(vetoresArray));
            fim = System.nanoTime();
            System.out.println("Tempo: " + (fim - inicio) + " nanossegundos");
        }
    
    }
    public static class Selection {
        public static void selectionSort(int[] vetoresArray) {
            long inicio = System.nanoTime();
            long fim;

            for (int i = 0; i < vetoresArray.length; i++) {
                int menorE = i;
                for (int j = i + 1; j < vetoresArray.length; j++)
                    if (vetoresArray[j] < vetoresArray[menorE])
                        menorE = j;

                int aux = vetoresArray[i];
                vetoresArray[i] = vetoresArray[menorE];
                aux = vetoresArray[menorE];
            }

            fim = System.nanoTime();
            System.out.println("Lista ordenada por SelectionSort: " + Arrays.toString(vetoresArray));
            System.out.println("Tempo: " + (fim - inicio) + " nanossegundos");
        }
    }

    public static class Merge {
        public static void mergeSort(int[] vetoresArray) {
            long inicio = System.nanoTime();
            long fim;

            if (vetoresArray.length <= 1) {
                return;
            }

            int mid = vetoresArray.length / 2;
            int[] left = new int[mid];
            int[] right = new int[vetoresArray.length - mid];

            System.arraycopy(vetoresArray, 0, left, 0, mid);
            System.arraycopy(vetoresArray, mid, right, 0, vetoresArray.length - mid);

            mergeSort(left);
            mergeSort(right);

            merge(vetoresArray, left, right);

            fim = System.nanoTime();
            System.out.println("Lista ordenada por MergeSort: " + Arrays.toString(vetoresArray));
            System.out.println("Tempo: " + (fim - inicio) + " nanossegundos");
        }

        private static void merge(int[] vetoresArray, int[] left, int[] right) {
            int i = 0, j = 0, k = 0;

            while (i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    vetoresArray[k++] = left[i++];
                } else {
                    vetoresArray[k++] = right[j++];
                }
            }

            while (i < left.length) {
                vetoresArray[k++] = left[i++];
            }

            while (j < right.length) {
                vetoresArray[k++] = right[j++];
            }
        }
    }

    public static class Quick {
        public static void quickSort(int[] vetoresArray) {
            long inicio = System.nanoTime();
            long fim;

            if (vetoresArray.length <= 1) {
                return;
            }

            int pivot = vetoresArray[vetoresArray.length - 1];
            int i = 0;

            for (int j = 0; j < vetoresArray.length - 1; j++) {
                if (vetoresArray[j] <= pivot) {
                    int temp = vetoresArray[i];
                    vetoresArray[i] = vetoresArray[j];
                    vetoresArray[j] = temp;
                    i++;
                }
            }

            int temp = vetoresArray[i];
            vetoresArray[i] = vetoresArray[vetoresArray.length - 1];
            vetoresArray[vetoresArray.length - 1] = temp;

            quickSort(Arrays.copyOfRange(vetoresArray, 0, i));
            quickSort(Arrays.copyOfRange(vetoresArray, i + 1, vetoresArray.length));

            fim = System.nanoTime();
            System.out.println("Lista ordenada por QuickSort: " + Arrays.toString(vetoresArray));
            System.out.println("Tempo: " + (fim - inicio) + " nanossegundos");
        }
    }

    public static class Heap {
        public static void heapSort(int[] vetoresArray) {
            long inicio = System.nanoTime();
            long fim;

            buildHeap(vetoresArray);

            for (int i = vetoresArray.length - 1; i >= 0; i--) {
                int temp = vetoresArray[0];
                vetoresArray[0] = vetoresArray[i];
                vetoresArray[i] = temp;

                heapify(vetoresArray, 0, i);
            }

            fim = System.nanoTime();
            System.out.println("Lista ordenada por HeapSort: " + Arrays.toString(vetoresArray));
            System.out.println("Tempo: " + (fim - inicio) + " nanossegundos");
        }

        private static void buildHeap(int[] vetoresArray) {
            for (int i = vetoresArray.length / 2 - 1; i >= 0; i--) {
                heapify(vetoresArray, i, vetoresArray.length);
            }
        }

        private static void heapify(int[] vetoresArray, int i, int n) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;

            if (left < n && vetoresArray[left] > vetoresArray[largest]) {
                largest = left;
            }

            if (right < n && vetoresArray[right] > vetoresArray[largest]) {
                largest = right;
            }

            if (largest != i) {
                int temp = vetoresArray[i];
                vetoresArray[i] = vetoresArray[largest];
                vetoresArray[largest] = temp;

                heapify(vetoresArray, largest, n);
            }
        }
    }

}


