package pis.hue1;

/**
 * Die Klasse Wuerfel implementiert die Klasse Codec
 * Klassen ínvariante:
 * 1) Schlussel darf nicht leer sein
 * 2) schluessel darf nicht null sein
 * @author Cedric Ndong
 * version 1.0
 */

public class Wuerfel implements Codec {

    /**
     * Die Variable Schluessel ist die Klasseninvariante
     */
    private String schluessel;

    /**
     * Der Konstruktor der Klasse Wuerfel
     */

    public Wuerfel(String schluessel) {

        this.schluessel = schluessel;
    }

    /**
     * verschluesselt den Klartext
     * @param klartext ist der Text zu entschluesseln
     * @return der Geheimtext wird zuruekgegeben
     */
    @Override
    public String kodiere(String klartext) {
        this.schluessel = schluessel.toUpperCase();
        int[] position = new int[schluessel.length()];
        int[] permutation = new int[schluessel.length()];
        StringBuilder wuerfelKodiert = new StringBuilder();

/**
 * dient zur Position
 */
        int count = 1;
        for (char a = 'A'; a <= 'Z'; a++) {
            for (int i = 0; i < schluessel.length(); i++) {
                if (schluessel.charAt(i) == a) {
                    position[i] = count;
                    count++;
                }
            }
        }

/**
 * dient zur Permutation
 */
        for (int i = 0 ; i < position.length; i++){
            permutation[position[i] - 1] = i;
        }

/**
 * Hier wird der Text kodiert
 */
        for (int i = 0 ; i < permutation.length; i++){
            for (int j = 0 ; j < klartext.length(); ){
                if( permutation[i] ==  j % permutation.length){
                   wuerfelKodiert.append(klartext.charAt(j));
                    j = j + permutation.length;
                }
                else {
                    j++;
                }
            }
        }
        return wuerfelKodiert.toString();
    }

    /**
     * verschluesselt den Geheimtext
     * @param geheimtext ist der Text zu entschluesseln
     * @return der Klartext wird zuruekgegeben
     */
    @Override
    public String dekodiere(String geheimtext) {

        this.schluessel = schluessel.toUpperCase();
        int[] dekPosition = new int[schluessel.length()];
        int[] dekPermutation = new int[schluessel.length()];
        char[] tempWuerfelDekodiert = new char[geheimtext.length()] ;

/**
 * dient zur Position
 */
        int count = 1;
        for (char a = 'A'; a <= 'Z'; a++) {
            for (int i = 0; i < schluessel.length(); i++) {
                if (schluessel.charAt(i) == a) {
                    dekPosition[i] = count;
                    count++;
                }
            }
        }

/**
 * dient zur Permutation
 */
        for (int i = 0 ; i < dekPosition.length; i++){
            dekPermutation[dekPosition[i] - 1] = i;
        }


/**
 * Hier wird der Text dekodiert
 */
        int temp0 = 0;
        int temp1 = 0;
        for (int i = 0; i < geheimtext.length(); i++) {

           tempWuerfelDekodiert[dekPermutation[temp1]  + temp0] = geheimtext.charAt(i);

            temp0 = temp0 + dekPermutation.length;
            if (dekPermutation[temp1] + temp0 >= geheimtext.length()) {
                temp0 = 0;
                temp1++;

            }
        }
        String wuerfelDekodiert = new String(tempWuerfelDekodiert);
        return wuerfelDekodiert.toString();
    }

    /**
     * Gibt das Losungwort zurueck
     * @return das Losungwort
     */
    @Override
    public String gibLosung() {
        return this.schluessel;
    }

    /**
     * @param schluessel
     * @throws IllegalArgumentException bei ungeeignetem Schluessel!
     */
    @Override
    public void setzeLosung(String schluessel) throws IllegalArgumentException {
        if(schluessel == null){
            throw new IllegalArgumentException("Schluessel darf nicht null sein");
        }else if(schluessel.length() == 0){
            throw new IllegalArgumentException("Schlussel darf nicht leer sein");
        }else{
            this.schluessel = schluessel;
        }

    }
}
