package tests;

import Requests.CoinRequest;
import Requests.connection;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RequestTests {

    @Before
    public void setUp() {
        // Set up the connection before testing
        connection conn = new connection();
        CoinRequest.setConnection(conn);
    }

    @Test
    public void testStatusCode200() throws Exception {
        int statusCode = CoinRequest.getStatusCode();
        assertEquals(200, statusCode);
    }
    @Test
    public void getPrice()throws Exception{
        CoinRequest.getCurrentPriceJson();
    }
}
