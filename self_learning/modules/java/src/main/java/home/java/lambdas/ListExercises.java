package home.java.lambdas;

import java.util.List;

/**
 * Created by muralov on 03/10/16.
 */
public class ListExercises {

    //A permutation of a list is another list with the same elements,
    //but in a possibly different order. For example, [1,2,1] is a permutation of [2,1,1], but not of [1,2,2].
    public static boolean isPermutation(List<Integer> list1, List<Integer> list2) {
        if (list1.size() != list2.size()) return false;
        return list1.stream().allMatch(x -> list2.contains(x));
    }

    public static <T> boolean isSorted(List<T> list) {
        //list.stream().forEach();
        return false;
    }

    public static boolean existDuplicate(List<Integer> list) {
        //list.stream().forEach(x -> list.contains(x));
        return false;
    }

}
