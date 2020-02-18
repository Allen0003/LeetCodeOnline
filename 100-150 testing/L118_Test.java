import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class L118_Test {


    Integer[] dimonstion1 = {1};
    Integer[] dimonstion2 = {1, 1};
    Integer[] dimonstion3 = {1, 2, 1};
    Integer[] dimonstion4 = {1, 3, 3, 1};

    @Test
    public void testGenerateCase1() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.stream(dimonstion1).collect(Collectors.toList()));
        assertEquals(new L100To150().generate(1), list);
    }

    @Test
    public void testGenerateCase2() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.stream(dimonstion1).collect(Collectors.toList()));
        list.add(Arrays.stream(dimonstion2).collect(Collectors.toList()));
        assertEquals(new L100To150().generate(2), list);
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
    public void testGenerateCase4() {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.stream(dimonstion1).collect(Collectors.toList()));
        list.add(Arrays.stream(dimonstion2).collect(Collectors.toList()));
        list.add(Arrays.stream(dimonstion3).collect(Collectors.toList()));
        list.add(Arrays.stream(dimonstion4).collect(Collectors.toList()));
        assertEquals(new L100To150().generate(4), list);
    }


}
