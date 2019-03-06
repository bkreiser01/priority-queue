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
        heap = (E[])(new Comparable[uCapacity + 1]);
        
        if(array != null)
        {
            for(int index = 0; index < array.length; index++)
            {
                if(array[index] == null)
                {
                    throw new NullElementException("Encountered null element in inputted array!");
                }
                else
                {
                    heap[index + 1] = array[index];
                    size++;
                }
                
                buildHeap();
            }
        }
        else
        {
        	size = 0;
        }
    }

    public HeapPriorityQueue(int uCapacity)
    {
        this(null, uCapacity);
    }
 
    public HeapPriorityQueue(E[] array)
    {
        this(array, array.length);
    }

    private void buildHeap()
    {
        for(int index = size/2; index > 0; index--)
            heapify(index);
    }

    private void heapify(int i)
    {
        int smallest;

        //Find the smallest cell i, or its children.
        if(((2*i) <= size) && ((heap[2*i].compareTo(heap[i])) < 0))
            smallest = 2*i;
        else
            smallest = i;
        
        if((((2*i) + 1) <= size) &&(heap[(2 * i) + 1].compareTo(heap[smallest]) < 0))
            smallest = (2 * i) + 1;

        //Now exchange and continue if necessary;
        if(smallest != i)
        {
            E temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;
            heapify(smallest);
        }
    }

    public E min()
    {
        if(isEmpty())
            throw new EmptyHeapException("Can't get the minimum element on a empty heap!");
        
        return(heap[1]);
    }
    
    public E deleteMin()
    {
        if(isEmpty())
            throw new EmptyHeapException("Can't delete an element from an already empty heap!");
            
        E temp = heap[1];
        heap[1] = heap[size];
        size--;
        heapify(1);
        
        return temp;
    }
    
    public boolean insert(E data)
    {
        if(isFull())
            throw new FullHeapException("Can't insert an element on an already full heap!");
        
        if(data == null)
        	throw new NullElementException("Can't insert a null element!");

        size++;
        int newPosition = size;
        heap[newPosition] = data;
		
        //Percolate to restore the heap property.
        while(newPosition > 1 && heap[newPosition].compareTo(heap[newPosition/2]) < 0)
        {
            E temp = heap[newPosition];
            heap[newPosition] = heap[newPosition/2];
            heap[newPosition/2] = temp;
            
            newPosition = newPosition/2;
        }
        
        return true;

    }
    
    public boolean isEmpty()
    {
        return(size == 0);
    }
    
    public boolean isFull()
    {
        return(capacity == size);
    }
    
    public int size()
    {
        return size;
    }
}
