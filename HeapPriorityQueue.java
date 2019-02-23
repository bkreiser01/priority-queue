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


    private void buildHeap()
    {
        for(int index = (int)(size/2); index >= 1; index--)
            heapify(index);
    }

    private void heapify(int i)
    {
        int smallest;

        //Find the smallest cell i, or its children.
        if(((2*i) <= size) && (heap[2*i] < heap[i]))
            smallest = 2*i;
        else
            smallest = i;
        
        if((((2*i) + 1) <= size) &&(heap[2 * i] < heap[smallest]))
            smallest = (2 * i) + 1;

        //Now exchange and continue if necessary;
        if(smallest != i)
        {
            exchange(i, smallest);
            heapify(smallest);
        }
    }

    private void exchange(int index1, int index2)
    {
        E temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
    
    public E min()
    {
        if(isEmpty())
            throw new EmptyHeapException("The heap is empty!");
        
        return(heap[1]);
    }
    
    public E deleteMin()
    {
        if(isEmpty())
            throw new EmptyHeapException("The heap is empty!");
            
        heap[1] = heap[size - 1];
        size--;
        heapify(1);
    }
    
    public boolean insert(E data)
    {
        if(isFull())
            throw new FullHeapException("The heap is full!");

        size++;
        int index = size;
        heap[index] = data;

        //Percolate to restore the heap property.
        while(index > 1 && heap[index] < heap[(int)(index/2)])
        {
            exchange(index, (int)(index/2));
            index = (int)(index/2);
        }

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
