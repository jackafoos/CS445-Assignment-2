//Jacob McAfoos
//Stack backed by a Linked List
public class LinkedStack<T> implements Stack<T>{
  private Node<T> head = null; //top node in Linked Stack

  //Constructor
  public LinkedStack(){
    head = null;
  }

  //returns and removes the top item in the stack
  public T pop(){
    T obj = peek();
    head = head.getNext();
    return obj;
  }

  //returns, but does not remove the top item in the stack
  public T peek(){
    if(!this.isEmpty())
      return head.getValue();
    else{
      throw new UnsupportedOperationException();
    }
  }

  //adds an item to the top of the stack
  public void push(T thing){
    Node<T> n = new Node<T>(thing, head);
    head = n;
  }

  //checks if the stack is empty
  public boolean isEmpty(){
    return head == null;
  }
}

//New Class for Node:
//Linked dataType
class Node<T>{
  private T value = null;
  private Node<T> next = null;//only a one way link

  //constructor 1: (no parameters)
  public Node(){
    this.value = null;
    this.next = null;
  }

  //constructor 2: (one parameter)
  public Node(T value){
    this.value = value;
  }

  //constructor 3: (two parameters)
  public Node(T value, Node<T> next){
    this.value = value;
    this.next = next;
  }

  //determines if the node is linked to another node, if null, return false
  public boolean hasNext(){
    return this.next != null;
  }

  //returns the linked node
  public Node<T> getNext(){
    return this.next;
  }

  //sets the linked node
  public void setNext(Node<T> newNext){
    this.next = newNext;
  }

  //gets the value of this node
  public T getValue(){
    return this.value;
  }
}
