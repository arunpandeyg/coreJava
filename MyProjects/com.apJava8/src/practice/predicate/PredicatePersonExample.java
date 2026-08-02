package practice.predicate;

import practice.consumer.Person;
import practice.consumer.PersonRepository;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicatePersonExample {
    static Predicate<Person> p1 = per -> per.getHeight() >=165;
    static Predicate<Person> p2 = per -> per.getGender().equals("Male");

    public static void main(String[] args) {
        List<Person> personList = PersonRepository.getAllPersons();
        personList.stream().filter(p1).collect(Collectors.toList());
        personList.forEach(per -> {
            if (p1.test(per)){
                System.out.println(per);
            }
        });
        personList.forEach(per -> {
            if (p1.and(p2).test(per)){
                System.out.println(per);
            }
        });
    }
}
