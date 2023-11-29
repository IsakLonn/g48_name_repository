package se.lexicon;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    static enum Name
    {
        LASTNAME,
        FIRSTNAME
    }

    static boolean isRunning = true;

    public static void main(String[] args) {
        run();
    }
    static void run(){

        // some variables to use in the switch cases
        String name;
        String[] names = new String[0];
        boolean success;

        while(isRunning)
        {
            welcomeText();

            int value = getIntInput();

            switch (value)
            {
                case 1:
                    name = getFullName();
                    boolean containsName = NameRepository.add(name);
                    if(!containsName) println("Name already exists. It wont be added to the system");
                    break;

                case 2:
                    boolean isDone = false;
                    while(!isDone)
                    {
                        names = Arrays.copyOf(names, names.length + 1);
                        names[names.length - 1] = getFullName();
                        println("Want to enter more names? y/n");
                        if(!Objects.equals(getInput(false).toLowerCase(), "y")) isDone = true;
                    }
                    NameRepository.SetNames(names);
                    break;

                case 3:
                    //update name
                    println("Please give the name to update followed by the new name");
                    name = getFullName();
                    String updatedName = getFullName();
                    success = NameRepository.update(name, updatedName);
                    if(!success) println("Name was not updated. Are you sure you entered the correct name?");
                    break;

                case 4:
                    names = NameRepository.findAll();
                    printArray(names, "All names in the system");
                    break;

                case 5:
                    println("There are " + NameRepository.getSize() + " names in the system"); ;
                    break;

                case 6:
                    name = getName(true);
                    names = NameRepository.findByLastName(name);
                    printArray(names, "Names that go by last name " + name);
                    break;

                case 7:
                    name = getName(false);
                    names = NameRepository.findByFirstName(name);
                    printArray(names, "Names that go by first name " + name);
                    break;

                case 8:
                    println("Are you sure you want to clear all names from the system? y/n");
                    if(Objects.equals(getInput(false).toLowerCase(), "y")) NameRepository.clear();
                    break;

                case 9:
                    name = getFullName();
                    success = NameRepository.remove(name);
                    if(!success) println("Error removing name from system. Possible name does not exist?");
                    break;

                case 10:
                    println("Exiting program, goodbye.");
                    isRunning = false;
                    break;
            }
        }
    }

    private static void welcomeText() {
        println("welcome to the name repository!");
        println("Enter what you would like to do:");
        println("1. Add a name");
        println("2. Add multiple names");
        println("3. Update a name in the system");
        println("4. Get all names in the system");
        println("5. Get how many names are in the system");
        println("6. Find by last name");
        println("7. Find by first name");
        println("8. Clear all names from the system");
        println("9. Remove a name from the system");
        println("10. Exit program");
    }

    /**
     * prints text without making a new line
     */
    static void print(String text){
        System.out.print(text);
    }

    /**
     * prints text, end with a new line
     */
    static void println(String text){
        System.out.println(text);
    }

    static int getIntInput()
    {
        println("Please input an integer");
        boolean exception;
        String input;
        int value = 0;
        while(true)
        {
            exception = false;
            input = getInput(false);
            try {
            value = Integer.parseInt(input);
            }catch(Exception e){
                exception = true;
            }
            if(exception) println("Error in input. Please input an integer");
            else return value;
        }

    }

    static String getInput(boolean askForInput){
        if(askForInput) println("Input:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    static String getFullName()
    {
        String firstName;
        String lastName;
        String fullName = "";
        boolean correctName = false;
        while(!correctName)
        {
            print("Please give a first name:");
            firstName = getInput(false);
            print("Please give a last name:");
            lastName = getInput(false);
            fullName = firstName + " " + lastName;
            println("The name put in is " + fullName + ". Is this correct? y/n");

            correctName = Objects.equals(getInput(false).toLowerCase(), "y");
        }

        return fullName;
    }

    /**
     * gets a name from user, use parameter to tell if it is a first or last name
     */
    static String getName(boolean isLastName)
    {
        String name = "";
        boolean correctName = false;
        while(!correctName)
        {
            if(isLastName) print("Please give a last name:");
            else print("Please give a first name:");
            name = getInput(false);
            println("The name put in is " + name + ". Is this correct? y/n");

            correctName = Objects.equals(getInput(false).toLowerCase(), "y");
        }

        return name;
    }

    static void printArray(String[] arr, String headerText)
    {
        println(headerText);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static void updatedName(){
        String originalName = "";
        String updatedName = "";
        if (NameRepository.update(originalName, updatedName)) {
            System.out.println("Updated name: " + originalName + " -> " + updatedName);
        } else {
            System.out.println("Name not found or already exists: " + originalName);
        }
    }

}