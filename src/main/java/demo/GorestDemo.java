package demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import util.ObjectConverter;

import java.util.List;

public class GorestDemo {

    @Test
    void demo1() {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://gorest.co.in/");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.accept(ContentType.JSON);

        Response response = requestSpecification.get("public/v2/users");
//        response.prettyPrint();
        List<User> users = ObjectConverter.convertJsonArrayToListOfObject(response.asPrettyString(), User[].class);
        users.forEach(user -> System.out.println(user.getName()));

        // Rest assured имеет интерфейсы:
        // 1. Request Specification: тело запроса, URL, токены итд.
        // 2. Response: тело ответа, headers, test results, request code
    }

    @Test
    void createUserTest() throws JsonProcessingException {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://gorest.co.in/");
        requestSpecification.header("Authorization",
                "Bearer 8b503f44e19b5c455be6a5c1443bc06f650cea86b41a59aef99b94a54ecdfe0e");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.accept(ContentType.JSON);
        User john = User.builder().name("John")
                .email("john@gmail.com")
                .gender("Male")
                .status("active")
                .build();
        requestSpecification.body(ObjectConverter.convertJavaObjectToJsonObject(john));

        Response response = requestSpecification.post("public/v2/users");
        response.prettyPrint();

//        JsonPath jsonPath = response.jsonPath();  //
//        int id = jsonPath.getInt("id");
//        String name = jsonPath.getString("name");
//        String email = jsonPath.getString("email");
//        String gender = jsonPath.getString("gender");
//        String status = jsonPath.getString("status");
//        Assertions.assertEquals("Hasans", name);
//        Assertions.assertEquals("hasan12@gmail.com", email);

        User user = ObjectConverter.convertJsonObjectToJavaObject(response.body().asPrettyString(), User.class);
        System.out.println(user);
    }

}
