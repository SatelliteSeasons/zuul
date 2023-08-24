package pkg_system;

import pkg_room.Room;
import pkg_room.TransporterRoom;

import pkg_room.ImageDirectionList;

import pkg_item.Item;
import pkg_item.Beamer;

import pkg_command.Command;

import pkg_character.PersonnageList;
import pkg_character.Personnage;

//
import java.util.Stack;
import java.util.ArrayList;

//Classe Pour Test()
import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

/**
 * Classe Game - Le moteur du jeu d'aventure
 *
 * @author Richard Ho
 * (30)
 * @version 22.05.2023
 */
public class GameEngine
{
    private Parser aParser;
    private UserInterface aGui;
    private Player aPlayer;
    private ArrayList<Room> aRoomRandomList;
    private boolean aEtatTest;
    
    private ArrayList<Personnage> aPersonnage;
    
    
    /**
     * Constructeur par défaut, déclare un joueur, création d'une liste des lieux du jeu
     * et lance le jeu.
     */
    public GameEngine()
    {
        this.aPlayer = new Player();
        this.aPersonnage = new ArrayList<Personnage>();
        this.aRoomRandomList = new ArrayList<Room>(30);
        this.createRooms();
        this.aEtatTest = false;
        this.aParser = new Parser();
    }//GameEngine()
    
    /**
     * Associe une interface graphique au moteur du jeu de l'objet courant.
     * @param pUserInterface, l'interface de type UserInterface, qu'on souhaite associer au moteur du jeu.
     */
    public void setGUI( final UserInterface pUserInterface)
    {
        this.aGui= pUserInterface;
        this.printWelcome();
    }//setGUI()
    
    /**
     * Méthode qui crée tout les lieux du jeu, les items, une liste de Room, leurs sorties et les personnages.
     */
    private void createRooms()
    {
        //Partie 1, créer les lieux/room et leurs description
        Room vGrandePlace = new Room("GrandePlace", "La grande intersection qui relie toute la ville.", "grandeplace");
        Room vRueNord1=new Room("RueNord1", "Rue Nord 1", "ruenord1");
        Room vRueNord2=new Room ("RueNord2", "Rue Nord 2", "ruenord2");
        Room vRueNord3=new Room("RueNord3", "Rue Nord 3", "ruenord3");
        
        Room vRueEst1=new Room("RueEst1", "Rue Est 1", "rueest1");
        Room vRueEst2 =new Room("RueEst2", "Rue Est 2", "rueest2");
        Room vRouteVide=new Room("RouteVide", "Une route vide, presque personne y traverse.", "routevide");
        Room vCampEnnemis=new Room("CampEnnemis", "Un endroit très dangereux, si possible, ne pas rester trop longtemps.", "campennemis");
        
        Room vRueSud1=new Room("RueSud1", "Rue Sud 1", "ruesud1");
        Room vRueSud2=new Room("RueSud2", "Rue Sud 2", "ruesud2");
        Room vMarchandArme=new Room("MarchandArme", "Lieu d'une marchande d'arme plutôt particulière.", "marchandarme");

        Room vTemple=new Room("Temple", "Un temple abandonné depuis un certains temps, seul un certains mégalomane y vit encore.", "temple");
        
        Room vRueOuest1=new Room("RueOuest1", "Rue Ouest 1", "rueouest1");
        Room vRueOuest2=new Room("RueOuest2", "Rue Ouest 2", "rueouest2");
        
        Room vGrandeCamelotte=new Room("GrandeCamelotte", "Un grand magasin qui vend tout et n'importequoi.", "grandecamelotte");
        Room vAuberge=new Room("Auberge", "Une auberge douce, où on ne veut plus partir.", "auberge");
        
        Room vLaboratoire=new Room("Laboratoire", "Un laboratoire de recherche, c'est ici qu'on a inventé la calculatrice.", "laboratoire");
        Room vSalleArchive=new Room("SalleArchive", "Une salle d'archive d'archive", "archive");
        
        Room vSalleTheatre=new Room("SalleTheatre", "Salle de théâtre", "theatre");
        Room vScene=new Room("Scene", "La scène", "scene");
        Room vCouloirTheatre=new Room("CouloirTheatre", "Couloir du théâtre", "couloir");
        Room vLoge=new Room("Loge", "La loge du théâtre", "loge");
        
        Room vAccueilPrison=new Room("AccueilPrison", "L'accueil de la prison", "accueilprison");
        Room vCouloirPrison=new Room("CouloirPrison", "Couloir de la prison", "couloirprison");
        Room vCelluleArika=new Room("CelluleArika", "Cellule d'Arika, une personne qui a l'air dangereuse et puissante.", "arika");
        
        Room vSalon=new Room("Salon", "Salon de DesirePeak", "salon");
        Room vSalleJeux=new Room("SalleJeux", "Salle de jeux de DesirePeak", "jeux");
        Room vSallePerso=new Room("SallePerso", "Salle du personnel", "perso");
            
        Room vRuine=new Room("Ruine", "Ruine d'une ancienne civilisation", "ruine");
        
        Room vTransporterRoom=new TransporterRoom("TransporterRoom", "RandomRoom hERE", "random",this.aRoomRandomList);
        
        //Partie 1.2 Association de lieux à une RandomListe pour  :
        this.aRoomRandomList.add(vGrandePlace);
        this.aRoomRandomList.add(vRueNord1);
        this.aRoomRandomList.add(vRueNord2);
        this.aRoomRandomList.add(vRueNord3);
        
        this.aRoomRandomList.add(vRueEst1);
        this.aRoomRandomList.add(vRueEst2);
        this.aRoomRandomList.add(vRouteVide);
        
        this.aRoomRandomList.add(vRueSud1);
        this.aRoomRandomList.add(vRueSud2);
        this.aRoomRandomList.add(vRuine);
        
        this.aRoomRandomList.add(vRueOuest1);
        this.aRoomRandomList.add(vRueOuest2);
        
        //Parie 1.5 Création d'item :
        
        Item vDynamite = new Item("Dynamite", "Littéralement des explosifs, à tenir écarter des enfants, ou bien des humains tout court.", 20);//
        Item vCafard = new Item("cafard", "Bestiole qu'on veut tous éviter.", 2);//
        Item vPioche = new Item("pioche", "Un outil permettant de miner principalement.", 10);//
        Item vCookie = new Item("cookie", "Ce cookie a l'air différent des autres cookies.", 5);
        Item vStopTime = new Item("stoptime", "Objet pour arrêter le mode timer.", 20);//
        Item vBeamer = new Beamer();
        
        Item vLampe = new Item("lampe", "Une lampe vétuste mais qui fonctionne encore, peut-être que ça appartient à quelqu'un ?", 20);
        Item vCalculatrice = new Item("calculatrice", "Une machine capable de faire des calculs à ta place jusqu'à ce qu'il te rend dépendant de lui.", 5);
        Item vPillier = new Item("pilier", "Un pilier qui appartient au temple de la ville, bien trop lourd pour toi.", 500);
        Item vClé = new Item("clé", "Une clé, permet d'ouvrir des serrures. Tu vas aller en prison pour avoir volé cette clé tu sais ?", 5);
        Item vLame = new Item("lame", "Une lame, attention, c'est plutôt tranchant.", 50);
        Item vDé = new Item("dé", "Objet qui est à l'origine de la moitié des dettes de la ville.", 2);
        Item vFeutre = new Item("feutre", "Accessoire qui donne la classe et permet de devenir adulte. Du moins, c'est ce que dit ton frère...", 20);
        
        //Partie 2, associer les différents lieux à leur sortie, créer le réseau et Item
        vAuberge.ajouterItem("cookie", vCookie);
        vLaboratoire.ajouterItem("calculatrice", vCalculatrice);
        vAccueilPrison.ajouterItem("clé", vClé);
        vCampEnnemis.ajouterItem("lame", vLame);
        vSallePerso.ajouterItem("dé",vDé);
        vLoge.ajouterItem("feutre",vFeutre);
        
        
        
        
        
        vGrandePlace.setExit("nord", vRueNord1);
        vGrandePlace.setExit("est", vRueEst1);
        vGrandePlace.setExit("sud", vRueSud1);
        vGrandePlace.setExit("ouest", vRueOuest1);
        

        vRueNord1.ajouterItem("pioche",vPioche);
        vRuine.ajouterItem("stoptime", vStopTime);
        vSalleArchive.ajouterItem("beamer", vBeamer);
        
        vRueNord1.setExit("nord", vRueNord2);
        vRueNord1.setExit("est", vTemple);
        vRueNord1.setExit("sud", vGrandePlace);
        vRueNord1.setExit("ouest", vGrandeCamelotte);
        
        vRueNord2.setExit("nord", vRueNord3);
        vRueNord2.setExit("est", vLaboratoire);
        vRueNord2.setExit("sud", vRueNord1);
        
        vRueNord3.setExit("est", vSalleArchive);
        vRueNord3.setExit("sud", vRueNord2);
        
        vSalleArchive.setExit("sud", vLaboratoire);
        vSalleArchive.setExit("ouest", vRueNord3);
        vLaboratoire.setExit("ouest", vRueNord2);
        
        vRueEst1.setExit("nord", vTemple);
        vRueEst1.setExit("est", vRueEst2);
        vRueEst1.setExit("ouest", vGrandePlace);
        
        vRueEst2.setExit("nord", vSalleTheatre);
        vRueEst2.setExit("est", vRouteVide);
        vRueEst2.setExit("ouest", vRueEst1);
        
        vRouteVide.setExit("est", vCampEnnemis);
        vRouteVide.setExit("ouest", vRueEst2);
        
        vCampEnnemis.setExit("ouest", vRouteVide);
        
        vSalleTheatre.setExit("nord", vScene);
        vSalleTheatre.setExit("sud", vRueEst2);
        vSalleTheatre.setExit("ouest", vCouloirTheatre);
        vScene.setExit("sud", vSalleTheatre);
        vScene.setExit("ouest", vLoge);
        vCouloirTheatre.setExit("nord", vLoge);
        vCouloirTheatre.setExit("est", vSalleTheatre);
        vLoge.setExit("est", vScene);
        vLoge.setExit("sud", vCouloirTheatre);
        vLoge.setExit("ouest", vTemple);
        
        vTemple.setExit("est", vLoge);
        vTemple.setExit("sud", vRueEst1);
        vTemple.setExit("ouest", vRueNord1);
        vTemple.ajouterItem("lampe", vLampe);
        vTemple.ajouterItem("pillier", vPillier);
        
        vRueSud1.setExit("nord", vGrandePlace);
        vRueSud1.setExit("est", vMarchandArme);
        vRueSud1.setExit("sud", vRueSud2);
        
        vRueSud2.setExit("nord", vRueSud1);
        vRueSud2.setExit("sud", vRuine);
        vRueSud2.setExit("ouest", vAccueilPrison);
        
        vRuine.setExit("nord", vRueSud2);
        //RandomAcess
        vRuine.setExit("sud", vTransporterRoom);
        
        vMarchandArme.setExit("nord", vRueEst1);
        vMarchandArme.setExit("ouest", vRueSud1);
        vMarchandArme.ajouterItem("cafard",vCafard);
        
        vRueOuest1.setExit("est", vGrandePlace);
        vRueOuest1.setExit("ouest", vRueOuest2);
        
        vRueOuest2.setExit("nord", vAuberge);
        vRueOuest2.setExit("est", vRueOuest1);
        vRueOuest2.setExit("sud", vSalon);
        
        vAuberge.setExit("est", vGrandeCamelotte);
        vAuberge.setExit("sud", vRueOuest2);
        vGrandeCamelotte.setExit("est", vRueNord1);
        vGrandeCamelotte.setExit("ouest", vAuberge);
        
        vGrandeCamelotte.ajouterItem("dynamite",vDynamite);
        
        vSalon.setExit("nord", vRueOuest2);
        vSalon.setExit("sud", vSalleJeux);
        vSalon.setExit("monter", vSallePerso);
        vSalleJeux.setExit("nord", vSalon);
        vSallePerso.setExit("descendre", vSalon);
        
        vAccueilPrison.setExit("est", vRueSud2);
        vAccueilPrison.setExit("descendre", vCouloirPrison);
        vCouloirPrison.setExit("monter", vAccueilPrison);
        vCouloirPrison.setExit("nord", vCelluleArika);
        vCelluleArika.setExit("sud", vCouloirPrison);
        
        //Partie 2.8 création des personnages
        vRueNord1.ajouterPersonnage( "Alex", new Personnage("Alex",false) );
        Personnage vAlex = vRueNord1.getPersonnage("Alex");
        vAlex.setFirstTalk( true );
        
        vRueNord2.ajouterPersonnage( "Steve", new Personnage("Steve",false) );
        Personnage vSteve = vRueNord2.getPersonnage("Steve");
        vSteve.ajouterNeedItem(vCookie);
        
        Personnage vKara = new Personnage("Kara",true);
        vKara.setCurrentRoom(vMarchandArme);
        vKara.setFirstTalk( true );
        ArrayList<Room> vKaraRoom = new ArrayList<Room>();
        vKaraRoom.add(vMarchandArme);
        vKaraRoom.add(vScene);
        vKara.setListRoom( vKaraRoom );
        vKara.ajouterNeedItem(vPioche);
        vKara.ajouterNeedItem(vDynamite);
        
        Personnage vBenoit = new Personnage("Benoit", true);
        vBenoit.setCurrentRoom(vTemple);
        vBenoit.setFirstTalk( false );
        ArrayList<Room> vBenoitRoom = new ArrayList<Room>();
        vBenoitRoom.add(vTemple);
        vBenoitRoom.add(vSalleTheatre);
        vBenoit.setListRoom( vBenoitRoom );
        vBenoit.ajouterNeedItem(vCalculatrice);
        vBenoit.ajouterNeedItem(vCafard);
        
        Personnage vArika = new Personnage("Arika", true);
        vArika.setCurrentRoom(vCelluleArika);
        vBenoit.setFirstTalk( false );
        ArrayList<Room> vArikaRoom = new ArrayList<Room>();
        vArikaRoom.add(vCelluleArika);
        vArikaRoom.add(vLoge);
        vArika.setListRoom( vArikaRoom );
        vArika.ajouterNeedItem(vClé);
        vArika.ajouterNeedItem(vLame);
        
        Personnage vEnka = new Personnage("Enka", true);
        vEnka.setCurrentRoom(vSalon);
        vEnka.setFirstTalk( true );
        ArrayList<Room> vEnkaRoom = new ArrayList<Room>();
        vEnkaRoom.add(vSalon);
        vEnkaRoom.add(vCouloirTheatre);
        vEnka.setListRoom(vEnkaRoom);
        vEnka.ajouterNeedItem(vDé);
        vEnka.ajouterNeedItem(vFeutre);
        
        
    
        
        Personnage vMia = new Personnage("Mia", false);
        vAuberge.ajouterPersonnage( "Mia", vMia );
        vMia.ajouterNeedItem(vLampe);
        vMia.setFirstTalk( false );
        
        
        this.aPersonnage.add(vKara);
        this.aPersonnage.add(vBenoit);
        this.aPersonnage.add(vArika);
        this.aPersonnage.add(vEnka);
        
        
        
        //Partie 3, placer le lieu actuel, le commencement
        this.aPlayer.setCurrentRoom( vGrandePlace );
    }//createRooms()
    
    /**
     * Méthode qui affiche la description du lieu courant et les différents direction possible des
     * prochains lieux.
     */
    public void printLocationInfo()
    {
        if( this.aPlayer.getCurrentRoom().getImageName()!=null){
                this.aGui.showImage( this.aPlayer.getCurrentRoom().getImageHashMap().getImage( this.aPlayer.getDirection() ) );
        }
        this.aGui.println( this.aPlayer.getCurrentRoom().getLongDescription() );
        this.printFirstTalk();
        if(aPersonnage.get(0).getEndGame() && aPersonnage.get(1).getEndGame() && aPersonnage.get(2).getEndGame() && aPersonnage.get(3).getEndGame()){
            this.aGui.println("Félicitation, 4 personnes ont rejoins votre équipe, vous avez gagné !");
            aPersonnage.get(0).setEndGame();
        }
    }//printLocationInfo()
    
    /**
     * Méthode qui permet d'afficher les messages des personnages qui parle lorsqu'on arrive dans un lieu.
     */
    private void printFirstTalk()
    {
        if( !(this.aPlayer.getCurrentRoom().getPersonnageList().getFirstTalkPersonnageList()).isEmpty() ){
            ArrayList<Personnage> vListPerso = this.aPlayer.getCurrentRoom().getPersonnageList().getFirstTalkPersonnageList();
            for(Personnage vPerso : vListPerso)
            {
                this.aGui.println("\n" + vPerso.getFirstTalkString() );
            }
        }
    }//printFirstTalk()
    
    /**
     * Méthode qui affiche un message de bienvenue.
     */
    private void printWelcome()
    {
        this.aGui.println("Bienvenue à granbo");
        this.aGui.println("Une ville qui va bientôt subir l'assaut de troupe ennemis");
        this.aGui.println("Trouve l'aide de 4 personne pour monter un groupe de résistant et espérer repousser l'envahisseur.");
        this.aGui.println("écrit aide pour avoir plus d'aide");
        this.aGui.println("");
        printLocationInfo();
    }//printWelcome()
    
    /**
     * Méthode qui affiche un message d'aide.
     */
    public void printHelp()
    {
        this.aGui.println("Tu dois trouver les bonnes personnes tout en réglant leur soucis afin qu'ils acceptent de te rejoindre.");
        this.aGui.println("");
        this.aGui.println("");
        this.aGui.println("Tes commandes sont :");
        this.aGui.println(this.aParser.getCommandsString());
        this.aGui.println("");
    }//printHelp()
    
    /**
     * Méthode qui affiche le nombre d'action actuellement effectuée sur le nombre d'action maximum pouvant
     * être effectuée.
     */
    private void printTimeInfo()
    {
        this.aGui.println("Vous êtes à "+this.aPlayer.getAction()+"/"+this.aPlayer.getActionMax()+" action maximum");
    }//printTimeInfo()
    
    /**
     * Méthode permettant d'afficher l'inventaire du joueur.
     */
    public void inventaire()
    {
        this.aGui.println( this.aPlayer.inventaireString() );
    }//inventaire()
    
    /**
     * Méthode qui active le mode Timer.
     */
    public void timeAction()
    {
        this.aGui.println("Mode timer activé, vous avez droit à "+ this.aPlayer.getActionMax() +
        " actions au maximum avant de perdre");
        this.aPlayer.setAction(0);
        this.aPlayer.setTimeMode(true);
    }//timeAction()
    
    /**
     * Méthode qui affiche les informations sur le mode Time, ou met fin au jeu dû au manque de temp
     */
    public void timeEtat()
    {
        if(this.aPlayer.getTimeMode() ){
            if( this.aPlayer.timeUp() ){
                this.endTime();
            }else{
                this.aPlayer.plusUnAction();
                this.printTimeInfo();
            }
        }
    }//timeEtat()
    
    /**
     * Méthode qui exécute la/les classe de commande associé à la commande reçu en paramètre.
     * @param pCommandLine, une commande en String
     */
    public void interpretCommand(final String pCommandLine)
    {
        this.aGui.println("> " + pCommandLine);
        Command vCommande = this.aParser.getCommand(pCommandLine);
        
        if(vCommande == null){
            this.aGui.println("Je ne comprend pas ce que je dois faire...");
            return;
        }

        vCommande.execute(this.aPlayer, this.aGui, this);
        
    }//interpretCommand()
    
    /**
     * Méthode qui arrête le jeu et envoie un message.
     */
    public void endGame()
    {
        this.aGui.println("Thank you for playing. GoodBye.");
        this.aGui.enable(false);
    }//endGame()
    
    /**
     * Méthode qui arrête le jeu et envoie un message d'écoulement de temps.
     */
    public void endTime()
    {
        this.aGui.println("Nombre d'action écoulé, fin de partie");
        this.aGui.enable(false);
    }//endTime()
    
    //acesseur et modificateur
    
    /**
     * Méthode qui modifie l'état Test du jeu.
     * @param pActive Un booléen, true si le jeu est en mode teste, false sinon.
     */
    public void setEtatTest( final boolean pActive )
    {
        this.aEtatTest = pActive;
    }//setEtatTest()
    
    /**
     * Méthode qui retourne l'état teste du jeu.
     * @return un booléen, true si le jeu est en mode teste, false sinon.
     */
    public boolean getEtatTest()
    {
        return this.aEtatTest;
    }//getEtatTest()
    
    /**
     * Méthode qui retourne la liste des Room Random.
     * @return Une ArrayList de Room.
     */
    public ArrayList<Room> getRoomRandomList()
    {
        return this.aRoomRandomList;
    }//getRoomRandomList()
    
} //GameEngine
