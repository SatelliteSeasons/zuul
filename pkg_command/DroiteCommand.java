package pkg_command;

import pkg_system.GameEngine;
import pkg_system.UserInterface;
import pkg_system.Player;

/**
 * Classe DroiteCommand - Représentation des instructions de la commande "droite"
 *
 * @author Richard Ho
 * @version 22/05/2023
 */
public class DroiteCommand extends Command
{

    /**
     * Constructeur d'objets de classe DroiteCommand
     */
    public DroiteCommand()
    {
    }//DroiteCommand()

    /**
     * Méthode qui exécute une instruction correspondant à la commande "droite".
     * @param pPlayer Player, le joueur.
     * @param pGui UserInterface, l'interface.
     * @param pGameEngine GameEngine, le moteur du jeu.
     */
    @Override public boolean execute( final Player pPlayer, final UserInterface pGui, final GameEngine pGameEngine )
    {
        if(this.hasSecondWord()){
            pGui.println("Plus de mot");
            return false; //optio
        }
        pPlayer.DirectionDroite();
        pGui.showImage( pPlayer.getCurrentRoom().getImageHashMap().getImage( pPlayer.getDirection() ) );
        return false; //optio
        
    }//execute()
}//DroiteCommand
