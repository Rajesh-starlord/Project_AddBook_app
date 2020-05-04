import com.BridgeLabz.CodingClub;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Service{
	Scanner sc = new Scanner(System.in);
	public void edit(String id){
		BufferedReader fileReader = null;
		int found = 0;
		try {
			List<Person> Persons = new ArrayList<Person>();
			String line = "";
			fileReader = new BufferedReader(new FileReader("AdressBook.csv"));
			while ((line = fileReader.readLine()) != null) {
				String[] details = line.split(",");
				if (details.length > 0) {
					if( details[0]!=id){
						Person P = new Person(details[0],details[1],details[2],details[3],Integer.parseInt(details[4]));  
						Persons.add(P);
					}else(details[0] == id){
						System.out.println("Enter an option:");
						System.out.println("1.Address 2.zip");
						int op = sc.nextInt();
						found = 1;
						switch(op){
							case 1:System.out.println("Enter new address:");
									String add = sc.nextLine();
									Person P = new Person(details[0],details[1],details[2],add,Integer.parseInt(details[4]));  
									Persons.add(P);
									break;
							case 1:System.out.println("Enter new zip:");
									int zip = sc.nextInt();
									Person P = new Person(details[0],details[1],details[2],details[3],zip);  
									Persons.add(P);
									break;
							default :System.out.println("Enter a valid option:");
						}
					}
				}
			}
			if(found == 1){
				fileReader = new BufferedReader(new FileReader("AdressBook.csv"));
				fileReader.close();
				Util u = new Util();
				for ( Person Per : Persons){
					u.addData(per);
				}
			}else{
				System.out.println("ID Not Found!.....");
			}	
		}catch (Exception e){
			e.printStackTrace();
		}
	}//edit
	
	public void delete(String id){
		
	}
	public void delete(){
		fileReader = new BufferedReader(new FileReader("AdressBook.csv"));
		fileReader.close();
	}
}//class