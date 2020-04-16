import basicDataStructure.ListNode;
import basicDataStructure.TreeNode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class L250To300 {

    public String getHint(String secret, String guess) {

        int A = 0;
        int B = 0;

        List guessList = new ArrayList<>(Arrays.asList(guess.split("")));
        List secretList = new ArrayList<>(Arrays.asList(secret.split("")));
        List<Integer> removeList = new ArrayList();

        for (int i = 0; i < secretList.size(); i++) {
            if (secretList.get(i).equals(guessList.get(i))) {
                A++;
                removeList.add(i);
            }
        }

        for (int i = removeList.size() - 1; i >= 0; i--) {
            guessList.remove(removeList.get(i).intValue());
            secretList.remove(removeList.get(i).intValue());
        }


        for (int i = 0; i < guessList.size(); i++) {
            if (secretList.contains(guessList.get(i))) {
                B++;
                secretList.remove(guessList.get(i));
            }
        }

        return A + "A" + B + "B";
    }


    public boolean canWinNim(int n) {
        return n % 4 <= 3;
    }

    public int missingNumber(int[] nums) {
        List<Integer> toReturn = IntStream.range(0, nums.length + 1).mapToObj(Integer::valueOf).collect(Collectors.toList());
        toReturn.removeAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        return toReturn.get(0);
    }

    public boolean isUgly(int num) {

        if (num == 0) {
            return false;
        } else if (num == 1) {
            return true;
        } else if (num % 2 == 0) {
            return isUgly(num / 2);
        } else if (num % 3 == 0) {
            return isUgly(num / 3);
        } else if (num % 5 == 0) {
            return isUgly(num / 5);
        }
        return false;
    }


    public int addDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += (num % 10);
            num = num / 10;
            if (num <= 0 && sum >= 10) {
                num = sum;
                sum = 0;
            }
        }
        return sum;
    }


    public List<String> binaryTreePaths(TreeNode root) {

        if (root == null) {
            return null;
        }
        List<String> result = new ArrayList<>();

        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);

        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        parent.put(root, null);

        while (!nodeStack.isEmpty()) {
            TreeNode current = nodeStack.pop();
            if (current.left == null && current.right == null) {
                Stack<TreeNode> stk = new Stack<>();
                while (current != null) {
                    stk.push(current);
                    current = parent.get(current);
                }
                String temp = "";
                while (!stk.isEmpty()) {
                    current = stk.pop();
                    temp += current.val + "->";
                }
                result.add(temp.length() != 0 ? temp.substring(0, temp.length() - 2) : "");
            }
            if (current.right != null) {
                parent.put(current.right, current);
                nodeStack.push(current.right);
            }
            if (current.left != null) {
                parent.put(current.left, current);
                nodeStack.push(current.left);
            }
        }

        return result;
    }

    public int[] singleNumber(int[] nums) {

        if (nums.length == 0) {
            return new int[]{0, 0};
        }

        List<Integer> arrayList = Arrays.stream(nums).boxed().collect(Collectors.toList());

        ArrayList<Integer> temp = new ArrayList<>(arrayList);
        for (Integer number : new HashSet<Integer>(arrayList)) {
            temp.remove(number);
        }
        arrayList.removeAll(temp);
        return arrayList.stream().mapToInt(i -> i).toArray();
    }

    public int lengthOfLIS(int[] nums) {
        int lis[] = new int[nums.length];
        int i, j, max = 0;

        for (i = 0; i < nums.length; i++) {
            lis[i] = 1;
        }

        for (i = 1; i < nums.length; i++) {
            for (j = 0; j < i; j++) {
                if (nums[i] > nums[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        for (i = 0; i < nums.length; i++) {
            max = Math.max(max, lis[i]);
        }
        return max;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String result = "";
        String shortest = Arrays.asList(strs).stream()
                .sorted((e2, e1) -> e1.length() > e2.length() ? -1 : 1)
                .findFirst().get();

        for (int i = 0; i < shortest.length(); i++) {
            char current = shortest.charAt(i);
            boolean isDifferent = false;
            for (String star : strs) {
                if (current != star.charAt(i)) {
                    isDifferent = true;
                    break;
                }
            }
            if (isDifferent) {
                break;
            } else {
                result += current;
            }
        }
        return result;
    }


    // TODO
    public int numSquares(int n) {

        int result = 0;

        int temp = (int) Math.sqrt(n);

        List<Integer> candidateNumbers = new ArrayList<>();

        for (int i = 1; i <= temp; i++) {
            candidateNumbers.add((int) Math.pow(i, 2));
        }


        int count[] = new int[n + 1];

        // base case
        count[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int candidateNumber : candidateNumbers) {
                if (i >= candidateNumber) {
                    count[i] += count[i - candidateNumber];
                }
            }
        }

        return result;
    }


}
