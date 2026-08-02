import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Practice2 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Sam", "Peter", "John", "Sam");

        //java 7
        List<String> uniqueList = new ArrayList<String>();
        for (String name : names) {
            if(!uniqueList.contains(name)){
                uniqueList.add(name);
            }
        }
        System.out.println("Unique List: " + uniqueList);
        //after
        List<String> UniqueList1 = names.stream().distinct().toList();
        System.out.println("Unique List : " + UniqueList1);
    }
}
