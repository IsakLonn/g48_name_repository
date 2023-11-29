package se.lexicon;

public class NameRepository {

    static String[] names;


    /**
     * returns numbers of elements in the array
     */
    public static int getSize(){
        return 0;
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
    public static String find(final String fullName){
        return null;
    }

    /**
     * Should add a new name to the array. Returns
     * true when name was added and false when the array contains the name.
     */
    public static boolean add(final String fullName){
        return true;
    }

    /**
     * Searches the array trying to find
     * all names that has passed in first name. Returns a String array containing all
     * matches.
     */
    public static String[] findByFirstName(final String firstName){
        return new String[0];
    }

    /**
     * Should find a
     * name and replace it with new fullName if available. Returns true if name was found and updated with
     * the new name. False if name could not be updated because name was’t found or name was found but
     * an existing name matching the updatedName already exists.
     */
    public static String[] findByLastName(final String lastName){
        return new String[0];
    }

    /**
     * Should remove a name from the array.
     * Returns true if name was removed and false if the name was not removed for some reason
     */
    public static boolean remove(final String fullName){
        return false;
    }

}
