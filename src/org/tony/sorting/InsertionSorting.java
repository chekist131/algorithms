package org.tony.sorting;

/**
 * O(n) ~ O(n^2)
 * Устойчивая
 * Сортировка раздвигает место для каждого элемента в массив,
 * если это необходимо
 */
public class InsertionSorting extends Sorting {

    @Override
    protected void sort(Integer[] array) {
        for (int left = 0; left < array.length; left++) {
            int value = array[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    break;
                }
            }
            array[i + 1] = value;
        }
    }
}
