package pkg_item;


import java.util.HashMap;
import java.util.Set;
import java.util.Collection;

/**
 * Classe ItemList - Permet de créer, de modifier et d'accéder à la liste d'Item.
 *
 * @author Richard Ho
 * @version 03/04/2023
 */
public class ItemList
{
    private HashMap<String, Item> aItemList;
    
    /**
     * Constructeur qui permet de déclarer une liste de valeur d'Item sous forme de HashMap avec leur clé en String.
     */
    public ItemList()
    {
        this.aItemList = new HashMap<String, Item>();
    }//ItemList()
    
    /**
     * Méthode pour ajouter un Item dans la liste de l'objet courant.
     * @param pNameItem, est le nom/clé de l'Item.
     * @param pItem, l'Item qu'on souhaite intégrer dans la liste.
     */
    public void ajouterItem( final String pNameItem , final Item pItem )
    {
        this.aItemList.put( pNameItem, pItem );
    }//ajouterItem()
    
    /**
     * Méthode pour enlever un Item dans la liste de l'objet courant.
     * @param pNameItem, le nom/clé de l'Item.
     */
    public void enleverItem( final String pNameItem )
    {
        this.aItemList.remove( pNameItem );
    }//enleverItem()
    
    /**
     * Méthode qui retourne l'Item de la liste lorsqu'on donne le nom/clé de celui-ci.
     * @param pNameItem, le nom/clé de l'Item.
     * @return l'Item selon le nom/clé donné en paramètre.
     */
    public Item getItem( final String pNameItem )
    {
        return this.aItemList.get( pNameItem );
    }//getItem()
    
    /**
     * Méthode qui retourne un booléen selon si la liste de l'objet courant est vide ou non.
     * @return true, si l'objet courant, possède une liste vide.
     */
    public boolean empty()
    {
        return this.aItemList.isEmpty();
    }//empty()
    
    /**
     * Méthode qui retourne un booléen selon si la liste contient ou non le nom de l'Item passé en paramètre.
     * @param pNameItem, le nom de l'Item en String qu'on souhaite savoir si il se trouve dans la liste.
     * @return true, si l'Item est bien présent.
     */
    public boolean contientItem( final String pNameItem )
    {
        return this.aItemList.containsKey( pNameItem );
    }//contientItem()
    
    /**
     * Méthode qui retourne un ensemble de String, qui représente tout les noms des Items de la liste de l'objet courant.
     * @return Un ensemble de String (Set de type String).
     */
    public Set<String> keySetItem()
    {
        return this.aItemList.keySet();
    }//keySetItem()
    
    /**
     * Méthode qui retourne la liste des Items présent dans la liste de l'objet courant sous forme de String.
     * @return String
     */
    public String itemsString()
    {
        String vInventaire = "";
        for( Item vObjet : this.aItemList.values() )
        {
            vInventaire += " " + vObjet.getItemName() + ",";
        }
        return vInventaire;
    }//itemsString()
}//ItemList
