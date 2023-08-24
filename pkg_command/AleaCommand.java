package pkg_command;

import pkg_system.Player;
import pkg_system.UserInterface;
import pkg_system.GameEngine;

import pkg_room.Room;
import pkg_room.TransporterRoom;

//
import java.util.ArrayList;

/**
 * Classe AleaCommand - Représentation des instructions de la commande "alea"
 *
 * @author Richard Ho
 * @version 09/04/2023
 */
public class AleaCommand extends Command
{

    /**
     * Constructeur d'objets de classe AleaCommand
     */
    public AleaCommand()
    {
        
    }//AleaCommand

    /**
     * Méthode qui exécute une instruction correspondant à la commande "alea".
     * @param pPlayer Player, le joueur.
     * @param pGui UserInterface, l'interface.
     * @param pGameEngine GameEngine, le moteur du jeu.
     */
    @Override public boolean execute( final Player pPlayer, final UserInterface pGui, final GameEngine pGameEngine )
    {
        if( (pGameEngine.getEtatTest() == true)){
            // &&  (this.aPlayer.getCurrentRoom().getName().equals("TransporterRoom") )
            if( this.hasSecondWord() ){
                String pName = this.getSecondWord();
                for(Room vRoom : pGameEngine.getRoomRandomList() )
                {
                    if(pName.equals( vRoom.getName() ) ){
                        TransporterRoom vTransporter = (TransporterRoom)pPlayer.getCurrentRoom();
                        vTransporter.setAlea(true);
                        // Command vCommandeAlea = new Command("go", pName); //Verif
                        Command vCommandeAlea = new GoCommand();
                        vCommandeAlea.setSecondWord( pName );
                        // this.goRoom( vCommandeAlea ); //Verif
                        vCommandeAlea.execute( pPlayer, pGui, pGameEngine );
                        return false; //optio
                    }
                }
                pGui.println("Second mot incompris, aucune action");
                return false; //optio
            }else{
                pGui.println("alea sans second mot, random normal");
                //Command vCommande = new Command("go","sud"); //Verif
                Command vCommande = new GoCommand();
                vCommande.setSecondWord("sud");
                //this.goRoom(vCommande); //Verif
                vCommande.execute( pPlayer, pGui, pGameEngine);
            }
        }else{
            pGui.println("Mode test non activé");
        }
        return false; //optio
    }//execute()
}//AleaCommand
