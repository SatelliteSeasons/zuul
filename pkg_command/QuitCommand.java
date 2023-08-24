package pkg_command;

import pkg_system.Player;
import pkg_system.UserInterface;
import pkg_system.GameEngine;

/**
 * Classe QuitCommand - Représentation des instructions de la commande "quitter"
 *
 * @author Richard Ho
 * @version 09/04/2023
 */
public class QuitCommand extends Command
{
    
    /**
     * Constructeur d'objet de la classe QuitCommand
     */
    public QuitCommand()
    {
        
    }//QuitCommand()
    
    /**
     * Méthode qui exécute une instruction correspondant à la commande "quitter".
     * @param pPlayer Player, le joueur.
     * @param pGui UserInterface, l'interface.
     * @param pGameEngine GameEngine, le moteur du jeu.
     */
    @Override public boolean execute( final Player pPlayer, final UserInterface pGui, final GameEngine pGameEngine )
    {
        if(this.hasSecondWord()){
            pGui.println("Quit what ?");
        }else{
            pGameEngine.endGame();
        }
        return false; //optio
    }//execute()
}//QuitCommand
