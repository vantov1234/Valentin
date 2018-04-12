package API;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;
import utils.Constants;
import static com.jayway.restassured.RestAssured.given;

public class ApiGetMethod extends ApiDefault {

    public ApiGetMethod(String restAPIUrl) {
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
                .spec(requestSpec).when().get(restAPIUrl);
        JSONObject JSONResponseBody = new JSONObject(response.body().asString());
        String result = JSONResponseBody.getJSONObject("client").toString();
        Assert.assertEquals("{\"country\":\"\",\"firm_addr_en\":\"\",\"firm_bulstat\":\"\",\"person_city_en\":\"\",\"firm_name_en\":\"\",\"firm_town\":\"Plovdiv\",\"is_person\":\"0\",\"firm_mol_en\":\"\",\"firm_is_reg_vat\":\"0\",\"person_name\":\"\",\"firm_town_en\":\"\",\"person_city\":\"\",\"firm_mol\":\"Valio\",\"person_address\":\"\",\"deleted\":\"1\",\"invoices\":\"0\",\"extra_data\":{},\"person_name_en\":\"\",\"firm_name\":\"Update REST FIRMA 2\",\"firm_vat_number\":\"\",\"person_address_en\":\"\",\"person_egn\":\"\",\"id\":\"36\",\"firm_addr\":\"Ivan Stranski 3v\"}", result);
        System.out.println(result);
    }

}
