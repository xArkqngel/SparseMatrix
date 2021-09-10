package models;

public class MySparceMatrixx<T> {

    private int rows;
    private int cols;
    private SparseNode begin = null;

    public MySparceMatrixx(int rows, int cols){
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

    public int numberOfElementsIntoCircularArea(int x, int y, int radius){



        return -1;
    }

}
