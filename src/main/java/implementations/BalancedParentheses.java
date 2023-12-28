package implementations;

import interfaces.Solvable;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BalancedParentheses implements Solvable {
    private String parentheses;

    public BalancedParentheses(String parentheses) {
        this.parentheses = parentheses;
    }

    @Override
    public Boolean solve() {
        if (this.parentheses == null || this.parentheses.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < this.parentheses.length(); i++) {
            char currentChar = this.parentheses.charAt(i);

            if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
                stack.push(currentChar);
            } else if (currentChar == ')' || currentChar == ']' || currentChar == '}') {
                if (stack.isEmpty() || !areParenthesesMatching(stack.pop(), currentChar)) {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }

    private boolean areParenthesesMatching(Character opening, char closing) {
        return (opening == '(' && closing == ')') ||
                (opening == '[' && closing == ']') ||
                (opening == '{' && closing == '}');
    }
}
