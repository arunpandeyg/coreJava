package practice.consumer;

import java.util.List;

public class Person {
    
    private String name;
    private Integer hight;
    private Double salary;
    private String gender;
    private int kids;
    List<String> hobbies;

    
    public Person() {
        super();
    }
    
    public Person(String name, Integer hight, Double salary, String gender, int kids, List<String> hobbies) {
        this.name = name;
        this.hight = hight;
        this.salary = salary;
        this.gender = gender;
        this.kids = kids;
        this.hobbies = hobbies;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getHeight() {
        return hight;
    }
    public void setHeight(Integer height) {
        this.hight = hight;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getKids() {
        return kids;
    }
    public void setKids(int kids) {
        this.kids = kids;
    }
    public List<String> getHobbies() {
        return hobbies;
    }
    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
    @Override
    public String toString() {
        return "Person [name=" + name + ", height=" + hight + ", salary=" + salary + ", gender=" + gender + ", kids="
                + kids + ", hobbies=" + hobbies + "]";
    }
}
