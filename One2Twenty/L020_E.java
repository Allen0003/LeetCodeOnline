
//        Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//        An input string is valid if:
//
//        Open brackets must be closed by the same type of brackets.
//        Open brackets must be closed in the correct order.
//        Note that an empty string is also considered valid.

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
}
