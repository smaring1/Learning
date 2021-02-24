import java.io.FileNotFoundException;
import java.util.Scanner;
/**

 *
 * @author Simon Marin Giraldo
 * @version May 2019.
 *
 * This class interacts with the user.
 * It prints data and does the operations
 * requested by the user.
 */
public class Imprimir {

    public static void main(String[] args) {
        System.out.println("Bienvenido");
        seleccionar();
        finalizar();
    }

    public static MarcoDeDato mostrar = new MarcoDeDato();

    /**
     * This method asks the user to select the
     * options for the data analysis.
     */
    public static void seleccionar() {
        try {
            mostrar.leer_archivo();
            Scanner teclado = new Scanner(System.in);
            System.out.println("Seleccione el dato que desea analizar");
            System.out.println("1. PRCP");
            System.out.println("2. TAVG ");
            System.out.println("3. TMAX");
            System.out.println("4. TMIN");
            int b = mostrar.coleccion.size();
            int a = 0;
            String d = "";
            do {
                try {
                    a = Integer.parseInt(teclado.nextLine());
                    switch (a) {
                        case 1:
                            d = "PRCP";
                            break;
                        case 2:
                            d = "TAVG";
                            break;
                        case 3:
                            d = "TMAX";
                            break;
                        case 4:
                            d = "TMIN";
                            break;
                        default:
                            a = 0;
                            throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("El valor ingresado no es valido. \nIntente nuevamente.");
                }
            } while (a == 0);


            System.out.println("Los datos " +d+ " son: ");
            for (int i = 0; i < mostrar.coleccion.size(); i++) {
                System.out.println(mostrar.coleccion.get(i).getValor(a));
            }
            System.out.println("Estos son los " + b + " datos de "+d+" en el archivo");
            System.out.println("Que operacion desea realizar?");
            System.out.println("1. Estadistica");
            System.out.println("2. Filtro");
            int op = 0;
            do {
                try {
                    op = Integer.parseInt(teclado.nextLine());
                    switch (op) {
                        case 1:
                            estadistica(a);
                            break;
                        case 2:
                            filtro(a);
                            break;
                        default:
                            op = 0;
                            throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    System.out.println("El valor ingresado no es valido. \nIntente nuevamente.");
                }
            } while (op == 0);


        } catch (FileNotFoundException ex) {
            System.err.println("El archivo no fue encontrado: " + ex.toString());
        }
    }

    /**
     * This method does the statistic operations
     * requested by the user.
     * @param a
     */
    public static void estadistica(int a) {
        Scanner consola = new Scanner(System.in);
        System.out.println("Que operacion desea realizar?");
        System.out.println("1. Promedio");
        System.out.println("2. Maximo");
        System.out.println("3. Minimo");
        int b = 0;

        do {
            try {
                b = Integer.parseInt(consola.nextLine());
                switch (b) {
                    case 1 :
                        double cont = 0;
                        for (int i = 0; i < mostrar.coleccion.size(); i++) {
                            if (mostrar.coleccion.get(i).getValor(a) != 0) {
                                cont += mostrar.coleccion.get(i).getValor(a);
                            }
                        }
                        System.out.println("El promedio es: " + cont/mostrar.coleccion.size());
                        break;
                    case 2:
                        double mayor = 0;
                        for (int i = 0; i < mostrar.coleccion.size(); i++) {
                            if (mostrar.coleccion.get(i).getValor(a) > mayor) {
                                mayor = mostrar.coleccion.get(i).getValor(a);
                            }
                        }
                        System.out.println("El valor mayor es: " + mayor);
                        break;
                    case 3:
                        double menor = mostrar.coleccion.get(0).getValor(a);
                        for (int i = 0; i < mostrar.coleccion.size(); i++) {
                            if (mostrar.coleccion.get(i).getValor(a) < menor && mostrar.coleccion.get(i).getValor(a) != 0.0) {
                                menor = mostrar.coleccion.get(i).getValor(a);
                            }
                        }
                        System.out.println("El valor menor es: " + menor);
                        break;
                    default:
                        b = 0;
                        throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {

                System.out.println("El valor ingresado no es valido. \nIntente nuevamente.");
            }
        } while (b == 0);


    }

    /**
     * This method filters the data with
     * the parameters selected by the users.
     * @param a
     */
    public static void filtro(int a) {
        Scanner consola = new Scanner(System.in);
        System.out.println("Que valor va a usar como referencia?");
        double valor = 0;
        do {
            try {
                valor = Double.parseDouble(consola.nextLine());
                if (valor % 1 != 0) {
                    valor = 0;
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("El valor ingresado no es valido. \nIntente nuevamente.");
            }
        } while (valor == 0);

        Scanner teclado = new Scanner(System.in);
        System.out.println("Que filtros desea aplicar?");
        System.out.println("1. Mayor que");
        System.out.println("2. Menor que");
        System.out.println("3. Mayor o igual que");
        System.out.println("4. Menor o igual que");
        System.out.println("5. Igual que");
        int filter = 0;

        do {
            try {
                filter = Integer.parseInt(teclado.nextLine());
                switch (filter) {
                    case 1:
                        int cont = 0;
                        for (int i = 0; i < mostrar.coleccion.size(); i++) {
                            if (mostrar.coleccion.get(i).getValor(a) > valor) {
                                cont++;
                                System.out.println(mostrar.coleccion.get(i).getValor(a));
                            }
                        }
                        System.out.println("Se encontraron " + cont + " valores mayores a " + valor);
                        break;
                    case 2:
                        int cont2 = 0;
                        for (int i = 0; i < mostrar.coleccion.size(); i++) {
                            if (mostrar.coleccion.get(i).getValor(a) < valor && mostrar.coleccion.get(i).getValor(a) != 0.0) {
                                cont2++;
                                System.out.println(mostrar.coleccion.get(i).getValor(a));
                            }
                        }
                        System.out.println("Se encontraron " + cont2 + " valores menores a " + valor);
                        break;
                    case 3:
                        int cont3 = 0;
                        for (int i = 0; i < mostrar.coleccion.size(); i++) {
                            if (mostrar.coleccion.get(i).getValor(a) >= valor) {
                                cont3++;
                                System.out.println(mostrar.coleccion.get(i).getValor(a));
                            }
                        }
                        System.out.println("Se encontraron " + cont3 + " valores mayores o iguales a " + valor);
                        break;
                    case 4:
                        int cont4 = 0;
                        for (int i = 0; i < mostrar.coleccion.size(); i++) {
                            if (mostrar.coleccion.get(i).getValor(a) <= valor && mostrar.coleccion.get(i).getValor(a) != 0.0) {
                                cont4++;
                                System.out.println(mostrar.coleccion.get(i).getValor(a));
                            }
                        }
                        System.out.println("Se encontraron " + cont4 + " valores menores o iguales a " + valor);
                        break;
                    case 5:
                        int cont5 = 0;
                        for (int i = 0; i < mostrar.coleccion.size(); i++) {
                            if (mostrar.coleccion.get(i).getValor(a) == valor) {
                                cont5++;
                                System.out.println(mostrar.coleccion.get(i).getValor(a));
                            }
                        }
                        System.out.println("Se encontraron " + cont5 + " valores iguales a " + valor);
                        break;
                    default:
                        filter = 0;
                        throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("El valor ingresado no es valido. \nIntente nuevamente.");
            }
        } while (filter == 0);
    }

    /**
     * This method runs after analyzing and it
     * asks the user if another file has to be
     * analyzed or to finish the program.
     */
    public static void finalizar() {
        Scanner consola = new Scanner(System.in);
        System.out.println("Desea usted");
        System.out.println("1. Analizar mas datos");
        System.out.println("2. Finalizar el programa");
        int accion = 0;

        do {
            try {
                accion = Integer.parseInt(consola.nextLine());
                switch (accion) {
                    case 1:
                        seleccionar();
                        finalizar();
                        break;
                    case 2:
                        System.out.println("El programa ha finalizado.");
                        System.out.println("Hasta pronto.");
                        break;
                    default:
                        accion = 0;
                        throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("El valor ingresado no es valido. \nIntente nuevamente.");
            }
        } while (accion == 0);
    }
}
