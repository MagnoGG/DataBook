package databook;

import java.awt.Color;
import java.awt.Font;

/**
 * Store the user configuration (appareance)
 * 
 *************************
 * 
 * LETTER:
 *  · Font type (also bold and italic)
 *  · Letter foreground color
 *  To add:
 *  · Letter background color
 * 
 * COLOR:
 *  · Blackground color
 *  · Highlight color 1: when mouse touches
 *  · Highlight color 2: alternative color 1
 *  · Highlight color 3: alternative color 2
 * 
 *************************
 * 
 * @author MagnoGG
 * @since 06/05/2020 13:50
 */
public class Configuration 
{
    public static void setConfiguration(
        boolean verticalMenu       ,
        Font paramLetra            ,
        Color paramLetraColor      ,
        Color paramBackgroundColor ,
        Color paramColorResalte    ,
        Color paramColorResalte2   ,
        Color paramColorResalte3)
    {
        setLetter(paramLetra);
        setLetterColor(paramLetraColor);
        setBackgroundColor(paramBackgroundColor);
        setHighlightColor(paramColorResalte);
        setHighlightColor2(paramColorResalte2);
        setHighlightColor3(paramColorResalte3);
    }
    public static void setDefaultConfiguration()
    {
        setLetter          (getDefaultLetter());
        setLetterColor     (getDefaultLetterColor());
        setBackgroundColor (getDefaultBackgroundColor());
        setHighlightColor  (getDefaultHighlightColor());
        setHighlightColor2 (getDefaultColorResalte2());
        setHighlightColor3 (getDefaultHighlightColor3());
    }
    
    private static Font letter;
    public  static Font getLetter()
    {
        return letter;
    }
    public  static Font getDefaultLetter()
    {
        return new Font("Consolas", 0, 12);
    }
    public  static void setLetter(Font paramLetra)
    {
        letter = paramLetra;
    }
    
    private static Color letterColor;
    public  static Color getLetterColor()
    {
        return letterColor;
    }
    public  static Color getDefaultLetterColor()
    {
        return new Color (0, 0, 0);
    }
    public  static void  setLetterColor(Color c)
    {
        letterColor = c;
    }
    
    private static Color backgroundColor;
    public  static Color getBackgroundColor()
    {
        return backgroundColor;
    }
    public  static Color getDefaultBackgroundColor()
    {
        return new Color (255, 255, 255);
    }
    public  static void  setBackgroundColor(Color c)
    {
        backgroundColor = c;
    }
    
    private static Color highlightColor;
    public  static Color getHighlightColor()
    {
        return highlightColor;
    }
    public  static Color getDefaultHighlightColor()
    {
        return new Color(255, 0, 0);
    }
    public  static void  setHighlightColor(Color c)
    {
        highlightColor = c;
    }
    
    private static Color highlightColor2;
    public  static Color getHighlightColor2()
    {
        return highlightColor2;
    }
    public  static Color getDefaultColorResalte2()
    {
        return new Color(100, 100, 100);
    }
    public  static void  setHighlightColor2(Color c)
    {
        highlightColor2 = c;
    }
    
    private static Color highlightColor3;
    public  static Color getHighlightColor3()
    {
        return highlightColor3;
    }
    public  static Color getDefaultHighlightColor3()
    {
        return new Color (150, 150, 150);
    }
    public  static void  setHighlightColor3(Color c)
    {
        highlightColor3 = c;
    }
}