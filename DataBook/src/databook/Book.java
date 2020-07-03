package databook;

/**
 * Class which store the books.
 * 
 ********************
 * 
 * It has a field for the author and for a title, and their
 * respective setters and getters.
 * 
 * Also it has a method which decides whether is posible to
 * store the book.
 * 
 *********************
 * 
 * @author MagnoGG
 * @since 28/04/2020 13:30
 */
public class Book 
{
    private String author;
    public  String getAuthor()
    {
        return author;
    }
    public  void   setAuthor(String giveAuthor) 
            throws TooLargeArgumentException, 
            InvalidArgumentException 
    {
        if (canSave(giveAuthor))
            this.author = giveAuthor;
        
        else if (giveAuthor.length() >= 25)
            throw new TooLargeArgumentException
                ("El mínimo permitido de carácteres es de 25");
        
        else
            throw new InvalidArgumentException
                ("No se puede guardar este libro");
    }
    
    private String title;
    public  String getTitle()
    {
        return this.title;
    }
    public  void   setTitle(String giveTitle) 
            throws TooLargeArgumentException, 
            InvalidArgumentException 
    {
        if (canSave(giveTitle))
            this.title = giveTitle;
        
        else if (giveTitle.length() >= 25)
            throw new TooLargeArgumentException
                ("El mínimo permitido de carácteres es de 25");
        
        else
            throw new InvalidArgumentException
                ("No se puede guardar este libro");
    }
    
    public  void   setBook(String giveAuthor, String giveTitle) 
            throws TooLargeArgumentException, 
            InvalidArgumentException 
    {
        this.setAuthor(giveAuthor);
        this.setTitle(giveTitle);
    }
    public  Book   (String giveAuthor, String giveTitle) 
            throws TooLargeArgumentException, 
            InvalidArgumentException 
    {
        this.setBook(giveAuthor, giveTitle);
    }
    
    private boolean canSave(String n)
    {        
        return  !n.isEmpty()        &&
                 n.length() <= 25   &&
                !n.equals("Título") &&
                !n.equals("Autor");
    }
}