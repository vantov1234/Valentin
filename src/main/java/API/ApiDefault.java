package API;

public abstract class ApiDefault {

    public String restAPIUrl;

    public ApiDefault(String restAPIUrl) {
        this.restAPIUrl = restAPIUrl;

    }

    public String getRestAPIUrl() {
        return restAPIUrl;
    }

    public void buildAndResponse() {

    }
}
