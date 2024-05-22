package predicate;

import java.util.ArrayList;
import java.util.Comparator;

public class PredicateMethods {
    public static <T> ArrayList<T> filterBy(Iterable<T> initialIterable, PredicateFilterInterface<T> predicate) {
        ArrayList<T> list = new ArrayList<>();
        for (T item : initialIterable) {
            if (predicate.test(item)) {
                list.add(item);
            }
        }
        return list;
    }

    public static <T> ArrayList<T> sortBy(Iterable<T> initialList, Comparator<T> predicate) {
        ArrayList<T> list = new ArrayList<>();
        initialList.forEach(list::add);

        list.sort(predicate);

        return list;
    }
}
