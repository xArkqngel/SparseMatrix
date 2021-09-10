package models;

/**
 * @author Diego Fernando Alba Novoa
 * @date 2 Sept 2021
 */
public class SparseNode<T>{
	public T key;

	public int x;

	public int y;

	public SparseNode next = null;

	SparseNode(T key, int x, int y) {

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
	public SparseNode getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(SparseNode next) {
		this.next = next;
	}
	
	
}
