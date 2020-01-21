
public class L60To80 {

    private String[] invertUsingStreams(String[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            String temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }

    //    L067
    public String addBinary(String a, String b) {
        String aArray[] = (String[]) invertUsingStreams(a.split(""));
        String bArray[] = (String[]) invertUsingStreams(b.split(""));
        String cArray[] = new String[Math.max(a.length(), b.length()) + 1];


        int count1 = 0;
        for (int i = 0; i < cArray.length; i++) {
            count1 = 0;

            if (i < aArray.length && aArray[i].equals("1")) {
                count1++;
            }
            if (i < bArray.length && bArray[i].equals("1")) {
                count1++;
            }
            if (cArray[i] != null && cArray[i].equals("1")) {
                count1++;
            }

            if (count1 == 3) {
                cArray[i] = "1";
                cArray[i + 1] = "1";
            } else if (count1 == 2) {
                cArray[i] = "0";
                cArray[i + 1] = "1";
            } else if (count1 == 1) {
                cArray[i] = "1";
            } else {
                cArray[i] = "0";
            }
        }
        return String.join("", (String[]) invertUsingStreams(cArray)).replaceFirst("^0+(?!$)", "");
    }

    //L070 using DP
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


}
