package org.tony.sorting;

public class QuickSorting extends Sorting {

    private static void quickSorting(
            Integer[] source,
            final int leftBorder,
            final int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = source[(leftMarker + rightMarker) / 2];
        do {
            while (source[leftMarker] < pivot)
                leftMarker++;
            while (source[rightMarker] > pivot)
                rightMarker--;
            if (leftMarker < rightMarker)
                swap(source, leftMarker, rightMarker);
            leftMarker++;
            rightMarker--;
        } while (leftMarker <= rightMarker);
        if (leftMarker < rightBorder)
            quickSorting(source, leftMarker, rightBorder);
        if (leftBorder < rightMarker)
            quickSorting(source, leftBorder, rightMarker);
    }

    @Override
    protected void sort(Integer[] array) {
        quickSorting(array, 0, array.length - 1);
    }
}
