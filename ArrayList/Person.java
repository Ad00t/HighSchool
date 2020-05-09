package ArrayList;

public class Person implements Comparable<Person> {

    private String name;
    private int age;
    private double weight;

    public Person(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Person other) {
        int compare = 0;

        if (weight > other.getWeight()) compare = 1;
        else if (weight < other.getWeight()) compare = -1;

        if (age > other.getAge()) compare = 1;
        else if (age < other.getAge()) compare = -1;

        if (name.compareTo(other.getName()) != 0) 
            compare = name.compareTo(other.getName());

        return compare;
    }

    @Override
    public String toString() {
        return "{" + name + ", " + age + ", " + weight + "}";
    }

}