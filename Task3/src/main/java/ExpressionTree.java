/**
 * Created by Влада on 20.11.2015.
 */
public class ExpressionTree implements Expression {
    private final Expression left;
    private final Expression right;
    private final char operation;

    public ExpressionTree(Expression left, Expression right, char operation) {
        this.left = left;
        this.right = right;
        this.operation = operation;
    }

    public double calc(double x) throws Exception {
        double resLeft = left.calc(x);
        double resRight = right.calc(x);
        switch (operation) {
            case '+':
                return (resLeft + resRight);
            case '-':
                return (resLeft - resRight);
            case '*':
                return (resLeft * resRight);
            case '/':
                if (resRight != 0)
                    return (resLeft / resRight);
                else
                    throw new Exception("Calculation error!");
            default:
                return 0;
        }
    }
}