import java.util.Scanner;

public class REO {
    //values
    private static Scanner sIn = new Scanner(System.in);
    private static final String lines = "----------------------------------------";

    public static void main(String[] args){
        while(true){ //the office will always be open in theory, so never close this loop
            mainMenu();
            }//end while(!closed)
        }//end public static void main(String[] args)



    /**
     * this will both present and handle the main menu interaction, returning the response as an integer.
     */
    private static void mainMenu(){
        print(formatTitle("Main Menu"),false);
        //formats the options printout in a single text string
        String options = String.format("%s%n%s%n%n%n%s","1:Listings","2:Bids","What would you like to do? (1-2):");
        //ask for the user input, validating their input
        String response = "";
        do {
            print(options,false);
            response = sIn.nextLine();
            //if they enter kaput, go back to main
            if (response.length() == 0){return;}
        }while(!isValid(2,response));
        //return the choice submitted as an integer
        switch (Integer.parseInt(response)) {
            //Listings
            case 1 -> listings();
            //Bids
            case 2 -> bids();
        }
    }

    /**
     * this will both present and handle the listings menu interaction, either returning to either
     * the main menu, the corresponding menu choice, or the selected method.
     */
    private static void listings(){
        print(formatTitle("Listing Menu"),false);
        //formats the options printout in a single text string
        String options = String.format("%s%n%s%n%s%n%s%n%n%n%s",
                "1: Add Listing",
                "2: Show Listings",
                "3: Auto Populate Listings (Dev tool)",
                "ENTER: Exit back to previous menu",
                "What would you like to do? (1-3):");
        //ask for the user input, validating their input
        String response = "";
        do {
            print(options,false);
            response = sIn.nextLine();
            //if they enter kaput, go back to main
            if (response.length() == 0){return;}
        }while(!isValid(3,response));
        //return the choice submitted as an integer
        switch (Integer.parseInt(response)) {
            //add a listing
            case 1 -> addListing();
            //show listings
            case 2 -> showListings();
            //auto populate listings
            case 3 -> autoPopulateListings();
        }//end switch (Integer.parseInt(response))
    }//end private static void listings()

    private static void bids(){
        print(formatTitle("Listing Menu"),false);
        //formats the options printout in a single text string
        String options = String.format("%s%n%s%n%s%n%s%n%n%n%s",
                "1: Add New Bid",
                "2: Show Existing Bids",
                "3: Auto Populate Listings (Dev tool)",
                "ENTER: Exit back to previous menu",
                "What would you like to do? (1-3):");
        //ask for the user input, validating their input
        String response = "";
        do {
            print(options,false);
            response = sIn.nextLine();
            //if they enter kaput, go back to main
            if (response.length() == 0){return;}
        }while(!isValid(3,response));
        //return the choice submitted as an integer
        switch (Integer.parseInt(response)) {
            //add a listing
            case 1 -> addNewBid();
            //show listings
            case 2 -> showExistingBids();
            //auto populate listings
            case 3 -> autoPopulateListings();
        }//end switch (Integer.parseInt(response))
    }//end private static void bids()

    private static void addListing(){
        print("selected addListing",true);
    }

    private static void showListings(){
        print("selected showListings",true);
    }

    private static void autoPopulateListings(){
        print("selected autoPopulateListings",true);
    }

    private static void addNewBid(){
        print("selected addNewBid",true);
    }

    private static void showExistingBids(){
        print("selected showExistingBids",true);
    }

    /**
     * @param printMe the actual text to be printed
     * @param isPrintLine if you want this to be printed like a printLn rather than a simple print statement
     */
    private static void print(String printMe, boolean isPrintLine){
        if (isPrintLine) {
            System.out.println(printMe);
        }else{
            System.out.print(printMe);
        }
    }//private static void print(String printMe, boolean isPrintLine)

    /**
     * @param printMe this is the text within the header
     * @return this returns a string which can be printed. this doesn't print the string
     */
    private static String formatTitle(String printMe){
        int length = (lines.length() - printMe.length())/2;
        StringBuilder buffer = new StringBuilder();
        int i = 0;
        while(i < length){
            buffer.append(" ");
            i++;
        }
        return String.format("%s%n%s%n%s%n",lines,buffer + printMe + buffer,lines);
    }

    /**
     * @param optionCount this is the max option integer. used in validating the input and providing the error prompt
     * @param input this is the input the user's provided, which is validated with this method
     * @return this method determines if the input for any of the menu items is valid (both an int and appropriate)
     */
    private static boolean isValid(int optionCount, String input){
        String error = String.format("invalid response. please choose 1-%d%n%s",optionCount,lines);
        try{
            int option = Integer.parseInt(input);
//            print("is valid",true);
           if (option > 0 && option <= optionCount){
               return true;
           }else{
               print(error, true);
               return false;
           }
        }catch(NumberFormatException badResponse){
//            print("is not valid", true);
            print(error,true);
            return false;
        }
    }
}//end public class REO
