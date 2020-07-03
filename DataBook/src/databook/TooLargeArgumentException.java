package databook;

/**
 * Exception thown when a param for a book
 * is too long.
 * 
 * @author MagnoGG
 */
public class TooLargeArgumentException extends Exception 
{
    private static final long serialVersionUID = 1L;

    public TooLargeArgumentException(String msg) {
        super(msg);
    }
}

