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
        
        heap = (E[])(new Comparable[uCapacity + 1]);
        capacity = uCapacity;
        size = 0;
        
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
                }
            }
        }

        buildHeap();
    }

    public HeapPriorityQueue(int uCapacity)
    {
        this(null, uCapacity);
    }
 
    public HeapPriorityQueue(E[] array)
    {
        this(array, 0);
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
        if(((2*i) <= size) && ((heap[2*i].compareTo(heap[i])) > 0))
            smallest = 2*i;
        else
            smallest = i;
        
        if((((2*i) + 1) <= size) &&(heap[2 * i].compareTo(heap[smallest]) > 0))
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
            
        E temp = heap[1];
        heap[1] = heap[size - 1];
        size--;
        heapify(1);
        return temp;
    }
    
    public boolean insert(E data)
    {
        if(isFull())
            throw new FullHeapException("The heap is full!");

        size++;
        int index = size;
        heap[index] = data;

        //Percolate to restore the heap property.
        while(index > 1 && heap[index].compareTo(heap[(int)(index/2)]) > 0)
        {
            exchange(index, (int)(index/2));
            index = (int)(index/2);
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
