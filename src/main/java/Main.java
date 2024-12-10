import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
////
//        double coords[] = RestaurantData.getCoordinates("13411 Lake willoughby Ln");
//
//        int radius = RestaurantData.convertToMeters(5);
//
//        String food = RestaurantData.getRetsaurant(coords,radius);
//
//
//        System.out.println(coords[0]);
//        System.out.println(coords[1]);
//
//        System.out.println(radius);
//        System.out.println(food);

        System.out.println("Welcome!");
        System.out.println("Press y to begin");


        String begin = scan.nextLine();

        if (begin.equalsIgnoreCase("y")) {
            startProgram();
        } else {
            System.out.println("Goodbye");
        }


    }

    public static void startProgram() {
        System.out.println("Welcome to Munch Map");
        Scanner scan = new Scanner(System.in);
        boolean running = true;

        while (running) {


            System.out.println("\nEnter your current address to get a random Restaurant in your area" +
                    " (press q to quit)");
            String address = scan.nextLine();
            if (address.equalsIgnoreCase("q")) {
                System.out.println("Goodbye");
                running = false;
                break;
            }

            System.out.println("Now choose a radius (5,10,15,15)");
            int mileRadius = scan.nextInt();
            scan.nextLine(); // next line trap

            int meterRadius = RestaurantData.convertToMeters(mileRadius);

            double[] coords = RestaurantData.getCoordinates(address);

            String food = RestaurantData.getRetsaurant(coords, meterRadius);

            System.out.println(food);

        }
    }
}
