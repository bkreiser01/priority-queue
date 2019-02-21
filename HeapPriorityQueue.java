//Brandon Kreiser

public class HeapPriorityQueue<E extends Comparable<? super E>> implements PriorityQueue<E>
{
    private E[] heap;
    private int size;
    private int capacity;
 
 
    public HeapPriorityQueue(E[] array, int uCapacity)
    {
        if(uCapacity < 0)
            throw new IllegalRequestedCapacityException("Requested capacity is less than zero!");
            
        capacity = uCapacity;
        size = 0;
        this(array);
    }

    public HeapPriorityQueue(int uCapacity)
    {
        if(uCapacity < 0)
        {
            throw new IllegalRequestedCapacityException("Requested capacity is less than zero!");
        }
        else
        {
            capacity = uCapacity;
            heap = new (E[])(new Comparable[capacity + 1]);
            size = 0;
        }
    }
 
    public HeapPriorityQueue(E[] array)
    {
    
        if(capacity == null)
        {
            heap = (E[])(new Comparable[array.length + 1]);
        }
        else
        {
            heap = (E[])(new Comparable[capacity + 1]);
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


    private void buildHeap() //IN PROGRESS
    {
        for(i = (int)(size/2); )
    }

    private void heapify(E element) //IN PROGRESS
    {
        
    }
    
    public E min()
    {
        if(isEmpty())
            //EmptyHeapException
        
        return(heap[1]);
    }
    
    public E deleteMin() //IN PROGRESS
    {
        if(isEmpty())
            //EmptyHeapException
            
        heap[1] = heap[size - 1];
        size--;
        heapify(heap[1]);
    }
    
    public boolean insert(E data) //IN PROGRESS
    {
        if(isFull())
            //FullHeapException
    }
    
    public boolean isEmpty(); //DONE
    {
        return(size == 0);
    }
    
    public boolean isFull(); //DONE
    {
        return(capacity == size);
    }
    
    public int size(); //DONE
    {
        return size;
    }
}
