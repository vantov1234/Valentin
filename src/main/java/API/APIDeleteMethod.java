package API;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;
import utils.Constants;

import static com.jayway.restassured.RestAssured.given;

public class APIDeleteMethod extends ApiGetMethod {
    public APIDeleteMethod(String restAPIUrl) {
        super(restAPIUrl);
    }

    @Override
    public String getRestAPIUrl() {
        return super.getRestAPIUrl();
    }

    @Override
    public void buildAndResponse() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setContentType("application/json; charset=UTF-8");
        RequestSpecification requestSpec = builder.build();
        Response response = given().authentication().preemptive().basic(Constants.logInEmailData, Constants.logInPasswordData)
                .spec(requestSpec).when().delete(restAPIUrl);
        JSONObject JSONResponseBody = new JSONObject(response.body().asString());
        String result = JSONResponseBody.getJSONObject("success").getString("message");
        Assert.assertEquals("Клиента е изтрит", result);
        System.out.println(result);
    }
}
