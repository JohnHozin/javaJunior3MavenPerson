package lesson19;

import java.util.ArrayList;
import java.util.Scanner;

public class MainDZ {
    public static void main(String[] args) {
        // сделать сортировку по country (вывод страны, которую ввели)

        // сделать метод который по числу и городу возвращает данное
        // количество людей из этого города

        //переделать с циклом
        ApiPerson apiPerson = new ApiPerson();
        ArrayList<Person> persons = new ArrayList<>();
        try {
            persons = apiPerson.getApiPersonFromRequest(10);
            System.out.println(persons);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("Введите страну:");
        Scanner scanner = new Scanner(System.in);
        String country = scanner.nextLine();

        PersonSort.filterCountry(persons, c -> c.getCountry().equals(country));

        System.out.println();
//        System.out.println("Введите город:");
//        String city = scanner.nextLine();
        System.out.println("Введите страну:");
        String countr = scanner.nextLine();
        System.out.println("Введите количество людей:");
        int countPeople = scanner.nextInt();

//        persons.clear();
//        while (persons.size()<countPeople){
//            try {
//                Person person = apiPerson.getApiPersonFromRequestCity();
//                System.out.print(person);
//
//                if (PersonSort.filterCity(person, d -> d.getCity().equals(city))){
//                    persons.add(person);
//                    System.out.print("!!!!!!!" + person);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        persons.clear();
        while (persons.size()<countPeople){
            try {
                Person person = apiPerson.getApiPersonFromRequestCity();


                if (PersonSort.filterCountryNum(person, d -> d.getCountry().equals(countr))){
                    persons.add(person);
                    System.out.print("!!!!!!!" + person);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}