package pkg_command;

import pkg_system.Player;
import pkg_system.UserInterface;
import pkg_system.GameEngine;

/**
 * Classe Command - Permet de définir et diviser un texte en deux mot. Et représente
 * une commande du jeu.
 *
 * @author Richard Ho
 * 
 * @version 22/05/2023
 */
public abstract class Command
{
    private String aSecondWord;
    private String aThirdWord;
    
    /**
     * Constructeur par défaut. (A compléter) 
     */
    public Command()
    {
        this.aSecondWord = null;
        this.aThirdWord = null;
    }//Command()
    
    /**
     * Méthode qui retourne le deuxième mot de la commande en String.
     * @return String
     */
    public String getSecondWord()
    {
        return this.aSecondWord;
    }//getSecondWord()
    
    /**
     * Méthode boolean qui retourne si il y a existence d'une second mot de l'objet courant.
     * @return true, si la commande possède un deuxième mot. False sinon
     */
    public boolean hasSecondWord()
    {
        return this.aSecondWord!=null;
    }//hasSecondWord()
    
    /**
     * Méthode qui modifie le second mot de la commande.
     * @param pSecondWord, le second mot en String
     */
    public void setSecondWord( final String pSecondWord )
    {
        this.aSecondWord = pSecondWord;
    }//setSecondWord()
    
    //Troisième mot :
    /**
     * Méthode qui retourne le troisième mot de la commande en String.
     * @return String
     */
    public String getThirdWord()
    {
        return this.aThirdWord;
    }//getThirdWord()
    
    /**
     * Méthode boolean qui retourne si il y a existence d'un troisème mot de l'objet courant.
     * @return true, si la commande possède un troisième mot. False sinon
     */
    public boolean hasThirdWord()
    {
        return this.aThirdWord != null;
    }//hasThirdWord()
    
    /**
     * Méthode qui modifie le troisième mot de la commande.
     * @param pThirdWord, le troisième mot en String
     */
    public void setThirdWord( final String pThirdWord )
    {
        this.aThirdWord = pThirdWord;
    }//setThirdWord()
    
    //Abstract method :
    
    /**
     * Exécute la commande. Méthode qui retourne un indicateur de si le jeu doit se terminer ou non
     * @param pPlayer Un joueur en Player.
     * @param pGui Un interface UserInterface.
     * @param pGameEngine Un moteur de jeu GameEngine.
     * @return true, si le jeu doit se terminer. False sinon.
     */
    public abstract boolean execute( final Player pPlayer, final UserInterface pGui, final GameEngine pGameEngine );
    //execute()
} // Command
