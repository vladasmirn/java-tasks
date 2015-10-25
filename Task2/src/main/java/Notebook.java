
/**
 * Created by Влада on 24.10.2015.
 */
public class Notebook {
    private final String colour;
    private final int countOfPage;


    public Notebook(int countOfPage, String colour) {
        this.countOfPage = countOfPage;
        this.colour = colour;
    }

    public int GetCountOfPage() {
        return countOfPage;
    }

    public String GetColor() {
        return colour;
    }

}