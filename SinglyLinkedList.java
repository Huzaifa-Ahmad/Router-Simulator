public class SinglyLinkedList<E>{

  private static class Node<E>{

    // Generic element of the node
    private E element;

    // Referencing next Node
    private Node<E> next; 

    public Node(E e, Node<E> n){
      element = e;
      next = n;
    }

    // Gets element of the node and returns the element of the node
    public E getElement(){
      return element;
    }

    // Gets next Node and returns it
    public Node<E> getNext(){
      return next;
    }

    // Sets the next node as n 
    public void setNext(Node<E> n){
      next = n;
      
    }
  }


  private Node<E> front;
  private Node<E> rear;
  private int size;

  
  public SinglyLinkedList(){
    front = null;
    rear = null;
    size = 0;
  }
  
  // Returns size of the linkedList
  public int size(){
    return size;
  }
  
  // Returns True if linkedList it empty
  public boolean isEmpty(){
    return size == 0;
  }
  
  // Gets and returns the first element
  public E first(){
    return (isEmpty() ? null : front.getElement());
  }
  
  // Gets and returns the last element 
  public E last(){
    return (isEmpty() ? null : rear.getElement());
  }
  
  public void addFirst(E element){
    // Initializing front with the element front
    front = new Node<E>(element, front);

    // if its the first element in the LinkedList then its the first and last element
    if(size == 0)
      rear = front; 
    size++;
  }
  
  // Adding an element to the front of the linkedList 
  public void addLast(E element){
    // Initializing a new node with element 
    Node<E> last = new Node<E>(element, null);
    if (isEmpty())

      // If its the first node in the linkedList, then its the front and the back
      front = last;
    else
      // setting the new node as the front of the queue 
      rear.setNext(last);
    rear = last;
    size++;
  }
  
  public E removeFirst(){
    if (isEmpty()) return null;
    E value = front.getElement();
    front = front.getNext();
    size--;
    if (size == 0)
      rear = null;
    return value;
  }
}