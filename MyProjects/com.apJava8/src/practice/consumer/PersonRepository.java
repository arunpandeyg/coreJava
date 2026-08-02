package practice.consumer;

import java.util.Arrays;
import java.util.List;

public class PersonRepository {
    public static List<Person> getAllPersons() {
        Person p1 = new Person("Jagmohan", 165, 72000.0, "Male", 1, Arrays.asList("Cricket", "Swimming", "Tennis"));
        Person p2 = new Person("Angle", 158, 65000.0, "Female", 2, Arrays.asList("Driving", "Music", "Food"));
        Person p3 = new Person("Deana", 170, 75700.0, "Male", 1, Arrays.asList("Football", "Driving", "Running"));
        Person p4 = new Person("Mahima", 165, 82000.0, "Female", 2, Arrays.asList("Running", "Swimming", "Sleeping"));
        Person p5 = new Person("Komal", 165, 62000.0, "Female", 3, Arrays.asList("Chatting", "Walking", "BikeRiding"));
        Person p6 = new Person("Rajesh", 165, 72000.0, "Male", 2, Arrays.asList("BikeRiding", "BirdWatching", "Chatting"));
        Person p7 = new Person("Ramesh", 165, 72000.0, "Male", 3, Arrays.asList("Cricket", "Humming", "Tennis"));
        Person p8 = new Person("Rima", 160, 72000.0, "Female", 3, Arrays.asList("Cooking", "Singing", "Tennis"));
        Person p9 = new Person("RamSingh", 175, 92000.0, "Male", 3, Arrays.asList("Cricket", "Gym", "Tennis"));
        Person p10 = new Person("RanVir", 180, 82000.0, "Male", 3, Arrays.asList("Running", "Swimming", "Tennis"));
        return Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
    }

    public static Person getPerson() {
        return new Person("Jagmohan", 165, 2000.0, "Male", 1, Arrays.asList("Cricket", "Swimming", "Tennis"));
    }
}
