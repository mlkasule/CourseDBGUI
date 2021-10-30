import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.*;

public class CourseDBStructure extends CourseDBElement implements CourseDBStructureInterface {

	private int hashTableSize;
	private String testWord;
	private int itemCRNHashCode; // hashcode
	private CourseDBElement newItem;
	private LinkedList<CourseDBElement> list;
	ArrayList<CourseDBElement> hashTable;
	Hashtable<Integer, CourseDBElement> myHashTable; // should be an array

	public CourseDBStructure(String courseID, int crn, int numberOfCredits, String roomNumber, String instructorName) {
		super(courseID, crn, numberOfCredits, roomNumber, instructorName);
	}

	public CourseDBStructure(int hashTableSize) {
		super();
		this.hashTableSize = hashTableSize;
		list = null;
	}

	public CourseDBStructure(String testString, int hashTableSize) {
		this.hashTableSize = hashTableSize;
		this.testWord = testWord;
		list = null;
	}

	/**
	 * @param hashTableSize the hashTableSize to set
	 */
	public void setHashTableSize(int hashTableSize) {
		this.hashTableSize = hashTableSize;
	}

	/**
	 * Use the hashcode of the CourseDatabaseElement to see if it is in the
	 * hashtable.
	 * 
	 * If the CourseDatabaseElement does not exist in the hashtable, add it to the
	 * hashtable.
	 * 
	 * @param element the CDE to be added
	 */

	@Override
	public void add(CourseDBElement element) {

		// get all element details
		newItem = new CourseDBElement(element.getCourseID(), element.getCRN(), element.getNumberOfCredits(),
				element.getRoomNumber(), element.getInstructorName());

		// create a hashCode of the element passed based on crn
		itemCRNHashCode = newItem.hashCode();

		hashTable = new ArrayList<CourseDBElement>();

		for (int i = 0; i < hashTable.size(); i++) {
			while (i != itemCRNHashCode) {
				// Create Array list to hold element details into an arraylist
				hashTable.add(itemCRNHashCode, newItem);
			}
		}

		// Instantiate a linked list
		list = new LinkedList<CourseDBElement>();

		// add element to linked list
		list.add(newItem);

//		// Create an empty hash Table
		myHashTable = new Hashtable<Integer, CourseDBElement>();

		// if hashCode does not exist, then add it in table
		if (!(myHashTable.containsKey(itemCRNHashCode))) {
			// add element to table mapped to this given hashCode
			myHashTable.put(itemCRNHashCode, newItem);
		}

	}

	/*
	 * Add test for string, int
	 */
	public void add(String test, int size) {

		// Instantiate testing constructor
		CourseDBStructure testConstructor = new CourseDBStructure(test, size);

		list.add(testConstructor);

	}

	/**
	 * Use the hashcode of the CourseDatabaseElement to see if it is in the
	 * hashtable.
	 * 
	 * If the CourseDatabaseElement is in the hashtable, return it If not, throw an
	 * IOException
	 * 
	 * @param element the CDE to be added
	 * @throws IOException
	 */

	@Override
	public CourseDBElement get(int crn) throws IOException {

		CourseDBElement element = new CourseDBElement();

		// check if hashtable array list is not empty
		if (!hashTable.isEmpty()) {

			// check if list itself is not null

			if (list != null) {
				// check for each element at i

				for (int i = 0; i < list.size(); i++) {

					// check for each element's getCRn == crn passed

					if (newItem.getCRN() == crn) {

						// if yes, assign that crn to itemCRNHashCode
						itemCRNHashCode = crn;

						// check if that key that matches any hash key in hashTable or return IO
						// exception
						if (myHashTable.containsKey(itemCRNHashCode)) {
							element = hashTable.get(itemCRNHashCode);
						} else {
							throw new IOException("Hashkey does not exit");
						}
					}
				}
			}

		}

		return element;
	}

	/**
	 * Returns the size of the ConcordanceDataStructure (number of indexes in the
	 * array)
	 */
	@Override
	public int getTableSize() {
		return hashTableSize;
	}

	/*
	 * Show all elements in list
	 * 
	 * @return arraylist of elements
	 */
	public ArrayList<String> showAll() {

		// store all elements within a linked list into an array list
		ArrayList<String> printList = new ArrayList<String>(getTableSize());

		// loop through every element and add it to arraylist
//		for (int i = 0; i < hashTable.size(); i++) {
//			printList.add(list.get(i).toString());
//		}
		int i = 0;

		while (i < hashTableSize) {
			printList.add(hashTable.get(i).toString());
			i++;
		}

		return printList;
	}

	public CourseDBElement show(int crn) {

		// create and store the element in question
		CourseDBElement displayElement = new CourseDBElement();

		// loop through every key in hashTable
		for (int i = 0; i < getTableSize(); i++) {

			// check for key matching with crn
			if (myHashTable.containsKey(crn)) {
				displayElement = hashTable.get(crn);
			}
		}

		return displayElement;
	}

}
