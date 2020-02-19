import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class L110_150_Test {


    Integer[] dimonstion1 = {1};
    Integer[] dimonstion2 = {1, 1};
    Integer[] dimonstion3 = {1, 2, 1};
    Integer[] dimonstion4 = {1, 3, 3, 1};
    Integer[] dimonstion5 = {1, 4, 6, 4, 1};
    Integer[] dimonstion30 = {1, 30, 435, 4060, 27405, 142506, 593775, 2035800, 5852925, 14307150, 30045015, 54627300, 86493225, 119759850, 145422675, 155117520, 145422675, 119759850, 86493225, 54627300, 30045015, 14307150, 5852925, 2035800, 593775, 142506, 27405, 4060, 435, 30, 1};

    @Test
    public void testGenerateCase1() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.stream(dimonstion1).collect(Collectors.toList()));
        assertEquals(new L100To150().generate(1), list);
    }

    @Test
    public void testGetRowCase1() {
        assertEquals(new L100To150().getRow(0), Arrays.stream(dimonstion1).collect(Collectors.toList()));
    }

    @Test
    public void testGenerateCase2() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.stream(dimonstion1).collect(Collectors.toList()));
        list.add(Arrays.stream(dimonstion2).collect(Collectors.toList()));
        assertEquals(new L100To150().generate(2), list);
    }

    @Test
    public void testGetRowCase2() {
        assertEquals(new L100To150().getRow(1), Arrays.stream(dimonstion2).collect(Collectors.toList()));
    }

    @Test
    public void testGenerateCase3() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.stream(dimonstion1).collect(Collectors.toList()));
        list.add(Arrays.stream(dimonstion2).collect(Collectors.toList()));
        list.add(Arrays.stream(dimonstion3).collect(Collectors.toList()));
        assertEquals(new L100To150().generate(3), list);
    }


    @Test
    public void testGetRowCase3() {
        assertEquals(new L100To150().getRow(2), Arrays.stream(dimonstion3).collect(Collectors.toList()));
    }

    @Test
    public void testGenerateCase4() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.stream(dimonstion1).collect(Collectors.toList()));
        list.add(Arrays.stream(dimonstion2).collect(Collectors.toList()));
        list.add(Arrays.stream(dimonstion3).collect(Collectors.toList()));
        list.add(Arrays.stream(dimonstion4).collect(Collectors.toList()));
        assertEquals(new L100To150().generate(4), list);
    }

    @Test
    public void testGetRowCase4() {
        assertEquals(new L100To150().getRow(3), Arrays.stream(dimonstion4).collect(Collectors.toList()));
    }


    @Test
    public void testGetRowCase5() {
        assertEquals(new L100To150().getRow(4), Arrays.stream(dimonstion5).collect(Collectors.toList()));
    }

    @Test
    public void testGetRowCase30() {
        assertEquals(new L100To150().getRow(30), Arrays.stream(dimonstion30).collect(Collectors.toList()));
    }


}
