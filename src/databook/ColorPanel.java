package databook;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class generates a panel to select a color
 *   ---------------------------------------------------------------------------------
 *  | Information | Color Preview | Color Selector | Open Personalized Color Selector |
 *   ---------------------------------------------------------------------------------
 * 
 ***************************
 * 
 * @author MagnoGG
 * @since 11/05/2020 16:56
 */
public class ColorPanel extends JPanel implements ActionListener
{
    private static final long serialVersionUID = 1L;
    
    private final Color defaultColor;
    private final JLabel    title;
    private final JPanel    colorDisplay;
    private final JComboBox<String> selectColor;
    private final JButton   chooseColor;
    
    public ColorPanel(final String t, final Color c) {
        defaultColor = c;
        title = new JLabel(t + ": ");
        colorDisplay = new JPanel();
        selectColor = new JComboBox<>();
        chooseColor = new JButton("Seleccionar color");

        this.setBackground(Configuration.getBackgroundColor());

        chooseColor.addActionListener(this);
        selectColor.addActionListener(this);

        selectColor.addItem("Predeterminado"); // 0
        selectColor.addItem("Personalizado"); // 1
        selectColor.addItem("Negro"); // 2
        selectColor.addItem("Gris oscuro"); // 3
        selectColor.addItem("Gris"); // 4
        selectColor.addItem("Gris claro"); // 5
        selectColor.addItem("Blanco"); // 6
        selectColor.addItem("Rojo"); // 7
        selectColor.addItem("Magenta"); // 8
        selectColor.addItem("Rosa"); // 9
        selectColor.addItem("Naranja"); // 10
        selectColor.addItem("Amarillo"); // 11
        selectColor.addItem("Verde"); // 12
        selectColor.addItem("Azul"); // 13
        selectColor.addItem("Azul claro"); // 14

        colorDisplay.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.setLayout(new GridLayout(1, 4));
        this.add(title);
        this.add(colorDisplay);
        this.add(selectColor);
        this.add(chooseColor);

        chooseColor.setVisible(false);

        refresh();
    }

    public void refresh() {
        title.setFont(Configuration.getLetter());
        selectColor.setFont(Configuration.getLetter());
        chooseColor.setFont(Configuration.getLetter());
    }

    public Color getColorSelected() {
        return colorDisplay.getBackground();
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == chooseColor) {
            final ColorSelector selector = new ColorSelector();
            selector.setVisible(true);
        }
        if (e.getSource() == selectColor)
        {
            switch (selectColor.getSelectedIndex())
            {
                case 0:
                    colorDisplay.setBackground(defaultColor);
                    break;
                case 2:
                    colorDisplay.setBackground(Color.BLACK);
                    break;
                case 3:
                    colorDisplay.setBackground(Color.DARK_GRAY);
                    break;
                case 4:
                    colorDisplay.setBackground(Color.GRAY);
                    break;
                case 5:
                    colorDisplay.setBackground(Color.LIGHT_GRAY);
                    break;
                case 6:
                    colorDisplay.setBackground(Color.WHITE);
                    break;
                case 7:
                    colorDisplay.setBackground(Color.RED);
                    break;
                case 8:
                    colorDisplay.setBackground(Color.MAGENTA);
                    break;
                case 9:
                    colorDisplay.setBackground(Color.PINK);
                    break;
                case 10:
                    colorDisplay.setBackground(Color.ORANGE);
                    break;
                case 11:
                    colorDisplay.setBackground(Color.YELLOW);
                    break;
                case 12:
                    colorDisplay.setBackground(Color.GREEN);
                    break;
                case 13:
                    colorDisplay.setBackground(Color.BLUE);
                    break;
                case 14:
                    colorDisplay.setBackground(Color.CYAN);
                    break;
            }
        }
    }
}