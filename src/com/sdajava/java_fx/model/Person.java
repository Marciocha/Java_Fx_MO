package com.sdajava.java_fx.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

/**
 * Created by user on 2017-04-04.
 */
public class Person {

    public final StringProperty firstName;
    public final StringProperty lastName;
    public StringProperty street;
    public StringProperty city;
    public IntegerProperty postalCode;
    public ObjectProperty<LocalDate> birthday;  //obiekt typu Date z Javy8

    public Person(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getFirstName() {
        return firstName.get();

    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();

    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }
}
