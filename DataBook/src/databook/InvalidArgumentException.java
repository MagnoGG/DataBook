package databook;
/**
 * Exception thrown when a param for a book
 * is not valid
 */
public class InvalidArgumentException extends Exception
{
    private static final long serialVersionUID = 1L;

    public InvalidArgumentException(String msg)
    {
        super(msg);
    }
}
