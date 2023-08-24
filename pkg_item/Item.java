package pkg_item;

/**
 * Classe Item - Représente un objet dans le jeu.
 *
 * @author Richard Ho
 * @version 03/04/2023
 */
public class Item
{
    private String aItemName;
    private String aItemDescription;
    private int aItemWeight;
    
    /**
     * Constructeur naturel qui créer un objet Item avec ces différents attributs.
     * @param pItemName, le nom de l'Item en String.
     * @param pItemDescription, la description de l'Item en String.
     * @param pItemWeight, le poid de l'Item en int.
     */
    public Item(final String pItemName, final String pItemDescription, final int pItemWeight)
    {
        this.aItemName = pItemName;
        this.aItemDescription = pItemDescription;
        this.aItemWeight = pItemWeight;
    }//Item()
    
    /**
     * Méthode qui retourne le nom de l'Item.
     * @return String
     */
    public String getItemName()
    {
        return this.aItemName;
    }//getItemName()
    
    /**
     * Méthode qui retourne la description de l'Item.
     * @return String
     */
    public String getItemDescription()
    {
        return this.aItemDescription;
    }//getItemDescription()
    
    /**
     * Méthode qui retourne le poid de l'Item.
     * @return int
     */
    public int getItemWeight()
    {
        return this.aItemWeight;
    }//getItemWeight()
    
    /**
     * Méthode qui retourne une description complète de l'Item. (Nom, description + poid).
     * @return String
     */
    public String getLongItemDescription()
    {
        return "Il y a " + this.aItemName + ", " + this.aItemDescription + "\n" + "Poid de l'objet : " + this.aItemWeight;
    }//getLongItemDescription()
    
}//Item
