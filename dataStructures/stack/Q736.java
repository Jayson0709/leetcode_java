package dataStructures.stack;
import java.util.*;
import java.nio.charset.StandardCharsets;


//You are given a string expression representing a Lisp-like expression to return the integer value of.
//
//    The syntax for these expressions is given as follows.
//
//    An expression is either an integer, let expression, add expression, multiply expression, or an assigned variable. Expressions always evaluate to a single integer.
//    (An integer could be positive or negative.)
//    A let expression takes the form "(let v1 e1 v2 e2 ... vn en expr)", where 'let' is always the string "let", then there are one or more pairs of alternating variables and expressions, meaning that the first variable v1 is assigned the value of the expression e1, the second variable v2 is assigned the value of the expression e2, and so on sequentially; and then the value of this let expression is the value of the expression expr.
//    An add expression takes the form "(add e1 e2)" where add is always the string "add", there are always two expressions e1, e2 and the result is the addition of the evaluation of e1 and the evaluation of e2.
//    A multiply expression takes the form "(multiply e1 e2)" where multiply is always the string "multiply", there are always two expressions e1, e2 and the result is the multiplication of the evaluation of e1 and the evaluation of e2.
//    For this question, we will use a smaller subset of variable names. A variable starts with a lowercase letter, then zero or more lowercase letters or digits. Additionally, for your convenience, the names "add", "let", and "multiply" are protected and will never be used as variable names.
//    Finally, there is the concept of scope. When an expression of a variable name is evaluated, within the context of that evaluation, the innermost scope (in terms of parentheses) is checked first for the value of that variable, and then outer scopes are checked sequentially. It is guaranteed that every expression is legal. Please see the examples for more details on the scope.
//
//    Example 1:
//    Input: expression = "(let x 2 (multiply x (let x 3 y 4 (add x y))))"
//    Output: 14
//    Explanation: In the expression (add x y), when checking for the value of the variable x,
//    we check from the innermost scope to the outermost in the context of the variable we are trying to evaluate.
//    Since x = 3 is found first, the value of x is 3.
//
//    Example 2:
//    Input: expression = "(let x 3 x 2 x)"
//    Output: 2
//    Explanation: Assignment in let statements is processed sequentially.
//
//    Example 3:
//    Input: expression = "(let x 1 y 2 x (add x y) (add x y))"
//    Output: 5
//    Explanation: The first (add x y) evaluates as 3, and is assigned to x.
//    The second (add x y) evaluates as 3+2 = 5.
//
//    Constraints:
//    1 <= expression.length <= 2000
//    There are no leading or trailing spaces in expression.
//    All tokens are separated by a single space in expression.
//    The answer and all intermediate calculations of that answer are guaranteed to fit in a 32-bit integer.
//    The expression is guaranteed to be legal and evaluate to an integer.


//给你一个类似 Lisp 语句的字符串表达式 expression，求出其计算结果。
//
//    表达式语法如下所示:
//
//    表达式可以为整数，let 表达式，add 表达式，multiply 表达式，或赋值的变量。表达式的结果总是一个整数。
//    (整数可以是正整数、负整数、0)
//    let 表达式采用"(let v1 e1 v2 e2 ... vn en expr)" 的形式，其中let 总是以字符串"let"来表示，接下来会跟随一对或多对交替的变量和表达式，也就是说，第一个变量v1被分配为表达式e1的值，第二个变量v2被分配为表达式e2的值，依次类推；最终 let 表达式的值为expr表达式的值。
//    add 表达式表示为"(add e1 e2)" ，其中add 总是以字符串"add" 来表示，该表达式总是包含两个表达式 e1、e2 ，最终结果是e1 表达式的值与e2表达式的值之 和 。
//    multiply 表达式表示为"(multiply e1 e2)"，其中multiply 总是以字符串 "multiply" 表示，该表达式总是包含两个表达式 e1、e2，最终结果是e1 表达式的值与e2表达式的值之 积 。
//    在该题目中，变量名以小写字符开始，之后跟随 0 个或多个小写字符或数字。为了方便，"add" ，"let" ，"multiply" 会被定义为 "关键字" ，不会用作变量名。
//    最后，要说一下作用域的概念。计算变量名所对应的表达式时，在计算上下文中，首先检查最内层作用域（按括号计），然后按顺序依次检查外部作用域。测试用例中每一个表达式都是合法的。有关作用域的更多详细信息，请参阅示例。
//
//    示例 1：
//    输入：expression = "(let x 2 (multiply x (let x 3 y 4 (add x y))))"
//    输出：14
//    解释：
//    计算表达式 (add x y), 在检查变量 x 值时，
//    在变量的上下文中由最内层作用域依次向外检查。
//    首先找到 x = 3, 所以此处的 x 值是 3 。
//
//    示例 2：
//    输入：expression = "(let x 3 x 2 x)"
//    输出：2
//    解释：let 语句中的赋值运算按顺序处理即可。
//
//    示例 3：
//    输入：expression = "(let x 1 y 2 x (add x y) (add x y))"
//    输出：5
//    解释：
//    第一个 (add x y) 计算结果是 3，并且将此值赋给了 x 。
//    第二个 (add x y) 计算结果是 3 + 2 = 5 。
//
//    提示：
//    1 <= expression.length <= 2000
//    expression 中不含前导和尾随空格
//    expression 中的不同部分（token）之间用单个空格进行分隔
//    答案和所有中间计算结果都符合 32-bit 整数范围
//    测试用例中的表达式均为合法的且最终结果为整数


public class Q736 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String expression = cin.nextLine().strip();
        cin.close();

        int result = evaluate(expression);
        System.out.println(result);
    }

    static Map<String, Deque<Integer>> scope = new HashMap<String, Deque<Integer>>();

    public static int evaluate(String expression) {
        Deque<Deque<String>> vars = new ArrayDeque<Deque<String>>();
        int start = 0, n = expression.length();
        Deque<Expr> stack = new ArrayDeque<Expr>();
        Expr cur = new Expr(ExprStatus.VALUE);
        while (start < n) {
            if (expression.charAt(start) == ' ') {
                start++; // remove space
                continue;
            }
            if (expression.charAt(start) == '(') {
                start++; // remove left parenthesis
                stack.push(cur);
                cur = new Expr(ExprStatus.NONE);
                continue;
            }
            StringBuilder sb = new StringBuilder();
            if (expression.charAt(start) == ')') { // turn the expression into a token
                start++; // remove right parenthesis
                if (cur.status == ExprStatus.LET2) {
                    sb = new StringBuilder(Integer.toString(cur.value));
                    if (vars.peek() != null) {
                        for (String var : vars.peek()) { // clear the action scope
                            scope.get(var).pop();
                        }
                    }
                    vars.pop();
                } else if (cur.status == ExprStatus.ADD2) {
                    sb = new StringBuilder(Integer.toString(cur.e1 + cur.e2));
                } else {
                    sb = new StringBuilder(Integer.toString(cur.e1 * cur.e2));
                }
                cur = stack.pop(); // obtain the upper status
            } else {
                while (start < n && expression.charAt(start) != ' ' && expression.charAt(start) != ')') {
                    sb.append(expression.charAt(start));
                    start++;
                }
            }
            String token = sb.toString();
            switch (cur.status.toString()) {
                case "VALUE":
                    cur.value = Integer.parseInt(token);
                    cur.status = ExprStatus.DONE;
                    break;
                case "NONE":
                    switch (token) {
                        case "let" -> {
                            cur.status = ExprStatus.LET;
                            vars.push(new ArrayDeque<String>()); // store all variables in this level's action scope
                        }
                        case "add" -> cur.status = ExprStatus.ADD;
                        case "mult" -> cur.status = ExprStatus.MULT;
                    }
                    break;
                case "LET":
                    if (expression.charAt(start) == ')') {
                        cur.value = calculateToken(token);
                        cur.status = ExprStatus.LET2;
                    } else {
                        cur.var = token;
                        if (vars.peek() != null) {
                            vars.peek().push(token); // store all variables in this level's action scope
                        }
                        cur.status = ExprStatus.LET1;
                    }
                    break;
                case "LET1":
                    scope.putIfAbsent(cur.var, new ArrayDeque<Integer>());
                    scope.get(cur.var).push(calculateToken(token));
                    cur.status = ExprStatus.LET;
                    break;
                case "ADD":
                    cur.e1 = calculateToken(token);
                    cur.status = ExprStatus.ADD1;
                    break;
                case "ADD1":
                    cur.e2 = calculateToken(token);
                    cur.status = ExprStatus.ADD2;
                    break;
                case "MULT":
                    cur.e1 = calculateToken(token);
                    cur.status = ExprStatus.MULT1;
                    break;
                case "MULT1":
                    cur.e2 = calculateToken(token);
                    cur.status = ExprStatus.MULT2;
                    break;
            }
        }
        return cur.value;
    }

    public static int calculateToken(String token) {
        if (Character.isLowerCase(token.charAt(0))) {
            return scope.get(token).peek();
        } else {
            return Integer.parseInt(token);
        }
    }
}

enum ExprStatus {
    VALUE,     // initial status
    NONE,      // type of the expression is unknown.
    LET,       // let expression
    LET1,      // let expression already evaluated vi
    LET2,      // let expression already evaluated expr
    ADD,       // add expression
    ADD1,      // add expression already evaluated e1
    ADD2,      // add expression already evaluated e2
    MULT,      // mult expression
    MULT1,     // mult expression already evaluated e1
    MULT2,     // mult expression already evaluated e2
    DONE       // evaluation is done
}

class Expr {
    ExprStatus status;
    String var; // let's variable: vi
    int value; // VALUE，or LET2
    int e1, e2; // add or mult's values of e1 and e2

    public Expr(ExprStatus s) {
        status = s;
    }
}
