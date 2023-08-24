package pkg_item;

import pkg_room.Room;

/**
 * Classe Beamer - Un Item spécial qui permet de mémoriser une Room et de le renvoyer.
 *
 * @author Richard Ho
 * @version 03/04/2023
 */
public class Beamer extends Item
{
    private Room aCharge;
    
    /**
     * Constructeur qui crée l'objet beamer avec une charge(aCharge) vide.
     */
    public Beamer()
    {
        super("beamer","Une machine capable de distordre le temps, permet lorsqu'il est chargé dans un lieu, d'y retourner depuis n'importe quelle espace, très puissant", 100);
        this.aCharge = null;
    }//Beamer()
    
    /**
     * Méthode qui retourne la Room mémorisé de l'objet courant.
     * @return Room
     */
    public Room getCharge()
    {
        return this.aCharge;
    }//getCharge()
    
    /**
     * Méthode boolean permettant de dire si l'objet courant a mémorisé ou non une Room.
     * @return true, si une Room dans la mémoire. False sinon.
     */
    public boolean estCharger()
    {
        if( this.aCharge == null){
            return false;
        }else{
            return true;
        }
    }//estCharger()
    
    /**
     * Méthode permettant d'associer une Room dans la mémoire(attribut) de l'objet courant.
     * @param pRoom, la Room qu'on souhaite mémoriser.
     */
    public void charger(final Room pRoom)
    {
        this.aCharge = pRoom;
    }//charger()
    
    /**
     * Méthode permettant de retourner la Room dans la mémoire et de le vider.
     * @return Room
     */
    public Room tirer()
    {
        Room vRoom = this.aCharge;
        this.aCharge = null;
        return vRoom;
    }//tirer()
}//Beamer
