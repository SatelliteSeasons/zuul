package pkg_system;

import pkg_room.Room;

import pkg_item.ItemList;
import pkg_item.Item;
import pkg_item.Beamer;

import java.util.Stack;


/**
 * Classe Player - Représente le joueur, les différents caractéristique qu'il possède. Tel que le lieu
 * actuel où il se trouve, ou bien son inventaire.
 *
 * @author Richard Ho
 * @version 22/05/2023
 */
public class Player
{
    private Room aCurrentRoom;
    private Stack<Room> aBackRoom;
    private ItemList aInvItems;
    
    private int aPoidMax;
    private int aPoid;
    
    private int aActionMax;
    private int aAction;
    private boolean aTimeMode;
    
    private String aDirection;

    /**
     * Contructeur qui déclare et initialise les attributs du joueur.
     */
    public Player()
    {
        this.aBackRoom = new Stack<Room>();
        this.aInvItems = new ItemList();
        this.aPoidMax = 100;
        this.aPoid = 0;
        this.aActionMax = 5;
        this.aAction = 0;
        this.aTimeMode = false;
        
        this.aDirection = "N";
    }//Player()
    
    // Acesseur et modificateur :
    
    //Room
    /**
     * Méthode qui retourne la Room actuel où se trouve le joueur.
     * @return Room.
     */
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;
    }//getCurrentRoom()
    
    /**
     * Méthode qui retourne le nom de la Room actuel où se trouve le joueur.
     * @return String.
     */
    public String getCurrentRoomName()
    {
        return this.aCurrentRoom.getName();
    }//getCurrentRoomName()
    
    /**
     * Méthode qui permet de changer la Room actuel du joueur.
     * @param pRoom, le lieu en Room.
     */
    public void setCurrentRoom( final Room pRoom )
    {
        this.aCurrentRoom = pRoom;
    }//setCurrentRoom()
    
    /**
     * Méthode qui retourne un booléen selon si le joueur est passé par des lieux juste avant.
     * @return true, si on ne peut pas revenir sur nos pas. False sinon
     */
    public boolean backRoomEmpty()
    {
        return this.aBackRoom.empty();
    }//backRoomEmpty()
    
    /**
     * Méthode qui permet renvoyer la dernière Room que le joueur viens de traverser.
     * @return Room.
     */
    public Room backRoomPeek()
    {
        return this.aBackRoom.peek();
    }//backRoomPeek()
    
    //Inventaire
    
    /**
     * Méthode permettant d'enlever un Item et son poid de l'inventaire du joueur.
     * @param pNameItem, le nom de l'Item en String.
     */
    public void enleverItemEtPoid( final String pNameItem )
    {
        this.aPoid -= this.aInvItems.getItem( pNameItem).getItemWeight();
        this.aInvItems.enleverItem(pNameItem);
    }//enleverItemEtPoid()
    
    /**
     * Méthode permettant de retourner différent Item selon le nom donné en paramètre.
     * @param pName, le nom de l'Item qu'on souhaite retourner.
     * @return Item.
     */
    public Item getInvItem( final String pName )
    {
        return this.aInvItems.getItem( pName );
    }//getInvItem()
    
    //Poid
    
    /**
     * Méthode pour changer le poid du joueur.
     * @param pPoid en int.
     */
    public void setPoid( final int pPoid )
    {
        this.aPoid = pPoid;
    }//setPoid()
    
    /**
     * Méthode permettant d'ajouter du poid au joueur.
     * @param pPoid en int, le nombre qu'on souhaite ajouter.
     */
    public void ajouterPoid( final int pPoid )
    {
        this.aPoid += pPoid;
    }//ajouterPoid()
    
    /**
     * Méthode pour enlever du poid au joueur
     * @param pPoid en int.
     */
    public void enleverPoid( final int pPoid )
    {
        this.aPoid -= pPoid;
    }//enleverPoid()
    
    /**
     * Méthode qui retourne le nombre de poid du joueur.
     * @return int
     */
    public int getPoid()
    {
        return this.aPoid;
    }//getPoid()
    
    //PoidMax
    
    /**
     * Méthode permettant d'obtenir le poid max transportable du joueur.
     * @return int
     */
    public int getPoidMax()
    {
        return this.aPoidMax;
    }//getPoidMax()
    
    /**
     * Méthode permettant de doubler le poid max transportable du joueur
     */
    public void doublePoidMax()
    {
        this.aPoidMax = this.aPoidMax*2;
    }//doublePoidMax()
    
    //Timer
    
    /**
     * Méthode permettant de modifier le nombre d'action maximum pouvant être effectué lors d'un Timer.
     * @param pNombre en int
     */
    public void setActionMax( final int pNombre )
    {
        this.aActionMax = pNombre;
    }//setActionMax()
    
    /**
     * Méthode qui retourne le nombre d'action maximum pouvant être effectué lors d'un Timer.
     * @return int.
     */
    public int getActionMax()
    {
        return this.aActionMax;
    }//getActionMax()
    
    /**
     * Méthode permettant de modifier le nombre d'action effectué lors d'un Timer.
     * @param pNombre int
     */
    public void setAction( final int pNombre )
    {
        this.aAction = pNombre;
    }//setAction()
    
    /**
     * Méthode qui retourne le nombre d'acction effectué du joueur lors d'un Timer.
     * @return int
     */
    public int getAction()
    {
        return this.aAction;
    }//getAction()
    
    /**
     * Méthode qui ajoute un action en plus au nombre d'action effectué par le joueur lors d'un Timer.
     */
    public void plusUnAction()
    {
        this.aAction += 1;
    }//plusUnAction()
    
    /**
     * Méthode permettant d'activer pour non le mode Timer.
     * @param pActive, true si on souhaite activer le mode Timer. False sinon.
     */
    public void setTimeMode( final boolean pActive )
    {
        this.aTimeMode =  pActive;
    }//setTimeMode()
    
    /**
     * Méthode qui retourne l'état du mode Timer.
     * @return true, si le mode est activé. False sinon.
     */
    public boolean getTimeMode()
    {
        return this.aTimeMode;
    }//getTimeMode()
    
    //Direction
    
    /**
     * Méthode qui retourne la direction du joueur.
     * @return N pour North/Nord, E pour Est, W pour West/Ouest et S pour South/Sud.
     */
    public String getDirection()
    {
        return this.aDirection;
    }//getDirection()
    
    /**
     * Méthode pour modifier la direction du joueur
     * @param pDirection La direction qu'on souhaite que le joueur regarde actuellement.
     */
    public void setDirection( final String pDirection)
    {
        this.aDirection = pDirection;
    }//setDirection()
    
    
    //Méthode :
    
    //Inventaire
    
    /**
     * Méthode qui permer d'ajouter un Item à l'inventaire du joueur.
     * @param pNameItem, le nom de l'Item qu'on souhaite ajouter en String.
     * @return retourne un String, qui décrit différent situation pour d'autre instruction.
     */
    public String ajouterInvItem(final String pNameItem)
    {
        if(this.aCurrentRoom.getItem( pNameItem ) == null){
            return "inexistance";
        }else{
            int vPoid = this.aCurrentRoom.getItem( pNameItem ).getItemWeight();
            if( this.aPoid + vPoid <= this.aPoidMax){
                Item vObjet = this.aCurrentRoom.getItem( pNameItem );
                this.aInvItems.ajouterItem( pNameItem, vObjet);
                this.aPoid += vPoid;
                this.aCurrentRoom.enleverItem( pNameItem );
                return "ok";
            }else{
                return "lourd";
            }
        }
    }//ajouterInvItem()
    
    /**
     * Méthode permettant d'enlever un Item de l'inventaire et de le poser dans la Room actuel où se trouve
     * le joueur
     * @param pNameItem, le nom de l'Item qu'on souhaite enlever de l'inventaire
     * @return retourne un String, qui décrit différent situation pour d'autre instruction.
     */
    public String enleverInvItem(final String pNameItem )
    {
        if( this.aInvItems.contientItem(pNameItem) ){
            Item vObjet = this.aInvItems.getItem( pNameItem );
            int vPoid = vObjet.getItemWeight();
            this.aCurrentRoom.ajouterItem( pNameItem, vObjet);
            this.aInvItems.enleverItem( pNameItem);
            this.aPoid -= vPoid;
            return "ok";
        }else{
            return "inexistance";
        }
    }//enleverInvItem()
    
    /**
     * Méthode qui retourne l'inventaire du joueur, la liste des Items posséder et le poid actuel du joueur.
     * @return String.
     */
    public String inventaireString()
    {
        return "Les objets que je possède :" + this.aInvItems.itemsString() + " | Poid total : " + this.aPoid + "/" + this.aPoidMax;
    }//inventaireString()
    
    /**
     * Méthode qui retourne un booléen selon si le nom de l'Item passé en paramètre est présent ou non dans l'inventaire
     * du joueur
     * @param pNameItem, le nom de l'Item
     * @return true, si l'Item est bien présent dans l'inventaire. False sinon.
     */
    public boolean contientItem( final String pNameItem )
    {
        return this.aInvItems.contientItem( pNameItem );
    }//contientItem()
    
    //CurrentRoom
    
    /**
     * Méthode qui permet de changer la room actuel du joueur et de le faire déplacer selon la direction donnée.
     * @param pDirection, la direction que le joueur veut aller en String.
     * @return true, si le joueur a pu se déplacer. False sinon
     */
    public boolean goRoom( final String pDirection )
    {
        Room vNextRoom = this.aCurrentRoom.getExit( pDirection );
        if(vNextRoom == null){
            return false;
        }else{
            this.aBackRoom.push(this.aCurrentRoom);
            this.aCurrentRoom = vNextRoom;
            return true;
        }
    }//goRoom()
    
    //Timer
    
    /**
     * Méthode qui retourne un booléen selon si le temps est écoulé durant le mode Timer.
     * @return true si le temps est écoulé. False sinon.
     */
    public boolean timeUp()
    {
        if(this.aAction >= this.aActionMax){
            return true;
        }else{
            return false;
        }
    }//timeUp()
    
    //Beamer
    
    /**
     * Méthode qui permet de charger un Beamer et de mémoriser le lieu où se trouve le joueur.
     * @return retourne un String, qui décrit différent situation pour d'autre instruction.
     */
    public String chargerBeamer()
    {
        if( this.contientItem("beamer") ){
            Beamer vBeamer = (Beamer)this.getInvItem("beamer");
            vBeamer.charger( this.aCurrentRoom );
            return "ok";
        }else{
            return "inexistance";
        }
    }//chargerBeamer()
    
    /**
     * Méthode qui permet d'aller dans le lieu où le Beamer a mémorisé si il a mémorisé une Room.
     * @return retourne un String, qui décrit différent situation pour d'autre instruction.
     */
    public String tirerBeamer()
    {
        if( this.contientItem("beamer") ){
            Beamer vBeamer = (Beamer)this.getInvItem("beamer");
            if( !(vBeamer.getCharge() == null) ){
                this.setCurrentRoom( vBeamer.tirer() );
                return "ok";
            }else{
                return "unknown";
            }
        }else{
            return "inexistance";
        }
    }//tirerBeamer()
    
    /**
     * Méthode qui retourne un booléen selon si le Beamer a actuellement mémoriser ou non une Room.
     * @return true, si le Beamer a mémorisé une Room. False sinon.
     */
    public boolean beamerEstCharger()
    {
        if( this.contientItem("beamer") ){
            Beamer vBeamer = (Beamer)this.getInvItem("beamer");
            return vBeamer.estCharger();
        }else{
            return false;
        }
    }//beamerEstCharger()
    
    //BackRoom
    
    /**
     * Méthode qui permet de revenir sur ces pas.
     */
    public void back()
    {
        this.aCurrentRoom = this.aBackRoom.pop();
    }//back()
    
    
    //ChangementDirection
    /**
     * Méthode qui change la direction du joueur de manière logique lorsqu'il tourne vers la droite.
     */
    public void DirectionDroite()
    {
        switch( this.aDirection ) {
            case "N" :
                this.aDirection = "E";
                break;
            case "E" :
                this.aDirection = "S";
                break;
            case "S" :
                this.aDirection = "W";
                break;
            case "W" :
                this.aDirection = "N";
                break;
            default :
                System.out.println("Alors là, il y a une erreur, j'arrive pas à changer la caméra Direction du joueur ?");
                break;
        }
    }//DirectionDroite()
    
    /**
     * Méthode qui change la direction du joueur de manière logique lorsqu'il tourne vers la gauche.
     */
    public void DirectionGauche()
    {
        switch( this.aDirection ) {
            case "N" :
                this.aDirection = "W";
                break;
            case "E" :
                this.aDirection = "N";
                break;
            case "S" :
                this.aDirection = "E";
                break;
            case "W" :
                this.aDirection = "S";
                break;
            default :
                System.out.println("Alors là, il y a une erreur, j'arrive pas à changer la caméra Direction du joueur ?");
                break;
        }
    }//DirectionGauche()
    
    /**
     * Méthode qui change la direction du joueur de manière logique lorsqu'il se retourne.
     */
    public void DirectionDerriere()
    {
        switch( this.aDirection ) {
            case "N" :
                this.aDirection = "S";
                break;
            case "E" :
                this.aDirection = "W";
                break;
            case "S" :
                this.aDirection = "N";
                break;
            case "W" :
                this.aDirection = "E";
                break;
            default :
                System.out.println("Alors là, il y a une erreur, j'arrive pas à changer la caméra Direction du joueur ?");
                break;
        }
    }//DirectionDerriere()
    
    /**
     * Méthode qui permet de renvoyer sous forme de string la direction sous forme de mot complet.
     * @return La direction, nord, est, sud, ouest/
     */
    public String DirectionPlayer()
    {
        switch( this.aDirection ) {
            case "N" :
                return "nord";
            case "E" :
                return "est";
            case "S" :
                return "sud";
            case "W" :
                return "ouest";
            default :
                System.out.println("Alors là, il y a une erreur, j'arrive pas à changer la caméra Direction du joueur ?");
                return "O";
        }
    }//DirectionPlayer()
}//Player
