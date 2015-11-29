/**
 * Created by Влада on 20.11.2015.
 */
public class Const implements Expression {
    private final double value;

    public Const(double value) {
        this.value = value;
    }

    public double calc(double x) {
        return this.value;
    }
}