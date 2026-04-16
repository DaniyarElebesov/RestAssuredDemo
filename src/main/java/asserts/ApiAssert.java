package asserts;

import io.restassured.response.Response;
import staticData.StatusCodes;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiAssert {
    Response response;

    public ApiAssert(Response response){
        this.response = response;
    }

    public static ApiAssert assertThat(Response response){
        return new ApiAssert(response);
    }

    public ApiAssert isCorrectStatusCode(StatusCodes expectedStatusCodes){
        if (this.response == null) assertTrue(false, "response is NULL");
        org.assertj.core.api.Assertions.assertThat(this.response.getStatusCode())
                .withFailMessage("response code is not correct Actual %s, Expected %s",
                        this.response.getStatusCode(), expectedStatusCodes)
                .isEqualTo(expectedStatusCodes.getStatus());
        return this;
    }

}
