package exercise_208.gui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import bl.Clothing;
import bl.ClothingSize;
import bl.ClothingType;

/**
 * @author Kilian Stöckler
 */
public class CellRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        label.setOpaque(true);
        Clothing cloth = null;
        if (value instanceof Clothing) {
            cloth = (Clothing) value;
        }

        if (isSelected) {
            label.setBackground(Color.darkGray);
            label.setForeground(Color.white);
        }

        try {
            switch (column) {
                case 0:
                    label.setText(cloth.getClothType().name());
                    break;
                case 1:
                    label.setBackground(cloth.getColor());
                    break;
                case 2:
                    label.setText(cloth.getClothSize().name());
                    break;
                case 3:
                    label.setText(cloth.getVendor().toString());
                    break;
                default: 
                    
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return label;
    }

}
