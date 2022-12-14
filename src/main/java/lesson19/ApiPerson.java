package lesson19;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class ApiPerson {
    public ArrayList<Person> getApiPersonFromRequest(int col) throws IOException, InterruptedException {

        ArrayList<Person> persons = new ArrayList<>();
        for (int i = 0; i < col; i++) {
            //while
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().GET()
                    .uri(URI.create("https://randomuser.me/api"))
                    .build();
            HttpResponse<String> response = httpClient
                    .send(request, HttpResponse.BodyHandlers.ofString());

            persons.add(parcePersonResponse(response.body()));
        }
        return persons;
    }

    public Person getApiPersonFromRequestCity() throws IOException, InterruptedException {

        //Person person = new Person();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().GET()
                .uri(URI.create("https://randomuser.me/api"))
                .build();
        HttpResponse<String> response = httpClient
                .send(request, HttpResponse.BodyHandlers.ofString());

        //person = parcePersonResponse(response.body());

        return parcePersonResponse(response.body());
    }


    public Person parcePersonResponse(String response) {
        Person person = new Person();

        JSONObject fullData = new JSONObject(response).
                getJSONArray("results").getJSONObject(0);

        person.setGender(fullData.getString("gender"));
        person.setFirstName(fullData.getJSONObject("name").getString("first"));
        person.setLastName(fullData.getJSONObject("name").getString("last"));
        person.setEmail(fullData.getString("email"));
        person.setCountry(fullData.getJSONObject("location").getString("country"));

        ZonedDateTime zonedDateTime = ZonedDateTime.parse(fullData.getJSONObject("dob").
                getString("date"));
        person.setDob(zonedDateTime.toLocalDateTime());
        person.setCity(fullData.getJSONObject("location").getString("city"));


        return person;
    }
}