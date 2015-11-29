/**
 * Created by Влада on 20.11.2015.
 */
public class Main {
    public static void main(String[] args) {
        double x = 0;
        final Calculation calc = new Calculation();
        Expression result = null;
        if (args.length == 2) {
            try {
                x = Double.valueOf(args[1]);
                result = calc.calcString(args[0]);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                System.out.println(result.calc(x));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.print("error: Wrong arguments");
        }
    }
}
