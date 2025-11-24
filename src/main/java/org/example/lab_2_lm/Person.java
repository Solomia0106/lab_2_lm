package org.example.lab_2_lm;

import javafx.beans.property.SimpleStringProperty;

public class Person {
    private final SimpleStringProperty pip = new SimpleStringProperty("");
    private final SimpleStringProperty phone = new SimpleStringProperty("");

    public Person() {}

    public Person(String pip, String phone) {
        this.pip.set(pip);
        this.phone.set(phone);
    }

    public String getPip() {
        return pip.get();
    }

    public void setPip(String pip) {
        this.pip.set(pip);
    }

    public SimpleStringProperty pipProperty() {
        return pip;
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pip='" + getPip() + '\'' +
                ", phone='" + getPhone() + '\'' +
                '}';
    }
}