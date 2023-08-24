package pkg_room;

//
import java.util.ArrayList;

/**
 * Classe TransporterRoom - Une Room spécial qui, lorsqu'on y sort, nous transporte de manière aléatoire
 * dans d'autre Room contenu dans une liste de Room.
 * 
 * @author Richard Ho
 * @version 03/04/2023
 */
public class TransporterRoom extends Room
{
    private RoomRandomizer aRandom;
    private boolean aNextRoomAlea;
    
    /**
     * Contructeur permettant de créer un TransporterRoom, et d'y associer une liste de Room qu'on pourrait
     * atterir.
     * @param pName,lLe Nom du lieu.
     * @param pDescription, description du lieu en String.
     * @param pImageName, le nom de l'image associé au lieu.
     * @param pRoomRandomList, une liste de Room qu'on souhaite piocher au hasard.
     */
    public TransporterRoom(final String pName, final String pDescription, final String pImageName, final ArrayList<Room> pRoomRandomList)
    {
        super(pName, pDescription, pImageName);
        this.aRandom = new RoomRandomizer( pRoomRandomList );
        this.aNextRoomAlea = false;
    }//TransporterRoom()
    
    /**
     * Méthode permettant de modifier le mode débug.
     * @param pActive, true si débug activé, false sinon.
     */
    public void setAlea( final boolean pActive )
    {
        this.aNextRoomAlea = pActive;
    }//setAlea()
    
    /**
     * Méthode permettant d'obtenir une Room de manière aléatoire, ou bien si débug activé, renvoie
     * la room espérée.
     * @param pDirection, qu'on ignore, ou bien lorsque débug activé, le nom du lieu qu'on souhaite atterir.
     * @return Room
     */
    @Override public Room getExit(final String pDirection)
    {
        if( this.aNextRoomAlea ){
            this.aNextRoomAlea = false;
            return this.aRandom.getRoomAlea( pDirection );
        }
        return this.findRandomRoom();
    }//getExit()
    
    /**
     * Méthode qui appel une méthode de la classe RoomRandomizer afin d'obtenir de manière aléatoire une
     * Room.
     * @return Room.
     */
    private Room findRandomRoom()
    {
        return this.aRandom.getRoom();
    }//findRandomRoom()
    
}//TransporterRoom
