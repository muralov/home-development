package home.java.lambdas;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by muralov on 03/10/16.
 */
public class ListExercisesTest {

    @Test
    public void isPermutationTest()
    {
        List<Integer> list1 = Arrays.asList(1,2,3,4);

        List<Integer> list2 = Arrays.asList(2,3,1,4);
        List<Integer> list3 = Arrays.asList(2,3,2,4);

        assertTrue(ListExercises.isPermutation(list1, list2));
        assertFalse(ListExercises.isPermutation(list1, list3));
    }

}
