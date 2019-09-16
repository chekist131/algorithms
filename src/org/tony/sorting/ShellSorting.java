package org.tony.sorting;

/**
 * ... ~ O(n^2)
 * Улучшение сортировки вставками (Insertion sort)
 * Неустойчивая
 */
public class ShellSorting extends Sorting {

    @Override
    protected void sort(Integer[] array) {
        int gap = array.length / 2;
        while (gap >= 1) {
            for (int right = 0; right < array.length; right++) {
                for (int c = right - gap; c >= 0; c -= gap) {
                    if (array[c] > array[c + gap]) {
                        swap(array, c, c + gap);
                    }
                }
            }
            gap /= 2;
        }
    }
}
