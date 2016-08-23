package DoubleHashing;

public class HashMapping {
	
	private final static int TABLE_SIZE = 1000;										// Declare a constant for table size
	public static int counter;
	HashItem[] table;																
	
	HashMapping() {
		table = new HashItem[TABLE_SIZE];											// Create a new hash table
		for (int i = 0; i < TABLE_SIZE; i++) {			
			table[i] = null;														// Set the value in each slot to NULL
		}
	}
	
	/* addItem method to insert a new item */
	public int addItem(int key, String value) {										
		int hashIndex = key % TABLE_SIZE;											// Get a hash index from the key

		while (table[hashIndex] != null) {											// If the slot is not empty
			if (table[hashIndex].getKey() != key) {									// If the item in the slot is not the same as the key we want to insert
				int step = getNewStep(key);
				hashIndex = (hashIndex + step) % TABLE_SIZE;						// Get new hashIndex
			}
			else {																	// If the item is the same
				return -1;															// Returns -1
			}
		}
		
		table[hashIndex] = new HashItem(key, value);								// Insert the item to the slot
		return 1;
	} 																				// End addItem
	
	/* get method to search for the value of a key */
	public String get(int searchKey) {
		int hashIndex = searchKey % TABLE_SIZE;										// Get a hash index from the key
		counter = 1;
		while (table[hashIndex] != null) {											// If the slot is not empty
			if (table[hashIndex].getKey() == searchKey) {							// If the key inside the slot is the same as the search key
				return table[hashIndex].getValue();									// Return the value of the key
			}
			else {																	// If the key inside the slot is not the same as the search key
				int step = getNewStep(searchKey);
				hashIndex = (hashIndex + step) % TABLE_SIZE;						// Get new hash index
				counter++;															// Number of comparison +1
			}
		}
		return null;																	// Unsuccessful search will return -1
	}																				// End get
	
	public int getNewStep(int key) {
		return (key % 11) + 1;
	}
}																					// End HashMapping

