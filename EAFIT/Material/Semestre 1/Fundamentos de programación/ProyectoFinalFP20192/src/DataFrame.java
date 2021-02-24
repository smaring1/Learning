import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esta clase contiene la informacion
 * a procesar por el programa
 */
public class DataFrame {
    ArrayList<Dato> coleccion = new ArrayList<>();
    ArrayList<Dato> hombres = new ArrayList<>();
    ArrayList<Dato> mujeres = new ArrayList<>();
    ArrayList<Dato> infarto = new ArrayList<>();
    ArrayList<Dato> noInfarto = new ArrayList<>();
    ArrayList<Dato> infartoHombres = new ArrayList<>();
    ArrayList<Dato> noInfartoHombres = new ArrayList<>();
    ArrayList<Dato> infartoMujeres = new ArrayList<>();
    ArrayList<Dato> noInfartoMujeres = new ArrayList<>();

    /**
     * Este metodo lee los datos contenidos
     * en el archivo que se pasa, se les da
     * el formato de tabla y se agregan
     * a un ArrayList para procesarlos.
     * @throws FileNotFoundException
     */
    public void leer_archivo() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("registro.txt");

        File file = new File("datos1.txt");
        Scanner scan = new Scanner(file);
        System.out.println("Documento\tNombre\t Apellido  Gén. Edad  Peso Estatura RitmoCPresionSPresD Inf Azuc");
        writer.println("Documento\tNombre\t Apellido  Gén. Edad  Peso Estatura RitmoCPresionSPresD Inf Azuc");
        scan.nextLine();
        String [] str = new String[12];
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String [] test = line.split(",");
            for (int i = 0; i < str.length; i++) {
                if (i >= test.length) {
                    str[i] = "";
                } else {
                    str[i] = test[i];
                }
            }

            for (int i = 0; i < str.length; i++) {
                str[i] = str[i].replace("\"", "");
                if (str[i].equals("")) {
                    str[i] = "0.0";
                }
            }
            coleccion.add(new Dato(Integer.parseInt(str[0]), str[1], str[2],
                    str[3], Integer.parseInt(str[4]), Integer.parseInt(str[5]),
                    Integer.parseInt(str[6]), Integer.parseInt(str[7]),
                    Integer.parseInt(str[8]), Integer.parseInt(str[9]),
                    str[10], Integer.parseInt(str[11])));

            if (str[3].equals("m") && str[10].equals("s")) { //mujeres que tuvieron infartos
                infartoMujeres.add(new Dato(Integer.parseInt(str[0]), str[1], str[2],
                        str[3], Integer.parseInt(str[4]), Integer.parseInt(str[5]),
                        Integer.parseInt(str[6]), Integer.parseInt(str[7]),
                        Integer.parseInt(str[8]), Integer.parseInt(str[9]),
                        str[10], Integer.parseInt(str[11])));
            }

            if (str[3].equals("m") && str[10].equals("n")) {
                noInfartoMujeres.add(new Dato(Integer.parseInt(str[0]), str[1], str[2],
                        str[3], Integer.parseInt(str[4]), Integer.parseInt(str[5]),
                        Integer.parseInt(str[6]), Integer.parseInt(str[7]),
                        Integer.parseInt(str[8]), Integer.parseInt(str[9]),
                        str[10], Integer.parseInt(str[11])));
            }

            if (str[3].equals("h") && str[10].equals("n")) { //hombres que no tuvieron infarto
                noInfartoHombres.add(new Dato(Integer.parseInt(str[0]), str[1], str[2],
                        str[3], Integer.parseInt(str[4]), Integer.parseInt(str[5]),
                        Integer.parseInt(str[6]), Integer.parseInt(str[7]),
                        Integer.parseInt(str[8]), Integer.parseInt(str[9]),
                        str[10], Integer.parseInt(str[11])));
            }

            if (str[3].equals("h") && str[10].equals("s")) { //hombres que tuvieron infartos
                infartoHombres.add(new Dato(Integer.parseInt(str[0]), str[1], str[2],
                        str[3], Integer.parseInt(str[4]), Integer.parseInt(str[5]),
                        Integer.parseInt(str[6]), Integer.parseInt(str[7]),
                        Integer.parseInt(str[8]), Integer.parseInt(str[9]),
                        str[10], Integer.parseInt(str[11])));
            }

            if (str[3].equals("h")) { //filtro hombres
                hombres.add(new Dato(Integer.parseInt(str[0]), str[1], str[2],
                        str[3], Integer.parseInt(str[4]), Integer.parseInt(str[5]),
                        Integer.parseInt(str[6]), Integer.parseInt(str[7]),
                        Integer.parseInt(str[8]), Integer.parseInt(str[9]),
                        str[10], Integer.parseInt(str[11])));
            }

            if (str[3].equals("m")) { //filtro mujeres
                mujeres.add(new Dato(Integer.parseInt(str[0]), str[1], str[2],
                        str[3], Integer.parseInt(str[4]), Integer.parseInt(str[5]),
                        Integer.parseInt(str[6]), Integer.parseInt(str[7]),
                        Integer.parseInt(str[8]), Integer.parseInt(str[9]),
                        str[10], Integer.parseInt(str[11])));
            }

            if (str[10].equals("s")) { //filtro infarto
                infarto.add(new Dato(Integer.parseInt(str[0]), str[1], str[2],
                        str[3], Integer.parseInt(str[4]), Integer.parseInt(str[5]),
                        Integer.parseInt(str[6]), Integer.parseInt(str[7]),
                        Integer.parseInt(str[8]), Integer.parseInt(str[9]),
                        str[10], Integer.parseInt(str[11])));
            }

            if (str[10].equals("n")) { //filtro no infarto
                noInfarto.add(new Dato(Integer.parseInt(str[0]), str[1], str[2],
                        str[3], Integer.parseInt(str[4]), Integer.parseInt(str[5]),
                        Integer.parseInt(str[6]), Integer.parseInt(str[7]),
                        Integer.parseInt(str[8]), Integer.parseInt(str[9]),
                        str[10], Integer.parseInt(str[11])));
            }

            for (String s:
                 str) {
                System.out.print(s + "    ");
                writer.print(s + "    ");
            }
            System.out.println();
            writer.println();
        }
        System.out.println("El total de datos es de " + coleccion.size());
        writer.close();
    }
}
