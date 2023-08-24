package pkg_command;

import pkg_system.Player;
import pkg_system.UserInterface;
import pkg_system.GameEngine;

import pkg_character.Personnage;


/**
 * Classe TalkCommand - Représentation des instructions de la commande "parler"
 *
 * @author Richard
 * @version 22/05/2023
 */
public class TalkCommand extends Command
{

    /**
     * Constructeur d'objets de classe TalkCommand
     */
    public TalkCommand()
    {
    }//TalkCommand()

    /**
     * Exécute la commande. Méthode qui retourne un indicateur de si le jeu doit se terminer ou non
     * @param pPlayer Un joueur en Player.
     * @param pGui Un interface UserInterface.
     * @param pGameEngine Un moteur de jeu GameEngine.
     * @return true, si le jeu doit se terminer. False sinon.
     */
    @Override public boolean execute( final Player pPlayer, final UserInterface pGui, final GameEngine pGameEngine)
    {
        if( !(this.hasSecondWord()) ){
            pGui.println( "Je dois parler à qui ?" );
            return false; //optio
        }
        
        String vPerso = this.getSecondWord();
        
        if( pPlayer.getCurrentRoom().contientPersonnage(vPerso) )
        {
            Personnage vPersonnage = pPlayer.getCurrentRoom().getPersonnage(vPerso);
            pGui.println( vPersonnage.talkString() );
        }else{
            pGui.println("Il n'y a personne de ce nom ici.");
        }
        return false; //optio
    }//execute()
    
}//TalkCommand
