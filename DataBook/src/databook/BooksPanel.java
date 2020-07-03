package databook;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Panel which shows all the BookPanels.
 * 
 ***************************
 * 
 * @author MagnoGG
 * @since 28/04/2020 13:25
 */
public class BooksPanel extends JScrollPane
{
    private static final long serialVersionUID = 1L;
    
    private final JPanel panel;
    private final JTextArea advice;
    private final DataBook  parent;
    
    public BooksPanel(DataBook parent)
    {
        this.panel  = new JPanel();
        this.advice = new JTextArea();
        this.parent = parent;
        
        advice.setText("        No hay ningún libro guardado.\n¡Pruebe a añadir uno desde la barra de abajo!");
        advice.setEditable(false);
        
        panel.setLayout(new GridBagLayout());
        
        this.setViewportView(panel);
        
        refresh();
    }
    public void refresh()
    {
        GridBagConstraints gdc= new GridBagConstraints();
        
        advice.setFont(Configuration.getLetter());
        advice.setBackground(Configuration.getBackgroundColor());
        advice.setForeground(Configuration.getLetterColor());
        panel .setBackground(Configuration.getBackgroundColor());
        
        if (parent.getStoredBooks().isEmpty())
        {
            panel.removeAll();
            panel.add(advice, gdc);
        }
        else
        {
            //Clear the panel
            panel.removeAll();
            int c = 0;
            
            //Redisplay the components
            gdc.anchor  = GridBagConstraints.PAGE_START;
            gdc.fill    = GridBagConstraints.HORIZONTAL;
            gdc.weightx = 1;
            gdc.weighty = 1;
            
            gdc.insets  = new Insets(0, 30, 0, 30);
            
            for (Book b : parent.getStoredBooks())
            {
                gdc.gridwidth = c - 1;
                gdc.gridy     = c;
                
                panel.add(new BookPanel(
                    parent,
                    ++c,
                    b.getAuthor(),
                    b.getTitle()),
                    gdc);
            }
        }
        this.paintAll(this.getGraphics());
    }
}