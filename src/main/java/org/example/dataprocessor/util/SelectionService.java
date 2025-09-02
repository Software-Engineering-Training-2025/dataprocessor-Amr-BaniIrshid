package org.example.dataprocessor.util;

import java.util.List;
import java.util.Random;

public class SelectionService {
    private static final Random RNG = new Random();

    private SelectionService() {}

    public static int select(List<Integer> list, int k1Based) {
        if (k1Based < 1 || k1Based > list.size()) {
            throw new IllegalArgumentException("k out of range");
        }
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();

        return quickSelect(arr, 0, arr.length - 1, k1Based - 1);
    }


    private static int quickSelect(int[] array, int left, int right, int k) {
        if (left == right) return array[left];
        int pivot = array[left + RNG.nextInt(right - left + 1)];
        int p = partition(array, left, right, pivot);
        if (k <= p) {
            return quickSelect(array, left, p, k);
        } else {
            return quickSelect(array, p + 1, right, k);
        }
    }

    private static int partition(int[] array, int left, int right, int pivotVal) {
        int i = left - 1, j = right + 1;
        while (true) {
            do { i++; } while (array[i] < pivotVal);
            do { j--; } while (array[j] > pivotVal);
            if (i >= j) return j;
            swap(array, i, j);

        }
    }

    private static void swap(int[] array, int i, int j) {
        if (i != j) {
            int t = array[i];
            array[i] = array[j];
            array[j] = t;
        }
    }
}
