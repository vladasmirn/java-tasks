/**
 * Created by ����� on 24.10.2015.
 */

import java.util.Comparator;

public class NotebookPageComp implements Comparator<Notebook> {
    public int compare(Notebook bookOne, Notebook bookTwo) {
        return Integer.compare(bookOne.getCountOfPage(), bookTwo.getCountOfPage());
    }
}