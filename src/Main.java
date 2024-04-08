import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    private static ArrayList<String> list = new ArrayList<>(); //initialize in main in order to use in methods
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {


        final String menu = "A - Add  D - Delete  P - Print  Q - Quit"; // initialize menu for user
        boolean done = false; // boolean for do while loop
        String cmd = "";

        do
        {
            cmd = SafeInput.getRegExString(in, menu, "[AaDdPpQq]"); //asks user for an item from the menu

            switch(cmd)
            {
                case "A": //if they choose "a" it runs addItem method
                    addItem();
                    break;
                case "D": //if they choose "d" it runs deleteItem method
                    deleteItem();
                    break;
                case "P": //if they choose "p" it runs displayList method
                    displayList();
                    break;
                case "Q": //if they choose "q" it runs quitList method
                    done = quitList();
                    break;

            }
        }while(!done);
    }

    private static boolean quitList()
    {
        return SafeInput.getYNConfirm(in, "Are you sure you want to quit?"); //returns the boolean for the users choice of y/n
    }

    private static void deleteItem()
    {
        list.remove( (SafeInput.getRangedInt(in, "What is the number of the item in the list that you want to delete?", 1, list.size()))-1 ); // asks for the ranged int that represent the item they wish to delete and subtract 1 to correspond to the array
    }

    private static void addItem()
    {
        list.add(SafeInput.getNonZeroLenString(in, "Type the item you would like to add to the list")); //asks for a string to add to the list
    }

    private static void displayList()
    {
        if(!list.isEmpty())
        {
            System.out.println();
            for (int x = 0; x < list.size(); x++)
            {
                System.out.printf("%3d%15s", x + 1, list.get(x)); //displays the list number "x + 1" and the list item
                System.out.println(); //new line
            }
        }
        else
        {
            System.out.println("The List is Empty"); //prints if the list is empty
        }
    }
}