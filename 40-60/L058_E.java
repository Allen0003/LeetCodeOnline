public class L058_E {


//    Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
//
//    If the last word does not exist, return 0.
//
//    Note: A word is defined as a character sequence consists of non-space characters only.
//
//            Example:
//
//    Input: "Hello World"
//    Output: 5

    public static void main(String[] args) {

        String input = " ";

        System.out.println(new L058_E().lengthOfLastWord(input));
    }

    public int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }
        String temp[] = s.trim().split(" ");
        return temp[temp.length - 1].length();
    }
}
