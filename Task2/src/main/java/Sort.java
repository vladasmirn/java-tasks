/**
 * Created by Влада on 24.10.2015.
 */

import java.util.Comparator;

public interface Sort<T> {
    T[] sort(T[] array, Comparator<T> comparator);
}
