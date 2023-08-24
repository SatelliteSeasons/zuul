package pkg_command;

import pkg_system.Player;
import pkg_system.UserInterface;
import pkg_system.GameEngine;

import pkg_item.Item;

/**
 * Classe LookCommand - Représentation des instructions de la commande "regarder"
 *
 * @author Richard Ho
 * @version 09/04/2023
 */
public class LookCommand extends Command
{
    /**
     * Constructeur d'objets de classe LookCommand
     */
    public LookCommand()
    {
    }//LookCommand()

    /**
     * Méthode qui exécute une instruction correspondant à la commande "regarder".
     * @param pPlayer Player, le joueur.
     * @param pGui UserInterface, l'interface.
     * @param pGameEngine GameEngine, le moteur du jeu.
     */
    @Override public boolean execute( final Player pPlayer, final UserInterface pGui, final GameEngine pGameEngine )
    {
        if(this.hasSecondWord()){
            String vSecondMot = this.getSecondWord();
            Item vObjetActuel = ( pPlayer.getCurrentRoom().getItem( vSecondMot ) );
            if(vObjetActuel != null && ( vObjetActuel.getItemName().equals( vSecondMot ) ) )
            {      
                pGui.println(vObjetActuel.getLongItemDescription());
            }else{
                pGui.println("''" + this.getSecondWord() + "''" +"..." + " Ce que je cherche n'est probablement pas ici");
            }
        }else{
            pGui.println( pPlayer.getCurrentRoom().getLongDescription() );
        }
        return false; //optio
    }//execute()
}//LookCommand
