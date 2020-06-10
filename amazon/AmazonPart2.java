package amazon;

import java.util.*;
import java.util.stream.Collectors;

public class AmazonPart2 {

//    Top K Frequently Mentioned Keywords
//
//    Given a list of reviews, a list of keywords and an integer k. Find the most popular k keywords in order of most to least frequently mentioned.
//
//    The comparison of strings is case-insensitive.
//    Multiple occurances of a keyword in a review should be considred as a single mention.
//    If keywords are mentioned an equal number of times in reviews, sort alphabetically.


//    keywords = ["anacell", "cetracular", "betacellular"]
//    reviews = [
//            "Anacell provides the best services in the city",
//            "betacellular has awesome services",
//            "Best services provided by anacell, everyone should use anacell",
//            ]

    public static void main(String[] args) {
        new AmazonPart2().getKFrequentKeyword(Arrays.asList("anacell", "betacellular", "cetracular", "deltacellular", "eurocell"),
                Arrays.asList("I love anacell Best services; Best services provided by anacell",
                        "betacellular has great services",
                        "deltacellular provides much better services than betacellular",
                        "cetracular is worse than anacell",
                        "Betacellular is better than deltacellular."),
                2
        );
    }


    public List<String> getKFrequentKeyword(List<String> keywords, List<String> reviews, int k) {

        List<String> result = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();

        for (String keyword : keywords) {
            for (String review : reviews) {
                if (review.contains(keyword)) {
                    if (map.get(keyword) == null) {
                        map.put(keyword, 1);
                    } else {
                        map.put(keyword, map.get(keyword) + 1);
                    }
                }
            }
        }

        Map<String, Integer> sortedByCount = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        PriorityQueue<String> heap = new PriorityQueue<>();

        for (Map.Entry<String, Integer> entry : sortedByCount.entrySet()) {
            if (heap.size() < k) {
                heap.add(entry.getKey());
            } else {
                heap.poll();
                heap.add(entry.getKey());
            }
        }


        heap.stream().forEach(System.out::println);

        return new ArrayList<>(heap);

    }

    //    88. Merge Sorted Array
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                result.add(nums1[i]);
                i++;
            } else {
                result.add(nums2[j]);
                j++;
            }
        }

        while (j < n) {
            result.add(nums2[j]);
            j++;
        }
        while (i < m) {
            result.add(nums1[i]);
            i++;
        }

        result.stream().forEach(System.out::println);
    }


    public int orangesRotting(int[][] grid) {
        Stack<Point> goodOranges = new Stack<>();
        Stack<Point> rottenOranges = new Stack<>();


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    goodOranges.add(new Point(i, j));
                }
                if (grid[i][j] == 2) {
                    rottenOranges.add(new Point(i, j));
                }
            }
        }
        int countDay = 0;
        int countBadOrange = 0;
        while (!goodOranges.isEmpty()) {
            Stack<Point> readyToRottenOranges = new Stack<>();
            while (!rottenOranges.isEmpty()) {
                Point tempRotton = rottenOranges.pop();
                // up
                if (tempRotton.getX() != 0 && grid[tempRotton.getX() - 1][tempRotton.getY()] == 1) {
                    grid[tempRotton.getX() - 1][tempRotton.getY()] = 2;
                    readyToRottenOranges.add(new Point(tempRotton.getX() - 1, tempRotton.getY()));
                }
                // down
                if (tempRotton.getX() != grid.length - 1 && grid[tempRotton.getX() + 1][tempRotton.getY()] == 1) {
                    grid[tempRotton.getX() + 1][tempRotton.getY()] = 2;
                    readyToRottenOranges.add(new Point(tempRotton.getX() + 1, tempRotton.getY()));
                }
                // left
                if (tempRotton.getY() != 0 && grid[tempRotton.getX()][tempRotton.getY() - 1] == 1) {
                    grid[tempRotton.getX()][tempRotton.getY() - 1] = 2;
                    readyToRottenOranges.add(new Point(tempRotton.getX(), tempRotton.getY() - 1));
                }
                // right
                if (tempRotton.getY() != grid[tempRotton.getX()].length - 1 && grid[tempRotton.getX()][tempRotton.getY() + 1] == 1) {
                    grid[tempRotton.getX()][tempRotton.getY() + 1] = 2;
                    readyToRottenOranges.add(new Point(tempRotton.getX(), tempRotton.getY() + 1));
                }
            }

            if (readyToRottenOranges.size() == 0) { // can't find any
                break;
            }
            countDay++;

            countBadOrange += readyToRottenOranges.size();

            while (!readyToRottenOranges.isEmpty()) {
                rottenOranges.add(readyToRottenOranges.pop());
            }

        }
        return goodOranges.size() == countBadOrange ? countDay : -1;
    }


    public List<Integer> partitionLabels(String S) {

        List<Integer> result = new ArrayList<>();
        int startPoint = 0;
        int endPoint = 0;

        while (endPoint < S.length()) {
            endPoint = S.lastIndexOf(S.charAt(startPoint));
            startPoint = endPoint + 1;
            result.add(startPoint);
        }

        return result;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
