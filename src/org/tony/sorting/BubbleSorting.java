package org.tony.sorting;

public class BubbleSorting extends Sorting {

    @Override
    protected void sort(Integer[] array) {
        boolean needIntegration = true;
        while (needIntegration) {
            needIntegration = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                    needIntegration = true;
                }
            }
        }
    }
}
