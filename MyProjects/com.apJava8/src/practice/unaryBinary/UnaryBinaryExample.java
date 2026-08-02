package practice.unaryBinary;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryBinaryExample {
    //static UnaryOperator<String> uo1 = name ->  name.toUpperCase();
    static UnaryOperator<String> uo1 = String :: toUpperCase;
    static UnaryOperator<Integer> uo2 = a -> a + 10;

    //static Comparator<Integer> comp = (a, b) -> a.compareTo(b);
    static Comparator<Integer> comp = Integer::compareTo;

    public static void main(String[] args) {
       /* System.out.println("Result1   " +uo1.apply("java"));
        System.out.println("Result2   " +uo2.apply(20));*/


        //BinaryOperator<Integer> bo1 = BinaryOperator.maxBy((a, b) -> a.compareTo(b));
        //BinaryOperator<Integer> bo1 = BinaryOperator.maxBy(Integer::compareTo);
       // BinaryOperator<Integer> bo1 = BinaryOperator.maxBy((a, b) -> (a > b) ? 1 : (a == b) ? 0 : -1);

        BinaryOperator<Integer> bo1 = BinaryOperator.maxBy((a, b) -> (a > b) ? 1 : (a.equals(b)) ? 0 : -1);

        System.out.println("Binary operator maxBy Result1 : " +bo1.apply(102, 15));

        BinaryOperator<Integer> bo2 = BinaryOperator.maxBy(comp);
        System.out.println("Binary operator maxBy Results: " +bo2.apply(102, 15));

        BinaryOperator<Integer> bo3 = BinaryOperator.minBy(comp);
        System.out.println("Binary operator minBy Results: " +bo3.apply(102, 15));


    }
}
