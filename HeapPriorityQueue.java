//Brandon Kreiser

public class HeapPriorityQueue<E extends Comparable<? super E>> implements PriorityQueue<E>
{
    private E[] heap;
    private int size;
    private int capacity;
    

    //Constructors
    /*
    public HeapPriorityQueue(E[] array, int uCapacity)
    {
        this(uCapacity);
        this(array);
    }
    */
    public HeapPriorityQueue(int uCapacity)
    {
        if(uCapacity < 0)
        {
            throw new IllegalRequestedCapacityException("Requested capacity is less than zero!");
        }
        else
        {
            capacity = uCapacity;
            heap = new E[capacity + 1];
            size = 0;
        }
    }
    /*
    public HeapPriorityQueue(E[] array)
    {
    
        if(capacity == null)
        {
            heap = (E[])(new Comparable<>)[array.length + 1];
        }
        else
        {
            heap = (E[])(new Comparable<>)[capacity + 1];
        }
        
        for(int index = 0; index < array.length; index++)
        {
            if(array[index] == null)
            {
                throw new NullElementException("Encountered null element in inputted array!");
            }
            else
            {
              heap[index + 1] = array[index];
            }
        }

        buildHeap();
    }

    private void buildHeap()
    {

    }

    private void heapify()
    {
        
    }
    public E min()
    {

    }
    public E deleteMin()
    {

    }
    public boolean insert(E data)
    {

    }
    public boolean isEmpty();
    {

    }
    public boolean isFull();
    {

    }
    public int size();
    {

    }
    */
}