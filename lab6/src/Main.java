import data.Data;
import data.Tour;
import predicate.PredicateFilter;
import predicate.PredicateMethods;

import java.util.ArrayList;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) {
        ArrayList<Tour> data = Data.data;
        System.out.println(data);

        ArrayList<Tour> filteredData = PredicateMethods.filterBy(data, new PredicateFilter<>() {
            @Override
            public boolean test(Tour item) {
                return item.getPrice() > 1000;
            }
        });

        System.out.println(filteredData);

        ArrayList<Tour> sortedData = PredicateMethods.sortBy(data, new Comparator<Tour>() {
            @Override
            public int compare(Tour first, Tour second) {
                return Integer.compare(first.getPrice(), second.getPrice());
            }
        });

        System.out.println(sortedData);

        ArrayList<Tour> filteredDataLambda = PredicateMethods.filterBy(data,
                (item) -> item.getPrice() > 1000
        );

        System.out.println(filteredDataLambda);

        ArrayList<Tour> sortedDataLambda = PredicateMethods.sortBy(data,
                Comparator.comparingInt(Tour::getPrice)
        );

        System.out.println(sortedDataLambda);
    }
}