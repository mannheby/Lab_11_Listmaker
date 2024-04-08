import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    private static ArrayList<String> list = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {


        final String menu = "A - Add  D - Delete  P - Print  Q - Quit";
        boolean done = false;
        String cmd = "";

        do
        {


            cmd = SafeInput.getRegExString(in, menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();

            switch(cmd)
            {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "P":
                    displayList();
                    break;
                case "Q":
                    done = quitList();
                    break;

            }
        }while(!done);
    }

    private static boolean quitList()
    {
        return SafeInput.getYNConfirm(in, "Are you sure you want to quit?");
    }

    private static void deleteItem()
    {
        list.remove( (SafeInput.getRangedInt(in, "What is the number of the item in the list that you want to delete?", 1, list.size()))-1 );
    }

    private static void addItem()
    {
        list.add(SafeInput.getNonZeroLenString(in, "Type the item you would like to add to the list"));
    }

    private static void displayList()
    {
        if(list.size() != 0)
        {
            System.out.println();
            for (int x = 0; x < list.size(); x++)
            {
                System.out.printf("%3d%15s", x + 1, list.get(x));
                System.out.println();
            }
        }
        else
        {
            System.out.println("The List is Empty");
        }
    }
}