package pkg_system;

//import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

import javax.swing.JButton; 

//import java.awt.*;
import java.awt.Dimension;
import java.awt.BorderLayout;

//import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.net.URL;

//import java.awt.image.*;

import java.awt.Color; //couleur

import java.awt.event.KeyListener; //écouter les touches de clavier
import java.awt.event.KeyEvent; //agi en conséquence

/**
 * This class implements a simple graphical user interface with a text entry
 * area, a text output area and an optional image.
 * 
 * @author Michael Kolling + Edited by Richard Ho
 * @version 1.0 (Jan 2003) DB edited (2019) + 22.05.2023
 */
public class UserInterface implements ActionListener, KeyListener
{
    private GameEngine aEngine;
    
    private JFrame     aMyFrame;
    private JTextField aEntryField;
    private JTextArea  aLog;
    
    private JLabel     aImage;
    private JLabel     aMap;

    /**
     * Construct a UserInterface. As a parameter, a Game Engine
     * (an object processing and executing the game commands) is
     * needed.
     * 
     * @param pGameEngine The GameEngine object implementing the game logic.
     */
    public UserInterface( final GameEngine pGameEngine )
    {
        this.aEngine = pGameEngine;
        this.createGUI();
    } // UserInterface()

    /**
     * Print out some text into the text area.
     * @param pText, String text.
     */
    public void print( final String pText )
    {
        this.aLog.append( pText );
        this.aLog.setCaretPosition( this.aLog.getDocument().getLength() );
    } // print(.)

    /**
     * Print out some text into the text area, followed by a line break.
     * @param pText, String text.
     */
    public void println( final String pText )
    {
        this.print( pText + "\n" );
    } // println(.)

    /**
     * Show an image file in the interface.
     * @param pImageName, the name of the image String.
     */
    public void showImage( final String pImageName )
    {
        String vImagePath = "Images/" + pImageName + ".jpg"; // to change the directory
        URL vImageURL = this.getClass().getClassLoader().getResource( vImagePath );
        if ( vImageURL == null )
            System.out.println( "Image not found : " + vImagePath );
        else {
            ImageIcon vIcon = new ImageIcon( vImageURL );
            //this.aImage.setIcon( vIcon ); Enlever, et remplacé par en dessous afin de redimensionné les images
            this.aImage.setIcon( new ImageIcon( vIcon.getImage().getScaledInstance(640,400,java.awt.Image.SCALE_SMOOTH)));
            //ligne de code au dessus, faite par Arthur FORTIN.
            this.aMyFrame.pack();
        }
        
        String vMapPath = "Maps/" + pImageName + "_map" + ".jpg";
        URL vMapURL = this.getClass().getClassLoader().getResource( vMapPath );
        if( vMapURL == null ){
            System.out.println( "Map non trouvé : " + vMapPath);
        }else{
            ImageIcon vIcone = new ImageIcon( vMapURL );
            this.aMap.setIcon( new ImageIcon( vIcone.getImage().getScaledInstance(320,400,java.awt.Image.SCALE_SMOOTH)));
            this.aMyFrame.pack();
        }
        this.aMyFrame.setLocationRelativeTo( null );
    } // showImage(.)
    
    /**
     * Enable or disable input in the input field.
     * @param pOnOff, boolean to active or not.
     */
    public void enable( final boolean pOnOff )
    {
        this.aEntryField.setEditable( pOnOff ); // enable/disable
        if ( ! pOnOff ) { // disable
            this.aEntryField.getCaret().setBlinkRate( 0 ); // cursor won't blink
            this.aEntryField.removeActionListener( this ); // won't react to entry
        }
    } // enable(.)

    /**
     * Set up graphical user interface.
     */
    private void createGUI()
    {
        this.aMyFrame = new JFrame( "Les Résistants" ); // change the title
        this.aEntryField = new JTextField( 34 ); // Longueur de la barre où tu écrit

        this.aLog = new JTextArea(); //Crée un afficheur de texte
        this.aLog.setEditable( false ); //Boolen qui détermine si on peut modifier le texte affiché
        //this.aLog.setPreferredSize( new Dimension( 500, 400)); N'est pas pris en compte
        
        JScrollPane vListScroller = new JScrollPane( this.aLog ); // Créer un Scroller pour l'afficheur de texte(aLog)
        vListScroller.setPreferredSize( new Dimension(200, 300) ); //Dimension du texte affiché
        vListScroller.setMinimumSize( new Dimension(100,100) ); // ?

        JPanel vPanel = new JPanel();
        
        JPanel vImageAndMap = this.createImageAndMap();
        vImageAndMap.addKeyListener(this);
        JPanel vButton = this.createButton();
        vButton.addKeyListener(this);
        this.aLog.addKeyListener(this);
        vListScroller.addKeyListener(this);
        
        vPanel.setLayout( new BorderLayout() ); // ==> only five places
        vPanel.add( vImageAndMap, BorderLayout.NORTH );
        vPanel.add( vListScroller, BorderLayout.CENTER );
        vPanel.add( this.aEntryField, BorderLayout.SOUTH);
        vPanel.add(vButton , BorderLayout.EAST); // Ajout du boutton à Est de l'appli
        
        this.aMyFrame.getContentPane().add( vPanel, BorderLayout.CENTER );

        this.aEntryField.addActionListener( this );

        // to end program when window is closed
        this.aMyFrame.addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        } );
    
        this.aMyFrame.pack();
        this.aMyFrame.setVisible( true ); // ? Rend visible l'appli ?
        
        
        
        this.aEntryField.requestFocus();
    } // createGUI()
    
    /**
     * Méthode qui crée un JPanel qui possède un cadre pour l'image de jeu et un pour la carte du jeu.
     * @return JPanel.
     */
    private JPanel createImageAndMap()
    {
        this.aImage = new JLabel();
        this.aMap = new JLabel();
        
        JPanel vPanel = new JPanel();
        vPanel.setBackground(Color.black);
        
        vPanel.setLayout( new BorderLayout() );
        vPanel.add( this.aImage, BorderLayout.CENTER);
        vPanel.add( this.aMap, BorderLayout.EAST);
        
    
        return vPanel;
    }//createImageAndMap()
    
    /**
     * Méthode qui crée un JPanel de boutton pour se déplacer (déplacement boussole).
     * @return JPanel.
     */
    private JPanel createButton()
    {
        JButton vBoutonNord = new JButton("Nord");
        vBoutonNord.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent pE){
                aEngine.interpretCommand("go nord");
            }
        });
        
        JButton vBoutonSud = new JButton("Sud");
        vBoutonSud.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent pE){
                aEngine.interpretCommand("go sud");
            }
        });
        
        JButton vBoutonEst = new JButton("Est");
        vBoutonEst.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent pE){
                aEngine.interpretCommand("go est");
            }
        });
        
        JButton vBoutonOuest = new JButton("Ouest");
        vBoutonOuest.addActionListener( new ActionListener(){
            public void actionPerformed( ActionEvent pE){
                aEngine.interpretCommand("go ouest");
            }
        });
        
        JPanel vJPanel = new JPanel();
        vJPanel.setLayout( new BorderLayout() );
        vJPanel.add( vBoutonNord, BorderLayout.NORTH);
        vJPanel.add( vBoutonEst, BorderLayout.EAST);
        vJPanel.add( vBoutonOuest, BorderLayout.WEST);
        vJPanel.add( vBoutonSud, BorderLayout.SOUTH);
        
        return vJPanel;
    }//createButton
    
    /**
     * Actionlistener interface for entry textfield.
     */
    public void actionPerformed( final ActionEvent pE ) 
    {
        // no need to check the type of action at the moment
        // because there is only one possible action (text input) : (Mais plus maintenant)
        // utilisatin de getsource afin d'obtenir la source de l'éveènement :
        // System.out.println("Qui " + pE.getSource() + " cliqué !");
        this.processCommand(); // never suppress this line
    } // actionPerformed()

    /**
     * A command has been entered. Read the command and do whatever is 
     * necessary to process it.
     */
    private void processCommand()
    {
        String vInput = this.aEntryField.getText();
        this.aEntryField.setText( "" );

        this.aEngine.interpretCommand( vInput );
    } // processCommand()
    
    /**
     * Méthode inutile Override pour l'interface.
     * @param pE la touche
     */
    @Override public void keyTyped(final KeyEvent pE){
        
    }//keyTyped()
    
    /**
     * Méthode qui permet d'exécuter l'instruction de déplacement selon les touches fléchés appuyés.
     * @param pE la touche
     */
    @Override public void keyReleased(final KeyEvent pE){
        switch( pE.getKeyCode() ){
            case 37 :
                //Touche de flèche gauche
                this.aEngine.interpretCommand("gauche");
                break;
            case 38 :
                //Touche de flèche haut
                this.aEngine.interpretCommand("avancer");
                break;
            case 39 :
                //touche de flèche droite
                this.aEngine.interpretCommand("droite");
                break;
            case 40 :
                //touche de flèche bas
                this.aEngine.interpretCommand("derriere");
                break;
        }
    }//keyReleased()
    
    /**
     * Méthode inutile Override pour l'interface.
     * @param pE la touche
     */
    @Override public void keyPressed(final KeyEvent pE){
        //System.out.println( pE.getKeyCode() );
        //System.out.println("tu as appuyé");
    }//keyPressed
} // UserInterface 
