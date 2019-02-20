//Brandon Kreiser

public class IllegalRequestedCapacityException extends RuntimeException
{
    public IllegalRequestedCapacityException() {}

    public IllegalRequestedCapacityException(String msg)
    {
        super(msg);
    }
}