package pkg_command;

import pkg_system.Player;
import pkg_system.UserInterface;
import pkg_system.GameEngine;

import pkg_character.Personnage;
import pkg_item.Item;


/**
 * Classe GiveCommand - Représentation des instructions de la commande "donner"
 *
 * @author Richard Ho
 * @version 22/05/2023
 */
public class GiveCommand extends Command
{

    /**
     * Constructeur d'objets de classe GiveCommand
     */
    public GiveCommand()
    {
        
    }//GiveCommand()
    /**
     * Méthode qui exécute une instruction correspondant à la commande "donner".
     * @param pPlayer Player, le joueur.
     * @param pGui UserInterface, l'interface.
     * @param pGameEngine GameEngine, le moteur du jeu.
     */
    @Override public boolean execute( final Player pPlayer, final UserInterface pGui, final GameEngine pGameEngine)
    {
        if( !(this.hasSecondWord() ) ){
            pGui.println("Je dois donner quoi ?");
            return false; //optio
        }else if(!(this.hasThirdWord() ) ){
            pGui.println("Je dois donner " + "'" + this.getSecondWord() +"'" + " à qui ?");
            return false; //optio
        }
        
        String vObjet = this.getSecondWord();
        String vCharacter = this.getThirdWord();
        
        //verif objet
        if( pPlayer.contientItem( vObjet ) ){
            if( (pPlayer.getCurrentRoom().contientPersonnage( vCharacter ) ) ){
                Personnage vPersonnage = pPlayer.getCurrentRoom().getPersonnage( vCharacter);
                Item vItem = pPlayer.getInvItem( vObjet);
                
                if( vPersonnage.contientNeedItem( vItem ) && vPersonnage.itemOrder(vItem) ){
                    //acceptation
                    pGui.println( vPersonnage.talkChoiceObject( true ) );
                    pPlayer.enleverItemEtPoid( vObjet );
                    vPersonnage.enleverNeedItem( vItem );
                    return false; //optio
                }else{
                    //refus
                    pGui.println( vPersonnage.talkChoiceObject( false ) );
                    return false; //optio
                }
            }else{
                pGui.println("'" + vCharacter +"'"+ ", n'est pas ici.");
                return false;//optio
            }
        }else{
            pGui.println("Je n'ai pas l'objet : " + "'" + vObjet + "'" + ", dans mon inventaire.");
            return false; //optio
        }
    }//execute()

}//GiveCommand
