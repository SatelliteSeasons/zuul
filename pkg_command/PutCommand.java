package pkg_command;

import pkg_system.Player;
import pkg_system.UserInterface;
import pkg_system.GameEngine;

/**
 * Classe PutCommand - Représentation des instructions de la commande "poser"
 *
 * @author Richard Ho
 * @version 09/04/2023
 */
public class PutCommand extends Command
{
    

    /**
     * Constructeur d'objets de classe PutCommand.
     */
    public PutCommand()
    {
        
    }//PutCommand()

    /**
     * Méthode qui exécute une instruction correspondant à la commande "poser".
     * @param pPlayer Player, le joueur.
     * @param pGui UserInterface, l'interface.
     * @param pGameEngine GameEngine, le moteur du jeu.
     */
    @Override public boolean execute( final Player pPlayer, final UserInterface pGui, final GameEngine pGameEngine )
    {
        if( !(this.hasSecondWord()) ){
            pGui.println("Je dois poser quoi ?");
            return false; //optio
        }
        String vNameItem = this.getSecondWord();
        String vExistItem = pPlayer.enleverInvItem( vNameItem );
        
        if( vExistItem.equals("ok") ){
            pGui.println("Je pose l'objet suivant : " + vNameItem);
            pGameEngine.timeEtat();
        }else{
            pGui.println("J'ai aucun objet du nom de " + vNameItem + " sur moi");
        }
        return false; //optio
    }//execute()
}//PutCommand
