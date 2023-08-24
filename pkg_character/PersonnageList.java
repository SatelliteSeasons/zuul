package pkg_character;

import java.util.HashMap;
import java.util.Set;

import java.util.ArrayList;
/**
 * Classe PersonnageList - Une classe qui permet de regrouper plusieurs personnage sous forme de liste.
 *
 * @author Richard Ho
 * @version 22/05/2023
 */
public class PersonnageList
{
    private HashMap<String, Personnage> aPersonnageList;

    /**
     * Constructeur d'objets de classe PersonnageList
     */
    public PersonnageList()
    {
        this.aPersonnageList = new HashMap<String, Personnage>();
    }//PersonnageList()
    
    /**
     * Méthode qui permet d'ajouter un personnage à la liste.
     * @param pName Le nom du personnage en String.
     * @param pPersonnage Le personnage en Personnage.
     */
    public void ajouterPersonnage( final String pName, final Personnage pPersonnage )
    {
        this.aPersonnageList.put(pName, pPersonnage);
    }//ajoutePersonnage()
    
    /**
     * Méthode qui permet d'enlever un personnage de la liste.
     * @param pName Le nom du personnage en String.
     */
    public void enleverPersonnage( final String pName )
    {
        this.aPersonnageList.remove( pName );
    }//enleverPersonnage()
    
    /**
     * Méthode qui retourne le personnage qu'on a mis en paramètre.
     * @param pName Le nom du personnage en String
     * @return Le personnage en Personnage.
     */
    public Personnage getPersonnage( final String pName )
    {
        return this.aPersonnageList.get( pName );
    }//getPersonnage()
    
    /**
     * Méthode qui retourne un set de String des personnages.
     * @return un Set de String.
     */
    public Set<String> keySetPersonnage()
    {
        return this.aPersonnageList.keySet();
    }//keySetPersonnage()
    
    /**
     * Méthode qui permet de retourner la liste des personnages qui initie la conversation.
     * @return En ArrayList de Personnage.
     */
    public ArrayList<Personnage> getFirstTalkPersonnageList()
    {
        Set<String> vPersoString = this.keySetPersonnage();
        ArrayList<Personnage> vPerso = new ArrayList<Personnage>();
        for( String vPersoName : vPersoString)
        {
            if( this.getPersonnage(vPersoName).getFirstTalkBoolean() ){
                vPerso.add( this.getPersonnage(vPersoName) );
            }
        }
        return vPerso;
    }//getFirstTalkPersonnageList()
    
    /**
     * Méthode qui permet de savoir si le personnage en paramètre est bien ou non dans la liste.
     * @param pName Le nom du personnage.
     * @return true si oui, false sinon.
     */
    public boolean contientPersonnage( final String pName )
    {
        return this.aPersonnageList.containsKey( pName );
    }//contientPersonnage()
}//PersonnageList
