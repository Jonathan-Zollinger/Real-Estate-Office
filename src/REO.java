import java.util.Scanner;

public class REO {
    //values
    private static final Scanner sIn = new Scanner(System.in);
    private static final String lines = "----------------------------------------";
    private static final String bigLines =
            "------------------------------------------------------------------------------------------------";
    private static final Listings listings = new Listings();
    private static final String question = "what is the %s of the residence?";
    private static String[] autoBidders= {
            "Patric Stewart","Walter Koenig","William Shatner","Leonard Nimoy","DeForect Kelley","James Doohan",
                    "George Takei","Majel Barrett","Nichelle Nichol","Jonathan Frank","Marina Sirtis","Brent Spiner",
                    "Gates McFadden","Michael Dorn","LeVar Burton","Wil Wheaton","Colm Meaney","Michelle Forbes"
            };


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
            case 2 -> bidsMenu();
        }//end switch (Integer.parseInt(response))
    }//end private static void mainMenu()

    /**
     * this will both present and handle the listings menu interaction, either returning to either
     * the main menu, the corresponding menu choice, or the selected method.
     */
    private static void listingsMenu(){
        print(formatTitle("Listing Menu"),false);
        //formats the options printout in a single text string
        while(true) {
            String options = String.format("%s%n%s%n%s%n%s%n%n%n%s",
                    "1: Add Listing",
                    "2: Show Listings",
                    "3: Auto Populate Listings (Dev tool)",
                    "ENTER: Exit back to previous menu",
                    "What would you like to do? (1-3):");
            //ask for the user input, validating their input
            String response = "";
            do {
                print(options, false);
                response = sIn.nextLine();
                //if they enter kaput, go back to main
                if (response.length() == 0) {
                    return;
                }
            } while (!isValidInt(3, response));
            //return the choice submitted as an integer
            switch (Integer.parseInt(response)) {
                //add a listing
                case 1 -> addListing();
                //show listings
                case 2 -> showListings();
                //auto populate listings
                case 3 -> autoPopulateListings();
            }//end switch (Integer.parseInt(response))
        }
    }//end private static void listings()

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
                listings.addListing(house.getStreetAddress(), house);
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
                listings.addListing(condo.getStreetAddress(), condo);
                print("\nYou have created a new listing!",true);
                print(condo.toString(),true);
            }//end case 2
        }//end switch (house or condo)
    }//end private static void addListing()

    /**
     * @param residential is the new listing that we're adding
     */
    private static void addMainListingInfo(Residential residential){
        String[] variables = {"address","zip code","bed Count","bath Count","square footage"};
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
    }//end addMainListingInfo(Residential)

    /**
     * this doesn't actually return anything, it just prints the listings to the console
     */
    private static void showListings(){
        int n = 0;
        print("Current Listings for REO:\n",true);
        for (String key: listings.getListings().keySet()){
            n ++;
            print(String.format("Listing No: %d%s",n,listings.getListing(key).toString()),true);
        }
    }

    private static void autoPopulateListings(){
        //int currentSize = listings.getListings().size();
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

    /**
     * prints navigation options, validates response from user as a valid option choice and calls the corresponding
     * method.
     */
    private static void bidsMenu() {
        print(formatTitle("Bids Menu"), false);
        //formats the options printout in a single text string
        while(true) {
            String options = String.format("%s%n%s%n%s%n%s%n%n%n%s",
                    "1: Add New Bid",
                    "2: Show Existing Bids",
                    "3: Auto Populate Bids (Dev tool)",
                    "ENTER: Exit back to previous menu",
                    "What would you like to do? (1-3):");
            //ask for the user input, validating their input
            String response = "";
            do {
                print(options, false);
                response = sIn.nextLine();
                //if they enter kaput, go back to main
                if (response.length() == 0) {
                    return;
                }
            } while (!isValidInt(3, response));
            //return the choice submitted as an integer
            switch (Integer.parseInt(response)) {
                //add a listing
                case 1 -> addNewBid();
                //show listings
                case 2 -> showExistingBids();
                //auto populate listings
                case 3 -> autoBidListings();
            }//end switch (Integer.parseInt(response))
        }
    }//end private static void bids()

    private static void autoBidListings(){
        for (Residential value : listings.getListings().values()) {
            int bids = 0;
            //make 4 random authored and priced bids
            while(bids < Math.random()*8) {
                value.newBid(
                        //select random bidder
                        autoBidders[(int) (Math.random() * (autoBidders.length - 1))],
                        //the bid will be a random number ranging from +-10% of the appraisal price
                        (Math.random()*.20-.10)*value.calculateAppraisalPrice()+value.calculateAppraisalPrice()
                );//end new bid
                bids ++;
            }//end while bids < 4
        }//end all values loop
    }//end autobid

    /**
     * adds a new bid to an existing property
     */
    private static void addNewBid() {
        //print bid opportunities menu
        print(String.format("Current Listings for REO:\n\nNo.\t%-30s(bids)\n%s", "Property", lines), true);
        String response = "";
        while (true) {//keep adding bids until they enter nothing (currently line 244)
            do {
                int i = 1;
                for (String key : listings.getListings().keySet()) {
                    print(String.format("%d:\t%-30s(%d)", i, key, listings.getListing(key).getBidCount()), true);
                    i++;
                }
                print(String.format("%s\n\n%s",
                        "ENTER: Exit back to previous menu",
                        "For which property would you like to add a bid?: "), false);
                response = sIn.nextLine();
                //if they enter kaput, go back to main
                if (response.length() == 0) {
                    return;
                }
            } while (!isValidInt(listings.getListingCount(), response));

            int choice = Integer.parseInt(response);
            //cycle through properties until we get the selected property, call that bidProperty
            int i = 1;
            Residential bidProperty = null;
            for (String key : listings.getListings().keySet()) {
                if (i == choice) {
                    bidProperty = listings.getListing(key);
                    //display property information before asking for bid info
                    print(listings.getListing(key).toString(),true);
                    print(listings.getListing(key).getBidsPrintout(),true);
                    break;
                }
                i++;
            }//end for (String key : listings.getListings().keySet())

            //ask for the name of the bidder
            print("Please enter the name of the bidder: ", false);
            String bidder = sIn.nextLine();
            //ask for their bid
            print("Please enter the new bid: $", false);
            assert bidProperty != null;
            bidProperty.newBid(bidder, Double.parseDouble(sIn.nextLine())); //it's assumed the user will input valid data
            print("New bid for property '" + bidProperty.getStreetAddress() + "' added", true);
        }
    }

    private static void showExistingBids(){
        //print bid opportunities menu
        print(String.format("Current Listings for REO:\n\nNo.\t%-30s(bids)\n%s", "Property", lines), true);
        String response = "";
        do {
            int i = 1;
            for (String key : listings.getListings().keySet()) {
                print(String.format("%d:\t%-30s(%d)", i, key, listings.getListing(key).getBidCount()), true);
                i++;
            }
            print(String.format("%s\n\n%s",
                    "ENTER: Exit back to previous menu",
                    "For which property would you like to see the current bids?: "), false);
            response = sIn.nextLine();
            //if they enter kaput, go back to main
            if (response.length() == 0) {
                return;
            }
        } while (!isValidInt(listings.getListingCount(), response));
        int choice = Integer.parseInt(response);

        //cycle through properties until we get the selected property, call that bidProperty
        int i = 1;
        Residential bidProperty = null;
        for (String key : listings.getListings().keySet()) {
            if (i == choice) {
                print(listings.getListing(key).toString(),true);
                print(listings.getListing(key).getBidsPrintout(),true);
                return;
            }
            i++;
        }//end for (String key : listings.getListings().keySet())
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
