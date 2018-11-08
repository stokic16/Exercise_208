

package bl;

import java.awt.Color;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Kilian Stöckler
 */
public class Clothing implements Serializable{
    
    private ClothingType clothType;
    private ClothingSize clothSize;
    private Color color;
    private transient Vendor vendor;

    public Clothing(ClothingType clothType, ClothingSize clothSize, Color color, Vendor vendor) {
        this.clothType = clothType;
        this.clothSize = clothSize;
        this.color = color;
        this.vendor = vendor;
    }
    
    private void readObject(ObjectInputStream ois) {
        try{
            ois.defaultReadObject();
            vendor = new Vendor(ois.readUTF(),ois.readUTF());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
        private void writeObject(ObjectOutputStream oos) {
        try {
               oos.defaultWriteObject();
               oos.writeUTF(vendor.getName());
               oos.writeUTF(vendor.getCountry());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ClothingSize getClothSize() {
        return clothSize;
    }

    public ClothingType getClothType() {
        return clothType;
    }

    public Color getColor() {
        return color;
    }

    public Vendor getVendor() {
        return vendor;
    }
    
    

}
