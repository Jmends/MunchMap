package controller;

import model.RestaurantData;
import view.MunchMapView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MunchMapController {
    private MunchMapView view;
    private RestaurantData model;

    public MunchMapController(RestaurantData model, MunchMapView view){
        this.view = view;
        this.model = model;

        view.getRestaurantButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleUserInput();
            }
        });
    }
    private void handleUserInput(){
        String address = view.getAddress();
        int radius = view.getRadius();

        try{
            int meterRadius = RestaurantData.convertToMeters(radius);
            double[] coords = RestaurantData.getCoordinates(address);

            String food = RestaurantData.getRetsaurant(coords,meterRadius);

            view.setRestaurant(food); // displays restaurant info to the GUI

        } catch (Exception e) {
            view.setRestaurant(e.getMessage());
        }
    }
}
