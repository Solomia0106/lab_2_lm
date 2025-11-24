package org.example.lab_2_lm;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CollectionAddressBook implements AddressBook {
    private final ObservableList<Person> personList = FXCollections.observableArrayList();

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public void fillTestData() {
        personList.add(new Person("Юлія Петренко", "0671234567"));
        personList.add(new Person("Оксана Іваненко", "0937654321"));
        personList.add(new Person("Петро Сидоренко", "0509876543"));
    }

    @Override
    public void add(Person person) {
        personList.add(person);
    }

    @Override
    public void update(Person person) {
        // Оновлення виконується через binding у контролері
    }

    @Override
    public void delete(Person person) {
        personList.remove(person);
    }
}