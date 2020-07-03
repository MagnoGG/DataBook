package databook;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** 
 * Program designed to store books.
 * This class show a window JFrame with the books already stored and let
 * add new ones, search them, or configure the appareance of the app.
 * 
 **************************
 * 
 * @author MagnoGG
 * @since 28/04/2020 12:50
 * @version DataBook 2
 */
public class DataBook extends JFrame implements 
    ActionListener,
    FocusListener ,
    WindowListener
{
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) 
    {
        Configuration.setDefaultConfiguration();
        
        DataBook mainWindow = new DataBook();
        mainWindow.setVisible(true);
    }
    
    //Book
    private final ArrayList<Book> storedBooks;
    
    public  ArrayList<Book> getStoredBooks()
    {
        return storedBooks;
    } 
    private boolean isStored   (String author, String title)
    {
        boolean output = false;
        for (Book b : storedBooks)
        {            
            output = b.getAuthor().equals(author) && 
                     b.getTitle().equals(title);
            if (output)
                break;
        }
        return output;
    }
    public  void    removeBook (int index)
    {
        storedBooks.remove(index);
        booksPanel .refresh();
    }
    public  void    addBook    (String author, String title)
    {
        try
        {
            if (isStored(author, title))
                JOptionPane.showMessageDialog(
                    this, 
                    "Este libro ya existe", 
                    "DataBook - Mensaje"  , 
                    JOptionPane.ERROR_MESSAGE);
            else
            {
                storedBooks.add(new Book(author, title));
                booksPanel.refresh();
            }
            
        }catch(TooLargeArgumentException e)
        {
            /*if (e.getMessage() == null || e.getMessage().isEmpty())
                JOptionPane.showMessageDialog(this , 
                    "No se puede guardar ese libro", 
                    "DataBook - Mensaje"           , 
                    JOptionPane.ERROR_MESSAGE);
            else 
                JOptionPane.showMessageDialog(this, 
                    e.getMessage()            , 
                    "DataBook - Mensaje"      , 
                    JOptionPane.ERROR_MESSAGE);*/
        }catch(InvalidArgumentException e)
        {
            
        }
    }
    public  void    editBook   (String author, String title, int index){
        try
        {
            if ( !author.equals(storedBooks.get(index).getAuthor()) && 
                 !title .equals(storedBooks.get(index).getTitle() ) && 
                 isStored(author, title))
                JOptionPane.showMessageDialog(this, 
                    "Este libro ya existe"        , 
                    "DataBook - Mensaje"          , 
                    JOptionPane.ERROR_MESSAGE);
            else
            {
                storedBooks.add(new Book(author, title));
                storedBooks.remove(index);
                booksPanel .refresh();
            }
            
        }
        catch(TooLargeArgumentException e){
            /*if (e.getMessage() == null || e.getMessage().isEmpty())
                JOptionPane.showMessageDialog(this , 
                    "No se puede guardar ese libro", 
                    "DataBook - Mensaje"           , 
                    JOptionPane.ERROR_MESSAGE);
            else 
                JOptionPane.showMessageDialog(this, 
                    e.getMessage()            , 
                    "DataBook - Mensaje"      , 
                    JOptionPane.ERROR_MESSAGE);*/
        }catch(InvalidArgumentException e){
            
        }
        
    }
    
    //Layouts
    private final CardLayout cl;
    
    //Caja de elementos
    private final JComboBox<String> selectSearch;
    
    //Contenedores
    private final JPanel             centerMenu;
    private final JPanel             southMenu;
    private final JPanel             addBookMenu;
    private final JPanel             searchMenu;
    private final BooksPanel         booksPanel;
    private final ConfigurationPanel configurationPanel;
    
    //Botones
    private final JButton setBookMenu;
    private void  setBookMenuPressed()
    {
        setBookMenu          .setVisible(false);
        setSearchMenu        .setVisible(false);
        setConfigurationMenu .setVisible(false);
        volverMenu           .setVisible(true);
        saveConfiguration    .setVisible(false);
        
        cl                   .show(centerMenu, "libros");
        addBookMenu          .setVisible(true);
        searchMenu           .setVisible(false);
    }
    
    private final JButton setSearchMenu;
    private void  setSearchMenuPressed()
    {
        setBookMenu          .setVisible(false);
        setSearchMenu        .setVisible(false);
        setConfigurationMenu .setVisible(false);
        volverMenu           .setVisible(true);
        saveConfiguration    .setVisible(false);
        
        cl                   .show(centerMenu, "libros");
        addBookMenu          .setVisible(false);
        searchMenu           .setVisible(true);
    }
    
    private final JButton setConfigurationMenu;
    private void  setConfigurationMenu()
    {
        setBookMenu          .setVisible(false);
        setSearchMenu        .setVisible(false);
        setConfigurationMenu .setVisible(false);
        volverMenu           .setVisible(true);
        saveConfiguration    .setVisible(true);
        
        cl                   .show(centerMenu, "confi");
        addBookMenu          .setVisible(false);
        searchMenu           .setVisible(false);
    }
    
    private final JButton volverMenu;
    private void  volverMenuPressed()
    {
        setBookMenu          .setVisible(true);
        setSearchMenu        .setVisible(true);
        setConfigurationMenu .setVisible(true);
        volverMenu           .setVisible(false);
        saveConfiguration    .setVisible(false);
        
        cl                   .show(centerMenu, "libros");
        addBookMenu          .setVisible(false);
        searchMenu           .setVisible(false);
    }
    
    
    private final JButton newBook;
    private void  newBookPressed()
    {
        addBook(writeAuthor.getText(), writeTitle.getText());
        writeAuthor.setText("Autor");
        writeTitle .setText("Título");
    }
    
    private final JButton saveConfiguration;
    private void  saveConfigurationPressed()
    {
        configurationPanel.setConfiguration();
        booksPanel.refresh();
        configurationPanel.refresh();
        refresh();
    }
    
    private final JButton doSearch;
    private void  doSearchPressed()
    {
        
    }
    
    //Campos de texto
    private final JTextField writeAuthor;
    private final JTextField writeTitle;
    private final JTextField writeSearch;
    
    private DataBook()
    {
        //Configuracion de la ventana
        this.setSize(new Dimension(700, 500));
        this.setTitle("DataBook");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addWindowListener    (this);
        this.setLocationRelativeTo(this);
        this.setResizable         (true);
        this.setIconImage(new ImageIcon(getClass().getResource("/programa/imagenes/icoApp.png")).getImage());
        
        //Inicializacion de componentes
        storedBooks          = new ArrayList<>();
        cl                   = new CardLayout();
        selectSearch         = new JComboBox<>();
        
        centerMenu           = new JPanel();
        southMenu            = new JPanel();
        addBookMenu          = new JPanel();
        searchMenu           = new JPanel();
        booksPanel           = new BooksPanel(this);
        configurationPanel   = new ConfigurationPanel();
        
        setBookMenu          = new JButton("Añadir Libro");
        setSearchMenu        = new JButton("Buscar");
        setConfigurationMenu = new JButton("Configuración");
        newBook              = new JButton("Guardar Libro");
        volverMenu           = new JButton("Volver");
        doSearch             = new JButton("Buscar");
        saveConfiguration    = new JButton("Guardar");
        
        writeAuthor          = new JTextField("Autor");
        writeTitle           = new JTextField("Título");
        writeSearch          = new JTextField();
        
        //Configuracion de elementos
        //Otros
        selectSearch.addItem("Búsqueda genérica");
        selectSearch.addItem("Título");
        selectSearch.addItem("Autor");
        
        //Menus
        addBookMenu          .setVisible(false);
        searchMenu           .setVisible(false);
        configurationPanel   .setVisible(false);
        
        //Botones
        setBookMenu          .addActionListener(this);
        setSearchMenu        .addActionListener(this);
        setConfigurationMenu .addActionListener(this);
        volverMenu           .addActionListener(this);
        newBook              .addActionListener(this);
        doSearch             .addActionListener(this);
        saveConfiguration    .addActionListener(this);
        
        volverMenu           .setVisible(false);
        saveConfiguration    .setVisible(false);
        
        //Campo de texto
        writeAuthor.addFocusListener(this);
        writeTitle .addFocusListener(this);
        
        //
        //Layouts
        this                 .setLayout(new BorderLayout());
        centerMenu           .setLayout(cl);
        southMenu            .setLayout(new GridBagLayout());
        addBookMenu          .setLayout(new GridLayout(1, 3));
        searchMenu           .setLayout(new GridBagLayout());
        
        this.add(centerMenu               , BorderLayout.CENTER);
        this.add(southMenu                , BorderLayout.SOUTH );
        
        centerMenu.add(configurationPanel , "confi" );
        centerMenu.add(booksPanel         , "libros");
        cl.show(centerMenu, "libros");
        
        GridBagConstraints gdc   = new GridBagConstraints();
        gdc.fill                 = GridBagConstraints.BOTH;
        gdc.weightx              = 1;
        
        gdc.gridy = 1;
        southMenu.add(setBookMenu          , gdc);
        gdc.gridx = 1;
        southMenu.add(setSearchMenu        , gdc);
        gdc.gridx = 2;
        southMenu.add(setConfigurationMenu , gdc);
        gdc.gridx = 1;
        southMenu.add(saveConfiguration    , gdc);
        gdc.gridx = 0;
        southMenu.add(volverMenu           , gdc);
        
        gdc.gridy = 0;
        gdc.gridx = 0;
        southMenu.add(addBookMenu , gdc);
        southMenu.add(searchMenu  , gdc);
        
        addBookMenu.add(writeAuthor);
        addBookMenu.add(writeTitle);
        addBookMenu.add(newBook);
        
        gdc.gridx   = 0;
        gdc.gridy   = 0;
        searchMenu.add(writeSearch , gdc);
        gdc.gridx   = 1;
        gdc.weightx = 0;
        searchMenu.add(selectSearch, gdc);
        gdc.gridx   = 2;
        searchMenu.add(doSearch    , gdc);
        
        refresh();
    }
    public void refresh()
    {
        //Contenedores
        this                 .setBackground(Configuration.getBackgroundColor());
        centerMenu           .setBackground(Configuration.getBackgroundColor());
        southMenu            .setBackground(Configuration.getBackgroundColor());
        addBookMenu          .setBackground(Configuration.getBackgroundColor());
        searchMenu           .setBackground(Configuration.getBackgroundColor());
        booksPanel           .setBackground(Configuration.getBackgroundColor());
        configurationPanel   .setBackground(Configuration.getBackgroundColor());
         
        //Botones        
        setBookMenu          .setFont(Configuration.getLetter());
        setSearchMenu        .setFont(Configuration.getLetter());
        setConfigurationMenu .setFont(Configuration.getLetter());
        volverMenu           .setFont(Configuration.getLetter()); 
        newBook              .setFont(Configuration.getLetter());
        doSearch             .setFont(Configuration.getLetter());
        saveConfiguration    .setFont(Configuration.getLetter());
        
        setBookMenu          .setForeground(Configuration.getLetterColor());
        setSearchMenu        .setForeground(Configuration.getLetterColor());
        setConfigurationMenu .setForeground(Configuration.getLetterColor());
        volverMenu           .setForeground(Configuration.getLetterColor());
        newBook              .setForeground(Configuration.getLetterColor());
        doSearch             .setForeground(Configuration.getLetterColor());
        saveConfiguration    .setForeground(Configuration.getLetterColor());
        
        writeAuthor.setFont(Configuration.getLetter());
        writeTitle .setFont(Configuration.getLetter());
        writeSearch.setFont(Configuration.getLetter());
        
        writeAuthor.setForeground(Configuration.getLetterColor());
        writeTitle .setForeground(Configuration.getLetterColor());
        writeSearch.setForeground(Configuration.getLetterColor());
    }

    @Override public void actionPerformed (ActionEvent e)
    {
        if (e.getSource() == setBookMenu)
            this.setBookMenuPressed();
        
        if (e.getSource() == setSearchMenu)
            this.setSearchMenuPressed();
        
        if (e.getSource() == setConfigurationMenu)
            this.setConfigurationMenu();
        
        if (e.getSource() == volverMenu)
            this.volverMenuPressed();
        
        if (e.getSource() == newBook)
            this.newBookPressed();
        
        if (e.getSource() == doSearch)
            this.doSearchPressed();
        
        if (e.getSource() == saveConfiguration)
            this.saveConfigurationPressed();
    }
    @Override public void focusGained     (FocusEvent e)
    {
        if (e.getSource() == writeAuthor && 
                writeAuthor.getText().equals("Autor"))
            writeAuthor.setText(null);
        
        if (e.getSource() == writeTitle  && 
                writeTitle.getText().equals("Título"))
            writeTitle.setText(null);
    }
    @Override public void focusLost       (FocusEvent e)
    {
        if  (e.getSource() == writeAuthor && 
                writeAuthor.getText().isEmpty())
            writeAuthor.setText("Autor");
        
        if (e.getSource() == writeTitle  &&
                writeTitle.getText().isEmpty())
            writeTitle.setText("Título");
    }
    @Override public void windowClosing     (WindowEvent e){/*TODO: guardar en archivo*/}
    //Implementations not used
    @Override public void windowOpened      (WindowEvent e) {}
    @Override public void windowClosed      (WindowEvent e) {}
    @Override public void windowIconified   (WindowEvent e) {}
    @Override public void windowDeiconified (WindowEvent e) {}
    @Override public void windowActivated   (WindowEvent e) {}
    @Override public void windowDeactivated (WindowEvent e) {}
    
}
