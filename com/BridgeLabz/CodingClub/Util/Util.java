import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import com.BridgeLabz.CodingClub;

public class Util{

  public static void addData(Person P){
    FileWriter fileWriter = null;
    try {
      fileWriter = new FileWriter("AdressBook.csv",true);
		fileWriter.append(P.getId());
		fileWriter.append(',');
		fileWriter.append(P.getfName());
		fileWriter.append(',');
		fileWriter.append(P.getlName());
		fileWriter.append(',');
		fileWriter.append(P.getAddress());
		fileWriter.append(',');
		fileWriter.append(String.valueOf((P.getZip())));
		fileWriter.append('\n');
		System.out.println("Write CSV successfully!");
	} catch (Exception e) {
		System.out.println("Writing CSV error!");
		e.printStackTrace();
	} finally {
		try {
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			System.out.println("Flushing/closing error!");
			e.printStackTrace();
		}
    }
  }//function_addData
  
  public void readData() {
    BufferedReader fileReader = null;
    try {
      List<Person> Persons = new ArrayList<Person>();
      String line = "";
      fileReader = new BufferedReader(new FileReader("AdressBook.csv"));
      /* Read customer data line by line*/
      while ((line = fileReader.readLine()) != null) {
        String[] details = line.split(",");
        if (details.length > 0) {
          Person P = new Person(details[0],details[1],details[2],details[3],Integer.parseInt(details[4]));  
          Persons.add(P);
        }
      }
 
      for (Person Per : Persons) {
        System.out.println(Per);
      }
	  
    } catch (Exception e) {
		  System.out.println("Reading CSV Error!");
		  e.printStackTrace();
    } finally {
      try {
        fileReader.close();
      } catch (IOException e) {
			System.out.println("Closing fileReader Error!");
			e.printStackTrace();
      }
    }
  }//function_readData
  
}//class