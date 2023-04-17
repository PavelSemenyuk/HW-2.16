import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    }

}

class Algoritm {

    private static final int DEFAULT_CAPACITY = 10;
    private Integer[] storage;
    private int size;

    public Algoritm() {
        this(DEFAULT_CAPACITY);
    }

    private void grow() {
        int newCapacity = (int) (storage.length * 1.5);
         storage = Arrays.copyOf(storage, newCapacity);
    }

    public Algoritm(int capacity) {
        storage = new Integer[capacity];
    }

    public void add(Integer item) {
        if (size == storage.length) {
            grow();
        }
        storage[size++] = item;
    }

    public void add(int index, Integer item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
        if (size == storage.length) {
            grow();
        }
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = item;
        size++;
    }

    private void sort(Integer[]arr){
        quickSort(arr, 0, arr.length-1);
    }

    public static void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private static void swapElements(Integer[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    public int size() {
        return size;
    }

    public int isEmpty() {
        return size;
    }
}