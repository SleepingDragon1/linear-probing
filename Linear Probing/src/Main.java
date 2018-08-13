/*
 *
 *   - Linear probing
 *
 * */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int key, value;

        HashTable hashTable = new HashTable(11);

        Scanner input = new Scanner(System.in);

        int count = 5;

        while (count != 0) {
            System.out.print("Enter a key: ");
            key = input.nextInt();

            System.out.print("Enter a value: ");
            value = input.nextInt();

            hashTable.add(key, value);
            count--;
        }

        System.out.print("\n");

        System.out.print("Enter a key to search for: ");
        key = input.nextInt();

        System.out.print("Enter a value to search for: ");
        value = input.nextInt();

        System.out.print("\n");

        hashTable.printHashTable();

        System.out.print("\n" + key + ": " + value + " exists = " + hashTable.contains(key, value) + "\n");

        System.out.print("\nEnter a key to remove: ");
        key = input.nextInt();

        System.out.print("Enter a value to remove: ");
        value = input.nextInt();

        hashTable.remove(key, value);

        System.out.print("\n");

        hashTable.printHashTable();

        System.out.print("\n");

        hashTable.printExperiment();

    } // End main method

} // End Main class
