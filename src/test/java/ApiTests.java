import API.ApiDeleteMethod;
import API.ApiGetMethod;
import API.ApiPostMethod;
import API.ApiPutMethod;
import org.junit.Test;

public class ApiTests {

    @Test
    public void getTest() {
        ApiGetMethod get = new ApiGetMethod("https://testvalio.inv.bg/RESTapi/client/36");
        get.getRestAPIUrl();
        get.buildAndResponse();
    }

    @Test
    public void postTest() {
        ApiPostMethod post = new ApiPostMethod("https://testvalio.inv.bg/RESTapi/client");
        post.buildAndResponse();
    }

    @Test
    public void putTest() {
        ApiPutMethod put = new ApiPutMethod("https://testvalio.inv.bg/RESTapi/client/54");
        put.buildAndResponse();
    }

    @Test
    public void deleteTest(){
        ApiDeleteMethod delete = new ApiDeleteMethod("https://testvalio.inv.bg/RESTapi/client/20)");
        delete.buildAndResponse();
    }
}
