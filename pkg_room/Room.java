package pkg_room;

import pkg_item.ItemList;
import pkg_item.Item;

import pkg_character.Personnage;
import pkg_character.PersonnageList;

//
import java.util.HashMap;
import java.util.Set;
 
/**
 * Classe Room - La Classe mère de tout les lieux du jeu
 * Possède différents méthodes pour créer et assigner différents paramètre pour les lieux.
 *
 * @author Richard Ho
 * 
 * @version 22.05.2023
 */
public class Room
{
    private String aName;
    private String aDescription;
    private String aImageName;
    private HashMap<String, Room> aExits;
    private ItemList aItems;
    
    private PersonnageList aPersonnageList;
        
    private ImageDirectionList aImageHash;
    
    /**
     * Constructeur naturel qui initialise une Room, une description et un HashMap associé au lieu.
     * @param pName, Le Nom du lieu.
     * @param pDescrip, Description du lieu en String.
     * @param pImageName, Le nom de l'image associé au lieu.
     * 
     */
    public Room(final String pName, final String pDescrip, String pImageName )
    {
        this.aName = pName;
        this.aDescription = pDescrip;
        this.aExits = new HashMap<String, Room>();
        this.aItems = new ItemList();
        this.aImageName = pImageName; //Inutile désormais ?
        
        this.aPersonnageList = new PersonnageList();
        
        this.aImageHash = new ImageDirectionList(pImageName);
    }//Room()
    
    //Accesseur et Modificateur :
    
    /**
     * Méthode qui retourne le nom du lieu courant en String.
     * @return String.
     */
    public String getName()
    {
        return this.aName;
    }//getName()
    
    /**
     * Fonction qui retourne la description du lieu courant en String.
     * @return String.
     */
    public String getDescription()
    {
        return this.aDescription;
    }//getDescription()
    
    /**
     * Fonction qui retourne la description et les directions possible du lieu courant.
     * @return String.
     */
    public String getLongDescription()
    {
        return this.getDescription() + "\n"+ "\n"+ this.getExitString() + "\n" + this.getItemsString() + "\n" + this.getPersonnageListString();
    }//getLongDescription()
    
    /**
     * Fonction qui retourne le lieu(Room) de la direction en paramètre.
     * @param pDirection une direction en String.
     * @return Room.
     */
    public Room getExit(final String pDirection)
    {
        return aExits.get(pDirection);
    }//getExit()
    
    /**
     * Méthode qui permet d'associer une direction et le lieu de la direction au lieu courant.
     * @param pDirection associe une direction possible en String.
     * @param pNext associe le lieu à la pDirection en Room.
     */
    public void setExit(final String pDirection, final Room pNext)
    {
        aExits.put(pDirection, pNext);
    }//setExit()
    
    /**
     * Fonction qui retourne le nom de l'image d'une Room.
     * @return String.
     */
    public String getImageName()
    {
        return this.aImageName;
    }//getImageName()
    
    //Image
    /**
     * Méthode qui retoune la liste d'image de la Room.
     * @return De type ImageDirectionList.
     */
    public ImageDirectionList getImageHashMap()
    {
        return this.aImageHash;
    }//getImageAndMap
    
    
    // Description du lieu :
    
    /**
     * Fonction qui retourne les différents directions/sorties possible du lieu courant en String.
     * 
     * @return String.
     */
    public String getExitString()
    {
        StringBuilder vSortieDispo = new StringBuilder("Les directions possible sont :");
        
        Set<String> keys = aExits.keySet();
        for(String exit : keys){
            vSortieDispo.append(" " + exit);
        }
        
        return vSortieDispo.toString();
    }//getExitString()
    
    // Partie Item :
    
    /**
     * Méthode qui permet d'enlever un Item présent sur le lieu courant.
     * @param pItemName, le nom de l'Item en String.
     */
    public void enleverItem(final String pItemName){
        this.aItems.enleverItem( pItemName );
    }//enleverItem()
    
    /**
     * Méthode qui permet d'ajouter un Item à une Room
     * @param pName, le nom de l'Item en String.
     * @param pItem, l'Item en Item.
     */
    public void ajouterItem(final String pName, final Item pItem)
    {
        this.aItems.ajouterItem(pName,pItem);
    }//setItem()
    
    /**
     * Méthode qui permet d'obtenir un Item avec son nom en String en paramètre.
     * @param pName, Le nom de l'Item qu'on veut obtenir en String.
     * @return Item.
     */
    public Item getItem(final String pName)
    {
        return this.aItems.getItem(pName);
    }//getItem()
    
    /**
     * Méthode pour obtenir une description de tout les items présent dans une pièce
     * @return String.
     */
    public String getItemsString()
    {
        StringBuilder vItemsDispo = new StringBuilder("Des objets sont présent ici :");
        
        Set<String> keys = this.aItems.keySetItem();
        for(String vObjet : keys){
            vItemsDispo.append(" " + vObjet);
        }
        
        return vItemsDispo.toString();
    }//getItemsString()
    
    //TrapRoom/Door
    
    /**
     * Méthode qui retourne un boléen selon si la room qu'on passe en paramètre est une sortie du lieu courant ou non.
     * @param pRoom, le lieu qu'on souhaite savoir si c'est une sortie du lieu courant.
     * @return true, si c'est bien une sortie du lieu courant. False sinon.
     */
    public boolean isExit( final Room pRoom )
    {
        return this.aExits.containsValue( pRoom );
    }//isExit()
    
    //Partie Personnage :
    
    /**
     * Méthode qui permet d'ajouter un personnage dans la Room
     * @param pName Le nom du personnage en String.
     * @param pPersonnage Le personnage de type Personnage.
     */
    public void ajouterPersonnage( final String pName, final Personnage pPersonnage)
    {
        this.aPersonnageList.ajouterPersonnage( pName, pPersonnage );
    }//ajouterPersonnage()
    
    /**
     * Méthode qui permet d'enlever un personnage dans la Room
     * @param pName Le nom du personnage en String.
     */
    public void enleverPersonnage( final String pName )
    {
        this.aPersonnageList.enleverPersonnage( pName );
    }//enleverPersonnage()
    
    /**
     * Méthode qui retourne le personnage de la room demandé en paramètre.
     * @param pName Le nom du personnage en String.
     * @return Le personnage de type Personnage.
     */
    public Personnage getPersonnage( final String pName )
    {
        return this.aPersonnageList.getPersonnage( pName );
    }//getPersonnage()
    
    /**
     * Méthode qui retourne la liste des personnages présent dans la Room.
     * @return String.
     */
    public String getPersonnageListString()
    {
        StringBuilder vPersoDispo = new StringBuilder("Des personnes sont présents ici :");
        
        Set<String> keys = this.aPersonnageList.keySetPersonnage();
        for(String vObjet : keys){
            vPersoDispo.append(" " + vObjet);
        }
        
        return vPersoDispo.toString();
    }//getPersonnageListString()

    /**
     * Méthode qui retourne la liste des personnages présent dann la Room
     * @return PersonnageList.
     */
    public PersonnageList getPersonnageList()
    {
        return this.aPersonnageList;
    }//getPersonnageList()
    
    /**
     * Méthode qui permet de savoir si le personnage mis en paramètre est-il présent ou non dans la Room
     * @param pName Le nom du personnage.
     * @return true si oui, false sinon.
     */
    public boolean contientPersonnage( final String pName )
    {
        return this.aPersonnageList.contientPersonnage( pName );
    }//contientPersonnage()
}// Room
