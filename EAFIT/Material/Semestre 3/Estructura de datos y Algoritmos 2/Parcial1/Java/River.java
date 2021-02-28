import java.util.Scanner;

/**
 * This class solves the Ferry Loading II problem
 * using a Greedy Algorithm.
 * @author Simón Marín Giraldo
 * Part of he solution was discussed with
 * Julián Ramírez, Jesús Zapata and David Calle
 */
class River {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); //Creating the scanner
        int cars [] = new int[1440]; //Creating an array which size will be maximum the limit of the problem
        int c = Integer.parseInt(scan.nextLine()); //Reading the first line containing the number of test cases
        String test = ""; //Initialising a String for saving the inputs
        String values [] = new String[3]; //Declaring an array for saving initial test values
        int arrival = 0; //Initialising a variable for saving each car arrival
        int n = 0; //Initialising a variable for saving the ferry capacity
        int t = 0; //Initialising a variable for saving the time that the ferry takes to go from one side to another
        int m = 0; //Initialising a variable for the cars to be transported
        for (int i = 0; i < c; i++) { //A loop for doing the number of test cases given in the first input line
            test = scan.nextLine(); //Reads the test lines containing info about the ferry load, the travel time and cars to be moved
            if (test.length() >= 5) { //Just to make sure: this line checks if the line being read is the initial line of a test
                values = test.split(" "); //Array receiving elements in the test declaration separated with a space
            }
            n = Integer.parseInt(values[0]); //Parsing n input n to integer
            t = Integer.parseInt(values[1]); //Parsing t input to integer
            m = Integer.parseInt(values[2]); //Parsing m input to integer
            for (int j = 0; j < m; j++) { //Loop for putting cars in a queue ordered depending on the arrival to terminal
                arrival = Integer.parseInt(scan.nextLine()); //Reading and parsing each car inputed
                cars[j] = arrival; //Saving cars arriving in a queue
            }
            System.out.println(solution(n, t, m, cars)); //Printing the solution for a test case
            for (int j = 0; j < cars.length; j++) { //Loop for clearing the cars list (I can't clear with zero because it is a possible problem value
                cars[i] = -1;
            }
        }
    }

    public static String solution(int n, int t, int m, int [] cars) {
        String sol = "";
        int minTrips = m/n; //It is the minimum quantity of trips you will do
        if (m % n != 0) { //I ceil because if my minimum trip quantity is non integer, I can't do decimal trips. I add one.
            minTrips++;
        }
        int totalTime = 0; //Initialising the total time that will be taken to do all the trips
        int totalTrips = minTrips; //The optimal quantity of trips will be the same as the minimum trips and we try to force to do that quantity of trips
        int index = -1;
        int aux = 0;
        int firstTrip = 0;
        for (int i = 0; i < minTrips; i++) { //Loop for going through the car list with the minimum of trips possible
            //Basic cases:
            if (cars.length == 0) { //Case 1
                totalTime = 0;
                totalTrips = 0;
            } else if (cars.length == 1) { //Case 2
                totalTime = cars[0] + t;
                //General solution
            } else if (m % n == 0) { //If the ferry capacity divides the number of cars
                index += n; //We add the capacity each time to the index
                aux = cars[index]; //We assign the car in the index position to aux variable
                if (totalTime > aux) { //While total time is higher than our time representing aux variable
                    totalTime += (2 * t); //We will add one round trip to total time
                } else { //If the previous condition doesn't happen anymore
                    totalTime = aux + (2 * t); //We add round trips and the time corresponding to aux
                }
            } else { //If the ferry capacity doesn't divide the number of cars
                firstTrip = m % n; //I get the modulus between the number of cars and the capacity. I do this for determining the first trip
                aux = cars[firstTrip-1]; //I assign the car time in the modulus position to aux variable
                index = firstTrip-1; //I keep the index as the modulus minus one
                totalTime = aux + (2 * t); //I get the car time in modulus minus one position and add a round trip to the counter
                m -= (m % n); //I substract the initial modulus from the number of cars in every iteration
            }
        }
        sol = totalTime-t + " " + totalTrips; //Concatenation of the total time and total trips to give the format of the output
        return sol; //Returns the final solution
    }
}