import java.util.Scanner;

public class DNASequenceChecker {
    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner scan = new Scanner(System.in); //Creando y comentando el scanner como a don señor le gusta
        System.out.print("Enter sequence 1: ");
        String s1 = scan.nextLine(); //Creando la primera entrada y guardándola en una variable
        System.out.print("Enter sequence 2: ");
        String s2 = scan.nextLine(); //Creando la segunda entrada y guardándola en una variable
        s1 = s1.toUpperCase(); //Pasando la primera secuencia a mayúsculas
        s2 = s2.toUpperCase(); //Pasando la segunda secuencia a mayúsculas
        if (s1.length() < 8) { //Me dio pereza seguir comentando
            System.out.println("Sequence must be longer");
        } else if (s1.length() != s2.length()) {
            System.out.println("Sequences must be the same length");
        } else {
            System.out.println("DNA Sequence length: " + s1.length());
            compare(s1, s2);
        }

        System.out.println("The weight of the first sequence is " + weight(s1));
        System.out.println("The weight of the second sequence is " + weight(s2));
    }

    public static void compare(String s1, String s2) {
        int cont = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) cont++;
        }
        if (cont == 0) {
            System.out.println("There are no differences, sequences are a match.");
        } else {
            System.out.println("There are " + cont + " differences between the sequences.");
        }
    }

    public static int weight(String s) {
        int cont = 0;
        int a = 1;
        int g = 2;
        int c = 3;
        int t = 4;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') cont += a;
            if (s.charAt(i) == 'G') cont += g;
            if (s.charAt(i) == 'C') cont += c;
            if (s.charAt(i) == 'T') cont += t;
        }
        return cont;
    }
}
