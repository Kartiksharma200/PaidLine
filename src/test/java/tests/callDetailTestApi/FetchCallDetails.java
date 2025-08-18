//package tests.callDetailTestApi;
//
//import org.testng.annotations.Test;
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//
//public class fetchCallDetails {
//
//    @Test
//    public void fetchAllCallDetails() {
//        String baseUrl = "http://localhost:8000/api";
//        String apiPath = "/call-history/vendor/call-history?page=1&pageSize=5000&filter=ALL";//change filter if you want any other call data
//        String bearerToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjp7Im5hbWUiOnsiZmlyc3QiOiJLYXJ0aWsiLCJsYXN0IjoiU2hhcm1hIn0sInNvY2lhbFZlcmlmaWNhdGlvbiI6eyJpc1R3aXR0ZXJWZXJpZmllZCI6ZmFsc2UsImlzR29vZ2xlVmVyaWZpZWQiOmZhbHNlLCJpc0xpbmtlZGluVmVyaWZpZWQiOmZhbHNlLCJpc0ZhY2Vib29rVmVyaWZpZWQiOmZhbHNlLCJpc1BpbnRlcmVzdFZlcmlmaWVkIjpmYWxzZX0sIl9pZCI6IjY4Nzc4MmUxNTIwMmJkY2E1YTkwNjY4ZCIsImVtYWlsIjoia2FydGlrLnNoYXJtYUBieWxkZC5jb20iLCJpc1ZlcmlmaWVkIjp0cnVlLCJmaXJlYmFzZVVpZCI6IllFSUhUNHpoYlNmempUWkUyOUQ0TDgwdWs0ejEiLCJoYXNQYXNzd29yZCI6dHJ1ZSwiaXNDbGllbnQiOnRydWUsImNhbGxlck5vdGVzIjpbXSwicm9sZXMiOiJVU0VSIiwiaXNCbG9ja2VkIjpmYWxzZSwiaXNPbmJvYXJkZWQiOnRydWUsIm9uYm9hcmRTdGF0dXMiOiJTZXQgWW91ciBBdmFpbGFiaWxpdHkiLCJpbWFnZXMiOltdLCJwcm9maWxlSW1hZ2UiOltdLCJjYXJkVG9rZW5zIjpbXSwic3Vic2NyaXB0aW9uQWN0aXZlVW50aWwiOjE3ODQxOTg4NzEwMDAsInN1YnNjcmlwdGlvbkNhbmNlbGxhdGlvblJlcXVlc3RlZCI6ZmFsc2UsInN1YnNjcmlwdGlvblN0YXR1cyI6IkFDVElWRSIsImlzUGhvbmVWZXJpZmllZCI6dHJ1ZSwiaXNTdHJpcGVDb25uZWN0Ijp0cnVlLCJ0aW1lWm9uZSI6IkFzaWEvQ2FsY3V0dGEiLCJwYXNzd29yZFVwZGF0ZWRBdCI6bnVsbCwiY3JlYXRlZEF0IjoiMjAyNS0wNy0xNlQxMDo0NTo1My4xMDRaIiwidXBkYXRlZEF0IjoiMjAyNS0wOC0xMVQxMDowNjoyNy4xNTRaIiwiX192IjowLCJvdHAiOiIiLCJvdHBFeHBpcmVzQXQiOiIyMDI1LTA3LTE2VDEwOjU2OjIzLjI4MFoiLCJleHRlbnNpb25JZCI6IjY4Nzc4MzBiNTIwMmJkY2E1YTkwNjY5YiIsInBob25lIjoiKzkxOTM4OTUxNzgxNCIsInByb2ZpbGVSZWYiOiI2ODc3ODMwYjUyMDJiZGNhNWE5MDY2OTgiLCJzdHJpcGVDdXN0b21lcklkIjoiY3VzX1NncVllRUJsWVJZcllPIiwic3Vic2NyaXB0aW9uSWQiOiI2NmNjMTA5MWQ2ZmM0ZDYxZmI3N2NjNzYiLCJzdWJzY3JpcHRpb25SZWYiOiI2ODc3ODM1YTUyMDJiZGNhNWE5MDY2YzMiLCJjbGllbnRJZCI6IjY4Nzc5MTQ5NTIwMmJkY2E1YTkwNmM3OCIsImZ1bGxOYW1lIjoiS2FydGlrIFNoYXJtYSIsImlzU3VwZXJBZG1pbiI6ZmFsc2UsImlzQWRtaW4iOmZhbHNlLCJpZCI6IjY4Nzc4MmUxNTIwMmJkY2E1YTkwNjY4ZCJ9LCJpYXQiOjE3NTUwNjI4MTksImV4cCI6MTc1NTQ5NDgxOX0.YGERf-fPT4YdNnB7ZdPLAzGV0J68axlCcFCkqILic1s";
//     
//        // Send GET request without forcing statusCode(200)
//        Response res = RestAssured
//                .given()
//                .baseUri(baseUrl)
//                .header("Authorization", "Bearer " + bearerToken)
//                .get(apiPath);
//
//        int statusCode = res.statusCode();
//
//        System.out.println("Status Code: " + statusCode);
//
//        if (statusCode == 200) {
//            System.out.println("✅ Success Response:");
//            System.out.println(res.asPrettyString());
//        } else {
//            System.out.println("❌ Backend Error Response:");
//            System.out.println(res.asPrettyString()); // Prints error details from backend
//        }
//    }
//}


//package tests.callDetailTestApi;
//
//import org.testng.annotations.Test;
//import io.restassured.RestAssured;
//import io.restassured.response.Response;
//
//import java.time.LocalDate;
//import java.time.OffsetDateTime;
//import java.util.List;
//import java.util.Map;
//
//public class fetchCallDetails {
//
//    @Test
//    public void fetchAllCallDetails throws ParseException() {
//        String baseUrl = "http://localhost:8000/api";
//        String apiPath = "/call-history/vendor/call-history?page=1&pageSize=5000&filter=ALL";
//        String bearerToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjp7Im5hbWUiOnsiZmlyc3QiOiJLYXJ0aWsiLCJsYXN0IjoiU2hhcm1hIn0sInNvY2lhbFZlcmlmaWNhdGlvbiI6eyJpc1R3aXR0ZXJWZXJpZmllZCI6ZmFsc2UsImlzR29vZ2xlVmVyaWZpZWQiOmZhbHNlLCJpc0xpbmtlZGluVmVyaWZpZWQiOmZhbHNlLCJpc0ZhY2Vib29rVmVyaWZpZWQiOmZhbHNlLCJpc1BpbnRlcmVzdFZlcmlmaWVkIjpmYWxzZX0sIl9pZCI6IjY4Nzc4MmUxNTIwMmJkY2E1YTkwNjY4ZCIsImVtYWlsIjoia2FydGlrLnNoYXJtYUBieWxkZC5jb20iLCJpc1ZlcmlmaWVkIjp0cnVlLCJmaXJlYmFzZVVpZCI6IllFSUhUNHpoYlNmempUWkUyOUQ0TDgwdWs0ejEiLCJoYXNQYXNzd29yZCI6dHJ1ZSwiaXNDbGllbnQiOnRydWUsImNhbGxlck5vdGVzIjpbXSwicm9sZXMiOiJVU0VSIiwiaXNCbG9ja2VkIjpmYWxzZSwiaXNPbmJvYXJkZWQiOnRydWUsIm9uYm9hcmRTdGF0dXMiOiJTZXQgWW91ciBBdmFpbGFiaWxpdHkiLCJpbWFnZXMiOltdLCJwcm9maWxlSW1hZ2UiOltdLCJjYXJkVG9rZW5zIjpbXSwic3Vic2NyaXB0aW9uQWN0aXZlVW50aWwiOjE3ODQxOTg4NzEwMDAsInN1YnNjcmlwdGlvbkNhbmNlbGxhdGlvblJlcXVlc3RlZCI6ZmFsc2UsInN1YnNjcmlwdGlvblN0YXR1cyI6IkFDVElWRSIsImlzUGhvbmVWZXJpZmllZCI6dHJ1ZSwiaXNTdHJpcGVDb25uZWN0Ijp0cnVlLCJ0aW1lWm9uZSI6IkFzaWEvQ2FsY3V0dGEiLCJwYXNzd29yZFVwZGF0ZWRBdCI6bnVsbCwiY3JlYXRlZEF0IjoiMjAyNS0wNy0xNlQxMDo0NTo1My4xMDRaIiwidXBkYXRlZEF0IjoiMjAyNS0wOC0xMVQxMDowNjoyNy4xNTRaIiwiX192IjowLCJvdHAiOiIiLCJvdHBFeHBpcmVzQXQiOiIyMDI1LTA3LTE2VDEwOjU2OjIzLjI4MFoiLCJleHRlbnNpb25JZCI6IjY4Nzc4MzBiNTIwMmJkY2E1YTkwNjY5YiIsInBob25lIjoiKzkxOTM4OTUxNzgxNCIsInByb2ZpbGVSZWYiOiI2ODc3ODMwYjUyMDJiZGNhNWE5MDY2OTgiLCJzdHJpcGVDdXN0b21lcklkIjoiY3VzX1NncVllRUJsWVJZcllPIiwic3Vic2NyaXB0aW9uSWQiOiI2NmNjMTA5MWQ2ZmM0ZDYxZmI3N2NjNzYiLCJzdWJzY3JpcHRpb25SZWYiOiI2ODc3ODM1YTUyMDJiZGNhNWE5MDY2YzMiLCJjbGllbnRJZCI6IjY4Nzc5MTQ5NTIwMmJkY2E1YTkwNmM3OCIsImZ1bGxOYW1lIjoiS2FydGlrIFNoYXJtYSIsImlzU3VwZXJBZG1pbiI6ZmFsc2UsImlzQWRtaW4iOmZhbHNlLCJpZCI6IjY4Nzc4MmUxNTIwMmJkY2E1YTkwNjY4ZCJ9LCJpYXQiOjE3NTUwNjI4MTksImV4cCI6MTc1NTQ5NDgxOX0.YGERf-fPT4YdNnB7ZdPLAzGV0J68axlCcFCkqILic1s";
//
//        // 1. API call
//        Response res = RestAssured
//                .given()
//                .baseUri("https://your-api-url.com")  // <-- Change to your API base URL
//                .basePath("/call-details")            // <-- Change to your API endpoint
//                .when()
//                .get();

//        // 2. Extract the list from nested "data.data"
//        List<Map<String, Object>> calls = res.jsonPath().getList("data.data");
//
//        // Variables for earnings
//        double monthlyEarnings = 0;
//        double yearlyEarnings = 0;
//        double lifetimeEarnings = 0;
//
//        // Get current date
//        Calendar now = Calendar.getInstance();
//        int currentMonth = now.get(Calendar.MONTH) + 1; // Jan = 0
//        int currentYear = now.get(Calendar.YEAR);
//
//        // Date parser for timestamp
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
//
//        // 3. Loop through calls and calculate
//        for (Map<String, Object> call : calls) {
//            double earnings = ((Number) call.get("earnings")).doubleValue();
//
//            // Add to lifetime earnings
//            lifetimeEarnings += earnings;
//
//            // Parse timestamp
//            String timestamp = (String) call.get("timestamp");
//            Date date = sdf.parse(timestamp);
//            Calendar cal = Calendar.getInstance();
////            cal.setTime(date);
////
////            int callMonth = cal.get(Calendar.MONTH) + 1;
////            int callYear = cal.get(Calendar.YEAR);
////
////            // Monthly earnings
////            if (callMonth == currentMonth && callYear == currentYear) {
////                monthlyEarnings += earnings;
////            }
////
////            // Yearly earnings
////            if (callYear == currentYear) {
////                yearlyEarnings += earnings;
////            }
////        }
////
////        // 4. Print results
////        System.out.println("📅 Monthly Earnings: " + monthlyEarnings);
////        System.out.println("📆 Yearly Earnings: " + yearlyEarnings);
////        System.out.println("🌍 Lifetime Earnings: " + lifetimeEarnings);
////    }
//}

package tests.callDetailTestApi;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FetchCallDetails {

    @Test
    public void fetchAllCallDetails() throws ParseException {
        String baseUrl = "http://localhost:8000/api";
        String apiPath = "/call-history/vendor/call-history?page=1&pageSize=5000&filter=ALL";
        String bearerToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjp7Im5hbWUiOnsiZmlyc3QiOiJLYXJ0aWsiLCJsYXN0IjoiU2hhcm1hIn0sInNvY2lhbFZlcmlmaWNhdGlvbiI6eyJpc1R3aXR0ZXJWZXJpZmllZCI6ZmFsc2UsImlzR29vZ2xlVmVyaWZpZWQiOmZhbHNlLCJpc0xpbmtlZGluVmVyaWZpZWQiOmZhbHNlLCJpc0ZhY2Vib29rVmVyaWZpZWQiOmZhbHNlLCJpc1BpbnRlcmVzdFZlcmlmaWVkIjpmYWxzZX0sIl9pZCI6IjY4Nzc4MmUxNTIwMmJkY2E1YTkwNjY4ZCIsImVtYWlsIjoia2FydGlrLnNoYXJtYUBieWxkZC5jb20iLCJpc1ZlcmlmaWVkIjp0cnVlLCJmaXJlYmFzZVVpZCI6IllFSUhUNHpoYlNmempUWkUyOUQ0TDgwdWs0ejEiLCJoYXNQYXNzd29yZCI6dHJ1ZSwiaXNDbGllbnQiOnRydWUsImNhbGxlck5vdGVzIjpbXSwicm9sZXMiOiJVU0VSIiwiaXNCbG9ja2VkIjpmYWxzZSwiaXNPbmJvYXJkZWQiOnRydWUsIm9uYm9hcmRTdGF0dXMiOiJTZXQgWW91ciBBdmFpbGFiaWxpdHkiLCJpbWFnZXMiOltdLCJwcm9maWxlSW1hZ2UiOltdLCJjYXJkVG9rZW5zIjpbXSwic3Vic2NyaXB0aW9uQWN0aXZlVW50aWwiOjE3ODQxOTg4NzEwMDAsInN1YnNjcmlwdGlvbkNhbmNlbGxhdGlvblJlcXVlc3RlZCI6ZmFsc2UsInN1YnNjcmlwdGlvblN0YXR1cyI6IkFDVElWRSIsImlzUGhvbmVWZXJpZmllZCI6dHJ1ZSwiaXNTdHJpcGVDb25uZWN0Ijp0cnVlLCJ0aW1lWm9uZSI6IkFzaWEvQ2FsY3V0dGEiLCJwYXNzd29yZFVwZGF0ZWRBdCI6bnVsbCwiY3JlYXRlZEF0IjoiMjAyNS0wNy0xNlQxMDo0NTo1My4xMDRaIiwidXBkYXRlZEF0IjoiMjAyNS0wOC0xMVQxMDowNjoyNy4xNTRaIiwiX192IjowLCJvdHAiOiIiLCJvdHBFeHBpcmVzQXQiOiIyMDI1LTA3LTE2VDEwOjU2OjIzLjI4MFoiLCJleHRlbnNpb25JZCI6IjY4Nzc4MzBiNTIwMmJkY2E1YTkwNjY5YiIsInBob25lIjoiKzkxOTM4OTUxNzgxNCIsInByb2ZpbGVSZWYiOiI2ODc3ODMwYjUyMDJiZGNhNWE5MDY2OTgiLCJzdHJpcGVDdXN0b21lcklkIjoiY3VzX1NncVllRUJsWVJZcllPIiwic3Vic2NyaXB0aW9uSWQiOiI2NmNjMTA5MWQ2ZmM0ZDYxZmI3N2NjNzYiLCJzdWJzY3JpcHRpb25SZWYiOiI2ODc3ODM1YTUyMDJiZGNhNWE5MDY2YzMiLCJjbGllbnRJZCI6IjY4Nzc5MTQ5NTIwMmJkY2E1YTkwNmM3OCIsImZ1bGxOYW1lIjoiS2FydGlrIFNoYXJtYSIsImlzU3VwZXJBZG1pbiI6ZmFsc2UsImlzQWRtaW4iOmZhbHNlLCJpZCI6IjY4Nzc4MmUxNTIwMmJkY2E1YTkwNjY4ZCJ9LCJpYXQiOjE3NTUwNjI4MTksImV4cCI6MTc1NTQ5NDgxOX0.YGERf-fPT4YdNnB7ZdPLAzGV0J68axlCcFCkqILic1s";

        // 1. API call
        Response res = RestAssured
//                .given()
//                .baseUri(baseUrl)
//                .basePath(apiPath)
//                .header("Authorization", "Bearer " + bearerToken)
//                .when()
//                .get();
        		.given()
                .baseUri(baseUrl)
                .header("Authorization", "Bearer " + bearerToken)
                .get(apiPath);

        // Print the response to check structure
        System.out.println(res.asPrettyString());

        // ✅ Adjust this path based on actual JSON structure
        // Example: { "data": { "data": [ {..}, {..} ] } }
        Map<String, Object> outerData = res.jsonPath().getMap("data");
        List<Map<String, Object>> calls = (List<Map<String, Object>>) outerData.get("data.data");

        if (calls == null) {
            System.out.println("No call data found!");
            return;
        }

        // Variables for earnings
        double monthlyEarnings = 0;
        double yearlyEarnings = 0;
        double lifetimeEarnings = 0;

        Calendar now = Calendar.getInstance();
        int currentMonth = now.get(Calendar.MONTH) + 1;
        int currentYear = now.get(Calendar.YEAR);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        for (Map<String, Object> call : calls) {
            double earnings = ((Number) call.getOrDefault("earnings", 0)).doubleValue();
            lifetimeEarnings += earnings;

            String timestamp = (String) call.get("timestamp");
            if (timestamp != null) {
                Date date = sdf.parse(timestamp);
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);

                int callMonth = cal.get(Calendar.MONTH) + 1;
                int callYear = cal.get(Calendar.YEAR);

                if (callMonth == currentMonth && callYear == currentYear) {
                    monthlyEarnings += earnings;
                }
                if (callYear == currentYear) {
                    yearlyEarnings += earnings;
                }
            }
        }

        // Print results
        System.out.println("📅 Monthly Earnings: " + monthlyEarnings);
        System.out.println("📆 Yearly Earnings: " + yearlyEarnings);
        System.out.println("🌍 Lifetime Earnings: " + lifetimeEarnings);
    }
}


