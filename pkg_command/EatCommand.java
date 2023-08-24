package pkg_command;

import pkg_system.Player;
import pkg_system.UserInterface;
import pkg_system.GameEngine;

/**
 * Classe EatCommand - Représentation des instructions de la commande "eat"
 *
 * @author Richard Ho
 * @version 09/04/2023
 */
public class EatCommand extends Command
{

    /**
     * Constructeur d'objets de classe EatCommand
     */
    public EatCommand()
    {
    }//EatCommand()

    /**
     * Méthode qui exécute une instruction correspondant à la commande "manger".
     * @param pPlayer Player, le joueur.
     * @param pGui UserInterface, l'interface.
     * @param pGameEngine GameEngine, le moteur du jeu.
     */
    @Override public boolean execute( final Player pPlayer, final UserInterface pGui, final GameEngine pGameEngine)
    {
        if( !(this.hasSecondWord()) ){
            pGui.println("Je dois manger quoi ?");
            return false; //optio
        }
        
        String vObjet = this.getSecondWord();
        
        if( vObjet.equals("cookie") ){
            if( pPlayer.contientItem( vObjet ) ){
                pPlayer.doublePoidMax();
                pPlayer.enleverItemEtPoid( vObjet );
                pGui.println("C'était pas si bon finalement, mais j'ai l'impression d'être devenu plus fort");
                pGameEngine.timeEtat();
            }else{
                pGui.println("Je n'ai pas cet objet en ma possession");
            }
        }else if( vObjet.equals("stoptime") ){
            if( pPlayer.contientItem( vObjet ) ){
                pPlayer.setTimeMode( false );
                pPlayer.enleverItemEtPoid( vObjet );
                pGui.println("Le bruit d'une aiguille s'est arrêté...");
            }else{
                pGui.println("Je n'ai pas cet objet en ma possession");
            }
        }else{
            pGui.println("Je ne crois pas que ce truc se mange, et non je n'essayerai pas");
        }
        return false; //optio
    }//execute()
}//EatCommand
