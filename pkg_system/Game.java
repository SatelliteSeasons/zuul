package pkg_system;

import pkg_system.GameEngine;
import pkg_system.UserInterface;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class.
 * 
 *  This main class creates the necessary implementation objects and starts the game off.
 * 
 * @author  Michael Kolling and David J. Barnes + Edited by Richard Ho
 * @version 2.0 (Jan 2003) DB edited (2019) + 2023.04.03
 */

public class Game
{
    private GameEngine aEngine;
    private UserInterface aGui;

    /**
     * Create the game and initialise its internal map. Create the interface and link to it.
     */
    public Game()
    {
        this.aEngine = new GameEngine();
        this.aGui = new UserInterface( this.aEngine );
        this.aEngine.setGUI( this.aGui );
    }//Game()
    
}//Game
