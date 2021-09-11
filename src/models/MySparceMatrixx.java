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
     */
    public void remove(int[] datas) {
        int x = datas[0];
        int y = datas[1];
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
     * @param coords arreglo con las coordenadas
     */
    public void swapPos(int[] coords){
        int [] tmp = new int[]{coords[0],coords[1]};
        T key = (T) search(coords[0],coords[1]).key;
        remove(tmp);
        int [] aux = new int[]{coords[2],coords[3]};
        add(key,aux);
    }

    /**
     * Calcula la distancia entre 2 puntos
     * @return distancia entre los 2 puntos(celdas)
     */
    public double distanceBetween(int[] coords){
        return Math.sqrt((coords[0]-coords[1])*(coords[0]-coords[1]) + (coords[2]-coords[3])*(coords[2]-coords[3]));
    }

    /**
     * añade un elemento en la pos x,y
     * @param key info del elemento
     * @param coordinate valor de X y Y cordenada
     */
    public void add(T key, int [] coordinate) {
        int x = coordinate[0];
        int y = coordinate[1];
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

    public int[] splitter(String tosplit){
        String[] strings = tosplit.split(",");
        int[] aux = new int[strings.length];
        for (int i = 0; i <strings.length ; i++) {
            aux[i] = Integer.parseInt(strings[i]);
        }
        return aux;
    }

    /**
     * Metodo encargado de recibir un punto central,un radio y marcar un area circular
     * contando el numero de elementos dentro de dicha area, y agreandolos a una lista
     * @return cantidad de elementos dentro del area circular
     */
    public String numberOfElementsIntoCircularArea(int[] datas){
        int totalElements = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (distanceBetween(new int[]{datas[0],i,datas[1],j}) <= datas[2]){
                    SparseNode tmp = search(i,j);
                    if ( tmp.getKey() != null){
                        this.elementsOfIntoCircularArea.add(tmp);
                        totalElements++;
                    }
                }
            }
        }
        return "Los elementos que se encuentran en el rectangulo son : " + totalElements;
    }

    /**
     * Metodo encargado de recibir 4 parametros que son los bordes del regtangulo, con estos datos encuentra la
     * informacion que se encuentra entre el  rectangulo ingresado, agregando la llave del nodo a una cadena
     * y con un contador que informara cuantos son los elemento totales dentro de la matriz
//     * @param xMin la coordenadda en x minima del rectanculo
//     * @param xMax la coordenadda en x maxima del rectanculo
//     * @param yMin la coordenadda en y minima del rectanculo
//     * @param yMax la coordenadda en y maxima del rectanculo
     * @return String cantidad de elemetos dentro del rectangulo y elementos dentro de el
     */
    public String elementsRectangle(int[] coords){
        String result = "";
        int elements = 0;
        SparseNode<T> node = this.begin;
        while (node!=null){
            if (node.x>=coords[0] && node.x<=coords[2] && node.y>=coords[1] && node.y<=coords[3]){
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
