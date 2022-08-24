package lesson19;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ApiPerson api = new ApiPerson();
        try {
            ArrayList<Person> persons = api.getApiPersonFromRequest(5);
            System.out.println(persons);
        } catch (Exception e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        }



        System.out.println();

        // Анонимный класс
//        PersonSort.filter(persons, new Proverka<Person>() {
//            @Override
//            public boolean test(Person person) {
//                return LocalDateTime.now().getYear() - person.getDob().getYear() > 40;
//            }
//        });
//
        //Лямбда выражение
//        PersonSort.filter(persons, person -> {
//            return LocalDateTime.now().getYear() - person.getDob().getYear() > 40;
//        });

//        PersonSort.filter(persons, q -> LocalDateTime.now().getYear() - q.getDob().getYear() > 40);


    }
}