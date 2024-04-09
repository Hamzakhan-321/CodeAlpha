            /*             Travel Itinerary Planner

           Create a travel itinerary planner that allows users to
           input destinations, dates, and preferences to generate
           a detailed travel plan. Include features like maps,
           weather information, and budget calculations.*/


import java.util.ArrayList;
import java.util.Scanner;

class Destination {
    private String name;
    private String description;

    public Destination(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

class Trip {
    private String name;
    private ArrayList<Destination> destinations;
    private String startDate;
    private String endDate;

    public Trip(String name, String startDate, String endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.destinations = new ArrayList<>();
    }

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public void displayItinerary() {
        System.out.println("Your Trip: " + name);
        System.out.println("Dates: " + startDate + " to " + endDate);
        System.out.println("Destinations:");
        for (Destination destination : destinations) {
            System.out.println("- " + destination.getName() + ": " + destination.getDescription());
        }
    }
}

public class TravelItineraryPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Travel Itinerary Planner");

        System.out.print("Enter a name for your trip: ");
        String tripName = scanner.nextLine();

        System.out.print("Enter the Date of Start of your trip: (MM/DD/YYYY):\n ");
        String startDate = scanner.nextLine();

        System.out.print("Enter the Date of end of your trip: (MM/DD/YYYY): \n");
        String endDate = scanner.nextLine();

        Trip trip = new Trip(tripName, startDate, endDate);

        System.out.println(" Add some destinations to your trip.");
        boolean addMoreDestinations = true;
        while (addMoreDestinations) {
            System.out.print("Enter the name of the destination: \n");
            String destName = scanner.nextLine();

            System.out.print("Briefly describe the destination: \n");
            String destDescription = scanner.nextLine();

            Destination destination = new Destination(destName, destDescription);
            trip.addDestination(destination);

            System.out.print("Would you like to add another destination? (yes/no):\n ");
            String response = scanner.nextLine();
            addMoreDestinations = response.equalsIgnoreCase("yes");
        }

        System.out.println("\nHere's your trip itinerary:");
        trip.displayItinerary();

        scanner.close();
    }
}
