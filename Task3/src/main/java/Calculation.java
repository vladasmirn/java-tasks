/**
 * Created by Влада on 20.11.2015.
 */
public class Calculation {
    public Expression calcString(String str) throws Exception {

        if (str.equals(""))
            throw new Exception("Syntax error!");
        if (!checkSyntax(str))
            throw new Exception("Syntax error!");
        if (!countOfBrackets(str))
            throw new Exception("Wrong count of brackets!");
        int lenStr = str.length();
        int pos;
        //'+'
        if ((pos = findPosNotInBracket(str, '+')) != -1)
            return new ExpressionTree(calcString(str.substring(0, pos)), calcString(str.substring(pos + 1)), '+');
        // '-'
        if ((pos = findPosNotInBracket(str, '-')) != -1)
            return new ExpressionTree(calcString(str.substring(0, pos)), calcString(str.substring(pos + 1)), '-');
        //'*'
        if ((pos = findPosNotInBracket(str, '*')) != -1)
            return new ExpressionTree(calcString(str.substring(0, pos)), calcString(str.substring(pos + 1)), '*');
        // '/'
        if ((pos = findPosNotInBracket(str, '/')) != -1)
            return new ExpressionTree(calcString(str.substring(0, pos)), calcString(str.substring(pos + 1)), '/');
        // '(' ')'
        if (str.charAt(0) == '(')
            return calcString(str.substring(1, lenStr - 1));

        int count = 0;
        for (int i = 0; i < lenStr; i++) {

            if (str.charAt(i) == '(')
                count++;
            if (str.charAt(i) == ')')
                count--;
            if (Character.isDigit(str.charAt(i)) && count == 0) {
                return new Const(Double.valueOf(str));
            }
        }
        if (findPosNotInBracket(str, 'x') != -1)
            return new Var();
        throw new Exception("Syntax error!");
    }

    private int findPosNotInBracket(String str, char symbol) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                count++;
            if (str.charAt(i) == ')')
                count--;
            if (str.charAt(i) == symbol && count == 0) {
                return i;
            }
        }
        return -1;
    }

    private boolean checkSyntax(String str) {
        char rightSymbol[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' ', '+', '-', '*', '/', '(', ')', 'x', '.'};
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < rightSymbol.length; j++) {
                if (str.charAt(i) != rightSymbol[j]) {
                    count++;
                }
            }
            if (count == rightSymbol.length)
                return false;
            count = 0;
        }
        return true;
    }

    private boolean countOfBrackets(String str) {
        int countLeft = 0;
        int countRight = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                countLeft++;
            if (str.charAt(i) == ')')
                countRight++;
        }
        if (countLeft != countRight)
            return false;
        return true;
    }
}