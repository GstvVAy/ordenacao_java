import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Sort{

    public static class Bubble {
    public static void bubbleSort(int[] vetoresArray) {
        long inicio = System.nanoTime();
        long fim;

        int e = calculateArrayLength(vetoresArray);

        int temp = 0;
        for (int i = 0; i < e; i++) {
            for (int j = 1; j < (e - 1); j++) {
                if (vetoresArray[j - 1] > vetoresArray[j]) {
                    temp = vetoresArray[j - 1];
                    vetoresArray[j - 1] = vetoresArray[j];
                    vetoresArray[j] = temp;
                }
            }
            fim = System.nanoTime();
        }
        fim = System.nanoTime();
        System.out.println("Lista ordenada por BubbleSort: " + Arrays.toString(vetoresArray));
        fim = System.nanoTime();
        System.out.println("Tempo: " + (fim - inicio) + " nanossegundos");
    }


    private static int calculateArrayLength(int[] arr) {
        int count = 0;
        for (int i : arr) {
            count++;
        }
        return count;
    }

}
    public static class Selection {
        public static void selectionSort(int[] vetoresArray) {
            long inicio = System.nanoTime();
            long fim;
    

            int e = calculateArrayLength(vetoresArray);
    
            for (int i = 0; i < e; i++) {
                int menorE = i;
                for (int j = i + 1; j < e; j++)
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
    

        private static int calculateArrayLength(int[] arr) {
            int count = 0;
            for (int i : arr) {
                count++;
            }
            return count;
        }
    }

    public static class Merge {
        public static void mergeSort(int[] vetoresArray) {
            long inicio = System.nanoTime();
            long fim;
    
            if (getArrayLength(vetoresArray) <= 1) {
                return;
            }
    
            int mid = getArrayLength(vetoresArray) / 2;
            int[] left = new int[mid];
            int[] right = new int[getArrayLength(vetoresArray) - mid];
    
            copyArray(vetoresArray, 0, left, 0, mid);
            copyArray(vetoresArray, mid, right, 0, getArrayLength(vetoresArray) - mid);
    
            mergeSort(left);
            mergeSort(right);
    
            merge(vetoresArray, left, right);
    
            fim = System.nanoTime();
            System.out.println("Lista ordenada por MergeSort: " + Arrays.toString(vetoresArray));
            System.out.println("Tempo: " + (fim - inicio) + " nanossegundos");
        }
    
        private static void merge(int[] vetoresArray, int[] left, int[] right) {
            int i = 0, j = 0, k = 0;
    
            while (i < getArrayLength(left) && j < getArrayLength(right)) {
                if (left[i] <= right[j]) {
                    vetoresArray[k++] = left[i++];
                } else {
                    vetoresArray[k++] = right[j++];
                }
            }
    
            while (i < getArrayLength(left)) {
                vetoresArray[k++] = left[i++];
            }
    
            while (j < getArrayLength(right)) {
                vetoresArray[k++] = right[j++];
            }
        }
    
        private static int getArrayLength(int[] arr) {
            int count = 0;
            for (int i : arr) {
                count++;
            }
            return count;
        }
    

        private static void copyArray(int[] src, int srcPos, int[] dest, int destPos, int length) {
            for (int i = 0; i < length; i++) {
                dest[destPos + i] = src[srcPos + i];
            }
        }
    }
    

    public static class Quick {
        public static void quickSort(int[] vetoresArray) {
            long inicio = System.nanoTime();
            long fim;
    
            int e = calculateArrayLength(vetoresArray);
    
            if (e <= 1) {
                return;
            }
    
            int pivot = vetoresArray[e - 1];
            int i = 0;
    
            for (int j = 0; j < e - 1; j++) {
                if (vetoresArray[j] <= pivot) {
                    int temp = vetoresArray[i];
                    vetoresArray[i] = vetoresArray[j];
                    vetoresArray[j] = temp;
                    i++;
                }
            }
    
            int temp = vetoresArray[i];
            vetoresArray[i] = vetoresArray[e - 1];
            vetoresArray[e - 1] = temp;
    
            quickSort(Arrays.copyOfRange(vetoresArray, 0, i));
            quickSort(Arrays.copyOfRange(vetoresArray, i + 1, e));
    
            fim = System.nanoTime();
            System.out.println("Lista ordenada por QuickSort: " + Arrays.toString(vetoresArray));
            System.out.println("Tempo: " + (fim - inicio) + " nanossegundos");
        }

        private static int calculateArrayLength(int[] arr) {
            int count = 0;
            for (int i : arr) {
                count++;
            }
            return count;
        }
    }
    

    public static class Heap {
        public static void heapSort(int[] vetoresArray) {
            long inicio = System.nanoTime();
            long fim;
    
            int e = calculateArrayLength(vetoresArray);
    
            buildHeap(vetoresArray, e);
    
            for (int i = e - 1; i >= 0; i--) {
                int temp = vetoresArray[0];
                vetoresArray[0] = vetoresArray[i];
                vetoresArray[i] = temp;
    
                heapify(vetoresArray, 0, i);
            }
    
            fim = System.nanoTime();
            System.out.println("Lista ordenada por HeapSort: " + Arrays.toString(vetoresArray));
            System.out.println("Tempo: " + (fim - inicio) + " nanossegundos");
        }
    
        private static void buildHeap(int[] vetoresArray, int e) {
            for (int i = e / 2 - 1; i >= 0; i--) {
                heapify(vetoresArray, i, e);
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
    

        private static int calculateArrayLength(int[] arr) {
            int count = 0;
            for (int i : arr) {
                count++;
            }
            return count;
        }
    }
}




