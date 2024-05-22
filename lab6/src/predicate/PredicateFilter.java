package predicate;

public class PredicateFilter<T> implements PredicateFilterInterface<T>{
    @Override
    public boolean test(T o) {
        return true;
    }
}
