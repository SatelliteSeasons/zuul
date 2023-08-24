package pkg_command;

import pkg_system.Player;
import pkg_system.UserInterface;
import pkg_system.GameEngine;

/**
 * Classe InventoryCommand - Représentation des instructions de la commande "inventaire"
 *
 * @author Richard Ho
 * @version 09/04/2023
 */
public class InventoryCommand extends Command
{

    /**
     * Constructeur d'objets de classe InventoryCommand
     */
    public InventoryCommand()
    {
        
    }//InventoryCommand()

    /**
     * Méthode qui exécute une instruction correspondant à la commande "inventaire".
     * @param pPlayer Player, le joueur.
     * @param pGui UserInterface, l'interface.
     * @param pGameEngine GameEngine, le moteur du jeu.
     */
    @Override public boolean execute( final Player pPlayer, final UserInterface pGui, final GameEngine pGameEngine )
    {
        pGameEngine.inventaire();
        return false; //optio
    }//execute()
}//InventoryCommand
