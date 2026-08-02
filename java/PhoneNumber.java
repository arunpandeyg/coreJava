import java.util.Random;
public class PhoneNumber {
    public static void main(String[] args) {

        Random random = new Random();
        int first = random.nextInt(8);
        int second = random.nextInt(8);
        int third = random.nextInt(8);
        int middle = random.nextInt(742);
        int last = random.nextInt(9999);
        String middleString;
        String lastString;
        middleString = Integer.toString(middle);
        lastString = Integer.toString(last);
        while (middleString.length() < 3){
            middleString = "0" + middleString;
        }
        while (lastString.length() < 4){
            lastString = "0" + lastString;
        }
        System.out.println(Integer.toString(first)  + Integer.toString(second) + Integer.toString(third) + "-"  + middleString + "-" +  lastString);
    }
    



}
