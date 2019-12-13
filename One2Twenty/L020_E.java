
//        Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//        An input string is valid if:
//
//        Open brackets must be closed by the same type of brackets.
//        Open brackets must be closed in the correct order.
//        Note that an empty string is also considered valid.

import java.util.HashMap;
import java.util.Stack;

public class L020_E {
    public static void main(String[] args) {
        String input = "[";
        System.out.println(new L020_E().isValid(input));
    }

    // my answer
    public boolean isValid(String s) {
        String[] waitingCharacters = s.split("");
        Stack<String> expectStack = new Stack<>();
        for (String waitingCharacter : waitingCharacters) {
            if (waitingCharacter.equals("(") || waitingCharacter.equals("{") || waitingCharacter.equals("[")) {
                expectStack.push(waitingCharacter);
            } else if (waitingCharacter.equals(")") || waitingCharacter.equals("}") || waitingCharacter.equals("]")) {
                if (expectStack.isEmpty()) {
                    return false;
                } else { // there is something in the stack
                    String tempCompare = expectStack.pop();
                    if (waitingCharacter.equals(")") && !tempCompare.equals("(")) {
                        return false;
                    } else if (waitingCharacter.equals("}") && !tempCompare.equals("{")) {
                        return false;
                    } else if (waitingCharacter.equals("]") && !tempCompare.equals("[")) {
                        return false;
                    }
                }
            }
        }
        return expectStack.isEmpty();
    }


    private HashMap<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public L020_E() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    //official solution
    public boolean isValid2(String s) {

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (this.mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }
}
