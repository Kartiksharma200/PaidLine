package integration;

import io.restassured.response.Response;
import java.util.List;
import java.util.Map;

public class BackendClient {

    public static int getCallCountByStatus(String token, String statusFilter) {
        Response response = utils.APIUtils.getCallData("/calls", token);

        List<Map<String, Object>> calls = response.jsonPath().getList("data");

        return (int) calls.stream()
                .filter(call -> statusFilter.equalsIgnoreCase((String) call.get("status")))
                .count();
    }

    public static int getTotalCalls(String token) {
        Response response = utils.APIUtils.getCallData("/calls", token);
        List<Map<String, Object>> calls = response.jsonPath().getList("data");
        return calls.size();
    }
}
