package se.lexicon;

public class Main {
    public static void main(String[] args) {
        run();
    }

    static void run(){
        boolean isRunning = true;

        while(isRunning)
        {
            welcomeText();
        }
    }

    private static void welcomeText() {
        println("welcome to the name repository!");
        
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
}