package pkg_command;

import pkg_system.Player;
import pkg_system.UserInterface;
import pkg_system.GameEngine;

/**
 * Classe GoCommand - Représentation des instructions de la commande "go"
 *
 * @author Richard Ho
 * @version 09/04/2023
 */
public class GoCommand extends Command
{
    
    /**
     * Constructeur d'objets de classe GoCommand
     */
    public GoCommand()
    {
    }
    
    /**
     * Méthode qui exécute une instruction correspondant à la commande "go".
     * @param pPlayer Player, le joueur.
     * @param pGui UserInterface, l'interface.
     * @param pGameEngine GameEngine, le moteur du jeu.
     */
    @Override public boolean execute( final Player pPlayer, final UserInterface pGui, final GameEngine pGameEngine )
    {
        if( !this.hasSecondWord() ){
            AvancerCommand vCommande = new AvancerCommand();
            vCommande.execute(pPlayer, pGui, pGameEngine);
            return false; //optio
        }
        String vDirection = this.getSecondWord();
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
}//GoCommand
