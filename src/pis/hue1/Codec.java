package pis.hue1;

/**
 * @author cedric
 * Interface Codec wird von den Klassen Caesar und Wuerfel implementiert
 * @author Cedric Ndong
 * version 1.0
 */
public interface Codec {
    /**
     * @param klartext
     * @return String Geheimtext
     */
    public String kodiere(String klartext);

    /**
     * @param geheimtext
     * @return String Klartext
     */
    public String dekodiere(String geheimtext);

    /**
     * @return String Schluessel
     */
    public String gibLosung();

    /**
     * @param schluessel
     * @throws IllegalArgumentException bei ungeeignetem Schluessel!
     */
    public void setzeLosung(String schluessel)throws
            IllegalArgumentException; // bei ungeeignetem Schluessel!


}
