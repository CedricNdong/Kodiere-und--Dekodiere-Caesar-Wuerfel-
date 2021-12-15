package pis.hue1;

/**
 * Die Klasse Caesar implementiert die Klasse Codec
 *  Klassen ínvariante:
 *   1) Schlussel darf nicht leer sein
 *  2) schluessel darf nicht null sein
 *    3) shlußel darf nicht laenger 32 zeichen sein
 * @author Cedric Ndong
 * version 1.0
 */
public class Caesar implements Codec {

    /**
     * Die Variable Schluessel ist die Klasseninvariante
     */
    private String schluessel ;

    /**
     * verschluesselt den Klartext
     * @param klarText ist der Text zu entschluesseln
     * @return der Geheimtext wird zuruekgegeben
     */
    @Override
    public String kodiere(String klarText) {

        int asciiWerte,geheimInt,restEncrypt;
        char geheimChar;
        StringBuilder geheimText = new StringBuilder();


        for (int i = 0; i < klarText.length(); i++) {


            asciiWerte = (int)klarText.charAt(i);
            geheimInt = asciiWerte + schluessel.length();

            if (asciiWerte > 96 && asciiWerte < 123) { // der Buchstabe ist erst [a - z]

                if (geheimInt > 122 ) {
                    restEncrypt = geheimInt % 122;
                    geheimInt = 96 + restEncrypt;
                }
            }
            else if (asciiWerte > 64 && asciiWerte < 91) {// der Buchstabe ist erst [A - Z]

                if (geheimInt > 90 ) {
                    restEncrypt = geheimInt % 90;
                    geheimInt = 64 + restEncrypt;
                }
            }
            else {
                geheimInt -=schluessel.length();
            }
            geheimChar = (char) geheimInt;
            geheimText.append(geheimChar);
        }
        return geheimText.toString();
    }

    /**
     * verschluesselt den Geheimtext
     * @param geheimText ist der Text zu entschluesseln
     * @return der Klartext wird zuruekgegeben
     */
    @Override
    public String dekodiere(String geheimText) {


        int asciiWerte,geheimInt;
        char asciiChar;
        int count;
        StringBuilder entschluesseltText = new StringBuilder();

        for (int i = 0; i < geheimText.length(); i++) {

            geheimInt = (int)geheimText.charAt(i);
            asciiWerte = geheimInt - schluessel.length();

            if (geheimInt > 96 && geheimInt < 123) { // der verschluesse Buchstabe ist erst [a - z]

                if (asciiWerte < 97 ) {
                    count = 97 - asciiWerte;
                    asciiWerte = 123 - count;
                }
            }
            else if (geheimInt > 64 && geheimInt < 91) {// der Buchstabe ist erst [A - Z]

                if (asciiWerte < 65 ) {
                    count = 65 - asciiWerte;
                    asciiWerte = 91 - count;
                }
            }
            else {
                asciiWerte += schluessel.length();
            }

            asciiChar = (char) asciiWerte;
            entschluesseltText.append(asciiChar);
        }

        return entschluesseltText.toString();
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
            throw new IllegalArgumentException("Schlussel darf nicht null sein");
        }else if(schluessel.length() == 0){
            throw new IllegalArgumentException("Schlussel darf nicht leer sein");
        }else if(schluessel.length() > 32){
            throw new IllegalArgumentException("Schlussel darf nicht laenger als 32 Zeichen  sein");
        }else{
            this.schluessel = schluessel;
        }
    }

}
