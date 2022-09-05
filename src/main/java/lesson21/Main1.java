package lesson21;

import patPerson.ApiPerson;
import patPerson.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

public class Main1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        ApiPerson api = new ApiPerson();
        ArrayList<Person> peoples = api.getApiPersonFromRequest(10);

//        ArrayList<Integer> i =new ArrayList<>();
//        CopyOnWriteArrayList i2 = new CopyOnWriteArrayList<>();
//
//        IntStream.range(0,1_000).parallel()
//                .forEach(i2::add);
//
//        System.out.println(i2.size());

        CopyOnWriteArrayList i = new CopyOnWriteArrayList<>();
        CopyOnWriteArrayList i2 = new CopyOnWriteArrayList<>();

        long l = System.currentTimeMillis();
        IntStream.range(0,300_000).parallel()
                .forEach(i::add);
        System.out.println(i.size());
        System.out.println(System.currentTimeMillis() - l);

        long l2 = System.currentTimeMillis();
        IntStream.range(0,300_000).parallel()
                .forEach(i2::add);
        System.out.println(i2.size());
        System.out.println(System.currentTimeMillis() - l2);
    }
}
