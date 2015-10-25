/**
 * Created by Влада on 23.10.2015.
 */

import java.util.Arrays;
import java.util.Comparator;

public class Qsort<T> implements Sort<T> {
    private static <T> void qsort(T[] input, int start, int end, Comparator<T> comparator) {
        int left = start;
        int right = end - 1;
        T pivot = input[(left + right) / 2];
        while (left <= right) {
            while (comparator.compare(input[left], pivot) < 0 && (left < end)) {
                left++;
            }
            while (comparator.compare(input[right], pivot) > 0 && (right > start)) {
                right--;
            }
            if (left <= right) {
                T temp = input[left];
                input[left] = input[right];
                input[right] = temp;
                left++;
                right--;
            }
        }
        if (start < right) {
            qsort(input, start, right + 1, comparator);
        }
        if (left < end) {
            qsort(input, left, end, comparator);
        }
    }

    public T[] sort(T[] array, Comparator<T> comparator) {
        T[] result = Arrays.copyOf(array, array.length);
        if (array.length != 0)
            qsort(result, 0, array.length, comparator);
        return result;
    }
}

