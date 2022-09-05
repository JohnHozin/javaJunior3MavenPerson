package lesson20;

import patPerson.ApiPerson;
import patPerson.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ApiPerson api = new ApiPerson();
        ArrayList<Person> people = api.getApiPersonFromRequest(10);
        for (Person p : people) {
            System.out.print(p);
        }
        System.out.println();

        //people.stream().forEach(System.out::print);
        people.stream()
                .map(p -> p.getCountry())
                .forEach(System.out::println);


        System.out.println();
        people.stream()
                .map(p -> p.getCountry())
                .filter(country -> country.equals("Turkey"))
                .forEach(System.out::println);

        System.out.println();
        people.stream()
                .map(p -> "Страна " + p.getCountry() + " живёт " + p.getFirstName())
                .forEach(System.out::println);

        System.out.println();
        people.stream()
                .filter(p -> p.getDob().getYear() < 1980)
                .forEach(System.out::print);

//        System.out.println();
//        people.stream()
//                .filter(p -> p.getDob().getYear() < 1980 && p.getCountry().equals("Turkey"))
//                .forEach(System.out::print);

        System.out.println();
        Stream.of(1, 2, 3, 4, 5, 6)
                .reduce((count, n) -> count + n)
                .ifPresent(System.out::println);

        var reduce = Stream.of(1, 2, 3, 4, 5, 6)
                .reduce((count, n) -> count + n);

        System.out.println();
        people.stream()
                .sorted((p, p1) -> {
                    if (p.getFirstName().compareTo(p1.getFirstName()) != 0) {
                        return p.getFirstName().compareTo(p1.getFirstName());
                    } else if (p.getLastName().compareTo(p1.getLastName()) != 0) {
                        return p.getLastName().compareTo(p1.getLastName());
                    } else {
                        return p.getDob().compareTo(p1.getDob());
                    }
                }).forEach(System.out::print);

        System.out.println();
        Stream.of(1, 2, 3, 3, 4, 4, 5, 6)
                .distinct()
                .forEach(System.out::print);
    }
}
