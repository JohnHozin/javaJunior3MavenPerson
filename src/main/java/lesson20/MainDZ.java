package lesson20;

import patPerson.ApiPerson;
import patPerson.Person;

import java.io.IOException;
import java.util.ArrayList;

/**
        1)Сортировку по возрасту.
        2) посчитать количество людей, которым от 30 до 40 лет.
        3) вывести результат по примеру:
        Мистер или миссис(* в зависимости от пола) Смит, родом из Канады. 1990 года рождения. Связаться по емейл
         */

public class MainDZ {
    public static void main(String[] args) throws IOException, InterruptedException {
        ApiPerson api = new ApiPerson();
        ArrayList<Person> people = api.getApiPersonFromRequest(20);
        people.stream().forEach(System.out::print);

        System.out.println("\n 1) Сортировка по возрасту: ");
        people.stream()
                .sorted((p, p1) -> {
                    if (p.getDob().compareTo(p1.getDob()) != 0) {
                        return p.getDob().compareTo(p1.getDob());
                    } else if (p.getFirstName().compareTo(p1.getFirstName()) != 0) {
                        return p.getFirstName().compareTo(p1.getFirstName());
                    } else {
                        return p.getLastName().compareTo(p1.getLastName());
                    }
                }).forEach(System.out::print);

        long count = people.stream()
                .filter(p -> p.getDob().getYear() < 1992 && p.getDob().getYear() > 1982)
                .count();
        System.out.println("\n 2) Количество людей от 30 до 40 лет: " + count);

        System.out.println("\n 3) вывести результат по примеру: ");
        people.stream()
                .map(p -> {
                    if (p.getGender().contains("female")){
                        return "Миссис " + p.getLastName() + " родом из " + p.getCountry() + ". " +  p.getDob().getYear() + " года рождения. Связаться по емейл: " + p.getEmail();
                    } else {
                        return "Мистер " + p.getLastName() + " родом из " + p.getCountry() + ". " +  p.getDob().getYear() + " года рождения. Связаться по емейл: " + p.getEmail();
                    }
                }).forEach(System.out::println);


    }
}
