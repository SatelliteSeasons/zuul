package pkg_command;

import pkg_system.Player;
import pkg_system.UserInterface;
import pkg_system.GameEngine;


/**
 * Classe AvancerCommand - Représentation des instructions de la commande "avancer"
 *
 * @author Richard Ho
 * @version 22/05/2023
 */
public class AvancerCommand extends Command
{
    
    /**
     * Constructeur d'objets de classe AvancerCommand
     */
    public AvancerCommand()
    {

    }//AvancerCommand()

    /**
     * Méthode qui exécute une instruction correspondant à la commande "avancer".
     * @param pPlayer Player, le joueur.
     * @param pGui UserInterface, l'interface.
     * @param pGameEngine GameEngine, le moteur du jeu.
     */
    @Override public boolean execute( final Player pPlayer, final UserInterface pGui, final GameEngine pGameEngine )
    {
        if( this.hasSecondWord() ){
            pGui.println("Pas plus de mot");
            return false; //optio
        }
        String vDirection = pPlayer.DirectionPlayer();
        boolean vExistRoom = pPlayer.goRoom( vDirection );
        
        if(!vExistRoom){
            pGui.println("Aucun passage vers ici...");
            return false; //optio
        }else{
            pGameEngine.printLocationInfo();
            pGameEngine.timeEtat();
        }
        return false; //optio
    }//execute()
}//AvancerCommand
