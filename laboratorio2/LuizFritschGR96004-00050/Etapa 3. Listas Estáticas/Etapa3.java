import java.util.Stack;

public class Etapa3 {
    public boolean checkBrackets(Stack<Character> s1) {
        Stack<Character> tempStack = new Stack<>();

        while (!s1.isEmpty()) {
            char current = s1.pop();
            if (current == ')') {
                tempStack.push(current);
            } else if (current == '(') {
                if (tempStack.isEmpty()) {
                    return false;
                } else {
                    tempStack.pop();
                }
            }
        }
        return tempStack.isEmpty();
    }
}
