package model;

public class Customer extends Person {

    private String customerId;
    private String phone;
    private Address address;

    // Inner class
    public class Nominee {

        private String name;
        private String relation;

        public Nominee(String name, String relation) {
            this.name = name;
            this.relation = relation;
        }

        public String getDetails() {
            return name + " (" + relation + ")";
        }
    }

    public Customer(String name, int age,
                    String customerId,
                    String phone,
                    Address address) {

        super(name, age);
        this.customerId = customerId;
        this.phone = phone;
        this.address = address;
    }

    // Copy Constructor
    public Customer(Customer customer) {

        super(customer.getName(), customer.getAge());

        this.customerId = customer.customerId;
        this.phone = customer.phone;
        this.address = customer.address;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String getDetails() {

        return "Customer ID: " + customerId +
                ", Name: " + getName() +
                ", Age: " + getAge() +
                ", Phone: " + phone +
                ", Address: " + address;
    }

    @Override
    public String toString() {
        return getDetails();
    }
}