package pkg_command;

import pkg_system.GameEngine;
import pkg_system.UserInterface;
import pkg_system.Player;

/**
 * Classe GaucheCommand - Représentation des instructions de la commande "gauche"
 *
 * @author Richard Ho
 * @version 22/05/2023
 */
public class GaucheCommand extends Command
{

    /**
     * Constructeur d'objets de classe GaucheCommand
     */
    public GaucheCommand()
    {
    
    }//GaucheCommand()

    /**
     * Méthode qui exécute une instruction correspondant à la commande "gauche".
     * @param pPlayer Player, le joueur.
     * @param pGui UserInterface, l'interface.
     * @param pGameEngine GameEngine, le moteur du jeu.
     */
    @Override public boolean execute( final Player pPlayer, final UserInterface pGui, final GameEngine pGameEngine )
    {
        if(this.hasSecondWord()){
            pGui.println("Pas plus de mot");
            return false; //optio
        }
        pPlayer.DirectionGauche();
        pGui.showImage( pPlayer.getCurrentRoom().getImageHashMap().getImage( pPlayer.getDirection() ) );
        return false; //optio
    }//execute()
}//GaucheCommand
