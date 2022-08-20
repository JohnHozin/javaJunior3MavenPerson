package lesson20;

import patPerson.ApiPerson;
import patPerson.Person;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ApiPerson api = new ApiPerson();
        ArrayList<Person> people = api.getApiPersonFromRequest(30);
        for (Person p:people){
            System.out.print(p);
        }
        System.out.println();

        people.stream().forEach(System.out::print);
        people.stream()
                .map(p->p.getCountry())
                .forEach(System.out::println);


        System.out.println();
        people.stream()
                .map(p -> p.getCountry())
                .filter(country->country.equals("Turkey"))
                .forEach(System.out::println);

        people.stream()
                .map(p->"Город " + p.getCountry() + " живёт" + p.getFirstName());
    }
}
