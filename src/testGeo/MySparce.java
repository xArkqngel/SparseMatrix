package testGeo;

public class MySparce<T> {

    private int rows;
    private int cols;
    private SparseMatrixNode begin = null;

    public MySparce(int rows,int cols){
        this.cols=cols;
        this.rows=rows;
    }

    public boolean is_empty() {
        return this.begin==null;
    }

    public SparseMatrixNode search(int x, int y) {
        if (this.is_empty())
            return null;
        SparseMatrixNode p = this.begin;
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

    public SparseMatrixNode search_previous(int x, int y) {
        if (this.is_empty())
            return null;
        SparseMatrixNode p = this.begin;
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

    public void remove(int x, int y) {
        SparseMatrixNode found = search(x,y);
        if (found!=null){
            SparseMatrixNode prev = this.search_previous(x,y);
            if (prev != null) {
                prev.next = found.next;
            } else {
                this.begin = found.next;
            }
        }
    }

    public void add(T key, int x, int y) {
        if ((x < 0) || (y < 0))
            return;
        if ((x >= this.rows) || (y >= this.cols))
            return;
        SparseMatrixNode previous = this.search_previous(x, y);
        SparseMatrixNode element = this.search(x, y);
        //genera el primer elemento
        if ((previous == null) && (element == null)) {
            SparseMatrixNode node = new SparseMatrixNode(key, x, y);
            this.begin = node;
            //reemplaza el elemento
        } else if ((previous == null) && (element != null)) {
            element.key = key;
            //si existe antes
        } else if ((previous != null) && (element == null)) {
            //
            if (previous.next == null) {
                SparseMatrixNode node = new SparseMatrixNode(key, x, y);
                previous.next = node;
            } else {
                SparseMatrixNode node = new SparseMatrixNode(key, x, y);
                node.next = previous.next;
                previous.next = node;
            }
        } else if ((previous != null) && (element != null)) {
            element.key = key;
        }
    }

}
