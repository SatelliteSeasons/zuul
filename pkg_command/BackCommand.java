package pkg_command;

import pkg_system.Player;
import pkg_system.UserInterface;
import pkg_system.GameEngine;

/**
 * Classe BackCommand - Représentation des instructions de la commande "back"
 *
 * @author Richard Ho
 * @version 09/04/2023
 */
public class BackCommand extends Command
{
    /**
     * Constructeur d'objets de classe BackCommand
     */
    public BackCommand()
    {
       
    }//BackCommand()

    /**
     * Méthode qui exécute une instruction correspondant à la commande "back".
     * @param pPlayer Player, le joueur.
     * @param pGui UserInterface, l'interface.
     * @param pGameEngine GameEngine, le moteur du jeu.
     */
    @Override public boolean execute( final Player pPlayer, final UserInterface pGui, final GameEngine pGameEngine)
    {
        if( this.hasSecondWord() ){
            pGui.println("Juste ''back'' suffit hein..");
            return false;//optio
        }
        
        if(pPlayer.backRoomEmpty()){
            pGui.println("Impossible de revenir en arrière");
        }else{
            if(pPlayer.getCurrentRoom().isExit( pPlayer.backRoomPeek() ) ){
                pPlayer.back();
                pGameEngine.printLocationInfo();
                pGameEngine.timeEtat();
            }else{
                pGui.println("Le passage que je viens d'emprunter est à sens unique");
            }
        }
        return false; //optio
    }//execute()
}//BackCommand
