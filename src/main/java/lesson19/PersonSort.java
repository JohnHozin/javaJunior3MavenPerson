package lesson19;

import patPerson.Person;
import patPerson.Proverka;

import java.util.ArrayList;

public class PersonSort {
    public static void filter(ArrayList<patPerson.Person> personList, patPerson.Proverka<patPerson.Person> proverka) {
        for (patPerson.Person p : personList) {
            if (proverka.test(p)) System.out.println(p);
        }
    }

    public static void filterCountry(ArrayList<patPerson.Person> personList, patPerson.Proverka<patPerson.Person> proverka) {
        for (patPerson.Person p : personList) {
            if (proverka.test(p)) System.out.println(p);
        }
    }

    public static void filterCity(ArrayList<patPerson.Person> personList, Proverka<patPerson.Person> proverkaCity, int proverkaCount) {
        for (Person p : personList) {
            if (proverkaCity.test(p)) {
                if (proverkaCount > 0) {
                    System.out.println(p);
                    proverkaCount--;
                } else {
                    proverkaCount=0;
                }
            }
        }
        if (proverkaCount > 0){
            System.out.println("Недостаточно людей, проживающих в данном городе");
        }
    }
}