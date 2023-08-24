package pkg_command;

import pkg_system.Player;
import pkg_system.UserInterface;
import pkg_system.GameEngine;

/**
 * Classe DerriereCommand - Représentation des instructions de la commande "derriere"
 *
 * @author Richard Ho
 * @version 22/05/2023
 */
public class DerriereCommand extends Command
{

    /**
     * Constructeur d'objets de classe DerriereCommand
     */
    public DerriereCommand()
    {
    
    }//DerriereCommand()

    /**
     * Méthode qui exécute une instruction correspondant à la commande "derriere".
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
        pPlayer.DirectionDerriere();
        pGui.showImage( pPlayer.getCurrentRoom().getImageHashMap().getImage( pPlayer.getDirection() ) );
        return false; //optio
        
    }//execute()
}//DerriereCommand
