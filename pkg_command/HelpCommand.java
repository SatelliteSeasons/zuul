package pkg_command;

import pkg_system.Player;
import pkg_system.UserInterface;
import pkg_system.GameEngine;

/**
 * Classe HelpCommand - Représentation des instructions de la commande "aide"
 *
 * @author Richard Ho
 * @version 09/04/2023
 */
public class HelpCommand extends Command
{
    
    /**
     * Constructeur d'objets de classe HelpCommand
     */
    public HelpCommand()
    {
    }//HelpCommand()
    
    /**
     * Méthode qui exécute une instruction correspondant à la commande "aide".
     * @param pPlayer Player, le joueur.
     * @param pGui UserInterface, l'interface.
     * @param pGameEngine GameEngine, le moteur du jeu.
     */
    @Override public boolean execute( final Player pPlayer, final UserInterface pGui, final GameEngine pGameEngine)
    {
        pGameEngine.printHelp();
        return false; //Optio
    }//execute()
}//HelpCommand
