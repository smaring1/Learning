import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class will contain the information
 * to be processed by the program.
 */
public class MarcoDeDato {
    ArrayList<Dato> coleccion = new ArrayList<>();

    /**
     * This method reads the file selected
     * by the user, fills the blank spaces with zeros
     * and logs the data in a new file named "Log.txt"
     *
     * @throws FileNotFoundException
     */
    public void leer_archivo() throws FileNotFoundException {
        Scanner teclado = new Scanner(System.in);
        PrintWriter writer = new PrintWriter("Log.txt");
        System.out.println("Que ciudad desea analizar?");
        System.out.println("1. Barranquilla");
        System.out.println("2. Cartagena");
        System.out.println("3. Cucuta");
        System.out.println("4. Medellin");
        System.out.println("5. Miami");
        System.out.println("6. Paris");
        System.out.println("7. Tokio");
        int a = 0;
        String d = "";
        do {
            try {
                a = Integer.parseInt(teclado.nextLine());
                switch (a) {
                    case 1:
                        d = "Barranquilla.csv";
                        break;
                    case 2:
                        d = "Cartagena.csv";
                        break;
                    case 3:
                        d = "Cucuta.csv";
                        break;
                    case 4:
                        d = "Medellin.csv";
                        break;
                    case 5:
                        d = "Miami.csv";
                        break;
                    case 6:
                        d = "Paris.csv";
                        break;
                    case 7:
                        d = "Tokyo.csv";
                        break;
                    default:
                        a = 0;
                        throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("El valor ingresado no es valido. \nIntente nuevamente.");
            }
        } while(a == 0);

        File file = new File(d);
        Scanner scan = new Scanner(file);
        System.out.println("Station\t\t\tName\t\t        Date     PRCP TAVG  TMAX TMIN");
        writer.println("Station\t         Name\t            Date     PRCP TAVG  TMAX TMIN");
        scan.nextLine();
        String[] str = new String[8];
        while (scan.hasNextLine()) {
            String line = scan.nextLine(); //
            String[] test = line.split(",");
            for (int j = 0; j < str.length; j++) {
                if (j >= test.length) {
                    str[j] = "";
                } else {
                    str[j] = test[j];
                }
            }
            for (int j = 0; j < str.length; j++) {
                str[j] = str[j].replace("\"", "");
                if (str[j].equals("")) {
                    str[j] = "0.0";
                }
            }
            coleccion.add(new Dato(str[0], str[1] + str[2], str[3], Double.parseDouble(str[4]), Double.parseDouble(str[5]), Double.parseDouble(str[6]), Double.parseDouble(str[7])));
            for (String s : str) {
                System.out.print(s + "  ");
                writer.print(s + "  ");
            }
            System.out.println();
            writer.println();
        }
        System.out.println("El total de datos es de: " + coleccion.size());
        writer.close();
    }
}