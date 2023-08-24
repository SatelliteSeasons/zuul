package pkg_command;

import pkg_system.Player;
import pkg_system.UserInterface;
import pkg_system.GameEngine;

/**
 * Classe TestTimeCommand - Représentation des instructions de la commande "testTime"
 *
 * @author Richard Ho
 * @version 09/04/2023
 */
public class TestTimeCommand extends Command
{
   
    /**
     * Constructeur d'objets de classe TestTimeCommand
     */
    public TestTimeCommand()
    {
        
    }//TestTimeCommand()

    /**
     * Méthode qui exécute une instruction correspondant à la commande "testTime".
     * @param pPlayer Player, le joueur.
     * @param pGui UserInterface, l'interface.
     * @param pGameEngine GameEngine, le moteur du jeu.
     */
    @Override public boolean execute( final Player pPlayer, final UserInterface pGui, final GameEngine pGameEngine )
    {
        pGameEngine.timeAction();
        return false; //optio
    }//execute()
}//TestTimeCommand
