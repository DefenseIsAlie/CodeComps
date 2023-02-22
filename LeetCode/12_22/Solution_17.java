import java.util.Stack;

class Solution_17 {
    
    public static void main(String[] args) {
        Solution_17 s = new Solution_17();

        String[] test = {"4","13","5","/","+"};

        System.out.println(s.evalRPN(test));

    }

    Stack<Integer> stackIntegers = new Stack<Integer>();

    public int evalRPN(String[] tokens) {

        int a;
        int b;
        
        for (String token : tokens) {
            switch (token) {
                case "+":
                    a = stackIntegers.pop();
                    b = stackIntegers.pop();
                    System.out.println("Doing a+b " + a + " " + b);
                    stackIntegers.push(b+a);
                    break;
                case "-":
                    a = stackIntegers.pop();
                    b = stackIntegers.pop();
                    System.out.println("Doing a-b " + a + " " + b);
                    stackIntegers.push(b-a);
                    break;

                case "*":
                    a = stackIntegers.pop();
                    b = stackIntegers.pop();
                    System.out.println("Doing b*a " + a + " " + b);
                    stackIntegers.push(a*b);

                    break;
                case "/":
                    a = stackIntegers.pop();
                    b = stackIntegers.pop();
                    System.out.println("Doing b/a " + a + " " + b);
                    stackIntegers.push((int)(b/a));

                    break;
                default:
                stackIntegers.push(Integer.parseInt(token));
                    break;
            }
        }

        return stackIntegers.pop();
    }
}