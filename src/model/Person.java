package model;

public abstract class Person {

    private String name;
    private int age;

    static String bankName;

    // Static block
    static {
        bankName = "SRITW National Bank";
        System.out.println("Static block executed. Bank initialized.");
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Encapsulation
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

    // Abstraction
    public abstract String getDetails();
}