package patPerson;

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

        //for (int i = 0; i < col; i++) {
        //while
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                //.uri(URI.create("https://randomuser.me/api")).build();
                .uri(URI.create(String.format("https://randomuser.me/api?results=%s", col))).build();
        HttpResponse<String> response = httpClient
                .send(request, HttpResponse.BodyHandlers.ofString());

        return parcePersonResponse(response.body());
    }


    public ArrayList<Person> parcePersonResponse(String response) {
        ArrayList<Person> persons = new ArrayList<>();
        int infoCount = new JSONObject(response).getJSONObject("info").getInt("results");

        for (int i = 0; i < infoCount; i++) {
            Person person = new Person();
            JSONObject fullData = new JSONObject(response).
                    getJSONArray("results").getJSONObject(i);

            person.setGender(fullData.getString("gender"));
            person.setFirstName(fullData.getJSONObject("name").getString("first"));
            person.setLastName(fullData.getJSONObject("name").getString("last"));
            person.setEmail(fullData.getString("email"));
            person.setCountry(fullData.getJSONObject("location").getString("country"));

            ZonedDateTime zonedDateTime = ZonedDateTime.parse(fullData.getJSONObject("dob").
                    getString("date"));
            person.setDob(zonedDateTime.toLocalDateTime());
            person.setCity(fullData.getJSONObject("location").getString("city"));
            persons.add(person);
        }

        return persons;
    }
}