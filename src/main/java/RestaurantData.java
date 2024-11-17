import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RestaurantData {
    //api key
    private static final String API_KEY = System.getenv("GOOGLE_API");

    public static double[] getCordinates(String address, String api){

        return new double[] {1,2}; //place holder
    }

}
