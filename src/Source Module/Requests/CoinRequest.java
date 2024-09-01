package Requests;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class CoinRequest {
    private static connection connection;
    public static String API_URL;

    public static void setConnection(connection conn) {
        CoinRequest.connection = conn;
        API_URL = conn.url;
    }
    public static String getCurrentPriceJson() throws Exception {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(API_URL);
            System.out.println("API Request: " + request.getURI());
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                String jsonResponse = EntityUtils.toString(response.getEntity());
                System.out.println("JSON Response: " + jsonResponse);
                return jsonResponse;
            }
        }
    }
    public static int getStatusCode() throws Exception {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(API_URL);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                System.out.println("Connection successful");
                return response.getStatusLine().getStatusCode();
            }
        }
    }
}
