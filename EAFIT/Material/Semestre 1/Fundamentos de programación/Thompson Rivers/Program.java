public class Program {
    public static void main(String[] args) {
        Shape figura = new Shape("Simon", 1, 2, 3, 4, 4);
        Shape figura2 = new Shape("Manuela", 1, 3, 5, 8, 2);
        System.out.println(figura.equals(figura2));
        System.out.println(figura.area());
        System.out.println(figura.perimeter());
        System.out.println(figura.toString());
        System.out.println(figura2.toString());
    }
}
