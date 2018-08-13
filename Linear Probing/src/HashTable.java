/*
 *
 *   - Linear probing
 *
 * */

public class HashTable {

    private Entry[] hashTable; // Initialize array for hash table
    private int capacity; // Store size
    private int countExperiment = 1;

    /* Constructor */
    public HashTable(int size) {
        capacity = size;
        hashTable = new Entry[capacity]; // Create hash table size
    }

    /* Contains method */
    public boolean contains(int key, int value) {

        int modulo; // To store index

        modulo = key % capacity; //  Hash table index

        int count = capacity - modulo; // Only search elements directly after hash table index

        if (hashTable[modulo] == null) {
            // System.out.println("\n" + key + ": " + value + " does not exist");
        }
        // If keys match return true
        else if (hashTable[modulo].getKey() == key && hashTable[modulo].getValue() == value) {
            return true;
        } else { // Else continue to search until either a key is found, the whole hash table has been searched or is not equal to null
            while (hashTable[modulo].getKey() != key || count == 0 || hashTable[modulo] != null) {

                modulo++; // Increment index

                if (hashTable[modulo] == null) {
                    break;
                }

                // If match is found return true
                if (hashTable[modulo].getKey() == key && hashTable[modulo].getValue() == value) {
                    return true;
                }
                count--; // Decrement count
            }
        }
        return false; // Key does not exist
    }

    /* Add method */
    public void add(int key, int value) {

        int modulo; // Hold modulus result
        int count = capacity;

        Entry entry = new Entry(); // Create new entry object
        entry.setKey(key); // Add key
        entry.setValue(value); // Add value
        modulo = key % capacity; // Take modulus of key by hash table size

        if (hashTable[modulo] == null || hashTable[modulo].getKey() == -1) {
            hashTable[modulo] = entry;
        } else {
            while (hashTable[modulo] != null || hashTable[modulo].getKey() != -1 || count == 0) {

                modulo++;

                if (hashTable[modulo] == null || hashTable[modulo].getKey() == -1) {
                    hashTable[modulo] = entry;
                    break;
                }
                count--;
            }
        }
    } // End for loop

    /* Remove method */
    public void remove(int key, int value) {

        int modulo; // To store index

        modulo = key % capacity; //  Hash table index

        int count = capacity - modulo; // Only search elements directly after hash table index

        if (hashTable[modulo] == null) {
            System.out.println("\n" + key + ": " + value + " does not exist");
        }
        // If keys match set key to open -1
        else if (hashTable[modulo].getKey() == -1) {
            hashTable[modulo].setKey(-1); // Open flag
        } else { // Else continue to search until either a key is found or the whole hash table has been searched
            while (hashTable[modulo].getKey() != key || count == 0) {

                modulo++; // Increment index

                countExperiment++;

                // If match is found set to flag
                if (hashTable[modulo].getKey() == key && hashTable[modulo].getValue() == value) {
                    hashTable[modulo].setKey(-1); // Open flag
                    break;
                }
                count--; // Decrement count
            }
        }
    } // End remove method

    /* Print hash table method */
    public void printHashTable() {

        for (int i = 0; i < hashTable.length; i++) {
            System.out.println(hashTable[i]);
        }
    }

    public void printExperiment() {
        System.out.println("Experiment probe count = " + countExperiment);
    }

} // End HashTable class
