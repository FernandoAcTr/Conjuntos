import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    Scanner teclado;
    ListaConjuntos lista = new ListaConjuntos();

    public Main() {
        teclado = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("-------------Menu de Opciones------------");
        System.out.println("1...Definir Conjunto Universo (U)");
        System.out.println("2...Crear un Conjuto");        
        System.out.println("3...Mostrar Conjunto");
        System.out.println("4...Operaciones");
        System.out.println("0...Salir");
    }

    public int selectOpcion() {
        int opcion;
        do {
            System.out.print("Opcion: ");
            opcion = teclado.nextInt();
        } while (opcion > 4 || opcion < 0);
        return opcion;
    }

    public void ejecutaAccion(int opcion) {
        String v_nombre;
        int v_numElementos;
        if (opcion == 1) {
            Conjunto conjuntoU = new Conjunto("U");
            System.out.println("¿Cuantos elementos contiene?");
            v_numElementos = teclado.nextInt();
            teclado.nextLine(); //limpiar el buffer                  
            for (int i = 0; i < v_numElementos; i++) {
                System.out.print("Elemento #" + (i + 1) + ": ");
                conjuntoU.agregarElemto(teclado.next());
            }
            lista.setConjuntoU(conjuntoU);
        } else if (opcion == 2) {
            System.out.println("");
            teclado.nextLine();
            System.out.print("Nombre del conjunto: ");
            v_nombre = teclado.nextLine();
            Conjunto v_conjunto = new Conjunto(v_nombre);
            System.out.println("¿Cuantos elementos contiene?");
            v_numElementos = teclado.nextInt();
            teclado.nextLine(); //limpiar el buffer                  
            for (int i = 0; i < v_numElementos; i++) {
                System.out.print("Elemento #" + (i + 1) + ": ");
                v_conjunto.agregarElemto(teclado.nextLine());
            }
            if (lista.compararConUniverso(v_conjunto)) 
                lista.agregarConjunto(v_conjunto);               
             else 
                System.out.println("\nImposible crear este conjunto. Contiene elementos no "
                        + "contenidos en el Conjunto Universo");
            
            System.out.println("");
            
            
        }else if (opcion == 3) {
            System.out.println("");
            int numConjunto; 
            
            listarConjuntos();
            System.out.print("Conjunto #: ");
            numConjunto = teclado.nextInt();
            
            System.out.println(); //salto de linea en pantalla
            
            if (numConjunto == 1) 
                if(lista.getConjuntoU() != null)
                     System.out.println(lista.getConjuntoU().toString());
                else
                    System.out.println("\nEl conjunto U aun no ha sido definido\n");
            else 
                System.out.println("\n"+lista.getConjunto(numConjunto - 2).toString());

            System.out.println("");
        }else if(opcion == 4){
            Conjunto conjNuevo = null;
            int operacion = elegirOperacion();
            teclado.nextLine();
                
                listarConjuntos();  
                if(operacion == 1 || operacion == 2 || operacion == 3){
                    
                    System.out.print("Conjunto #1: ");
                    int c1 = teclado.nextInt();
                    System.out.print("Conjunto #2: ");
                    int c2 = teclado.nextInt();
                    Conjunto conj1, conj2; 
                    if(c1 == 1)
                        conj1 = lista.getConjuntoU();
                    else
                        conj1 = lista.getConjunto(c1-2);
                    
                    if(c2 == 1)
                        conj2 = lista.getConjuntoU();
                    else
                        conj2 = lista.getConjunto(c2-2);                    
                    
                    switch(operacion){
                        case 1: 
                            conjNuevo = lista.unionConjuntos(conj1, conj2);
                        break;
                        case 2: 
                            conjNuevo = lista.interConjunto(conj1, conj2);
                        break;
                        case 3:
                            conjNuevo = lista.restaConjunto(conj1, conj2);                                             
                    }
                   lista.agregarConjunto(conjNuevo);                   
                    System.out.println("\n"+conjNuevo.toString()+"\n");                  
                }else if(operacion == 4){
                    System.out.println("Conjunto #: ");
                    int c1 = teclado.nextInt();
                    conjNuevo = lista.compleConjunto(lista.getConjunto(c1-2));
                    lista.agregarConjunto(conjNuevo);   
                    System.out.println(conjNuevo.toString());
                }
            
        }

    }
    
    private void listarConjuntos(){
        ArrayList<String> nombres = lista.getNombres();
        int i = 2, numConjunto;
        System.out.println("1...Conjunto Universo(U)");
            if (nombres != null) 
                for (String nombre : nombres) {
                    System.out.println(i + "..." + nombre);
                    i++;
                }       
    }
    
    private int elegirOperacion(){
        System.out.println("");        
        System.out.println("1...Unión");
        System.out.println("2...Intersección");
        System.out.println("3...Diferencia");
        System.out.println("4...Complemento");       
        System.out.print("Opcion: ");
        return teclado.nextInt();
    }

    public static void main(String[] args) {
        Main main = new Main();
        int opcion;
        do {
            main.mostrarMenu();
            opcion = main.selectOpcion();
            main.ejecutaAccion(opcion);
        } while (opcion != 0);
    }
}
