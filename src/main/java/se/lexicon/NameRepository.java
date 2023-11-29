package se.lexicon;
import java.util.Arrays;
import java.util.Objects;

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
    public static void SetNames(String[] namesToAdd){

        int startIndex = names.length;

        names = Arrays.copyOf(names, names.length+namesToAdd.length);

        int index = 0;

        System.out.println(names.length);
        System.out.println(namesToAdd.length);

        for (int i = startIndex; i < names.length; i++) {
            System.out.println(i);
            names[i] = namesToAdd[index];
            index++;
        }
    }

    /**
     * clears all names
     */
    public static void clear(){
        names = new String[0];
    }

    /**
     * returns all names in a new array
     */
    public static String[] findAll(){
        return Arrays.copyOf(names, names.length);
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
        /*
        if (find(fullName) != null) {
            return false;
        }
        */

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
            if (name.contains(firstName)) {
                result = Arrays.copyOf(result, result.length +1);
                result [result.length -1]  =name;
            }
        }
        return result;
    }

    /**
     * Searches the array trying to find all names that has passed in last name. Returns a String array
     * containing all
     * matches.
     */
    public static String[] findByLastName(final String lastName){
        String[] result = new String [0];
        for (String name : names) {
            if(name.contains(lastName))
            {
                result = Arrays.copyOf(result, result.length+1);
                result[result.length - 1] = name;
            }
            /*
            String[] parts = name.split("");
            if (parts[1]).equals(lastName)) {
                result = Arrays.copyOf(result, result.length +1);
                result[result.length -1] = name;
            }
            */
        }
        return result;
    }

    /**
     * Should remove a name from the array.
     * Returns true if name was removed and false if the name was not removed for some reason
     */
    public static boolean remove(final String fullName) {

        if(!contains(names, fullName)) return false;
        boolean success = false;

        String[] copy = new String[names.length - 1];
        int index = 0;
        for (int i = 0; i < names.length; i++) {
            if(names[i].equals(fullName))
            {
                success = true;
            }
            else if(names[i] != fullName)
            {
                System.out.println(names[i]);
                copy[index] = names[i];
                index++;
            }


        }

        if(success) names = copy; // only update name array if successful in removal

        return success;
    }

    static boolean contains(String[] arr, String name)
    {
        for (String s : arr) {
            if (Objects.equals(s, name)) return true;
        }

        return false;
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
