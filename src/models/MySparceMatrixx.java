package models;

import java.util.ArrayList;

public class MySparceMatrixx<T> {

    private ArrayList<SparseNode> elementsOfIntoCircularArea;
    private int rows;
    private int cols;
    private SparseNode begin = null;

    public MySparceMatrixx(int rows, int cols){
        this.elementsOfIntoCircularArea = new ArrayList<>();
        this.cols=cols;
        this.rows=rows;
    }

    public boolean is_empty() {
        return this.begin==null;
    }

    /**
     * Busca un elemento en la posicion x,y
     * @param x
     * @param y
     * @return elemento
     */
    public SparseNode search(int x, int y) {
        if (this.is_empty())
            return null;
        SparseNode p = this.begin;
        while (p != null) {
            if ((p.x == x) && (p.y == y))
                return p;
            if (p.x > x)
                return null;
            if ((p.x == x) && (p.y > y))
                return null;
            p = p.next;
        }

        return null;
    }

    /**
     * busca si hay un elemento antes de la posición x,y
     * @param x
     * @param y
     * @return elemento
     */
    public SparseNode searchPrevious(int x, int y) {
        if (this.is_empty())
            return null;
        SparseNode p = this.begin;
        while (p.next != null) {
            if ((p.next.x == x) && (p.next.y == y))
                return p;
            if (p.next.x > x)
                return p;
            if ((p.next.x == x) && (p.next.y > y))
                return p;
            p = p.next;
        }
        return p;
    }

    /**
     * elimina un elemento en la pos x,y
     * @param x
     * @param y
     */
    public void remove(int x, int y) {
        SparseNode found = search(x,y);
        if (found!=null){
            SparseNode prev = this.searchPrevious(x,y);
            if (prev != null) {
                prev.next = found.next;
            } else {
                this.begin = found.next;
            }
        }
    }

    /**
     *
     * @param key
     * @param xactual posicion x actual del elemento
     * @param yactual posicion y actual del elemento
     * @param x posicion x a mover
     * @param y posicion y a mover
     */
    public void swapPos(T key, int xactual, int yactual,int x, int y){
        remove(xactual,yactual);
        add(key,x,y);
    }

    /**
     * Calcula la distancia entre 2 puntos
     * @param x1
     * @param x2
     * @param y1
     * @param y2
     * @return distancia entre los 2 puntos(celdas)
     */
    public double distanceBetween(int x1,int x2, int y1,int y2){
        return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }

    /**
     * añade un elemento en la pos x,y
     * @param key info del elemento
     * @param x
     * @param y
     */
    public void add(T key, int x, int y) {
        if ((x < 0) || (y < 0))
            return;
        if ((x >= this.rows) || (y >= this.cols))
            return;
        SparseNode previous = this.searchPrevious(x, y);
        SparseNode element = this.search(x, y);
        //genera el primer elemento
        if ((previous == null) && (element == null)) {
            SparseNode node = new SparseNode(key, x, y);
            this.begin = node;
            //reemplaza el elemento
        } else if ((previous == null) && (element != null)) {
            element.key = key;
            //si existe antes
        } else if ((previous != null) && (element == null)) {
            //
            if (previous.next == null) {
                SparseNode node = new SparseNode(key, x, y);
                previous.next = node;
            } else {
                SparseNode node = new SparseNode(key, x, y);
                node.next = previous.next;
                previous.next = node;
            }
        } else if ((previous != null) && (element != null)) {
            element.key = key;
        }
    }

    /**
     * Metodo encargado de recibir un punto central,un radio y marcar un area circular
     * contando el numero de elementos dentro de dicha area, y agreandolos a una lista
     * @param x posicion en x
     * @param y posicion en y
     * @param radius radio circulo
     * @return cantidad de elementos dentro del area circular
     */
    public int numberOfElementsIntoCircularArea(int x, int y, int radius){
        int totalElements = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (distanceBetween(4,i,2,j) <= 4.5){
                    SparseNode tmp = search(i,j);
                    if ( tmp.getKey() != null){
                        this.elementsOfIntoCircularArea.add(tmp);
                        totalElements++;
                    }
                }
            }
        }
        return totalElements;
    }

    /**
     * Metodo encargado de recibir 4 parametros que son los bordes del regtangulo, con estos datos encuentra la
     * informacion que se encuentra entre el  rectangulo ingresado, agregando la llave del nodo a una cadena
     * y con un contador que informara cuantos son los elemento totales dentro de la matriz
     * @param xMin la coordenadda en x minima del rectanculo
     * @param xMax la coordenadda en x maxima del rectanculo
     * @param yMin la coordenadda en y minima del rectanculo
     * @param yMax la coordenadda en y maxima del rectanculo
     * @return String cantidad de elemetos dentro del rectangulo y elementos dentro de el
     */
    public String elementsRectangle(int xMin,int xMax,int yMin,int yMax){
        String result = "";
        int elements = 0;
        SparseNode<T> node = this.begin;
        while (node!=null){
            if (node.x>=xMin && node.x<=xMax && node.y>=yMin && node.y<=yMax){
                result += node.key+"\n";
                elements ++;
            }
            node = node.next;
        }
        return "Los elementos que se encuentran en el rectangulo son : " + elements + "\n"+result;
    }
    public void sort(){
//        SparseNode<T> node = this.begin, index ;
//        T temp;
//        while (node != null) {
//            index = node.next;
//            while (index != null) {
//                if (Math.hypot(index.x,index.y)>Math.hypot(node.x,node.y)) {
//                    temp = node.key;
//                    node.key = index.key;
//                    index.key = temp;
//                }
//
//                index = index.next;
//            }
//            node = node.next;
//        }
    }

}
