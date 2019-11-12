public class LinkedListQueue<E> implements Queue<E>{

  // Linked List for the Queue 
  private SinglyLinkedList<E> linkedList;

  // Constructing the linked list
  public LinkedListQueue(){
    // Initializing linkedList
    linkedList = new SinglyLinkedList<>();
  }

  public int size(){
    // Returns size of linkedList
    return linkedList.size();
  }

  public boolean isEmpty(){
    return linkedList.isEmpty();
  }

  public E first(){
    return linkedList.first();
  }

  public void enqueue(E node){
    linkedList.addLast(node);
  }
  public E dequeue(){
    return linkedList.removeFirst();
  }
}
