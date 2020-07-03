package databook;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Adds all the differents configurations to the main window
 * 
 ***************************
 * 
 * @author MagnoGG
 * @since 28/04/2020 13:53
 */
class ConfigurationPanel extends JPanel{
    private static final long serialVersionUID = 1L;
    
    private final JLabel     colorConfiguration;
    private final ColorPanel background;
    private final ColorPanel resalte;
    private final ColorPanel resalte2;
    private final ColorPanel resalte3;
    
    private final JLabel     letraConfiguration;
    private final LetterPanel letra;
    private final ColorPanel letraColor;
    
    public ConfigurationPanel()
    {        
        colorConfiguration = new JLabel("Color");
        
        background = new ColorPanel("Fondo", 
            Configuration.getDefaultBackgroundColor());
        
        resalte    = new ColorPanel("Resalte (al tocar)", 
            Configuration.getDefaultHighlightColor());
        
        resalte2   = new ColorPanel("Resalte 1",
            Configuration.getDefaultColorResalte2());
        
        resalte3   = new ColorPanel("Resalte 2",
            Configuration.getDefaultHighlightColor3());
        
        
        letraConfiguration= new JLabel("Letra");
        
        letra      = new LetterPanel("Letra: ", 
            Configuration.getDefaultLetter());
        
        letraColor = new ColorPanel("Color de la letra", null);
        
        this.setLayout(new GridBagLayout());
        
        GridBagConstraints gdc = new GridBagConstraints();
        gdc.insets             = new Insets(0, 60, 0, 50);
        gdc.anchor             = GridBagConstraints.PAGE_START;
        gdc.fill               = GridBagConstraints.NONE;
        
        this.add(colorConfiguration, gdc);
        gdc.gridy  = 1;
        gdc.insets = new Insets(0 , 50, 0, 50);
        
        this.add(background , gdc);
        gdc.gridy  = 2;
        this.add(resalte    , gdc);
        gdc.gridy  = 3;
        this.add(resalte2   , gdc);
        gdc.gridy  = 4;
        this.add(resalte3   , gdc);
        gdc.gridy = 5;
        this.add(letraConfiguration, gdc);
        gdc.gridy = 6;
        this.add(letraColor, gdc);
    }
    public void refresh()
    {        
        colorConfiguration.setFont(Configuration.getLetter());
        letraConfiguration.setFont(Configuration.getLetter());
        
        background .refresh();
        resalte    .refresh();
        resalte2   .refresh();
        resalte3   .refresh();
        letra      .refresh();
        letraColor .refresh();
    }
    
    public void setConfiguration()
    {
        Configuration.setBackgroundColor(background.getColorSelected());
        Configuration.setHighlightColor(resalte.getColorSelected());
        Configuration.setHighlightColor2(resalte2.getColorSelected());
        Configuration.setHighlightColor3(resalte3.getColorSelected());
        Configuration.setLetterColor(letraColor.getColorSelected());
    }
}
