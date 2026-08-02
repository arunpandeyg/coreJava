package practice.p;

import java.util.stream.IntStream;

public class Practice1 {
    //old code style
    public static void main(String[] args) {
        int total = 0;
        for (int i = 0; i <= 50; i++) {
            total += i;
        }
        System.out.println("total is " +total);
        //after
        int total1 = IntStream.rangeClosed(0, 50)
                .map(Integer::new)
                .sum();
                System.out.println("Total in java 8 : " +total1);
    }

}