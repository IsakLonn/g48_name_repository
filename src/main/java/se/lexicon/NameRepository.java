package se.lexicon;
import java.util.Arrays;

public class NameRepository {

    private static String[] names = new String[0];


    /**
     * returns numbers of elements in the array
     */
    public static int getSize(){
        return names.length;
    }

    /**
     * sends in an array that set the private static array
     */
    public static void SetNames(String[] names){

    }

    /**
     * clears all names
     */
    public static void clear(){
        names = new String[0];
    }

    /**
     * returns all new in a new array
     */
    public static String[] findAll(){
        return new String[0];
    }

    /**
     * name if found and null if not found.
     */
    public static String[] find(final String fullName){

        return Arrays.copyOf(names, names.length);
    }

    /**
     * Should add a new name to the array. Returns
     * true when name was added and false when the array contains the name.
     */
    public static boolean add(final String fullName) {
        if (find(fullName) != null) {
            return false;
        }
        for (int i = 0; i < names.length; i++) {
            if(names[i] == fullName)
            {
                // name exists, do nothing
                return false;
            }
        }

        names = Arrays.copyOf(names, names.length + 1);
        names[names.length - 1] = fullName;
        return true;
    }
    /**
     * Searches the array trying to find
     * all names that has passed in first name. Returns a String array containing all
     * matches.
     */
    public static String[] findByFirstName(final String firstName){
        String[] result = new String [0];
        for (String name : names) {
            String[] parts = name.split("");
            if (parts[0].equals(firstName)) {
                result = Arrays.copyOf(result, result.length +1);
                result [result.length -1]  =name;
            }
        }
        return new String[0];
    }

    /**
     * Searches the array trying to find all names that has passed in last name. Returns a String array
     * containing all
     * matches.
     */
    public static String[] findByLastName(final String lastName){
        String[] result = new String [0];
        for (String name : names) {
            String[] parts = name.split("");
            if (parts[1]).equals(lastName)) {
                result = Arrays.copyOf(result, result.length +1);
                result[result.length -1] = name;
            }
        }
        return new String[0];
    }

    /**
     * Should remove a name from the array.
     * Returns true if name was removed and false if the name was not removed for some reason
     */
    public static boolean remove(final String fullName) {

        boolean success = false;

        String[] copy = new String[names.length - 1];
        int index = 0;
        for (int i = 0; i < names.length; i++) {
            if(names[i] == fullName)
            {
                success = true;
                continue;
            }
            copy[index] = names[i];
            index++;
        }

        names = copy;

        return success;

        /* for (int i = 0; i < names.length; i++) {
            if (names[i].equals(fullName)) {
                names = removeFromArray(names, i);
                return true;
            }
        }
        */

        //return false;
    }

    /**
     * Should find a
     * name and replace it with new fullName if available. Returns true if name was found and updated with
     * the new name. False if name could not be updated because name wasn’t found or name was found but
     * an existing name matching the updatedName already exists.
     */
    public static boolean update(final String original, final String updatedName){

        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(original)) {
                names[i] = updatedName;
                return true;
            }
        }
        return false;

    }

}
