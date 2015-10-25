/**
 * Created by Влада on 24.10.2015.
 */

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Random;


@RunWith(Parameterized.class)

public class QuickSortTest<T> {

    private static final Comparator<Notebook> BOOK_COMPARATOR = new NotebookColourComp();//NotebookPageComp();
    private static final Comparator<Double> DOUBLE_COMPARATOR = new Comparator<Double>() {
        public int compare(final Double value1, final Double value2) {
            return value1.compareTo(value2);
        }
    };
    private static final Qsort QUICK_SORT = new Qsort();
    private static Object[][] TEST_DATA_DOUBLE = TestInitialization();
    private static final Object[][] TEST_DATA_BOOK = {

            {QUICK_SORT, BOOK_COMPARATOR, new Notebook[]{}},
            {QUICK_SORT, BOOK_COMPARATOR, new Notebook[]{new Notebook(101, "blue"), new Notebook(32, "red"), new Notebook(54, "grey"), new Notebook(77, "white")}},
            {QUICK_SORT, BOOK_COMPARATOR, new Notebook[]{new Notebook(55, "yellow"), new Notebook(22, "black"), new Notebook(78, "green"), new Notebook(66, "orange")}},
    };


    private static Object[][] TestInitialization() {
        int size = 5;
        Object[][] data = new Object[size][3];

        Random rand = new Random();
        int numb;
        Double[] array;
        for (int i = 0; i < size; i++) {
            numb = rand.nextInt(20);
            array = new Double[numb];

            for (int j = 0; j < array.length; j++) {
                array[j] = Math.floor(rand.nextDouble() * 100.0) / 10.0 - 5.0;
            }

            data[i][0] = QUICK_SORT;
            data[i][1] = DOUBLE_COMPARATOR;
            data[i][2] = array;
        }

        return data;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        //return Arrays.asList(TEST_DATA_BOOK);
        return  Arrays.asList(TEST_DATA_DOUBLE);


    }

    private Sort<T> sort;
    private T[] input;
    private Comparator<T> comparator;

    public QuickSortTest(Sort<T> sort, Comparator<T> comparator, T[] input) {
        this.sort = sort;
        this.comparator = comparator;
        this.input = input;
    }

    @Test
    public void test() {
        T[] result = sort.sort(input, comparator);

        Assert.assertTrue("The array is not sorted", testAscendingOrder(result, comparator));
        Assert.assertEquals("Result array length should be equal to original", input.length, result.length);
        Assert.assertTrue(hasEachElementOf(input, result, comparator));
    }

    private boolean testAscendingOrder(T[] array, Comparator<T> comparator) {
        for (int i = 0; i < array.length - 1; i++) {
            if (comparator.compare(array[i], array[i + 1]) > 0)
                return false;
        }
        return true;
    }

    private boolean hasEachElementOf(T[] input, T[] result, Comparator<T> comparator) {
        for (T element : input) {
            for (int j = 0; j < result.length; j++) {
                if (result[j] == element)
                    break;
                if (j == result.length - 1)
                    return false;
            }
        }
        return true;
    }
}
