public class Nodo {

    // estos son los atributos del Nodo
    private int dato; // esta el dato
    private Nodo izquierdo;// el nodo izquierdo
    private Nodo derecho; // el nodo derecho
    private int altura;// y la altura del arbol para el arbol avl

    // inicialisamos un constructor con un valor dato
    public Nodo(int dato) {
        this.dato = dato;
        // y colocaos como si no tuviera nodo a la izquierda ni a la derecha
        this.izquierdo = null;
        this.derecho = null;
        // e inicializamos la altura en 0
        this.altura = 0;
    }

    // este metodo es en orden osea que va de izquierda a raiz y despues a derecha
    public void enOrden() {
        // Si existe un hijo izquierdo, recorre ese subarbol
        if (izquierdo != null) {
            izquierdo.enOrden();
        }

        // imprime el dato actual
        System.out.println(dato);

        // si existe un hijo derecho recorre ese subarbol
        if (derecho != null) {
            derecho.enOrden();
        }
    }

    // este metodo es preorden el cual va de raiz a izquierda y luego a derecha
    public void preOrden() {

        // imprime el dato actual
        System.out.println(dato);

        // Si existe un hijo izquierdo, recorre ese subarbol
        if (izquierdo != null) {
            izquierdo.preOrden();
        }
        // si existe un hijo derecho recorre ese subarbol
        if (derecho != null) {
            derecho.preOrden();
        }
    }

    // este metodo es postorden el cual va de izquierda a derecha y luego a la raiz
    public void postOrden() {

        // Si existe un hijo izquierdo, recorre ese subarbol
        if (izquierdo != null) {
            izquierdo.postOrden();
        }
        // si existe un hijo derecho recorre ese subarbol
        if (derecho != null) {
            derecho.postOrden();
        }

        // imprime el dato actual
        System.out.println(dato);
    }

    // este metodo es para obtener una representación del árbol en formato gráfico
    public String textoGraph() {
        if (izquierdo == null && derecho == null) {
            return String.valueOf(dato);
        } else {
            String texto = "";
            if (izquierdo != null) {
                texto += dato + " -> " + izquierdo.textoGraph() + "\n";
            }
            if (derecho != null) {
                texto += dato + " -> " + derecho.textoGraph() + "\n";
            }
            return texto;
        }
    }

    // estos son los seterrs y getters el cual el get se encarga de obtener el dato
    // o valor que tenga el atributo en ese momento y el set es el encargado de
    // modificar el valor de estos.
    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

}
