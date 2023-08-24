package pkg_command;

import pkg_system.Player;
import pkg_system.UserInterface;
import pkg_system.GameEngine;

/**
 * Classe TakeCommand - Représentation des instructions de la commande "prendre"
 *
 * @author Richard Ho
 * @version 09/04/2023
 */
public class TakeCommand extends Command
{

    /**
     * Constructeur d'objets de classe TakeCommand
     */
    public TakeCommand()
    {
    }//TakeCommand()

    /**
     * Méthode qui exécute une instruction correspondant à la commande "prendre".
     * @param pPlayer Player, le joueur.
     * @param pGui UserInterface, l'interface.
     * @param pGameEngine GameEngine, le moteur du jeu.
     */
    @Override public boolean execute( final Player pPlayer, final UserInterface pGui, final GameEngine pGameEngine)
    {
        if( !(this.hasSecondWord()) ){
            pGui.println("Je dois prendre quoi ?");
            return false; //optio
        }
        String vNameItem = this.getSecondWord();
        String vExistItem = pPlayer.ajouterInvItem( vNameItem );
        if( vExistItem.equals( "ok" ) ){
            pGui.println("Je prend l'objet suivant : " + vNameItem);
            pGameEngine.timeEtat();
        }else if( vExistItem.equals("lourd") ){
            pGui.println("L'objet est trop lourd pour moi");
        }else{
            pGui.println("Il n'y a aucun objet du nom de " + vNameItem + " ici");
        }
        return false; //optio
    }//execute()
}//TakeCommand
