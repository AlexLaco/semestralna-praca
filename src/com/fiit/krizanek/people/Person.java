package com.fiit.krizanek.people;

import java.util.ArrayList;

public class Person<abstarct> {
    public String position;
    public String name;
    public String address;
    public static int nPerson;
    public static ArrayList<Person> people = new ArrayList<>();

    public Person(){
        nPerson++;
    }

    public static void showAllParticipants(){
        for(Person x: Person.people)
            System.out.println("Name: " + x.name + " | Address: " + x.address + " | Position: " + x.position);
    }
}
