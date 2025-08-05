package tests.earningDetailTestApi;

import org.testng.annotations.Test;
import java.text.DecimalFormat;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class earningDetails {
	
	  
    // Instance variables to hold values
    private String currentMonth;
    private String currentYear;
    private String lifeTime;
    private String lastMonth;
    private String currentYearPayout;
    private String lifeTimeOut;
    private String pay;
    private String bal;

    // Getter methods
    public String getCurrentMonth() {
        return currentMonth;
    }
    public String getCurrentYear() {
        return currentYear;
    }
    public String getLifeTime() {
    	return lifeTime;
    }
    public String getLastMonth() {
    	return lastMonth;
    }
    public String getCurrentYearPay() {
    	return currentYearPayout;
    }
    public String getLifeTimeOut() {
    	return lifeTimeOut;
    }
    public String getPay() {
    	return pay;
    }
    public String getBal() {
    	return bal;  	
    }
    

     @Test
    public void fetchAllCallDetails() {
        String baseUrl = "http://localhost:8000/api";
        String apiPath = "/user/dashboard/earnings?timeLine=Month";//change filter if you want any other call data
        String bearerToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRhIjp7Im5hbWUiOnsiZmlyc3QiOiJLYXJ0aWsiLCJsYXN0IjoiU2hhcm1hIn0sInNvY2lhbFZlcmlmaWNhdGlvbiI6eyJpc1R3aXR0ZXJWZXJpZmllZCI6ZmFsc2UsImlzR29vZ2xlVmVyaWZpZWQiOmZhbHNlLCJpc0xpbmtlZGluVmVyaWZpZWQiOmZhbHNlLCJpc0ZhY2Vib29rVmVyaWZpZWQiOmZhbHNlLCJpc1BpbnRlcmVzdFZlcmlmaWVkIjpmYWxzZX0sIl9pZCI6IjY4Nzc4MmUxNTIwMmJkY2E1YTkwNjY4ZCIsImVtYWlsIjoia2FydGlrLnNoYXJtYUBieWxkZC5jb20iLCJpc1ZlcmlmaWVkIjp0cnVlLCJmaXJlYmFzZVVpZCI6IllFSUhUNHpoYlNmempUWkUyOUQ0TDgwdWs0ejEiLCJoYXNQYXNzd29yZCI6dHJ1ZSwiaXNDbGllbnQiOnRydWUsImNhbGxlck5vdGVzIjpbXSwicm9sZXMiOiJVU0VSIiwiaXNCbG9ja2VkIjpmYWxzZSwiaXNPbmJvYXJkZWQiOnRydWUsIm9uYm9hcmRTdGF0dXMiOiJTZXQgWW91ciBBdmFpbGFiaWxpdHkiLCJpbWFnZXMiOltdLCJwcm9maWxlSW1hZ2UiOltdLCJjYXJkVG9rZW5zIjpbXSwic3Vic2NyaXB0aW9uQWN0aXZlVW50aWwiOjE3ODQxOTg4NzEwMDAsInN1YnNjcmlwdGlvbkNhbmNlbGxhdGlvblJlcXVlc3RlZCI6ZmFsc2UsInN1YnNjcmlwdGlvblN0YXR1cyI6IkFDVElWRSIsImlzUGhvbmVWZXJpZmllZCI6dHJ1ZSwiaXNTdHJpcGVDb25uZWN0Ijp0cnVlLCJ0aW1lWm9uZSI6IkFzaWEvQ2FsY3V0dGEiLCJwYXNzd29yZFVwZGF0ZWRBdCI6bnVsbCwiY3JlYXRlZEF0IjoiMjAyNS0wNy0xNlQxMDo0NTo1My4xMDRaIiwidXBkYXRlZEF0IjoiMjAyNS0wOC0xMVQxMDowNjoyNy4xNTRaIiwiX192IjowLCJvdHAiOiIiLCJvdHBFeHBpcmVzQXQiOiIyMDI1LTA3LTE2VDEwOjU2OjIzLjI4MFoiLCJleHRlbnNpb25JZCI6IjY4Nzc4MzBiNTIwMmJkY2E1YTkwNjY5YiIsInBob25lIjoiKzkxOTM4OTUxNzgxNCIsInByb2ZpbGVSZWYiOiI2ODc3ODMwYjUyMDJiZGNhNWE5MDY2OTgiLCJzdHJpcGVDdXN0b21lcklkIjoiY3VzX1NncVllRUJsWVJZcllPIiwic3Vic2NyaXB0aW9uSWQiOiI2NmNjMTA5MWQ2ZmM0ZDYxZmI3N2NjNzYiLCJzdWJzY3JpcHRpb25SZWYiOiI2ODc3ODM1YTUyMDJiZGNhNWE5MDY2YzMiLCJjbGllbnRJZCI6IjY4Nzc5MTQ5NTIwMmJkY2E1YTkwNmM3OCIsImZ1bGxOYW1lIjoiS2FydGlrIFNoYXJtYSIsImlzU3VwZXJBZG1pbiI6ZmFsc2UsImlzQWRtaW4iOmZhbHNlLCJpZCI6IjY4Nzc4MmUxNTIwMmJkY2E1YTkwNjY4ZCJ9LCJpYXQiOjE3NTU0OTcxOTIsImV4cCI6MTc1NTkyOTE5Mn0.azUSCwfZn7RgUyQFIOPzx0BcLmqfNBHrnTswsnJQ4lQ";
     
        // Send GET request without forcing statusCode(200)
        Response res = RestAssured
                .given()
                .baseUri(baseUrl)
                .header("Authorization", "Bearer " + bearerToken)
                .get(apiPath);

        int statusCode = res.statusCode();

        System.out.println("Status Code: " + statusCode);
     // Assuming 'res' is your Response object
        double currentMonthEarning = res.jsonPath().getDouble("data.currentMonthEarning");
        double currentYearEarning = res.jsonPath().getDouble("data.currentYearEarning");
        double lifeTimeEarning    = res.jsonPath().getDouble("data.lifeTimeEarning");
        double lastMonthPayout    = res.jsonPath().getDouble("data.lastMonthPayout");
        double currentYearPayout  = res.jsonPath().getDouble("data.currentYearPayout");
        double lifeTimePayout     = res.jsonPath().getDouble("data.lifeTimePayout");
        double nextPayout         = res.jsonPath().getDouble("data.nextPayout");
        double balance            = res.jsonPath().getDouble("data.balance");

        // Print them
        DecimalFormat df = new DecimalFormat("0.00");
        String currentMonth = df.format(currentMonthEarning/100);
        String currentYear = df.format(currentYearEarning/100);
        String lifeTime = df.format(lifeTimeEarning/100); 
        String lastMonth = df.format(lastMonthPayout/100);
        String currentYearPay = df.format(currentYearPayout/100);
        String lifeTimePay = df.format(lifeTimePayout/100);
        String nextPay = df.format(nextPayout/100);
        String bal = df.format(balance/100);
       
        System.out.println("Current Month Earning: " + currentMonth);
        System.out.println("Current Year Earning: " + currentYear);
        System.out.println("Lifetime Earning: " + lifeTime);
        System.out.println("Last Month Payout: " + lastMonth);
        System.out.println("Current Year Payout: " + currentYearPay);
        System.out.println("Lifetime Payout: " + lifeTimePay);
        System.out.println("Next Payout: " + nextPay);
        System.out.println("Balance: " + bal);
       
        if (statusCode == 200) {
            System.out.println("✅ Success Response:");
            System.out.println(res.asPrettyString());
        } else {
            System.out.println("❌ Backend Error Response:");
            System.out.println(res.asPrettyString()); // Prints error details from backend
        }
    } 
}
