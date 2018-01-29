//Jacob McAfoos
//Stack backed by an Array
public class ArrayStack<T> implements Stack<T>{
  private T[] stack; //The the array treated as a stack
  private int head; //# of items in the stack, [head-1] is the top item
  private int capacity;//amount of space array has to be filled.

  //Constructor
  public ArrayStack(){
    //Cast is safe, prevents Linter Warnings
    @SuppressWarnings("unchecked")
    T[] array = (T[]) new Object[1];
    stack = array;
    head = 0;
    capacity = stack.length;
  }

  //makes sure that the array has enough space to add new items
  private void ensureCapacity(){
    if (head == capacity){
      //Cast is safe, prevents Linter Warnings
      @SuppressWarnings("unchecked")
      T[] tempArry = (T[])new Object[(capacity * 2) + 1];
      System.arraycopy(stack, 0, tempArry, 0, head);
      stack = tempArry;
      capacity = stack.length;
    }
  }

  //removes and returns the top item in the stack
  public T pop(){
    T obj = peek();
    stack[head - 1] = null;
    head--;
    return obj;
  }

  //returns but does not remove the top item in the stack
  public T peek(){
    if (!isEmpty())
      return stack[head - 1];
    else
      throw new UnsupportedOperationException();
  }

  //adds an item to the stack
  public void push(T thing){
    ensureCapacity();
    stack[head] = thing;
    head++;
  }
  
  //checks if the stack is empty
  public boolean isEmpty(){
    if (head <= 0)
      return true;
    else
      return false;
  }
}
