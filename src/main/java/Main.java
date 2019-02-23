import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    Conjunto conjuntoA, conjuntoB, conjuntoU;
    Scanner scanner = new Scanner(System.in);
    int opcionType;
    int opcionMenu;
    Operaciones operaciones;

    public Main() {
        operaciones = new Operaciones();
    }

    void showTypeMenu() {
        System.out.println("Ingresa el tipo de dato que serán los conjuntos");
        System.out.println("1........Caracter");
        System.out.println("2........Entero");
        System.out.println("3........Flotante");
        System.out.print("Opción: ");
    }

    void validateTypeOpcion() {
        opcionType = scanner.nextInt();
        while (opcionType < 1 || opcionType > 3) {
            System.out.println("\nSolo opciones del menu");
            System.out.print("Opción: ");
            opcionType = scanner.nextInt();
        }
    }

    void initData() {
        if (opcionType == 1) {
            if(conjuntoA == null) conjuntoA = new Conjunto<Character>();
            if(conjuntoB == null) conjuntoB = new Conjunto<Character>();
            if(conjuntoU == null)conjuntoU = new Conjunto<Character>();
        } else if (opcionType == 2) {
            if(conjuntoA == null)conjuntoA = new Conjunto<Integer>();
            if(conjuntoB == null)conjuntoB = new Conjunto<Integer>();
            if(conjuntoU == null)conjuntoU = new Conjunto<Integer>();
        } else {
            if(conjuntoA == null)conjuntoA = new Conjunto<Float>();
            if(conjuntoB == null)conjuntoB = new Conjunto<Float>();
            if(conjuntoU == null)conjuntoU = new Conjunto<Float>();
        }
    }

    void createGroupA() {
        System.out.print("\nNúmero de elementos: ");
        int numElements = scanner.nextInt();
        Object elemento;

        for (int i = 0; i < numElements; i++) {
            System.out.print("Elemento #" + (i + 1) + ": ");
            if (opcionType == 1) {
                elemento = scanner.next().charAt(0);
                //scanner.next();
            } else if (opcionType == 2) {
                elemento = scanner.nextInt();
            } else {
                elemento = scanner.nextFloat();
            }
            conjuntoA.addElement(elemento);
        }
    }

    void createGroupB() {
        System.out.print("\nNúmero de elementos: ");
        int numElements = scanner.nextInt();
        Object elemento;

        for (int i = 0; i < numElements; i++) {
            System.out.print("Elemento #" + (i + 1) + ": ");
            if (opcionType == 1) {
                elemento = scanner.next().charAt(0);
                //scanner.next();
            } else if (opcionType == 2) {
                elemento = scanner.nextInt();
            } else {
                elemento = scanner.nextFloat();
            }
            conjuntoB.addElement(elemento);
        }
    }

    void createUniverse() {
        System.out.print("\nNúmero de elementos: ");
        int numElements = scanner.nextInt();
        Object elemento;

        for (int i = 0; i < numElements; i++) {
            System.out.print("Elemento #" + (i + 1) + ": ");
            if (opcionType == 1) {
                elemento = scanner.next().charAt(0);
                //scanner.next();
            } else if (opcionType == 2) {
                elemento = scanner.nextInt();
            } else {
                elemento = scanner.nextFloat();
            }
            conjuntoU.addElement(elemento);
        }
    }

    void showMenu() {
        System.out.println("-----------------------Menu de opciones:--------------------------");
        System.out.println("1......Definir conjunto Universo");
        System.out.println("2......Crear conjunto A");
        System.out.println("3......Crear conjunto B");
        System.out.println("4......Union");
        System.out.println("5......Interseccion");
        System.out.println("0......Salir");
        System.out.println("-------------------------------------------------------------------");
        System.out.print("Opcion: ");
    }

    void validateMenuOpcion() {
        opcionMenu = scanner.nextInt();
        while (opcionMenu < 0 || opcionMenu > 5) {
            System.out.println("\nSolo opciones del menu");
            System.out.print("Opción: ");
            opcionMenu = scanner.nextInt();
        }
    }

    void execOption() {
        switch (opcionMenu) {
            case 1:
                conjuntoU = null;
                initData();
                createUniverse();
                operaciones.setUniverse(conjuntoU);
                break;
            case 2:
                if (conjuntoU.getSize() != 0) {
                    conjuntoA = null;
                    initData();
                    createGroupA();
                    operaciones.setConjuntoA(conjuntoA);
                    if (!operaciones.verifyUniverse(conjuntoA)) {
                        System.out.println("\nEl conjunto A no se guardó, tiene elementos diferentes del universo. Redefinalo\n");
                        operaciones.setConjuntoA(null);
                    }
                } else
                    System.out.println("Primero defina un Universo\n");
                break;
            case 3:
                if (conjuntoU.getSize() != 0) {
                    conjuntoB = null;
                    initData();
                    createGroupB();
                    operaciones.setConjuntoB(conjuntoB);
                    if (!operaciones.verifyUniverse(conjuntoB)) {
                        System.out.println("\nEl conjunto B no se guardó, tiene elementos diferentes del universo. Redefinalo\n");
                        operaciones.setConjuntoB(null);
                    }

                } else
                    System.out.println("Primero defina un Universo\n");
                break;
            case 4:
                if (conjuntoU.getSize() != 0)
                    if (operaciones.getConjuntoA() != null)
                        if (operaciones.getConjuntoB() != null) {
                            Conjunto conjunto = operaciones.union();
                            System.out.println("Conjunto Solucion: ");
                            System.out.println(conjunto.toString());
                        } else
                            System.out.println("\nNo existe un conjunto B");
                    else
                        System.out.println("\nNo existe un conjunto A");
                else
                    System.out.println("\nNo existe un conjunto Universo");

                break;
            case 5:

                if (conjuntoU.getSize() != 0)
                    if (operaciones.getConjuntoA() != null)
                        if (operaciones.getConjuntoB() != null) {
                            Conjunto conjunto = operaciones.intersection();
                            System.out.println("Conjunto Solucion: ");
                            System.out.println(conjunto.toString());
                        } else
                            System.out.println("\nNo existe un conjunto B");
                    else
                        System.out.println("\nNo existe un conjunto A");
                else
                    System.out.println("\nNo existe un conjunto Universo");

        }
    }

    public static void main(String[] args) {
        try {
            Main main = new Main();
            main.showTypeMenu();
            main.validateTypeOpcion();
            main.initData();
            do {
                main.showMenu();
                main.validateMenuOpcion();
                main.execOption();
            } while (main.opcionMenu != 0);
        }catch (InputMismatchException ex){}
    }
}
