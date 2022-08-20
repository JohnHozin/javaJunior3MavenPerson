package lesson21;

import patPerson.ApiPerson;
import patPerson.Person;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
//        List.of(1,2,3);
//        Stream.of(1,2,3);
//
//
//
//        IntStream
//                .range(0,100)
//                .skip(10)
//                .limit(50)
//                .average()
//                .ifPresent(System.out::println);
//
//        Random random = new Random();
//        IntStream.generate(()->random.nextInt(100))
//                .limit(10)
//                .forEach(System.out::println);
//
//        IntStream.concat(IntStream.of(1,2,3),IntStream.of(3,4,5))
//                .forEach(System.out::println);


        ApiPerson api = new ApiPerson();
        ArrayList<Person> peoples = api.getApiPersonFromRequest(10);

//        Optional<Integer> max1 = peoples.stream()
//                .map(m -> LocalDate.now().getYear() - m.getDob().getYear())
//                .max(Integer::compareTo);
//
//        System.out.println(max1);

        peoples.stream()
                .sorted(Comparator.comparing(Person::getCountry)
                        .thenComparing(Person::getFirstName)
                        .thenComparing(Person::getLastName))
                .forEach(System.out::print);

        System.out.println();
        peoples.stream()
                .sorted(Comparator.comparing(Person::getGender)
                        .thenComparing(Person::getFirstName))
                .forEach(System.out::print);

        // firstname + date birthday + @gmail.com
        System.out.println();

        String collect = peoples.stream()
                .peek(System.out::println)
                .map(m -> m.getLastName() + m.getDob().getYear())
                .collect(Collectors.joining("@gmail.com ","","@gmail.com"));
        System.out.println(collect);


        // запросить 100 людишек.
        // раскидать их по листам (мужчины, женщины,  * регионам(динамический))
    }
}
