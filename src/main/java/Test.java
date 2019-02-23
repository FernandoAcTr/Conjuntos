import java.util.Scanner;

public class Test {
    public static void main(String [] args){
        Scanner teclado = new Scanner(System.in);
        Conjunto<Integer> conjuntoA = new Conjunto<Integer>();


        Conjunto<Integer> conjuntoB = new Conjunto<Integer>();
        conjuntoB.addElement(4);
        conjuntoB.addElement(6);

        Conjunto<Integer> conjuntoU = new Conjunto();
        conjuntoU.addElement(4);
        conjuntoU.addElement(5);
        conjuntoU.addElement(6);
        conjuntoU.addElement(7);

        Operaciones op = new Operaciones();
        op.setUniverse(conjuntoU);
        op.setConjuntoA(conjuntoA);
        op.setConjuntoB(conjuntoB);
        Conjunto inter = op.intersection();
        System.out.println(inter.toString());
    }
}
