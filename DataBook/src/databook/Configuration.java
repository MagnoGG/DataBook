package databook;

import java.awt.Color;
import java.awt.Font;

/**
 * Esta clase guarda los datos de configuracion del usuario
 * (Apariencia)
 * 
 * @author MarMagnoGG
 * @since 06/05/2020 13:50
 * @version DataBook 2
 */
public class Configuration {
    
    public static void setConfiguration(boolean verticalMenu       ,
                                        Font paramLetra            ,
                                        Color paramLetraColor      ,
                                        Color paramBackgroundColor ,
                                        Color paramColorResalte    ,
                                        Color paramColorResalte2   ,
                                        Color paramColorResalte3)
                                                {
        setLetra(paramLetra);
        setLetraColor(paramLetraColor);
        setBackgroundColor(paramBackgroundColor);
        setColorResalte(paramColorResalte);
        setColorResalte2(paramColorResalte2);
        setColorResalte3(paramColorResalte3);
    }
    public static void setDefaultConfiguration(){
        setLetra          (getDefaultLetra());
        setLetraColor     (getDefaultLetraColor());
        setBackgroundColor(getDefaultBackgroundColor());
        setColorResalte   (getDefaultColorResalte ());
        setColorResalte2  (getDefaultColorResalte2());
        setColorResalte3  (getDefaultColorResalte3());
    }
    
    //TODO: private static boolean resalteColor;
    
    private static Font letra;
    public  static Font getLetra()                   {
        return letra;
    }
    public  static Font getDefaultLetra()            {
        return new Font("Consolas", 0, 12);
    }
    public  static void setLetra(Font paramLetra)    {
        letra= paramLetra;
    }
    
    private static Color letraColor;
    public  static Color getLetraColor()             {
        return letraColor;
    }
    public  static Color getDefaultLetraColor()      {
        return new Color (0, 0, 0);
    }
    public  static void  setLetraColor(Color c)      {
        letraColor= c;
    }
    
    private static Color backgroundColor;
    public  static Color getBackgroundColor()        {
        return backgroundColor;
    }
    public  static Color getDefaultBackgroundColor() {
        return new Color (255, 255, 255);
    }
    public  static void  setBackgroundColor(Color c) {
        backgroundColor= c;
    }
    
    private static Color colorResalte;
    public  static Color getColorResalte()           {
        return colorResalte;
    }
    public  static Color getDefaultColorResalte()    {
        return new Color(255, 0, 0);
    }
    public  static void  setColorResalte(Color c)    {
        colorResalte= c;
    }
    
    private static Color colorResalte2;
    public  static Color getColorResalte2()          {
        return colorResalte2;
    }
    public  static Color getDefaultColorResalte2()   {
        return new Color(100, 100, 100);
    }
    public  static void  setColorResalte2(Color c)   {
        colorResalte2= c;
    }
    
    private static Color colorResalte3;
    public  static Color getColorResalte3()          {
        return colorResalte3;
    }
    public  static Color getDefaultColorResalte3()   {
        return new Color (150, 150, 150);
    }
    public  static void  setColorResalte3(Color c)   {
        colorResalte3= c;
    }
    
}
