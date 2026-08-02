import java.util.stream.IntStream;

public class Practice1 {
    public static void main(String[] args) {
        //java 7 vs java 8
        int total = 0;
        for(int i = 0; i <= 50; i++){
            total += i;
        }
        System.out.println("Total is "  +total);
        //after
        int total1 = IntStream.rangeClosed(0, 50).map(Integer :: new).sum();
        System.out.println("Total in java8: " +total1);
    }
}
