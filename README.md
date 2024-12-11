# Munch Map

Munch Map is a Java-based application that helps users find random restaurants in their area based on a given address and radius. The program uses the Google Maps API to get geolocation coordinates and search for nearby restaurants.

## Features
- Allows the user to enter an address and a search radius.
- Retrieves the geolocation coordinates of the address using the Google Maps Geocoding API.
- Finds restaurants within the specified radius using the Google Places API.
- Displays the name, address, and rating of a random restaurant in the area.

## Requirements

Before running the application, ensure that you have the following:

- **Java 8+**: The project is written in Java and requires Java 8 or higher.
- **Google API Key**: The project uses Google's APIs (Geocoding and Places) to retrieve data. You need to set up a Google Cloud project and enable the APIs. Obtain your API key and store it as an environment variable named `GOOGLE_API`.

## Setup

1. Clone this repository to your local machine.

   ```bash
   git clone https://github.com/your-username/munch-map.git
   ```

2. Compile and run the project:

   ```bash
   javac Main.java RestaurantData.java
   java Main
   ```

3. Set your Google API key as an environment variable. In Linux/MacOS:

   ```bash
   export GOOGLE_API="your-api-key-here"
   ```

   For Windows:

   ```bash
   set GOOGLE_API="your-api-key-here"
   ```

## Usage

1. Start the program by pressing `y` when prompted.

2. Enter your current address to find a random restaurant in your area.

3. Choose a radius (in miles) for the search (e.g., 5, 10, 15).

4. The program will display a random restaurant within the specified radius, including its name, address, and rating.

5. To exit the program, type `q` when prompted for the address.

## Example

```
Welcome!
Press y to begin
y

Welcome to Munch Map
Enter your current address to get a random Restaurant in your area (press q to quit)
123 Main St, New York
Now choose a radius (5, 10, 15)
10
Name: Pizza Place
Address: 456 Elm St, New York
Rating: 4.2/5
```

## Methods

### `RestaurantData.getCoordinates(String address)`

Fetches the latitude and longitude of the provided address using the Google Geocoding API.

### `RestaurantData.getRetsaurant(double[] coordinates, int radius)`

Finds a random restaurant within the specified radius using the Google Places API.

### `RestaurantData.convertToMeters(int miles)`

Converts the provided radius in miles to meters, as required by the Google Places API.

## Error Handling

- If the geolocation or restaurant search fails, the program will display an error message.
- If no restaurants are found, the program will notify the user.

## License

