import java.util.LinkedList;
import java.util.Scanner;

/**
 * This class solves the Ferry Loading II problem
 * using a Brute Force Algorithm
 * @author Simón Marín Giraldo
 * Part of the solution was discussed with David Calle
 */
class BruteRiver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); //Creating the scanner
        LinkedList<Integer> cars = new LinkedList<>(); //Creating a list for saving the cars in arrival order
        int c = Integer.parseInt(scan.nextLine()); //Reading the first line containing the number of test cases
        String test = ""; //Initialising a String for saving the inputs
        String[] values = new String[3]; //Declaring an array for saving initial test values
        int arrival = 0; //Initialising a variable for saving each car arrival
        int index = 0; //Initialising a variable for the index in the solution function
        int waiting = 1; //Initialising a variable for waiting cars. Initialised in 1 because we start with at least one car waiting
        int arrivalTime = 0; //Initialising a variable for saving the current arrival time. It will change and will be returned at the end
        int trips = 0; //Initialising a variable for saving the current number of trips. It will change and will be returned at the end
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
                cars.addLast(arrival);
            }
            System.out.println(formatting(solution(n, t, m, cars, index, waiting, arrivalTime, trips))); //Printing the solution for a test case
            cars.clear(); //Clearing the cars list to give place to a new test case
        }
    }

    public static double solution(int n, int t, int m, LinkedList<Integer> cars, int index, int waiting, int arrivalTime, int trips) {
        double sol1 = 0; //Initialising an auxiliar variable for the recursion
        double sol2 = 0; //Initialising an auxiliar variable for the recursion
        if (index < (m-1)) { //While index is lower than number of cars minus one, following instructions will be done
            sol1 = solution(n, t, m, cars, index + 1, 1 + waiting - (Math.min(waiting, n)),
                    (Math.max(arrivalTime, cars.get(index))) + (t * 2), trips + 1);
            sol2 = solution(n, t, m, cars, index + 1, waiting + 1, arrivalTime, trips);
            return Math.min(sol1, sol2);
        } else { //If the case in the beginning conditional doesn't happen, following instructions will be done
            if (waiting == 0) { //(Base case) if we don't have any more waiting cars, we return
                return Double.parseDouble((arrivalTime - t) + "." + trips);
            } else { //If the previous doesn't happen, we do recursive calls until that condition happens
                return solution(n, t, m, cars, index, waiting - (Math.min(waiting, n)),
                        (Math.max(arrivalTime, cars.get(index))) + (t * 2), trips + 1);
            }
        }
    }

    public static String formatting(double result) { //This function gives the solution output a proper format for the judge
        String input = result + ""; //Parsing the result returned by the solution into a String value
        return input.replace(".", " "); //Replacing the decimal point for a space which gives us the needed format
    }
}