package pkg_command;

import pkg_command.Command;
import pkg_command.GoCommand;
import pkg_command.HelpCommand;
import pkg_command.InventoryCommand;
import pkg_command.QuitCommand;
import pkg_command.LookCommand;
import pkg_command.TestTimeCommand;
import pkg_command.EatCommand;
import pkg_command.TestCommand;
import pkg_command.UseCommand;
import pkg_command.BackCommand;
import pkg_command.AleaCommand;
import pkg_command.TakeCommand;
import pkg_command.PutCommand;

import pkg_command.DroiteCommand;
import pkg_command.GaucheCommand;

import pkg_command.AvancerCommand;
import pkg_command.DerriereCommand;

//
import  java.util.HashMap; 
import  java.util.Iterator;

/**
 * This class is the main class of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.
 * 
 * This class holds a collection of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author Michael Kolling and David J. Barnes + Edited by Richard Ho
 * @version 2011.07.31 + 2023.04.09
 */
public class CommandWords
{
    private final HashMap<String, Command> aValidCommands;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        this.aValidCommands = new HashMap<String, Command>();
        this.aValidCommands.put("go", new GoCommand() );
        this.aValidCommands.put("aide", new HelpCommand() );
        this.aValidCommands.put("quitter", new QuitCommand() );
        this.aValidCommands.put("regarder", new LookCommand() );
        this.aValidCommands.put("manger", new EatCommand() );
        this.aValidCommands.put("back", new BackCommand() );
        this.aValidCommands.put("prendre", new TakeCommand() );
        this.aValidCommands.put("poser", new PutCommand() );
        this.aValidCommands.put("inventaire", new InventoryCommand() );
        this.aValidCommands.put("utiliser", new UseCommand() );
        this.aValidCommands.put("alea", new AleaCommand() );
        this.aValidCommands.put("testTime", new TestTimeCommand() );
        this.aValidCommands.put("test", new TestCommand() );
    
        this.aValidCommands.put("parler", new TalkCommand() );
        this.aValidCommands.put("donner", new GiveCommand() );
        
        this.aValidCommands.put("droite", new DroiteCommand() );
        this.aValidCommands.put("gauche", new GaucheCommand() );
        
        this.aValidCommands.put("avancer", new AvancerCommand() );
        this.aValidCommands.put("derriere", new DerriereCommand() );
    } // CommandWords()
    
    /**
     * Méthode qui récupère en paramètre la commande en String, et qui renvoie la classe de la commande correspondant.
     * @param pWord La commande en premier mot.
     * @return Command, la classe de commande correspondant.
     */
    public Command get( String pWord )
    {
        return (Command)this.aValidCommands.get( pWord );
    }//get()
    
    /**
     * Check whether a given String is a valid command word. 
     * @param pString, the word we want to verify.
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand( final String pString )
    {
        for(Iterator i = this.aValidCommands.keySet().iterator(); i.hasNext(); ) {
            if( pString.equals( i.next() ) ){
                return true;
            }
        }
        return false;
    } // isCommand()
    
    /**
     * Méthode qui retourne la liste de commande possible sous forme de String.
     * @return String
     */
    public String getCommandList()
    {
        String vLocal="";
        for(Iterator i = this.aValidCommands.keySet().iterator(); i.hasNext(); ) {
            vLocal += i.next() + " ";
        }
        return vLocal;
    }// getCommandList()
    
}// CommandWords