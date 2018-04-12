package API;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;
import utils.Constants;

import static com.jayway.restassured.RestAssured.given;

public class ApiPutMethod extends ApiDefault {

    public ApiPutMethod(String restAPIUrl) {
        super(restAPIUrl);
    }

    String apiBody = "{\"firm_name\":\"REST API FIRMA 4\",\"firm_town\":\"Dimitrovgrad\",\"firm_addr\":\"Elhovo\",\"firm_is_reg_vat\":\"0\",\"firm_mol\":\"Valio\"}";

    @Override
    public String getRestAPIUrl() {
        return super.getRestAPIUrl();
    }

    @Override
    public void buildAndResponse() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBody(apiBody);
        builder.setContentType("application/json; charset=UTF-8");
        RequestSpecification requestSpec = builder.build();
        Response response = given().authentication().preemptive().basic(Constants.logInEmailData,Constants.logInPasswordData )
                .spec(requestSpec).when().put(restAPIUrl);
        JSONObject JSONResponseBody = new JSONObject(response.body().asString());
        String result = JSONResponseBody.getJSONObject("success").getString("message");
        Assert.assertEquals(result, "Клиента е редактиран успешно!");
        System.out.println(result);
    }
}
