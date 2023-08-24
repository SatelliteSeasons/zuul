package pkg_room;

import java.util.Random;
import java.util.ArrayList;

/**
 * Classe RoomRandomizer - Une classe qui a pour but de générer une room de manière (pseudo) aléatoire
 * et de le renvoyer.
 *
 * @author Richard Ho
 * @version 03/04/2023
 */
public class RoomRandomizer
{
    private Random aRandom;
    private ArrayList<Room> aRoomsList;
    
    /**
     * Constructeur naturel qui récupère une liste de Room qu'on va exploiter.
     * (Seed pour débug = 10)
     * @param pRoomRandomList, une liste de Room qu'on souhaite piocher au hasard.
     */
    public RoomRandomizer(final ArrayList<Room> pRoomRandomList)
    {
        this.aRandom = new Random();
        this.aRoomsList = pRoomRandomList;
    }//RoomRandomizer()
    
    /**
     * Méthode qui retourne de manière aléatoire une Room depuis une liste de Room.
     * @return Room
     */
    public Room getRoom()
    {
        return this.aRoomsList.get( this.aRandom.nextInt( this.aRoomsList.size() ) );
    }//getRoom()
    
    /**
     * Méthode qui retourne différent Room selon leur nom.
     * @param pSalle, le nom de la Room en String qu'on souhaite retourner.
     * @return la Room.
     */
    public Room getRoomAlea(final String pSalle)
    {
        String vName = pSalle;
        for (Room vRoom : this.aRoomsList)
        {
            if(vName.equals( vRoom.getName() ) ){
                return vRoom;
            }
        }
        return null;
    }//getRoomAlea()
    
}//RoomRandomizer
