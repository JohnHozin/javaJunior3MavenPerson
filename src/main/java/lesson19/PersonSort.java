package lesson19;

import java.util.ArrayList;

public class PersonSort {
    public static void filter(ArrayList<Person> personList, Proverka<Person> proverka) {
        for (Person p : personList) {
            if (proverka.test(p)) System.out.println(p);
        }
    }

    public static void filterCountry(ArrayList<Person> personList, Proverka<Person> proverka) {
        for (Person p : personList) {
            if (proverka.test(p)) System.out.print(p);
        }
    }

    public static boolean filterCity(Person personList, Proverka<Person> proverkaCity) {
        if (proverkaCity.test(personList)) {
            return true;
        }
        return false;
    }

    public static boolean filterCountryNum(Person personListCo, Proverka<Person> proverkaCity) {
        if (proverkaCity.test(personListCo)) {
            return true;
        }
        return false;
    }
}