/**
 * Created by ����� on 24.10.2015.
 */

import java.util.Comparator;

public class NotebookColourComp implements Comparator<Notebook> {
    public int compare(Notebook bookOne, Notebook bookTwo) {
        return (bookOne.getColor()).compareTo(bookTwo.getColor());
    }
}