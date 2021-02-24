import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Esta clase contiene la ejecucion del programa,
 * la interaccion con el usuario y las funciones
 * para generar los reportes.
 */
public class Imprimir {
    public static void main(String[] args) {
        seleccionar();
        finalizar();
    }

    public static DataFrame mostrar = new DataFrame();

    /**
     * Este metodo permite seleccionar el reporte que
     * se desea obtener e invoca la funcion correspondiente
     * al reporte seleccionado
     */
    public static void seleccionar() {
        //TODO: crear interaccion con usuario
        try {
            mostrar.leer_archivo();
            Scanner teclado = new Scanner(System.in);
            System.out.println("Seleccione el reporte que desea generar");
            System.out.println("1. Promedio IMC");
            System.out.println("2. Promedio IMC por género y rango de edad");
            System.out.println("3. Parejas con presión diastólica menor a 80 por rango de edad");
            System.out.println("4. Presión sistólica promedio hombres con infarto vs hombres sin infarto");
            System.out.println("5. Presión sistólica promedio mujeres con infarto vs mujeres sin infarto");
            System.out.println("6. Promedio, mediana y desviación estándar de la presión sistólica para\n" +
                    "todas las mujeres de la muestra.");
            System.out.println("7. Promedio, mediana y desviación estándar de la presión sistólica para\n" +
                                        "todos los hombres de la muestra.");
            System.out.println("8. Matriz por género y rango de edad con ocurrencias de infarto.");
            System.out.println("9. Matriz por género y rango de edad con el valor de la mediana de la medida\n" +
                    "de glucosa en sangre por género y rango de edad.");
            System.out.println("10. Coefciente de correlación de Pearson entre el ritmo cardíaco en reposo y\n" +
                    "la presión sistólica para los hombres de la muestra.");
            System.out.println("11. Coeficiente de correlación de Pearson entre el ritmo cardíaco en reposo y\n" +
                    "la presión sitólica para los hombres de la muestra");
            System.out.println("12. Matriz por género y rango de edad con los coefcientes de correlación\n" +
                    "entre el ritmo cardíaco y la presión diastólica para todas las personas de\n" +
                    "la muestra.");
            int tamano = mostrar.coleccion.size();
            int opcion = 0;
            do {
                try {
                    opcion = Integer.parseInt(teclado.nextLine());
                    switch (opcion) {
                        case 1:
                            reporte1();
                            break;
                        case 2:
                            reporte2();
                            break;
                        case 3:
                            reporte3();
                            break;
                        case 4:
                            reporte4();
                            break;
                        case 5:
                            reporte5();
                            break;
                        case 6:
                            reporte6();
                            break;
                        case 7:
                            reporte7();
                            break;
                        case 8:
                            reporte8();
                            break;
                        case 9:
                            reporte9();
                            break;
                        case 10:
                            reporte10();
                            break;
                        case 11:
                            reporte11();
                            break;
                        case 12:
                            reporte12();
                            break;
                        default:
                            opcion = 0;
                            throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    System.err.println("El valor ingresado no es válido. Intente nuevamente.");
                }
            } while (opcion == 0);

            /*
            System.out.println("Se encontró esta cantidad de registros: ");
            for (int i = 0; i < mostrar.coleccion.size(); i++) {
                System.out.println(mostrar.coleccion.get(i).getValor(i));
            }
             */

        } catch (FileNotFoundException ex) {
            System.err.println("El archivo no fue encontrado: " + ex.toString());
        }
    }

    /**
     * Este metodo pregunta al usuario si desea
     * analizar mas datos o cerrar el programa.
     * Dependiendo de la seleccion, sera lo que se ejecute.
     */
    public static void finalizar() {
        Scanner consola = new Scanner(System.in);
        System.out.println("Desea usted");
        System.out.println("1. Realizar otro reporte");
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
                        System.out.println("El programa ha finalizado. \nHasta pronto.");
                        break;
                    default:
                        accion = 0;
                        throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.err.println("El valor ingresado no es valido. \nIntente nuevamente");
            }
        } while (accion == 0);
    }

    /**
     * Este metodo reporta el indice de masa
     * corporal promedio de los hombres
     * y el indice de masa corporal promedio
     * de las mujeres
     */
    public static void reporte1() {

        double cont = 0;
        for (int i = 0; i < mostrar.coleccion.size(); i++) {
            double imc = ((double) mostrar.coleccion.get(i).getValor(2)) / ((double) (mostrar.coleccion.get(i).getValor(3) / 100) * ((double) mostrar.coleccion.get(i).getValor(3) / 100));
            cont += imc;
        }
        System.out.println("El promedio de IMC del total es: " + cont / mostrar.coleccion.size());

        double contHombres = 0;
        for (int i = 0; i < mostrar.hombres.size(); i++) {
            double imc = ((double) mostrar.hombres.get(i).getValor(2)) / ((double) (mostrar.hombres.get(i).getValor(3) / 100) * ((double) mostrar.hombres.get(i).getValor(3) / 100));
            contHombres += imc;
        }
        System.out.println("El promedio de IMC de los hombres es: " + contHombres / mostrar.hombres.size());

        double contMujeres = 0;
        for (int i = 0; i < mostrar.mujeres.size(); i++) {
            double imc = ((double) mostrar.mujeres.get(i).getValor(2)) / ((double) (mostrar.mujeres.get(i).getValor(3) / 100) * ((double) mostrar.mujeres.get(i).getValor(3) / 100));
            contMujeres += imc;
        }
        System.out.println("El promedio de IMC de las mujeres es: " + contMujeres / mostrar.mujeres.size());
    }

    /**
     * Este metodo reporta el indice de masa
     * corporal promedio por genero y rango de edad
     */
    public static void reporte2() {
        //...
    }

    /**
     * Este metodo reporta las posibles parejas
     * formadas por una mujer y un hombre que esten
     * en el mismo rango de edad, ambos con una presion
     * diastolica menor a 80
     */
    public static void reporte3() {
        //...
    }

    /**
     * Este metodo reporta la presion sistolica promedio
     * de los hombres que han sufrido un infarto y la de
     * los hombres que no han sufrido un infarto
     */
    public static void reporte4() {
        double cont = 0;

        for (int i = 0; i < mostrar.infartoHombres.size(); i++) {
            if (mostrar.infartoHombres.get(i).getValor(5) != 0) {
                cont += mostrar.infartoHombres.get(i).getValor(5);
            }
        }
        System.out.println("Promedio de presion sistolica para los hombres \n" +
                "que han sufrido de infartos es de: " + cont / mostrar.infartoHombres.size());

        double cont2 = 0;

        for (int i = 0; i < mostrar.noInfartoHombres.size(); i++) {
            if (mostrar.noInfartoHombres.get(i).getValor(5) != 0) {
                cont2 += mostrar.noInfartoHombres.get(i).getValor(5);
            }
        }
        System.out.println("\nPromedio de presion sistolica para los hombres \n" +
                "Que no han sufrido de infartos es de: " + cont2 / mostrar.noInfartoHombres.size());
    }

    /**
     * Este metodo reporta la presion sistolica promedio
     * de las mujeres que han sufrido un infarto y la de
     * las mujeres que no han sufrido un infarto
     */
    public static void reporte5() {
        double cont = 0;

        for (int i = 0; i < mostrar.infartoMujeres.size(); i++) {
            if (mostrar.infartoMujeres.get(i).getValor(5) != 0) {
                cont += mostrar.infartoMujeres.get(i).getValor(5);
            }
        }
        System.out.println("El promedio de la presion sistolica de las mujeres \n" +
                "que han sufrido infartos es de: " + cont / mostrar.infartoMujeres.size());

        double cont2 = 0;

        for (int i = 0; i < mostrar.noInfartoMujeres.size(); i++) {
            if (mostrar.noInfartoMujeres.get(i).getValor(5) != 0) {
                cont2 += mostrar.noInfartoMujeres.get(i).getValor(5);
            }
        }
        System.out.println("El promedio de la presion sistolica de las mujeres \n" +
                "que no han sufrido de infartos es de: " + cont2 / mostrar.noInfartoMujeres.size());
    }

    /**
     * Este metodo reporta el promedio y mediana de
     * la presion sistolica para todas las mujeres
     * de la muestra
     */
    public static void reporte6() {
        //...
    }

    /**
     * Este metodo reporta el promedio y mediana de
     * la presion sistolica para todos los hombres
     * de la muestra
     */
    public static void reporte7() {
        double cont = 0;
        for (int i = 0; i < mostrar.hombres.size(); i++) {
            if (mostrar.hombres.get(i).getValor(5) != 0) {
                cont += mostrar.hombres.get(i).getValor(5);
            }
        }
        System.out.println("El promedio de presion sistolica para todos los hombres \n" +
                "de la muestra es de: " + cont / mostrar.hombres.size());
    }

    /**
     * Este metodo reporta la matriz por genero y
     * rango de edad con ocurrencias de infarto
     */
    public static void reporte8() {
        //...
    }

    /**
     * Este metodo reporta la matriz por genero
     * y rango de edad con el valor de la mediana
     * de la medida de glucosa en la sangre por genero
     * y rango de edad
     */
    public static void reporte9() {
        //...
    }

    /**
     * Este metodo reporta el coeficiente de correlacion
     * de Pearson entre el ritmo cardiaco en reposo y la
     * presion sistolica para los hombres de la muestra
     */
    public static void reporte10() {
        //...
    }

    /**
     * Este metodo reporta el coeficiente de correlacion
     * de Pearson entre el ritmo cardiaco en reposo y la
     * presion sistolica para las mujeres de la muestra
     */
    public static void reporte11() {
        //...
    }

    /**
     * Este metodo reporta la matriz por genero y rango
     * de edad con los coeficientes de correlacion entre
     * el ritmo cardiaco y la presion diastolica para todas
     * las personas de la muestra
     */
    public static void reporte12() {
        //...
    }

    /*
    public ArrayList<Dato> de10a20(ArrayList<Dato> lista) {

    }

    public ArrayList<Dato> de21a30(ArrayList<Dato> lista) {
        //...
    }

    public ArrayList<Dato> de31a40(ArrayList<Dato> lista) {
        //...
    }

    public ArrayList<Dato> de41a50(ArrayList<Dato> lista) {
        //...
    }

    public ArrayList<Dato> de51a60(ArrayList<Dato> lista) {
        //...
    }

    public ArrayList<Dato> de61a70(ArrayList<Dato> lista) {
        //...
    }

    public ArrayList<Dato> de71a80(ArrayList<Dato> lista) {
        //...
    }

    public ArrayList<Dato> de81a90(ArrayList<Dato> lista) {

    }

    public ArrayList<Dato> mayorA90(ArrayList<Dato> lista) {
        //...
    }

     */
}
