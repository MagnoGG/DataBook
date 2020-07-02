package databook;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Esta clase genera un panel para configurar la aplicacion
 * 
 * @author MarMagnoGG
 * @since 28/04/2020 13:53
 * @version DataBook 2
 */
class ConfigurationPanel extends JPanel{
    
    private final JLabel     colorConfiguration;
    private final ColorPanel background;
    private final ColorPanel resalte;
    private final ColorPanel resalte2;
    private final ColorPanel resalte3;
    
    private final JLabel     letraConfiguration;
    private final LetraPanel letra;
    private final ColorPanel letraColor;
    
    public ConfigurationPanel(){
        /*//Si hay archivo de configuracion
        if (Configuration.fileExists())
            Configuration.setConfiguration();
        else
            Configuration.setConfiguration(Configuration.readFileLine(0),
                                           Configuration.readFileLine(1),
                                           Configuration.readFileLine(2),
                                           Configuration.readFileLine(3),
                                           Configuration.readFileLine(4));
        */
        
        colorConfiguration = new JLabel("Color");
        
        background = new ColorPanel("Fondo", 
            Configuration.getDefaultBackgroundColor());
        
        resalte    = new ColorPanel("Resalte (al tocar)", 
            Configuration.getDefaultColorResalte());
        
        resalte2   = new ColorPanel("Resalte 1",
            Configuration.getDefaultColorResalte2());
        
        resalte3   = new ColorPanel("Resalte 2",
            Configuration.getDefaultColorResalte3());
        
        
        letraConfiguration= new JLabel("Letra");
        
        letra      = new LetraPanel("Letra: ", 
            Configuration.getDefaultLetra());
        
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
    public void refresh(){        
        colorConfiguration.setFont(Configuration.getLetra());
        letraConfiguration.setFont(Configuration.getLetra());
        
        background .refresh();
        resalte    .refresh();
        resalte2   .refresh();
        resalte3   .refresh();
        letra      .refresh();
        letraColor .refresh();
    }
    
    public void setConfiguration(){
        Configuration.setBackgroundColor(background.getColorSelected());
        Configuration.setColorResalte(resalte.getColorSelected());
        Configuration.setColorResalte2(resalte2.getColorSelected());
        Configuration.setColorResalte3(resalte3.getColorSelected());
        //Configuration.setLetraColor(letraColor.getColorSelected());
    }
}
