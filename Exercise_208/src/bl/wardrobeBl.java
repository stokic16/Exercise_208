package bl;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 * @author Kilian Stöckler
 */
public class wardrobeBl extends AbstractTableModel {

    private ArrayList<Clothing> cloths = new ArrayList<>();
    private String[] names = {"TYPE", "COLOR", "SIZE", "VENDOR"};

    public void add(Clothing cloth) {
        cloths.add(cloth);
        fireTableRowsInserted(cloths.size(), cloths.size());
    }

    public void load(File f) throws FileNotFoundException, IOException, ClassNotFoundException {
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Clothing c = null;
            while ((c = (Clothing) ois.readObject()) != null) {
                cloths.add(c);
            }
            fis.close();
            fireTableRowsUpdated(0, cloths.size());
        }catch(EOFException e){
            
        }

    }

    public void save(File f) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Clothing cloth : cloths) {

            oos.writeObject(cloth);
        }

    }

    public void change(int idx, Clothing cloth) {
        cloths.set(idx, cloth);
        fireTableRowsUpdated(idx, idx);
    }

    @Override
    public int getRowCount() {
        return cloths.size();
    }

    @Override
    public String getColumnName(int column) {
        return names[column];
    }

    @Override
    public int getColumnCount() {
        return names.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return cloths.get(rowIndex);
    }

}
