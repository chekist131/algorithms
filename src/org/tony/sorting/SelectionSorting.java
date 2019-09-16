package org.tony.sorting;

/**
 * O(n^2)
 * Неустойчивая (может быть и устойчивой)
 * На каждой итерации находим минимальное
 * значение на нетсортированном участке и производим обмен
 * этого значения со значением первого элемента на этом участке
 */
public class SelectionSorting extends Sorting {

    @Override
    protected void sort(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }
}
