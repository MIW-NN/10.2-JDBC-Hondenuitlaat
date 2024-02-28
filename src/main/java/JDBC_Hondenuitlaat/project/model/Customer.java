package JDBC_Hondenuitlaat.project.model;

public class Customer {
    private int customerNumber;
    private String initials;
    private String prefix;
    private String surname;
    private String phoneNumber;


    public Customer(int customerNumber, String initials, String prefix, String surname, String phoneNumber) {
        this.customerNumber = customerNumber;
        this.initials = initials;
        this.prefix = prefix;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[Klant: ");
        result.append(customerNumber + " - ");
        result.append(initials + " ");
        if (prefix != null) {
            result.append(prefix + " ");
        }
        result.append(surname + " ");
        result.append(phoneNumber + "]");
        return result.toString();
    }
}
