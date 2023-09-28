package com.example.dataklassuppgift;

public class PersonModel {

    String PersonsName;
    String PersonsAge;
    String PersonsAddress;
    int image;

    public PersonModel(String personsName, String personsAge, String personsAddress, int image) {
        PersonsName = personsName;
        PersonsAge = personsAge;
        PersonsAddress = personsAddress;
        this.image = image;
    }

    public String getPersonsName() {
        return PersonsName;
    }

    public String getPersonsAge() {
        return PersonsAge;
    }

    public String getPersonsAddress() {
        return PersonsAddress;
    }

    public int getImage() {
        return image;
    }
}
