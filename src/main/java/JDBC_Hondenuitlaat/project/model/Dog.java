package JDBC_Hondenuitlaat.project.model;

public class Dog {
    private String chipnumber;
    private String name;
    private String breed;
    private Customer Owner;

    public Dog(String chipnumber, String name, String breed, Customer Owner) {
        this.chipnumber = chipnumber;
        this.name = name;
        this.breed = breed;
        this.Owner = Owner;
    }

    public String getChipnumber() {
        return this.chipnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Customer getOwner() {
        return Owner;
    }

    public void setOwner(Customer owner) {
        this.Owner = owner;
    }

    public void setChipnumber(String chipnumber) {
        this.chipnumber = chipnumber;
    }

    @Override
    public String toString() {
        return String.format("[Hond %s - %s, bezit van %s]", this.chipnumber, this.name, Owner);
    }
}
