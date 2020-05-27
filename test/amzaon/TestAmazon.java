package amzaon;


import amazon.ThreeSum;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestAmazon {

    @Test
    public void testMinPathSumCase1() {


        List<List<Integer>> results = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        result.add(-1);
        result.add(0);
        result.add(1);
        results.add(result);

        result = new LinkedList<>();
        result.add(-1);
        result.add(-1);
        result.add(2);
        results.add(result);

        assertEquals(new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}), results);
    }

}
