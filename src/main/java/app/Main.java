package app;

import controller.MunchMapController;
import model.RestaurantData;
import view.MunchMapView;

public class Main {
    public static void main(String[] args) {


        RestaurantData model = new RestaurantData();
        MunchMapView view = new MunchMapView();

        MunchMapController controller = new MunchMapController(model,view);

    }
}
