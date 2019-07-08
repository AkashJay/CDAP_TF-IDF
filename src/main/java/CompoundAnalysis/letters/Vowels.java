package CompoundAnalysis.letters;

public class Vowels {

    /* This function is useful in many use cases.
    Called when a vowel of a sinhala semi character needed.
     */

    public static char getVowel(String input){
        char output = ' ';

        /* These vowels are constant and won't be needed to be modify or extend.
        Considering the use case there is no need to store these in a db or file. Keeping these values in memory is doable and also increases performance.
         */

        switch (input){
            case "ු":
                output = 'උ';
                break;
            case "ූ":
                output = 'ඌ';
                break;
            case "ි":
                output = 'ඉ';
                break;
            case "":
                output = 'ඊ';
                break;
            case "ා":
                output = 'ආ';
                break;
            case "ැ":
                output = 'ඇ';
                break;
            case "‌ෙ":
                output = 'එ';
                break;
            case "්":
                output = ' ';
                break;
            default:
                output = 'අ';
        }

        return output;
    }

    public static boolean isVowel(char input){
        boolean output;

        switch (input){
            case 'අ':
                output = true;
                break;
            case 'ආ':
                output = true;
                break;
            case 'ඉ':
                output = true;
                break;
            case 'ඊ':
                output = true;
                break;
            case 'උ':
                output = true;
                break;
            case 'ඌ':
                output = true;
                break;
            default:
                output = false;
        }

        return output;
    }

    public static char getCharAddon(String string){
        char output;

        switch (string){
            case "ඇ":
                output = 'ැ';
                break;
            case "ආ":
                output = 'ා';
                break;
            case "ඈ":
                output = 'ෑ';
                break;
            case "ඉ":
                output = 'ි';
                break;
            case "ඊ":
                output = 'ී';
                break;
            case "උ":
                output = 'ු';
                break;
            case "ඌ":
                output = 'ූ';
                break;
            default:
                output = 'අ';
        }
        return output;
    }
}
