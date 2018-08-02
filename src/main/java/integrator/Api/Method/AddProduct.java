package integrator.Api.Method;

import integrator.Api.Request;

public class AddProduct {

    public static String create(String productDetails) {
        String createLink = "/v1/product";
        Request request = new Request();
        return request.postRequest(createLink, productDetails);
    }
}
