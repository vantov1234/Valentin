package API;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;
import utils.Constants;

import static com.jayway.restassured.RestAssured.given;

public class ApiPostMethod extends ApiDefault {

    String apiBody = "{\"firm_name\":\"REST API FIRMA 4\",\"firm_town\":\"Elhovo\",\"firm_addr\":\"Elhovo\",\"firm_is_reg_vat\":\"0\",\"firm_mol\":\"Valio\"}";

    public ApiPostMethod(String restAPIUrl) {
        super(restAPIUrl);

    }

    @Override
    public void buildAndResponse() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBody(apiBody);
        builder.setContentType("application/json; charset=UTF-8");
        RequestSpecification requestSpec = builder.build();
        Response response = given().authentication().preemptive().basic(Constants.logInEmailData,Constants.logInPasswordData )
                .spec(requestSpec).when().post(restAPIUrl);
        JSONObject JSONResponseBody = new JSONObject(response.body().asString());
        String result = JSONResponseBody.getJSONObject("success").getString("message");
        Assert.assertEquals(result, "Клиента е създаден успешно!");
        System.out.println(result);
    }
}
