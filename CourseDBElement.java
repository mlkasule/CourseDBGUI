import java.util.ArrayList;

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
	public CourseDBElement() {
		this.courseID = "";
		this.crn = 0;
		this.numberOfCredits = 0;
		this.roomNumber = "";
		this.instructorName = "";
	}

	public CourseDBElement(String courseID, int crn, int numberOfCredits, String roomNumber, String instructorName) {
		this.courseID = courseID;
		this.crn = crn;
		this.setNumberOfCredits(numberOfCredits);
		this.setRoomNumber(roomNumber);
		this.setInstructorName(instructorName);
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

	/**
	 * @return the numberOfCredits
	 */
	public int getNumberOfCredits() {
		return numberOfCredits;
	}

	/**
	 * @param numberOfCredits the numberOfCredits to set
	 */
	public void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}

	/**
	 * @return the roomNumber
	 */
	public String getRoomNumber() {
		return roomNumber;
	}

	/**
	 * @param roomNumber the roomNumber to set
	 */
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * @return the instructorName
	 */
	public String getInstructorName() {
		return instructorName;
	}

	/**
	 * @param instructorName the instructorName to set
	 */
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	/*
	 * compare if passed element exits or not
	 * 
	 * @return true of false
	 */
	public int compareTo(T x) {

		return getCRN();
	}

	/*
	 * get a hash code for based on the crn
	 */
	@Override
	public int hashCode() {
		return ("" + getCRN()).hashCode();
	}

	/*
	 * toString method to return
	 */
	public String toString() {
		String elementValue = "Course: " + getCourseID() + " CRN " + getCRN() + " Credits " + getNumberOfCredits()
				+ " Instructor " + getInstructorName();

		return elementValue;
	}
}
