import java.util.Scanner;//importamos la clase Scanner

public class Main {// clase principal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// creamos un objeto de la clase Scanner
        ArbolAvl arbol = new ArbolAvl();// creamos un objeto de la clase ArbolAvl
        int opcion;// creamos una variable para guardar la opcion del usuario
        do {// ciclo do while
            System.out.println("--- Menú Árbol AVL ---");// imprimimos un menu
            System.out.println("1. Insertar elemento");
            System.out.println("2. Eliminar elemento");
            System.out.println("3. Ver estado actual del árbol(Insertar en GraphvizOnline)");
            // el codigo que le da la
            // terminal para poder
            // visualizar el arbol hay
            // que ponerlo en esta
            // pagina
            // https://dreampuf.github.io/GraphvizOnline/#digraph%20G%20%7B%0A%0A%20%20subgraph%20cluster_0%20%7B%0A%20%20%20%20style%3Dfilled%3B%0A%20%20%20%20color%3Dlightgrey%3B%0A%20%20%20%20node%20%5Bstyle%3Dfilled%2Ccolor%3Dwhite%5D%3B%0A%20%20%20%20a0%20-%3E%20a1%20-%3E%20a2%20-%3E%20a3%3B%0A%20%20%20%20label%20%3D%20%22process%20%231%22%3B%0A%20%20%7D%0A%0A%20%20subgraph%20cluster_1%20%7B%0A%20%20%20%20node%20%5Bstyle%3Dfilled%5D%3B%0A%20%20%20%20b0%20-%3E%20b1%20-%3E%20b2%20-%3E%20b3%3B%0A%20%20%20%20label%20%3D%20%22process%20%232%22%3B%0A%20%20%20%20color%3Dblue%0A%20%20%7D%0A%20%20start%20-%3E%20a0%3B%0A%20%20start%20-%3E%20b0%3B%0A%20%20a1%20-%3E%20b3%3B%0A%20%20b2%20-%3E%20a3%3B%0A%20%20a3%20-%3E%20a0%3B%0A%20%20a3%20-%3E%20end%3B%0A%20%20b3%20-%3E%20end%3B%0A%0A%20%20start%20%5Bshape%3DMdiamond%5D%3B%0A%20%20end%20%5Bshape%3DMsquare%5D%3B%0A%7D

            System.out.println("4. Recorrido en orden");
            System.out.println("5. Recorrido pre orden");
            System.out.println("6. Recorrido post orden");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();// guardamos la opcion del usuario

            switch (opcion) {
                case 1:// caso 1 insertar un elemento
                    System.out.print("Introduce el valor a insertar: ");
                    int valorInsertar = sc.nextInt();
                    arbol.insertar(valorInsertar);
                    System.out.println("Valor insertado.");
                    break;

                case 2:// caso 2 eliminar un elemento
                    System.out.print("Introduce el valor a eliminar: ");
                    int valorEliminar = sc.nextInt();
                    arbol.eliminar(valorEliminar);
                    System.out.println("Valor eliminado.");
                    break;

                case 3:// caso 3 ver el estado actual del arbol
                    System.out.println("Estado actual del árbol(Insertar en GraphzOnline):");
                    System.out.println(arbol.obtenercgraph());
                    break;

                case 4:// caso 4 recorrido en orden
                    System.out.println("Recorrido Inorden:");
                    arbol.enOrden();
                    break;

                case 5:// caso 5 recorrido pre orden
                    System.out.println("Recorrido Preorden:");
                    arbol.preOrden();
                    break;

                case 6:// caso 6 recorrido post orden
                    System.out.println("Recorrido Postorden:");
                    arbol.postOrden();
                    break;

                case 7:// caso 7 salir del programa
                    System.out.println("Saliendo del programa...");
                    break;

                default:// caso default opcion no valida
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 7);// mientras la opcion sea diferente de 7 se seguira ejecutando el programa

        sc.close();// cerramos el objeto scanner
    }
}
