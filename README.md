# CourseDataBase GUI app
Most data is stored in databases, for ready access and organization.  Our course data is backed up by IT in databases which makes our data easy to access and use.   Write a program that creates a database of courses.  It will either read from a file of courses, or allow the user to add one course at a time.   Upload the initial files and your working files in the repository in GitHub you created in Lab 1, in a directory named Assignment4. Take a screenshot of your repo, and post the assignment to the Assignment 4 dropbox.
## Concepts Tested
Hash Table, 
Link List,
hash code, buckets/chaining,
exception handling, 
read/write files using FileChooser
## Classes
Data Element - CourseDBElement, 
CourseDBElement implements Comparable, and consists of five attributes: the Course ID (a String), the CRN (an int), the number of credits (an int), the room number (a String), and the instructor name (a String).   Normally the CourseDBElement will be an object consisting of these five attributes, and is referred to as a CDE.

### Data Structure - CourseDBStructure 
Implements the CourseDBStructureInterface that is provided.
You will be implementing a hash table with buckets.  It will be an array of linked lists of CourseDBElements.  Each CDE will have a hash code that comes from the CRN, since the CRN is unique for courses.  Note that the CRN is an int, and the tests require the hashcode of a string, so you will need to coerce it to a String, and take the hash code of the resulting string.  The add method will take a CourseDBElement and add it to the data structure. If a linked list at the relevant hash code doesn’t exist, create a LinkedList with the first element being the CDE and add it to the HashTable. If the LinkedList already exists, add the CDE to the existing list. Two constructors for the CDS will be required, one that takes in an integer that is the estimated number of courses, the other is used for testing purposes.  The comments in the CourseDBStructureInterface (provided) should help you figure out how to set the length of the hash table.  You will not need to use the 4k+3 code.

### Data Manager - CourseDBManager
Implements the CourseDBManagerInterface that is provided.
The data manager allows the user to read the courses from a file or to enter the data by hand, and uses an Alert to print out the database elements. The input is read from a file or read from the textfields and is added to the data structure through the add method.  The add method uses the CDS add method. The CourseDBManager is also referred to as a CDM.

### Exception Classes
IOException – created and thrown when user selects an input file that cannot be read or attempting to retrieve a CDE that does not exist in the DB.

### GUI Driver (provided)
•	User will only create a course database once they have entered an input file or entered one or more sets of attributes.
•	Buttons and textfields are grayed out if they are not relevant at the current time.
•	A FileChooser is used to select the input and output files. 
•	Inform the user if there is an error with the input file.
•	Use exception handling for the validity of the files.
•	A way is provided for the user to “clear” the text fields.
•	A way is provided for the user to select a CRN and retrieve the corresponding course.
