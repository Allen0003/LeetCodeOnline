public class L066_E {
    public static void main(String[] args) {

//        System.out.println(new L020_E().isValid(input));

        int input[] = new int[]{9, 9, 9, 9};


        int[] temp = new L066_E().plusOne(input);


        System.out.println(" ----------------------------------- ");
        System.out.println(temp.length);
        for (int i : temp) {
            System.out.println(i);
        }


    }


    public int[] plusOne(int[] digits, int index) {
        if (index >= digits.length) {
            int[] copy = new int[digits.length + 1];
            System.arraycopy(digits, 0, copy, 0, digits.length);
            copy[0] = 1;
            return copy;
        }

        if (digits[digits.length - 1 - index] != 9) {
            digits[digits.length - 1 - index]++;
        } else {
            digits[digits.length - 1 - index] = 0;
            index = index + 1;
            digits = this.plusOne(digits, index);
        }
        return digits;
    }

    // my solution
    public int[] plusOne(int[] digits) {
        return this.plusOne(digits, 0);
    }


    // almost best solution
    public int[] plusOneCool(int[] digits) {
        int count = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                count++;
                if (count == digits.length) { //hit the first digital
                    int arr[] = new int[digits.length + 1];
                    arr[0] = 1;
                    return arr;
                }
            } else {
                digits[i] += 1;
                break;
            }
        }
        return digits;
    }

}
