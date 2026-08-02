package practice.p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Practice2 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("sam", "Peter", "Billings", "Sam");
        //before
        List<String> uniqueList = new ArrayList<>();
        for (String name : names) {
            if (!uniqueList.contains(name)) {
                uniqueList.add(name);
            }
        }
        System.out.println("Unique List1" + uniqueList);
        
        //after
        List<String> uniqueValues1 = names.stream().distinct().toList();
        System.out.println("unique list 2  " +uniqueValues1);
    }
}
