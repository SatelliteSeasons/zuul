package pkg_system;

import pkg_command.CommandWords;
import pkg_command.Command;

// 
import java.util.StringTokenizer;


/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a two word command. It returns the command
 * as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 * 
 * @author  Michael Kolling and David J. Barnes + D.Bureau + Edited by Richard Ho
 * @version 2008.03.30 + 2013.09.15 + 2023.02.20
 */
public class Parser 
{
    private CommandWords aValidCommands;  // (voir la classe CommandWords)

    /**
     * Constructeur par défaut qui crée les objets prévus pour l'attributs, ici, 
     * l'initialisation des commandes valides.
     */
    public Parser() 
    {
        this.aValidCommands = new CommandWords();
    } // Parser()

    /**
     * Méthode permettant de renvoyer différent commande, selon le texte reçu.
     * @param pInputLine, texte en String
     * @return The next command from the user.
     */
    public Command getCommand(final String pInputLine) 
    {
        String vWord1 = null;
        String vWord2 = null;
        
        String vWord3 = null;

        System.out.print( "> " );  // affiche le prompt (invite de commande)

        StringTokenizer tokenizer = new StringTokenizer( pInputLine );

        if ( tokenizer.hasMoreTokens() )
            vWord1 = tokenizer.nextToken();      // get first word
        else
            vWord1 = null;

        if ( tokenizer.hasMoreTokens() )
            vWord2 = tokenizer.nextToken();      // get second word
        else
            vWord2 = null;
            
        if( tokenizer.hasMoreTokens() ){
            vWord3 = tokenizer.nextToken();
        }else{
            vWord3 = null;
        }
        
        // note: we just ignore the rest of the input line.
        
        Command vCommande = this.aValidCommands.get( vWord1 ); // obtient la valeur du HashMap validCommand selon la clé vWord1
        
        if( !(vCommande == null) ){
            vCommande.setSecondWord( vWord2 ); // place le second mot, utile pour les commandes qui ont besoin d'un deuxième mot.
            vCommande.setThirdWord( vWord3 ); //A voir le cas où on a pas besoin du troisème mot ?
        }
        return vCommande;
    } // getCommand()
    
    /**
     * Affiche la liste des commandes valides.
     * @return Renvoie la liste sous forme de String.
     */
    public String getCommandsString()
    {
        return this.aValidCommands.getCommandList();
    }//getCommandsString()
} // Parser