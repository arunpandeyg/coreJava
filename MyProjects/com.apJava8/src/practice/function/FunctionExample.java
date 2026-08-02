package practice.function;

import java.util.function.Function;

public class FunctionExample {
    static Function<String, String> f1 = name -> name.toUpperCase();
    static Function<String, String> f2 = name -> name.toUpperCase().concat("   features");

    public static void main(String[] args) {
       /* System.out.println("result1  " +f1.apply("java"));
        System.out.println("result2  " +f2.apply("java"));*/
        System.out.println("And then result " +f1.andThen(f2).apply("java"));
        System.out.println("compose result  " +f1.compose(f2).apply("java"));

    }
}
