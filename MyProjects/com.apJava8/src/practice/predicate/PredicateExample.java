package practice.predicate;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Integer> lessThen =  a -> (a<= 50);
        Predicate<Integer> greaterThen =  a -> (a>= 50);
        Predicate<Integer> equalTo =  a -> (a == 0);
        /*boolean result = lessThen.test(55);
        System.out.println("Result:   " + result);*/
        System.out.println("greater then   " +greaterThen.test(150));
        System.out.println("less then   " +lessThen.test(150));
        System.out.println("Equal   " +equalTo.test(150));
        boolean result = lessThen.and(greaterThen).and(equalTo).test(150);
        System.out.println("Result1:   " + result);

        boolean result2 = lessThen.or(greaterThen).test(150);
        System.out.println("Result2:   " + result2);
        boolean result3 = lessThen.or(greaterThen).negate().test(150);
        System.out.println("Result3:   " + result3);

    }
}
