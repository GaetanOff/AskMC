import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

/**
 * Solution proposée par
 * -> Gaetan#0099
 */
public class index {

    //On init le programme en lancant la fonction sequence avec la valeur souhaité
    public static void main(String[] args) {
        sequence(0);
    }

    //Fonction pour calculer la suite
    public static void sequence(int nbr) {
        if (nbr < 0)
            return;

        String result = "1";

        for (int i = 0; i < nbr; i++) {
            result = rle(result);
        }

        System.out.println(result);
    }

    //Fonction pour traduire un nombre avec la suite donnée
    public static String rle(String val) {
        StringBuilder sb = new StringBuilder();
        CharacterIterator itr = new StringCharacterIterator(val);

        char current = itr.current();
        int count = 1;

        while(current != CharacterIterator.DONE) {

            count = 1;

            while(itr.next() == current) {
                count++;
            }

            itr.previous();
            sb.append(count).append(current);

            current = itr.next();
        }

        return sb.toString();
    }
}
