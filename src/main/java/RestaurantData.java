import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import org.json.JSONArray;

public class RestaurantData {
    //api key
    private static final String API_KEY = System.getenv("GOOGLE_API");

    public static double[] getCordinates(String address, String api) {
        try {

            String encodedAddress = address.replace(" ", "+");
            String urlString = "https://maps.googleapis.com/maps/api/geocode/json?address=" + encodedAddress + "&key=" + API_KEY;

            URL url = new URL(urlString);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return new double[]{1, 2}; //place holder
    }

}
