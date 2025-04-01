package week7;

import java.util.Scanner;

public class Week7Driver {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        //String collection
        SortedLinkedCollection<String> cString = new SortedLinkedCollection<>();
        cString.add("Zebra");
        cString.add("Apple");
        cString.add("Original");
        cString.add("Panda");
        cString.add("Mountain");
        cString.add("Mountain");

        System.out.println("Items in String collection: " + cString);
        System.out.println();

        System.out.println("Smallest item in collection: " + cString.smallest());
        System.out.println();

        System.out.print("Enter an element in the current collection: ");
        String stringInput = in.nextLine();
        System.out.println("Number of items greater than element " + stringInput + ": " + cString.greater(stringInput));
        System.out.println();

        //Integer Collection
        SortedLinkedCollection<Integer> cInt = new SortedLinkedCollection<>();
        cInt.add(10);
        cInt.add(500);
        cInt.add(10);
        cInt.add(50);
        cInt.add(10);

        System.out.println("Items in integer collection: " + cInt);
        System.out.println();

        System.out.println("Smallest item in collection: " + cInt.smallest());
        System.out.println();

        System.out.print("Enter an element in the current collection: ");
        int intInput = in.nextInt();
        System.out.println("Number of items greater than element " + intInput + ": " + cInt.greater(intInput));
        System.out.println();

        //Second String collection
        SortedLinkedCollection<String> cString2 = new SortedLinkedCollection<>();
        cString2.add("Orange");
        cString2.add("Triangle");
        cString2.add("Pirate");
        cString2.add("Lion");
        cString2.add("Video");
        cString2.add("School");

        System.out.println("First String Collection: " + cString);
        System.out.println("Second String Collection: " + cString2);
        System.out.println();

        //Combine String collection one and two
        System.out.println("Combined String Collections: " + cString.combine(cString2));

    }

}
