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
        //Illegal Requested Capacity
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
            //Null Element Exception
            }
        }
    }
    
    public HeapPriorityQueue(E[] arrray, int uCapacity))
    {
        
    }
}
