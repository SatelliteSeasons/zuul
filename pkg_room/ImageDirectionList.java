package pkg_room;

import java.util.HashMap;


/**
 * Classe ImageDirectionList - Une classe qui liste les 4 images de 4 directions différentes d'un lieu/room.
 *
 * @author Richard Ho
 * @version 22/05/2023
 */
public class ImageDirectionList
{
    private HashMap<String,String> aImageDirectionList;
    private String aImageName;

    /**
     * Constructeur d'objets de classe ImageDirectionList
     * @param pImageName Le nom de l'image/fichier en String.
     */
    public ImageDirectionList( final String pImageName )
    {
        this.aImageDirectionList = new HashMap<String, String>();
        this.aImageName = pImageName;
        this.ajouterImage( "N", this.aImageName+"_N" );
        this.ajouterImage( "E", this.aImageName+"_E" );
        this.ajouterImage( "S", this.aImageName+"_S" );
        this.ajouterImage( "W", this.aImageName+"_W" );
    }//ImageDirectionList()
    
    /**
     * Méthode qui permet d'ajouter une image à la liste.
     * @param pDirection La direction que vise l'image avec un seul caractère en String.
     * @param ImageName Le nom de l'image en String.
     */
    public void ajouterImage( final String pDirection, final String ImageName )
    {
        this.aImageDirectionList.put(pDirection, ImageName);
    }//ajouterImage()
    
    /**
     * Méthode qui permet d'obtenir le nom de l'image.
     * @param pDirection La direction en String et un seul caractère.
     * @return Le nom de l'image en String.
     */
    public String getImage( final String pDirection )
    {
        return this.aImageDirectionList.get( pDirection );
    }//getImage()
    
}//ImageDirectionList
