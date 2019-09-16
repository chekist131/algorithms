package org.tony.sorting;

/**
 * O(nlogn)
 * O(n) памяти
 */
public class MergeSorting extends Sorting {

    private static void mergeSorting(final Integer[] array) {
        if (array.length >= 2) {
            Integer[] leftArray;
            Integer[] rightArray;
            {
                final int middle = (array.length) / 2;
                leftArray = new Integer[middle];
                System.arraycopy(array, 0, leftArray, 0, middle);
                rightArray = new Integer[array.length - middle];
                System.arraycopy(array, middle, rightArray, 0, array.length - middle);
            }
            mergeSorting(leftArray);
            mergeSorting(rightArray);
            final Integer[] newArray = new Integer[array.length];
            for (int i = 0, leftMarker = 0, rightMarker = 0; i < newArray.length; i++) {
                if (rightMarker == rightArray.length) {
                    newArray[i] = leftArray[leftMarker];
                    leftMarker++;
                } else if (leftMarker == leftArray.length) {
                    newArray[i] = rightArray[rightMarker];
                    rightMarker++;
                } else if (leftArray[leftMarker] > rightArray[rightMarker]) {
                    newArray[i] = rightArray[rightMarker];
                    rightMarker++;
                } else {
                    newArray[i] = leftArray[leftMarker];
                    leftMarker++;
                }
            }
            System.arraycopy(newArray, 0, array, 0, newArray.length);
        }
    }

    @Override
    protected void sort(Integer[] array) {
        mergeSorting(array);
    }
}
