package databook;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Esta clase es un panel que mostrara los paneles con cada
 * libro individualmente
 * 
 * @author MarMagnoGG
 * @since 28/04/2020 13:25
 * @version DataBook 2
 */
public class BooksPanel extends JScrollPane{
    
    private final JPanel    panel;
    private final JTextArea advice;
    private final DataBook  parent;
    
    public BooksPanel(DataBook parent){
        
        this.panel  = new JPanel();
        this.advice = new JTextArea();
        this.parent = parent;
        
        advice.setText("        No hay ningún libro guardado.\n¡Pruebe a añadir uno desde la barra de abajo!");
        advice.setEditable(false);
        
        panel.setLayout(new GridBagLayout());
        
        this.setViewportView(panel);
        
        refresh();
    }
    public void refresh(){
        
        GridBagConstraints gdc= new GridBagConstraints();
        
        advice.setFont(Configuration.getLetra());
        advice.setBackground(Configuration.getBackgroundColor());
        advice.setForeground(Configuration.getLetraColor());
        
        panel.setBackground(Configuration.getBackgroundColor());
        
        if (parent.getStoredBooks().isEmpty()){
            panel.removeAll();
            panel.add(advice, gdc);
        
        }else{
            //Limpiamos todo lo que tenemos
            panel.removeAll();
            int contador= 0;
            
            gdc.anchor  = GridBagConstraints.PAGE_START;
            gdc.fill    = GridBagConstraints.HORIZONTAL;
            gdc.weightx = 1;
            gdc.weighty = 1;
            
            gdc.insets  = new Insets(0, 30, 0, 30);
            
            //Volvemos preparar todo
            for (Book b : parent.getStoredBooks()){
                gdc.gridwidth= contador - 1;
                gdc.gridy = contador;
                
                panel.add(new BookPanel(parent, 
                                    ++contador,
                                 b.getAuthor(),
                                 b.getTitle()),
                                          gdc);
            }
        }
        this.paintAll(this.getGraphics());
    }
}
