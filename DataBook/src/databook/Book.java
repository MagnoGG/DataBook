package databook;

/**
 * Tipo de dato libro
 * 
 * @author MarMagnoGG
 * @since 28/04/2020 13:30
 * @version DataBook 2
 */
public class Book {
    
    private String author;
    public  String getAuthor(){
        return author;
    }
    public  void   setAuthor(String giveAuthor) 
            throws TooLargeArgumentException  ,
                   InvalidArgumentException   {
        if (isGuardable(giveAuthor))
            this.author= giveAuthor;
        
        else if (giveAuthor.length() >= 25)
            throw new TooLargeArgumentException
                ("El mínimo permitido de carácteres es de 25");
        
        else
            throw new InvalidArgumentException
                ("No se puede guardar este libro");
    }
    
    
    private String title;
    public  String getTitle(){
        return this.title;
    }
    public  void   setTitle(String giveTitle) 
            throws TooLargeArgumentException, 
                   InvalidArgumentException {
        if (isGuardable(giveTitle))
            this.title= giveTitle;
        
        else if (giveTitle.length() >= 25)
            throw new TooLargeArgumentException
                ("El mínimo permitido de carácteres es de 25");
        
        else
            throw new InvalidArgumentException
                ("No se puede guardar este libro");
    }
    
    
    public  void   setBook(String giveAuthor, String giveTitle) 
            throws TooLargeArgumentException, 
                   InvalidArgumentException {
        this.setAuthor(giveAuthor);
        this.setTitle(giveTitle);
    }
    
    public  Book   (String giveAuthor, String giveTitle) 
            throws TooLargeArgumentException, 
                   InvalidArgumentException {
        this.setBook(giveAuthor, giveTitle);
    }
    
    
    private boolean isGuardable(String n){        
        return  !n.isEmpty()        &&
                 n.length() <= 25   &&
                !n.equals("Título") &&
                !n.equals("Autor");
    }
}
