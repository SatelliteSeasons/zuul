package pkg_command;

import pkg_system.Player;
import pkg_system.UserInterface;
import pkg_system.GameEngine;

//
import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

/**
 * Classe TestCommand - Représentation des instructions de la commande "test"
 *
 * @author Richard Ho
 * @version 09/04/2023
 */
public class TestCommand extends Command
{

    /**
     * Constructeur d'objets de classe TestCommand
     */
    public TestCommand()
    {
        
    }//TestCommand()

    /**
     * Méthode qui exécute une instruction correspondant à la commande "test".
     * @param pPlayer Player, le joueur.
     * @param pGui UserInterface, l'interface.
     * @param pGameEngine GameEngine, le moteur du jeu.
     */
    @Override public boolean execute( final Player pPlayer, final UserInterface pGui, final GameEngine pGameEngine )
    {
        pGameEngine.setEtatTest(true);
        if(!this.hasSecondWord() ){
            pGui.println("Veuillez mettre le nom du fichier contenant les instructions à tester");
            return false; //optio
        }
        
        Scanner vFile;
        String vTotalCommande ="Tout les commandes utilisé : ";
        
        String vNameFile = this.getSecondWord(); //Récupération du nom du fichier
        String vPathFile = "TestFile/" + vNameFile + ".txt"; //Récupération localisation du fichier
        // java.io.InputStream vNameURL = this.getClass().getClassLoader().getResourceAsStream( vPathFile );  (Ne sert à rien)
        
        pGui.println("Commencement du test du fichier : " + vNameFile);
        
        //Try permet de tester les instructions suivant, puis catch au cas où il y a des
        //exeptions
        try{
            vFile = new Scanner( new File ( vPathFile ) ); //Récupération du fichier et ouverture de celle-ci
            while(vFile.hasNextLine() ){ //Tant qu'il y a une ligne à lire
                String vLigne = vFile.nextLine(); 
                vTotalCommande += " " + vLigne;
                pGameEngine.interpretCommand(vLigne);
            }
            pGui.println(vTotalCommande);
            pGui.println("Fin du test");
            vFile.close();  //Ferme le fichier qui est ouvert actuellement pour la lecture de son contenue
        }catch(final FileNotFoundException pFNFE){
            pGui.println("Nom du fichier introuvable");
        }
        return false; //optio
    }//execute()
}//TestCommand
