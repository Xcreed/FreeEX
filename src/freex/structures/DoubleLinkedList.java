package freex.structures;

/**
 * Class for DoubleLinkedList.
 *
 * @param <T>
 */

public class DoubleLinkedList <T> {
	
	private DoubleNode<T> head = null; //null node for the head of the list
	private DoubleNode<T> tail = null; //null node for the tail of the list
	private int index;
	
	/**
	 * Return the length of the list.
	 * 
	 * @return length (integer)
	 */
	public int getLength() {
		int counter = 0; 
		DoubleNode<T> tmp = head;
		
		while (tmp != null) {
			counter++;
			tmp = tmp.getNext();
			}
		return counter;
	}
	
	/**
	 * Returns the position number (index)  of a given element.
	 * Position number (index) starts at cero (0).
	 * 
	 * @param <T>
	 * @param pData
	 * @return position
	 */
	
	public <T> int getElementPosition(T pData){
		
		int index = 0;
		DoubleNode<T> tmp = (DoubleNode<T>) head; 
		
		while(tmp != null){
			if(tmp.getData().equals(pData)){
				index++;
				break;
			}else{
				tmp = tmp.getNext();
			}
		}
		return index;
	}
		
	/**
	 * Returns a true if list's empty, else false.
	 * 
	 * @return boolean 
	 */
	public boolean isEmpty(){
		if (head == null){  //optional: getLength() == 0
			return true;
		}else{
			return false;
			}
		}
	
	/**
	 * Insert an element (pData) at the beginning of the list.
	 * 
	 * @param pData
	 */
	public boolean insertBeginning(T pData){
		
		DoubleNode<T> data = new DoubleNode<T>(pData);
		
		if(isEmpty()){
			head = tail = data;
			index = 0;
		}else{
			head.setPrev(data); //head.prev = data;
		}
		data.setNext(head); //data.next = head;
		head = data; //head = data;
		index++;
		return true;
	}
	
	/**
	 * Insert an element (tData) at the end of the list.
	 * 
	 * @param pData
	 */
	public boolean insertEnd(T pData){
		
		DoubleNode<T> data = new DoubleNode<T>(pData);
		
		if(isEmpty()){
			head = tail = data;
			index = 0;
		}else{
			tail.setNext(data); //tail.next = data;
			data.setPrev(tail); //data.prev = tail;
		}
		tail = data; //tail = head;
		index++;
		return true;
	}
	
	/**
	 * Return a list (type StringBuilder) that shows all the node together.
	 * @return 
	 * 
	 * @return list 
	 */
	public StringBuilder print(){	
		
		StringBuilder list = new StringBuilder();
		DoubleNode<T> tmp = head;
		
		while(tmp != null){
			//System.out.println(list);
			list.append(tmp.getData() + ",");
			tmp = tmp.getNext();
		}
		//System.out.println(list);
		return list;
	}
	
	/**
	 * Given a number, search and return the element
	 * from the position in the list. 
	 * @param i
	 * @return element
	 */
	public T getItem(int i) {
		
		if (head == tail) {
			return (T) head.getData();
		}else{
			DoubleNode<T> temp = head;
			if (temp != null) {
				for (int j = 0; j < i; j++) {
					temp = temp.getNext();
				}
			}else{
				System.out.println("Index out of reach");
				return null;
			}
			return (T) temp.getData();
		}	
	}
	
	/**
	 * Return the search (pData) element, else false.
	 * @param pData
	 * @return pData
	 */
	public Object search(T pData){
		DoubleNode<T> data = new DoubleNode<T>(pData);
		boolean bool = false;
	
		if(isEmpty()){
			return null;
		}else{
			DoubleNode<T> tmp = head; 
			while(tmp != null){
				if(tmp.getData() == pData){
					return tmp;
				}else{
					tmp = tmp.getNext(); 
				} 
			}
			System.out.println("Item not found");
			return null;
		}
	}
	
	/**
	 * Removes the first the element of the list. 
	 */
	public boolean deleteBeginning(){
		
		//List only has one element
		if (head == tail) {
			head = tail = null;
		} else {
	
		DoubleNode<T> tmp = head.getNext();
		
		head = head.getNext();
		head.setNext(tmp.getNext());
		head.setPrev(null);
		}
		return true;
	}
	
	/**
	 * Removes the last element of the list. 
	 */
	public boolean deleteEnd() {
		//List only has one element
		if (head == tail) {
			head = tail = null;
		} else {
			tail = tail.getPrev();
			tail.setNext(null);			
		}
		return true;
	}
	
	/**
	 * Deletes (pData) from any middle position inside the list.
	 * Any middle position are any position that isn't the beginning
	 * or the end. 
	 * @param <U>
	 * @param element
	 */
	public <T> void deleteMiddle(DoubleNode<T> element) {
		
		DoubleNode<T> tmp = (DoubleNode<T>) head;
		if(contains(element) == true){
			while(tmp != null){
				if (tmp.getData() == element){
					tmp.getPrev().setNext(tmp.getNext());
					tmp.setPrev(null);
					tmp.getNext().setPrev(tmp.getPrev());
					tmp.setNext(null);
					break;
				}else{
					tmp = tmp.getNext();
				}
			}	
		}else{
			return;
		}
	}
	
	
	/**
	 * Deletes an given item from the list at any position. 
	 * @param index starts in 1
	 * @return 
	 */
	public boolean deleteByIndex(int index){
		
		if (index == 1) {
			head = head.getNext();
			return true;
		}else{
			DoubleNode<T> temp = head;
			
			for (int j = 1; j < index; j++) {
				temp = temp.getNext();
			} 
			
			DoubleNode<T> next = temp.getNext();
			DoubleNode<T> prev = temp.getPrev();
			
			if (prev == null) {
				temp = null;
				head = next;
			}else if (next == null) {
				temp = null;
				prev.setNext(null);
			}else {
				temp = null;
				prev.setNext(next);
			}
			System.out.println("Deleted");
			return true;
		}
	}
		

	/**
	 * Return the search  element, else false.
	 * @param <U>
	 * @param pData
	 * @return pData
	 */
	public <T> boolean contains(T pData){
		DoubleNode<T> data = new DoubleNode<T>((T) pData);
		boolean bool = false;
	
		if(isEmpty()){
			return false;
		}else{
			DoubleNode<T> tmp = (DoubleNode<T>) head; 
			while(tmp != null){
				if(tmp.getData().equals(pData)){
					bool = true;
					return bool;
				}else{
					tmp = tmp.getNext(); 
				} 
			}
			System.out.println("Item not found");
			return bool;
		}
	}

}
