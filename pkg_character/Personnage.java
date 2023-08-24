package pkg_character;

import pkg_item.ItemList;
import pkg_item.Item;

import pkg_room.Room;

import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

import java.util.ArrayList;

/**
 * Classe Personnage - Classe qui permet de créer des personnages non jouable dans le jeu qui possède différent caractéristiques.
 *
 * @author Richard Ho
 * @version 22/05/2023
 */
public class Personnage
{
    private String aName;
    private boolean aFirstTalk;
    private ArrayList<Item> aNeedItem;
    
    private Room aCurrentRoom;
    
    private int aSituation; // 0=Personnage qui bouge jamais  , 1= Special personnage
    private boolean aSuccess;
    private boolean aSpecial;
    
    private boolean aEndGame;
    
    private ArrayList<Room> aRoom;
    

    /**
     * Constructeur d'objets de classe Character
     * @param pName Le nom du personnage en String
     * @param pSpecial Permet de définir si le personnage est spécial ou non en booléen (Permet ou non des déplacement).
     */
    public Personnage( final String pName, final boolean pSpecial )
    {
        this.aName = pName;
        this.aFirstTalk = false;
        this.aSuccess = false;
        this.aEndGame = false;
        this.aNeedItem = new ArrayList<Item>();
        this.aSpecial = pSpecial;
        if(pSpecial){
            this.aSituation = 1;
        }else{
            this.aSituation = 0;
        }
    }//Personnage()
    
    //a Name
    /**
     * Méthode qui retourne le nom du Personnage
     * @return String.
     */
    public String getName()
    {
        return this.aName;
    }//getName()
    
    //a FirstTalk
    /**
     * Méthode qui permet de définir si le personnage va initialer la conversation lorsqu'on rentre dans une Room.
     * @param pFirstTalk en boléen, true si oui, false sinon.
     */
    public void setFirstTalk( final boolean pFirstTalk )
    {
        this.aFirstTalk = pFirstTalk;
    }//setFirstTalk()
    
    /**
     * Méthode qui retourne si le personnage initie ou non la conversation lorsqu'on rentre dans une Room
     * @return true si oui, false sinon.
     */
    public boolean getFirstTalkBoolean()
    {
        return this.aFirstTalk;
    }//getFirstTalkBoolean()
    
    //a NeedItem

    /**
     * Méthode qui permet d'ajouter un Item que le personnage veut.
     * @param pItem L'item en Item.
     */
    public void ajouterNeedItem(final Item pItem )
    {
        this.aNeedItem.add(pItem);
    }//ajouterNeedItem()
    
    /**
     * Méthode qui permet d'enlever un Item que le personnage veut;
     * @param pName L'item en Item.
     */
    public void enleverNeedItem( final Item pName )
    {
        this.aNeedItem.remove( pName );
    }//enleverNeedItem()
    
    /**
     * Méthode qui permet de savoir si l'Item en paramètre est bien un Item que le personnage veut actuellement ou non.
     * @param pName l'item en Item.
     * @return true si oui, false sinon.
     */
    public boolean contientNeedItem( final Item pName )
    {
        return this.aNeedItem.contains( pName );
    }//contientNeedItem()
    
    //a CurrentRoom
    /**
     * Méthode qui permet d'associer une room au personnage.
     * @param pRoom Le lieu en Room.
     */
    public void setCurrentRoom( final Room pRoom )
    {
        this.aCurrentRoom = pRoom;
        pRoom.ajouterPersonnage( this.aName, this );
    }//setCurrentRoom()
    
    /**
     * Méthode qui permet d'associer une nouvelle room au personnage et de surprimer l'ancienne.
     * @param pRoom Le lieu en Room.
     */
    public void setCurrentRoomUpdate( final Room pRoom )
    {
        this.aCurrentRoom.enleverPersonnage(this.aName);
        this.setCurrentRoom( pRoom );
    }//setCurrentRoomUpdate()
    
    //a Moving
    
    //a Liste Room
    /**
     * Méthode qui associe la liste des rooms que le personnage peut se déplacer.
     * @param pRoom La liste des Room en ArrayList.
     */
    public void setListRoom( final ArrayList<Room> pRoom )
    {
        this.aRoom = pRoom;
    }//setListRoom()
    
    
    //methode
    /**
     * Méthode qui permet de retourner le dialogue du personnage lorsqu'il initie la conversation selon différent situation.
     * @return Le dialogue en String
     */
    public String getFirstTalkString()
    {
        Scanner vFile;
        String vPathFile = "Dialogues/" + this.aName + "_firstTalk"; //Le fichier semble confondre les majuscule et minuscule.
        if(this.aSituation>1){
            vPathFile += "_" + this.aSituation + ".txt";
        }else{
            vPathFile += ".txt";
        }
        
        try{
            vFile = new Scanner( new File( vPathFile) );
            String vDialogue = this.aName + " :";
            while(vFile.hasNextLine() ){ //Tant qu'il y a une ligne à lire
                String vLigne = vFile.nextLine(); 
                vDialogue += " " + vLigne;
            }
            vFile.close();
            return vDialogue;
        }catch(final FileNotFoundException pFNFE){
            return "Erreur, dialogue non-trouvé";
        }
    }//getFirstTalkString()
    
    /**
     * Méthode qui permet de retourner le dialogue du personnage lorsqu'on lui parle selon différent situation.
     * @return Le dialogue en String
     */
    public String talkString()
    {
        Scanner vFile;
        String vPathFile = "Dialogues/" + this.aName + "_talk";
        if(this.aSituation>1){
            vPathFile += "_" + this.aSituation + ".txt";
        }else{
            if(this.aSuccess){
                vPathFile += "0" + ".txt";
            }else{
                vPathFile += ".txt";
            }
        }
        
        try{
            vFile = new Scanner( new File( vPathFile) );
            String vDialogue = this.aName + " :";
            while(vFile.hasNextLine() ){ //Tant qu'il y a une ligne à lire
                String vLigne = vFile.nextLine(); 
                vDialogue += " " + vLigne;
            }
            vFile.close();
            return vDialogue;
        }catch(final FileNotFoundException pFNFE){
            return "Erreur, dialogue non-trouvé";
        }
    }//talkString()
    
    /**
     * Méthode qui permet de retourner le dialogue de réponse d'un personnage après avoir donné un objet.
     * @param pActive true si il accepte, false sinon.
     * @return Le dialogue en String.
     */
    public String talkChoiceObject( final boolean pActive )
    {
        if( pActive ){
            this.aSuccess = true;
            return this.talkAcceptObject();
        }else{
            return this.talkRefuseObject();
        }
    }//talkChoiceObject()
    
    /**
     * Méthode qui permet de retourner le dialogue du personnage lorsqu'il accepte l'objet qu'on lui donne selon différent situation. Permet de plus
     * , de faire changer le lieu du personnage si personnage spécial et d'activer la fin des quête du personnage si tout ses quêtes ont été complétés.
     * @return Le dialogue en String
     */
    public String talkAcceptObject()
    {
        Scanner vFile;
        String vPathFile = "Dialogues/" + this.aName + "_accept";
        if(this.aSituation>1){
            vPathFile += "_" + this.aSituation + ".txt";
        }else{
            vPathFile += ".txt";
        }
        if(this.aSpecial && this.aSuccess){
            this.aSuccess = false;
            if(this.aRoom.size() > this.aSituation){
                this.setCurrentRoomUpdate( this.aRoom.get(this.aSituation) );
                this.aSituation += 1;
            }else{
                this.aSituation += 1;
                this.aEndGame = true;
            }
        }
        
        try{
            vFile = new Scanner( new File( vPathFile) );
            String vDialogue = this.aName + " :";
            while(vFile.hasNextLine() ){ //Tant qu'il y a une ligne à lire
                String vLigne = vFile.nextLine(); 
                vDialogue += " " + vLigne;
            }
            vFile.close();
            return vDialogue;
        }catch(final FileNotFoundException pFNFE){
            return "Erreur, dialogue non-trouvé";
        }
    }//talkAcceptObject()
    
    /**
     * Méthode qui permet de retourner le dialogue du personnage lorsqu'il refuse l'objet qu'on lui donnae selon différent situation.
     * @return Le dialogue en String
     */
    public String talkRefuseObject()
    {
        Scanner vFile;
        String vPathFile = "Dialogues/" + this.aName + "_refuse";
        if(this.aSituation>1){
            vPathFile += "_" + this.aSituation + ".txt";
        }else{
            vPathFile += ".txt";
        }
        
        try{
            vFile = new Scanner( new File( vPathFile) );
            String vDialogue = this.aName + " :";
            while(vFile.hasNextLine() ){ //Tant qu'il y a une ligne à lire
                String vLigne = vFile.nextLine(); 
                vDialogue += " " + vLigne;
            }
            vFile.close();
            return vDialogue;
        }catch(final FileNotFoundException pFNFE){
            return "Erreur, dialogue non-trouvé";
        }
    }//talkRefuseObject()
    
    /**
     * Méthode qui permet de renvoyer si c'est bien l'objet actuellement voulu du personnage.
     * @param pObjet L'objet qu'on veut comparer
     * @return true si oui, false sinon.
     */
    public boolean itemOrder( final Item pObjet )
    {
        return pObjet==this.aNeedItem.get(0);
    }//itemOrder()
    
    /**
     * Méthode qui permet de savoir si tout les quêtes de ce personne est finis.
     * @return true si oui, false sinon.
     */
    public boolean getEndGame()
    {
        return this.aEndGame;
    }//getEndGame()
    
    /**
     * Méthide qui force ici le endGame en false afin de ne pas afficher le message de féliciation indéfiniment.
     * 
     */
    public void setEndGame()
    {
        this.aEndGame = false;
    }//setEndGame()
}//Personnage
