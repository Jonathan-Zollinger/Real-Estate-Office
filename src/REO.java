import java.util.Scanner;

public class REO {
    //values
    private static Scanner sIn = new Scanner(System.in);
    private static final String lines = "----------------------------------------";
    private static Listings listings;
    private static String question = "what is the %s of the residence?";


    //main (constructor)
    public static void main(String[] args){
        while(true){ //the office will always be open in theory, so never close this loop
            mainMenu();
            }//end while(!closed)
        }//end public static void main(String[] args)

    //methods
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
        }while(!isValidInt(2,response));
        //return the choice submitted as an integer
        switch (Integer.parseInt(response)) {
            //Listings
            case 1 -> listingsMenu();
            //Bids
            case 2 -> bids();
        }//end switch (Integer.parseInt(response))
    }//end private static void mainMenu()

    /**
     * this will both present and handle the listings menu interaction, either returning to either
     * the main menu, the corresponding menu choice, or the selected method.
     */
    private static void listingsMenu(){
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
        }while(!isValidInt(3,response));
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
        }while(!isValidInt(3,response));
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
        String input = "";
        House house = new House();
        Condo condo = new Condo();
        do {
        print("Enter 1 if this residence is a House, enter 2 if it's a condo.",false);
        input = sIn.nextLine();
        }while(!isValidInt(2,input));
        switch (Integer.parseInt(input)){
            case 1 -> {
                addMainListingInfo(house);
                print(String.format(question,"yard acres"),false);
                house.setYardAcres(Double.parseDouble(sIn.nextLine()));
                print("the appraisal price for this property is "
                        + house.calculateAppraisalPrice(),true);
                print("Please enter the List Price for the property:$",false);
                house.setListPrice(Double.parseDouble(sIn.nextLine()));
                print("\nYou have created a new listing!",true);
                print(house.toString(),true);
            }//end case 1
            case 2 -> {
                addMainListingInfo(condo);
                print(String.format(question,"levels"),false);
                condo.setFloorLvl(Integer.parseInt(sIn.nextLine()));
                print("the appraisal price for this property is "
                        + house.calculateAppraisalPrice(),true);
                print("Please enter the List Price for the property:$",false);
                condo.setListPrice(Double.parseDouble(sIn.nextLine()));
                print("\nYou have created a new listing!",true);
                print(condo.toString(),true);
            }//end case 2
        }//end switch (house or condo)
    }//end private static void addListing()

    private static void addMainListingInfo(Residential residential){
        String[] variables = {"address","zip code","bedcount","bathcount","square footage"};
        String input = "";
        //enter values for the residence that aren't unique to either houses or condos
        for (int i = 0; i < 5; i++){
            print(String.format(question,variables[i]),false);
            input = sIn.nextLine();
            switch (i){
                case 0 -> residential.setStreetAddress(input);
                case 1 -> residential.setZip(input);
                case 2 -> residential.setBeds(Integer.parseInt(input));//it's assumed only valid entries will be entered
                case 3 -> residential.setBaths(Integer.parseInt(input));
                case 4 -> residential.setSize(Double.parseDouble(input));
            }
        }//end for (int i = 0; i < 5; i++)
    }//end  private static Residential addMainListingInfo(Residential residential)

    private static void showListings(){
        print("selected showListings",true);
    }

    private static void autoPopulateListings(){
        int currentSize = listings.getListings().size();
        House house1 = new House("34 Elm","95129", 3, 2, 2200, .2);
        house1.setListPrice(house1.calculateAppraisalPrice() * 1.1);
        listings.addListing("34 Elm", house1);
        House house2 = new House("42 Hitchhikers","95136", 4, 3, 2800, .3);
        house2.setListPrice(house2.calculateAppraisalPrice() * 1.1);
        listings.addListing("42 Hitchhikers", house2);
        Condo condo1 = new Condo("4876 Industrial", "95177", 3, 1, 1800, 3);
        condo1.setListPrice(condo1.calculateAppraisalPrice() * 1.1);
        listings.addListing("4876 Industrial", condo1);
        House house3 = new House("2654 Oak","84062", 5, 53, 4200, .5);
        house3.setListPrice(house3.calculateAppraisalPrice() * 1.1);
        listings.addListing("2654 Oak", house3);
        Condo condo2 = new Condo("9875 Lexington","84063", 2, 1, 1500, 1);
        condo2.setListPrice(condo2.calculateAppraisalPrice() * 1.1);
        listings.addListing("9875 Lexington", condo2);
        Condo condo3 = new Condo("3782 Market", "84066", 3, 1, 1800, 2);
        condo3.setListPrice(condo3.calculateAppraisalPrice() * 1.1);
        listings.addListing("3782 Market", condo3);
        House house4 = new House("7608 Glenwood", "84055", 6, 3, 3900, .4);
        house4.setListPrice(house4.calculateAppraisalPrice() * 1.1);
        listings.addListing("7608 Glenwood", house4);
        House house5 = new House("1220 Apple", "84057", 8, 7, 7900, 1);
        house5.setListPrice(house5.calculateAppraisalPrice() * 1.1);
        listings.addListing("1220 Apple", house5);
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
    private static boolean isValidInt(int optionCount, String input){
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
