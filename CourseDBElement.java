/*
 *	CourseDBElement implements Comparable, and consists of five attributes:
 *  the Course ID (a String), 
 *  the CRN (an int), the number of credits (an int), 
 *  the room number (a String), and the instructor name (a String).
 *  Normally the CourseDBElement will be an object consisting of these five attributes,
 *  and is referred to as a CDE.
 */
public class CourseDBElement<T> implements Comparable<T> {

	// attributes
	private String courseID;
	private int crn;
	private int numberOfCredits;
	private String roomNumber;
	private String instructorName;

	// CONSTRUCTOR
	public CourseDBElement(String courseID, int crn, int numberOfCredits, String roomNumber, String instructorName) {
		this.courseID = courseID;
		this.crn = crn;
		this.numberOfCredits = numberOfCredits;
		this.roomNumber = roomNumber;
		this.instructorName = instructorName;
	}

	// METHODS

	/*
	 * @return the courseID
	 */
	public String getCourseID() {
		return courseID;
	}

	/*
	 * @param courseID the courseID to set
	 */
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	
	/**
	 * @return the crn
	 */
	public int getCRN() {
		return crn;
	}

	/**
	 * @param crn the crn to set
	 */
	public void setCRN(int crn) {
		this.crn = crn;
	}

	/*
	 * compare if passed element exits or not
	 * @return true of false
	 */

	@Override
	public int compareTo(T thing) {
		
		return getCRN();
	}

}
