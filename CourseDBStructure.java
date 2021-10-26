import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

public class CourseDBStructure extends CourseDBElement implements CourseDBStructureInterface {

	private int hashTableSize;
	private String testWord;
	private LinkedList<CourseDBElement> myList;
	private Hashtable<Integer, CourseDBElement> hashTable;

	public CourseDBStructure(int hashTableSize) {
		super();
		this.setHashTableSize(hashTableSize);
	}

	public CourseDBStructure(String testString, int hashTableSize) {
		this.setHashTableSize(hashTableSize);
		this.testWord = testWord;
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
		CourseDBElement newItem = new CourseDBElement(element.getCourseID(), element.getCRN(),
				element.getNumberOfCredits(), element.getRoomNumber(), element.getInstructorName());

//		// Create Array list to hold element details into an arraylist
//		ArrayList<CourseDBElement> arr = new ArrayList<CourseDBElement>();
//		
//		// add element to list
//		arr.add(newItem);

		// get hashCode of the element passed
		int itemCode = newItem.hashCode();

		// Create an empty hashTable
		hashTable = new Hashtable<Integer, CourseDBElement>();

		// if hashCode does not exist, then add it in table
		if (!(hashTable.containsKey(itemCode))) {
			// add element to table mapped to this given hashCode
			hashTable.put(itemCode, newItem);
		}

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
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns the size of the ConcordanceDataStructure (number of indexes in the
	 * array)
	 */
	@Override
	public int getTableSize() {
		return hashTableSize;
	}

}
