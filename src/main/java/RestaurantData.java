import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.Random;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class RestaurantData {
    //api key
    private static final String API_KEY = System.getenv("GOOGLE_API");

    public static double[] getCoordinates(String address) {
        double[] coordinates = new double[2];
        try {

            String encodedAddress = address.replace(" ", "+");
            String urlString = "https://maps.googleapis.com/maps/api/geocode/json?address=" + encodedAddress + "&key=" + API_KEY;

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("ERROR \nResponse code: " + responseCode);
            } else {

                String inline = "";
                Scanner scan = new Scanner(url.openStream());

                //writes all json data into a string
                while (scan.hasNext()) {
                    inline += scan.nextLine();
                }
                scan.close();

                //parse string into a json object
                JSONParser parse = new JSONParser();
                JSONObject data_obj = (JSONObject) parse.parse(inline);

                JSONArray results = (JSONArray) data_obj.get("results");

                if (results != null && !results.isEmpty()) {
                    JSONObject firstResult = (JSONObject) results.get(0);

                    JSONObject geometry = (JSONObject) firstResult.get("geometry");
                    JSONObject location = (JSONObject) geometry.get("location");

                    double lat = (double) location.get("lat");
                    double lng = (double) location.get("lng");

                    coordinates[0] = lat;
                    coordinates[1] = lng;

                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return coordinates;
    }

    public static String getRetsaurant(double[] coordinates, int radius) {
        try {
            String urlString = "https://maps.googleapis.com/maps/api/place/nearbysearch/json" +
                    "?location" + coordinates[0] + coordinates[1] + "&radius=" + radius +
                    "&type=restaurant" + "&key=" + API_KEY;

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("ERROR \nResponse code: " + responseCode);
            } else {

                String inline = "";
                Scanner scan = new Scanner(url.openStream());

                while (scan.hasNext()) {
                    inline += scan.nextLine();
                }

                scan.close();

                JSONParser parse = new JSONParser();
                JSONObject data_obj = (JSONObject) parse.parse(inline);

                JSONArray results = (JSONArray) data_obj.get("resluts");

                if (results.isEmpty()) {
                    return "No resturants found";
                }

                //gets a random restaurant
                int randomIndex = (int) (Math.random() * results.size());
                JSONObject resturant = (JSONObject) results.get(randomIndex);

                String name = (String) resturant.get("name");
                String address = (String) resturant.get("Vicinity");
                Double rating = (Double) resturant.get("rating");


                return "name: " + name + "\nAddress: " + address + "\nRating: "
                        + (rating != null ? rating + "/5" : "No rating available");

            }
        } catch (Exception e) {
            return e.getMessage();
        }

    }

}
