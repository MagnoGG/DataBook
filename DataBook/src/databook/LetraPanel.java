package databook;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Esta clase genera un panel que muestra la configuracion de la letra
 * 
 * @author MarMagnoGG
 * @since 11/05/2020 16:56
 * @version DataBook 2
 */
public class LetraPanel extends JPanel implements ActionListener, KeyListener{
    
    private final Font       defaultFont;
    private final JLabel     title;
    private final JLabel     letraDisplay;
    private final JComboBox  selectLetraType;
    private final JComboBox  selectLetraStyle;
    private final JTextField letraSize;
    
    public LetraPanel(String t, Font l){
        defaultFont      = l;
        title            = new JLabel(t + ": ");
        letraDisplay     = new JLabel("Este es un texto de ejemplo");
        selectLetraType  = new JComboBox();
        selectLetraStyle = new JComboBox();
        letraSize        = new JTextField("12");
        
        selectLetraType  .addActionListener(this);
        selectLetraStyle .addActionListener(this);
        
        selectLetraType.addItem("Predeterminado");   //0
        for (String c : GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames())
            selectLetraType.addItem(c);
        
        selectLetraStyle.addItem("Predeterminado");  //0
        selectLetraStyle.addItem("Negrita");         //1
        selectLetraStyle.addItem("Cursiva");         //2
        selectLetraStyle.addItem("Negrita cursiva"); //3
        
        letraDisplay.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        this.setBackground(Configuration.getBackgroundColor());
        
        this.setLayout(new GridLayout(1, 5));
        this.add(title);
        this.add(letraDisplay);
        this.add(selectLetraType);
        this.add(selectLetraStyle);
        this.add(letraSize);
        
        refresh();
    }
    public void refresh(){
        title            .setFont(Configuration.getLetra());
        letraDisplay     .setFont(Configuration.getLetra());
        selectLetraType  .setFont(Configuration.getLetra());
        selectLetraStyle .setFont(Configuration.getLetra());
        letraSize        .setFont(Configuration.getLetra());
        
        refreshLetraDisplay();
    }
    
    private void refreshLetraDisplay(){
        if (selectLetraType.getSelectedIndex() == 0)
            letraDisplay.setFont(defaultFont);
        try{
            letraDisplay.setFont(new Font(selectLetraType.getSelectedItem().toString(),
                selectLetraStyle.getSelectedIndex(), 
                Integer.parseInt(letraSize.getText()))); 
        }catch (java.lang.NumberFormatException e){
            JOptionPane.showMessageDialog(this          , 
                    "Debes introducir un valor numérico en el tamaño de la letra", 
                    "DataBook - Mensaje"                , 
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    @Override public void actionPerformed (ActionEvent e) {
        refreshLetraDisplay();        
    }
    @Override public void keyPressed      (KeyEvent e)    {
        if (e.getExtendedKeyCode() == 10){
            refreshLetraDisplay();
        }
    }
    
    @Override public void keyTyped        (KeyEvent e) {}
    @Override public void keyReleased     (KeyEvent e) {}
}
