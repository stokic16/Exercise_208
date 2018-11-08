/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

/**
 *
 * @author kilia
 */
public enum ClothingSize {
    
    XXS("very very small"), XS("very small"), S("small"), M("medium"),L("large"),XL("very large"),XXL("elephant"),XXXL("whale");
    String text;

    private ClothingSize(String text) {
        this.text = text;
    }
    
    
    
    
}
