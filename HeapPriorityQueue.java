//Brandon Kreiser
public class HeapPriorityQueue<E extends Comparable<? super E>> implements PriorityQueue<E>
{
    private E[] heap;
    private int size;
    private int capacity;
    
    public HeapPriorityQueue(int uCapacity)
    {
        if(uCapacity < 0)
        {
            throw new IllegalRequestedCapacityException("Requested capacity is less than zero!");
        }
        else
        {
            capacity = hCapacity;
            heap = new E[capacity] + 1;
            size = 0
        }
    }
    
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
        }
    }
    
    public HeapPriorityQueue(E[] arrray, int uCapacity))
    {
        
    }
}
