package pkg_command;

import pkg_system.Player;
import pkg_system.UserInterface;
import pkg_system.GameEngine;

/**
 * Classe UseCommand - Représentation des instructions de la commande "utiliser"
 *
 * @author Richard Ho
 * @version 09/04/2023
 */
public class UseCommand extends Command
{

    /**
     * Constructeur d'objets de classe UseCommand
     */
    public UseCommand()
    {
        
    }//UseCommand()

    /**
     * Méthode qui exécute une instruction correspondant à la commande "utiliser".
     * @param pPlayer Player, le joueur.
     * @param pGui UserInterface, l'interface.
     * @param pGameEngine GameEngine, le moteur du jeu.
     */
    @Override public boolean execute( final Player pPlayer, final UserInterface pGui, final GameEngine pGameEngine )
    {
        if( !(this.hasSecondWord()) ){
            pGui.println("Je dois utiliser quoi ?");
            return false; //optio
        }
        String vNameItem = this.getSecondWord();
        
        if( vNameItem.equals("beamer") ){
            if(pPlayer.beamerEstCharger()){
                String vString = pPlayer.tirerBeamer();
                if( vString.equals("inexistance") ){
                    pGui.println("Je n'ai pas cet objet en ma possesion (ERREUR tire)");
                }else if( vString.equals("unknown") ){
                    pGui.println("Arme non chargé");
                }else{
                    pGameEngine.printLocationInfo();
                    pGameEngine.timeEtat();
                    pGui.println("J'ai tirer");
                }
            }else{
                String vInstruction = pPlayer.chargerBeamer();
                if( vInstruction.equals("ok") ){
                    pGui.println("Je charge l'arme pour qu'il enregistre cet endroit");
                }else{
                    pGui.println("Je n'ai pas cet objet en ma possession");
                }
            }
        }else{
            pGui.println("Je n'ai aucune idée de quoi faire avec cet objet...");
        }
        return false; //optio
    }//execute()
}//UseCommand
