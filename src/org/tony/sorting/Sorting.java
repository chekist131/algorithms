package org.tony.sorting;

public abstract class Sorting {

    protected static void swap(Integer[] array, int i1, int i2) {
        int tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }

    protected abstract void sort(Integer[] array);

    public Integer[] getSortedArray(final Integer[] array) {
        Integer[] newArray = array.clone();
        this.sort(newArray);
        return newArray;
    }

}
