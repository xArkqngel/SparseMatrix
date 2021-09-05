package testGeo;

/**
 * @author Diego Fernando Alba Novoa
 * @date 2 Sept 2021
 */
public class SparseMatrixNode<T>{
	public T key;

	public int x;

	public int y;

	public SparseMatrixNode next = null;

	SparseMatrixNode(T key, int x, int y) {

		this.key = key;
		this.x = x;
		this.y = y;
	}

	/**
	 * @return the key
	 */
	public T getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(T key) {
		this.key = key;
	}

	/**
	 * @return the next
	 */
	public SparseMatrixNode getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(SparseMatrixNode next) {
		this.next = next;
	}
	
	
}
