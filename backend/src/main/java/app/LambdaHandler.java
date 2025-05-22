package app;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import app.customer.CustomerRepository;

@Component
public class LambdaHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent request, Context context) {
        String httpMethod = request.getHttpMethod();
        String path = request.getPath();

        switch (httpMethod) {
            case "GET":
                if (path.equals("/api/v1/customers")) {
                    return getCustomers();
                }
                break;
            case "POST":
                if (path.equals("/api/v1/customers")) {
                    return createCustomer(request);
                }
                break;
            // Add more cases for other endpoints
        }

        return new APIGatewayProxyResponseEvent()
                .withStatusCode(404)
                .withBody("Not Found");
    }

    private APIGatewayProxyResponseEvent getCustomers() {
        // Logic to retrieve customers
        return new APIGatewayProxyResponseEvent()
                .withStatusCode(200)
                .withBody("List of customers");
    }

    private APIGatewayProxyResponseEvent createCustomer(APIGatewayProxyRequestEvent request) {
        // Logic to create a customer
        return new APIGatewayProxyResponseEvent()
                .withStatusCode(201)
                .withBody("Customer created");
    }
}