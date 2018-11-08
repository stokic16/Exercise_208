

package bl;

/**
 * @author Kilian Stöckler
 */
public class Vendor {
    
    private String name;
    private String country;

    public Vendor(String name, String country) {
        this.name = name;
        this.country = country;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", name,country);
    }

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }
    
    

}
