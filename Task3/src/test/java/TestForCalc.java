/**
 * Created by Влада on 20.11.2015.
 */

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestForCalc {
    private String expression;
    private Double var;
    private Double answer;
    private String error;

    public TestForCalc(String expression, Double var, Double answer, String error) {
        this.expression = expression;
        this.var = var;
        this.answer = answer;
        this.error = error;
    }

    private static final Object[][] TEST_DATA = new Object[][]{
            {"java", 0.0, 0.0, "Syntax error!"},
            {"1 +1/0", 0.0, 0.0, "Calculation error!"},
            {"x", 2.0, 2.0, ""},
            {"1 + x", 2.0, 3.0, ""},
            {"((((2+2)", 0.0, 0.0, "Wrong count of brackets!"}
    };

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(TEST_DATA);
    }

    @Test
    public void test() {
        try {
            Assert.assertTrue("Wrong answer", checkResult());
        } catch (Exception e) {
            Assert.assertTrue("Wrong exception", checkException(e.getMessage()));
        }

    }

    private boolean checkResult() throws Exception {
        final Calculation calc = new Calculation();
        Expression result = calc.calcString(expression);
        if (result.calc(var) != answer)
            return false;
        else return true;
    }

    private boolean checkException(String exception) {
        System.out.println(exception);
        if (!exception.equals(error))
            return false;
        else return true;
    }

}
