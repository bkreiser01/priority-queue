//Brandon Kreiser

public class EmptyHeapException extends RuntimeException
{
    public EmptyHeapException() {}

    public EmptyHeapException(String msg)
    {
        super(msg);
    }
}