import java.io.*;

public class Planets {
    public static void main(String[] args) throws IOException {
        PrintWriter writer = new PrintWriter("PlanetSummary.txt");
        String [] planet = {"Mercury", "Venus", "Earth", "Mars",
        "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"};

        int [] diamKM = {4878, 12104, 12760, 6787, 139822,
                120500, 51120, 49530, 2301};

        double [] orbitYR = {0.241, 0.616, 1.0, 1.88, 11.9,
        29.5, 84.0, 165.0, 248.0};

        int [] orbitDays = new int[orbitYR.length];

        for (int i = 0; i < orbitDays.length; i++) {
            orbitDays[i] = (int) orbitYR[i] * 365;
        }
        int minOrbit = minOrbit(orbitDays);
        int maxOrbit = maxOrbit(orbitDays);
        String nameMinOrbit = planet[indexMin(orbitDays)];
        String nameMaxOrbit = planet[indexMax(orbitDays)];
        System.out.println("Planet\tDiam(1000kms)\tOrbit(days)");
        for (int i = 0; i < planet.length; i++) {
            System.out.println(planet[i] + "\t" + decimalRound(diamKM[i] / 1000.0, 2) + "\t\t\t" + orbitDays[i]);
            writer.println(planet[i] + "\t" + decimalRound(diamKM[i] / 1000.0, 2) + "\t\t\t" + orbitDays[i]);
        }
        writer.close();
    }

    public static int minOrbit(int [] numbers) {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }

    public static int maxOrbit(int [] numbers) {
        int max = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public static int indexMin(int [] numbers) {
        int min = numbers[0];
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (min > numbers[i]) {
                min = numbers[i];
                index = i;
            }
        }
        return index;
    }

    public static int indexMax(int [] numbers) {
        int max = numbers[0];
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (max < numbers[i]) {
                max = numbers[i];
                index = i;
            }
        }
        return index;
    }

    public static double decimalRound(double number, int digits) {
        double integerPart, result;
        result = number;
        integerPart = Math.floor(result);
        result = (result-integerPart) * Math.pow(10, digits);
        result = Math.round(result);
        result = (result / Math.pow(10, digits)) + integerPart;
        return result;
    }
}
