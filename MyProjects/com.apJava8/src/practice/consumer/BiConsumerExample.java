package practice.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void main(String[] args) {
   /* Consumer<String> con1 = (s) -> {
         System.out.println(s.toLowerCase());
     };*/
   /*  BiConsumer<Integer,  Integer> con =  (a, b) -> System.out.println("add : "+(a+b));
     con.accept(10 , 20);

        List<Integer> list1 =
                Arrays.asList(new Integer(10), new Integer(10), new Integer(10), new Integer(10) );
        List<Integer> list2 =
                Arrays.asList( new Integer(10), new Integer(10), new Integer(10) );
        BiConsumer<List<Integer> , List<Integer> > con2 = (l1, l2) -> {
            if (l1.size() == l2.size()) System.out.println("True");
            else {
                System.out.println("False");
            }
        };
        con2.accept(list1, list2);*/


        BiConsumer<Integer,  Integer> addConsumer =  (a, b) -> System.out.println("add : "+(a+b));
        BiConsumer<Integer,  Integer> subConsumer =  (a, b) -> System.out.println("add : "+(a-b));
        BiConsumer<Integer,  Integer> multiConsumer =  (a, b) -> System.out.println("add : "+(a*b));
//        addConsumer.accept(10, 20);
//        subConsumer.accept(10, 20);
//        multiConsumer.accept(10, 20);
        addConsumer.andThen(subConsumer).andThen(multiConsumer).accept(10, 20);
    }

}
