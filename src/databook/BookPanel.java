package databook;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Generates a Panel which show the information of a book.
 *   ---------------------------------------------
 *  | Book Index | Author | Title | Edit (Button) |
 *   ---------------------------------------------
 * On the edit mode, both author and title switch for a text 
 * field to rename the book.
 *   --------------------------------------------------------------------------------------------
 *  | Book Index | Edit Author | Edit Title | Leave Editing Mode (Button) | Remove Book (Button) |
 *   --------------------------------------------------------------------------------------------
 *************************
 * 
 * @author MagnoGG
 * @since 28/04/2020 13:53
 */
public class BookPanel extends JPanel implements ActionListener, MouseListener
{
    private static final long serialVersionUID = 1L;

    private final DataBook parent;
    
    private final JLabel bookIndex;
    private final JLabel shownAuthor;
    private final JLabel shownTitle;
    
    private final JTextField newAuthor;
    private final JTextField newTitle;
    
    //Switch between edit and view mode
    private final JButton editBook;
    private void  editBookPressed()
    {
        if (editing)
        {
            editing= false;
            editBook.setText("Editar");
            
            newAuthor  .setVisible(false);
            newTitle   .setVisible(false);
            removeBook .setVisible(false);
            
            shownAuthor.setVisible(true);
            shownTitle .setVisible(true);            
            
            parent.editBook(
                newAuthor.getText(), 
                newTitle .getText(), 
                Integer  .valueOf(bookIndex.getText()) - 1);
        }
        else
        {
            editing= true;
            editBook.setText("Guardar");
            
            newAuthor  .setVisible(true);
            newTitle   .setVisible(true);
            removeBook .setVisible(true);
            
            shownAuthor.setVisible(false);
            shownTitle .setVisible(false);
            
            newAuthor.setText(shownAuthor.getText());
            newTitle .setText(shownTitle .getText());
        }
    }
    
    private final JButton removeBook;
    
    private boolean editing;
    
    public BookPanel(
            DataBook giveParent, 
            int giveIndex,
            String giveAuthor, 
            String giveTitle)
    {
        parent      = giveParent;
        bookIndex   = new JLabel(String.valueOf(giveIndex));
        shownAuthor = new JLabel(giveAuthor);
        shownTitle  = new JLabel(giveTitle);
        
        newAuthor   = new JTextField();
        newTitle    = new JTextField();
        
        editing     = false;
        
        editBook    = new JButton("Editar");
        removeBook  = new JButton("Borrar");
        
        this.addMouseListener(this);
        
        newAuthor .setVisible(false);
        newTitle  .setVisible(false);
        removeBook.setVisible(false);
        
        editBook  .addActionListener(this);
        removeBook.addActionListener(this);
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints gdc = new GridBagConstraints();
        gdc.fill               = GridBagConstraints.BOTH;
        gdc.anchor             = GridBagConstraints.EAST;
        gdc.weightx            = 1;
        
        this.add(bookIndex  , gdc);
        gdc.gridx   = 1;
        this.add(shownAuthor, gdc);
        this.add(newAuthor  , gdc);
        gdc.gridx   = 2;
        this.add(shownTitle , gdc);
        this.add(newTitle   , gdc);
        gdc.weightx = 0;
        gdc.gridx   = 3;
        this.add(editBook   , gdc);
        gdc.gridx   = 4;
        this.add(removeBook , gdc);
        
        refresh();
    }
    public void refresh()
    {
        setColor();
        
        editBook  .setFont(Configuration.getLetter());
        removeBook.setFont(Configuration.getLetter());
        
        bookIndex  .setFont(Configuration.getLetter());
        shownAuthor.setFont(Configuration.getLetter());
        shownTitle .setFont(Configuration.getLetter());
        newAuthor  .setFont(Configuration.getLetter());
        newTitle   .setFont(Configuration.getLetter());
        
        bookIndex  .setForeground(Configuration.getLetterColor());
        shownAuthor.setForeground(Configuration.getLetterColor());
        shownTitle .setForeground(Configuration.getLetterColor());
        newAuthor  .setForeground(Configuration.getLetterColor());
        newTitle   .setForeground(Configuration.getLetterColor());
    }
    
    private void setColor()
    {
        if (Integer.parseInt(bookIndex.getText())%2 == 0)
            this.setBackground(Configuration.getHighlightColor2());
        
        else
            this.setBackground(Configuration.getHighlightColor3());
    }
    
    @Override public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == editBook)
            this.editBookPressed();
        
        if (e.getSource() == removeBook)
            parent.removeBook(Integer.valueOf(bookIndex.getText()) - 1);
    }
    @Override public void mouseEntered   (MouseEvent e) 
    {
        this.setBackground(Configuration.getHighlightColor());
    }
    @Override public void mouseExited    (MouseEvent e) 
    {
        setColor();
    }
    
    @Override public void mouseClicked (MouseEvent e) {}
    @Override public void mousePressed (MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
}