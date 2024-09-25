public class ArbolAvl {

    // atributos de la clase ArbolAvl
    private Nodo raiz; // creamos un Nodo raiz

    // creamos un metodo para buscar un nodo con dato y el nodo raiz
    public Nodo buscar(int dato, Nodo raiz) {
        // Si el nodo actual es igual a null retorna null osea no lo encontro
        if (raiz == null) {
            return null;

            // Si el nodo actual es igual al dato retorna la raiz, ya que, la ha encontrado
        } else if (raiz.getDato() == dato) {
            return raiz;

            // Si el dato es mayor busca en el subárbol derecho
        } else if (raiz.getDato() < dato) {
            return buscar(dato, raiz.getDerecho());
            // y si el dato es menor busca en el subárbol izquierdo
        } else {
            return buscar(dato, raiz.getIzquierdo());
        }
    }

    // este metodo es para obtener el equilibrio
    public int equilibrio(Nodo x) {
        if (x == null) {
            // si el nodo es igual a null retorna -1 ya que no tiene altura
            return -1;
            // si no retorna la altura
        } else {
            return x.getAltura();
        }
    }

    // este metodo es para la rotacion simple hacia la izquierda para balancear el
    // arbol
    public Nodo rotacionIzquierda(Nodo x) {
        Nodo aux = x.getIzquierdo(); // guardar el hijo izquierdo de x en aux
        x.setIzquierdo(aux.getDerecho()); // el hijo derecho del auxiliar pasa a ser con el set el hijo izquierdo de x
        aux.setDerecho(x); // x pasa a ser el hijo derecho del auxiliar

        // estas lineas lo que hacen es que actualizan las las alturas despues de la
        // rotacion y retorna el aux
        x.setAltura(Math.max(equilibrio(x.getIzquierdo()), equilibrio(x.getDerecho())) + 1);
        aux.setAltura(Math.max(equilibrio(aux.getIzquierdo()), equilibrio(aux.getDerecho())) + 1);
        return aux;
    }

    // este metodo es para la rotacion simple hacia la izquierda para balancear el
    // arbol
    public Nodo rotacionDerecha(Nodo x) {
        Nodo aux = x.getDerecho(); // guarda el hijo derecho de x en el aux
        x.setDerecho(aux.getIzquierdo()); // el hijo izquierdo del auxiliar pasa a ser el hijo derecho de x
        aux.setIzquierdo(x); // x pasa a ser el hijo izquierdo de aux

        // y estas lineas lo que hacen es que actualizan las alturas despues de la
        // rotacion y devuelve el aux
        x.setAltura(Math.max(equilibrio(x.getIzquierdo()), equilibrio(x.getDerecho())) + 1);
        aux.setAltura(Math.max(equilibrio(aux.getIzquierdo()), equilibrio(aux.getDerecho())) + 1);
        return aux;
    }

    // este metodo hace una rotacion doble osea primero rota hacia la derecjha y
    // luego lo rota hacia la izquierda
    public Nodo rotacionIzquierdaDoble(Nodo x) {
        Nodo aux;

        // con este se realiza una rotacion hacia la derecha
        x.setIzquierdo(rotacionDerecha(x.getIzquierdo()));

        // luego se hace una rotacion a la izquierda
        aux = rotacionIzquierda(x);

        // y devuelve por ultimo el aux que es el nodo padre
        return aux;
    }

    // este metodo hace una rotacion doble pero esta la hace primero hacia la
    // izquierda y luego lo rota hacia la derecha
    public Nodo rotacionDerechaDoble(Nodo x) {
        Nodo aux;

        // con este se realiza una rotacion hacia la izquierda
        x.setDerecho(rotacionIzquierda(x.getDerecho()));

        // luego se hace una rotacion a la derecha
        aux = rotacionDerecha(x);

        // se devuelve por ultimo el aux que es el nodo padre
        return aux;
    }

    // este metodo nos permite insertar un nuevo dato en el arbol AVL
    public Nodo insertarDato(Nodo nuevo, Nodo subArbol) {
        Nodo nuevoPadre = subArbol;

        // Si el dato del nuevo nodo es menor se inserta en el subárbol izquierdo
        if (nuevo.getDato() < subArbol.getDato()) {

            // y si no hay un hijo izquierdo se inserta aqui
            if (subArbol.getIzquierdo() == null) {
                subArbol.setIzquierdo(nuevo);
            } else {

                // luego con la recursividad insertamos en el subárbol izquierdo
                subArbol.setIzquierdo((insertarDato(nuevo, subArbol.getIzquierdo())));

                // con este comprobamos si el subarbol izquierdo esta desbalanceado
                if ((equilibrio(subArbol.getIzquierdo()) - equilibrio(subArbol.getDerecho()) == 2)) {

                    // aca con estos condicionales miramos si es necesario utilizar una rotacion
                    // simple o una doble
                    if (nuevo.getDato() < subArbol.getIzquierdo().getDato()) {
                        nuevoPadre = rotacionIzquierda(subArbol);
                    } else {
                        nuevoPadre = rotacionIzquierdaDoble(subArbol);
                    }
                }
            }

            // este si no cumple todo lo anterior es por que se va insertar en el subarbol
            // derecho
        } else if (nuevo.getDato() > subArbol.getDato()) {
            // si el hijo derecho es = a null es por que no hay y se inserta aqui
            if (subArbol.getDerecho() == null) {
                subArbol.setDerecho(nuevo);
            } else {

                // aca se comprueba si el subarbol derecho esta desbalanceado
                subArbol.setDerecho(insertarDato(nuevo, subArbol.getDerecho()));
                if (equilibrio(subArbol.getDerecho()) - equilibrio(subArbol.getIzquierdo()) == 2) {

                    // aca con estos condicionales miramos si es necesario utilizar una rotacion
                    // simple o una doble
                    if (nuevo.getDato() > subArbol.getDerecho().getDato()) {
                        nuevoPadre = rotacionDerecha(subArbol);
                    } else {
                        nuevoPadre = rotacionDerechaDoble(subArbol);
                    }
                }
            }
        } else {
            System.out.println("Nodo Duplicado");
        }

        // actualiza la altura del nodo actual
        if ((subArbol.getIzquierdo() == null) && (subArbol.getDerecho() != null)) {
            subArbol.setAltura(subArbol.getDerecho().getAltura() + 1);
        } else if ((subArbol.getDerecho() == null) && (subArbol.getIzquierdo() != null)) {
            subArbol.setAltura(subArbol.getIzquierdo().getAltura() + 1);
        } else {
            subArbol.setAltura(Math.max(equilibrio(subArbol.getIzquierdo()), equilibrio(subArbol.getDerecho())) + 1);
        }
        return nuevoPadre; // retorna al nodo padre
    }

    // este metodo es para insertarun nuevo valor al arbol
    public void insertar(int x) {

        // se crea un nuevo nodo como un objeto
        Nodo nuevo = new Nodo(x);

        // si el arbol es = a null es por que ese nuevo valor va a ser la raiz
        if (raiz == null) {
            raiz = nuevo;

            // si no llamamos la funcion insertar dato
        } else {
            raiz = insertarDato(nuevo, raiz);
        }
    }

    // este metodo elimina un nodo con su valor
    public Nodo eliminarDato(Nodo subArbol, int dato) {

        // si el nodo es = a null el dato no existe y retorna null
        if (subArbol == null) {
            System.out.println("El dato no se encuentra en el árbol");
            return null;
        }

        // se empieza a buscar el dato a eliminar
        if (dato < subArbol.getDato()) {
            subArbol.setIzquierdo(eliminarDato(subArbol.getIzquierdo(), dato));
        } else if (dato > subArbol.getDato()) {
            subArbol.setDerecho(eliminarDato(subArbol.getDerecho(), dato));
        } else {

            // Caso 1: El nodo tiene uno o ningún hijo
            if (subArbol.getIzquierdo() == null || subArbol.getDerecho() == null) {
                Nodo temp = null;
                if (subArbol.getIzquierdo() != null) {
                    temp = subArbol.getIzquierdo();
                } else {
                    temp = subArbol.getDerecho();
                }

                if (temp == null) {
                    temp = subArbol;
                    subArbol = null;
                } else {
                    subArbol = temp;
                }
            } else {

                // Caso 1: El nodo tiene uno o ningún hijo
                Nodo temp = minValorNodo(subArbol.getDerecho());
                subArbol.setDato(temp.getDato());
                subArbol.setDerecho(eliminarDato(subArbol.getDerecho(), temp.getDato()));
            }
        }

        // si el arbol solo tiene ese nodo como es el unico lo retorna
        if (subArbol == null) {
            return subArbol;
        }

        // se actualiza la altura del nodo actual
        subArbol.setAltura(Math.max(equilibrio(subArbol.getIzquierdo()), equilibrio(subArbol.getDerecho())) + 1);

        // despues de la eliminacion se balancea el arbol
        int balance = equilibrio(subArbol.getIzquierdo()) - equilibrio(subArbol.getDerecho());

        // se hacen las rotaciones necesarias para mantener el equilibrio
        if (balance > 1 && (equilibrio(subArbol.getIzquierdo()) >= 0)) {
            return rotacionIzquierda(subArbol);
        }

        if (balance > 1 && (equilibrio(subArbol.getIzquierdo()) < 0)) {
            return rotacionIzquierdaDoble(subArbol);
        }

        if (balance < -1 && (equilibrio(subArbol.getDerecho()) <= 0)) {
            return rotacionDerecha(subArbol);
        }

        if (balance < -1 && (equilibrio(subArbol.getDerecho()) > 0)) {
            return rotacionDerechaDoble(subArbol);
        }

        return subArbol;
    }

    // este metodo ayuda a encontrar el valor minimo en un subarbol
    private Nodo minValorNodo(Nodo nodo) {
        Nodo actual = nodo;

        while (actual.getIzquierdo() != null) {
            actual = actual.getIzquierdo();
        }

        return actual;
    }

    // con este metodo eliminamos un nodo con un valor en especifico
    public void eliminar(int dato) {
        raiz = eliminarDato(raiz, dato);
    }

    // estos son los tipos de recorridos que hay para recorrer el arbol
    public void enOrden() {
        raiz.enOrden();
    }

    public void preOrden() {
        raiz.preOrden();
    }

    public void postOrden() {
        raiz.postOrden();
    }

    public String obtenercgraph() {
        String texto = "digraph G\n"
                + "{\n"
                + "  node[shape = circle]\n"
                + "  node[style = filled]\n"
                + "  node[fillcolor = \"#EEEEEE\"]\n"
                + "  node[color = \"#EEEEEE\"]\n"
                + "  edge[color = \"#31CEF0\"]\n";

        if (raiz != null) {
            texto += raiz.textoGraph();
        }

        texto += "}";

        return texto;
    }
}
