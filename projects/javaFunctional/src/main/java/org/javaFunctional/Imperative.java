package org.javaFunctional;

import java.util.ArrayList;
import java.util.List;

import static org.javaFunctional.Imperative.Person.Gender.FEMALE;
import static org.javaFunctional.Imperative.Person.Gender.MALE;

/**
 * Arun Pandey!
 */
public class Imperative {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Rake", MALE),
                new Person("Dinesh", MALE),
                new Person("Hira", MALE),
                new Person("Mamta", FEMALE),
                new Person("Samta", FEMALE),
                new Person("Heama", FEMALE),
                new Person("Lata", FEMALE)
        );

        //Imperative approach
        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if(FEMALE.equals(person.gender)){
                females.add(person);
            }
        }
        for(Person female : females) {
            System.out.println(female);
        }
    }

    static class Person {
        private final String name;
        final Gender gender;


        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @java.lang.Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }

        enum Gender {
            MALE, FEMALE
        }
    }
}
