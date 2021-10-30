import java.io.*;
import java.util.*;

public class CourseDBManager extends CourseDBStructure implements CourseDBManagerInterface {
	
	public CourseDBManager() {
		super(0);
	}
	public CourseDBManager(int hashTableSize) {
		super(hashTableSize);
	}

	CourseDBStructure cds = new CourseDBStructure(getTableSize());


	public void add(String id, int crn, int credits, String roomNum, String instructor) {

		CourseDBElement cde = new CourseDBElement(id, crn, credits, roomNum, instructor);
		cds.add(cde);

	}

	@Override
	public CourseDBElement get(int crn) {
		return cds.show(crn);
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {

		FileReader fr = new FileReader(input);
		int i;
		try {
			while ((i = fr.read()) != -1)
				System.out.print((char) i);
			fr.close();
		} catch (Exception e) {
			throw new FileNotFoundException("File not found");

		}

	}

	@Override
	public ArrayList<String> showAll() {
		return cds.showAll();
	}

}
