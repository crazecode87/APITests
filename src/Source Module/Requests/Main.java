package Requests;

public class Main {

    public static void main(String[] args) {
        try {
            //Set up the connection
            connection conn = new connection();
            Requests.CoinRequest.setConnection(conn);

            //Get status code
            int statusCode = Requests.CoinRequest.getStatusCode();
            System.out.println("HTTP Status Code: " + statusCode);

            //Get the current price
            String jsonResponse = Requests.CoinRequest.getCurrentPriceJson();
            System.out.println("Response: " + jsonResponse);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
