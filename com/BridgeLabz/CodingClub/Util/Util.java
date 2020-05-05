  import com.bridgeLabz.codingclub;
  import java.io.FileWriter;
  import java.io.IOException;
  import java.util.ArrayList;
  import java.util.List;
  import java.io.BufferedReader;
  import java.io.FileReader;
  import java.util.Scanner;
  import java.util.Random;
  /*
  *utility class
  */

  public class Util{
  	private static Scanner sc = new Scanner(System.in);
  	public static  boolean checkInt(String entry){
  		try{
  			Integer.parseInt(entry);
  			return true;
  		}catch(Exception e){
  			return false;
  		}
  	}
  	public static void getPerson(){
  		Random r = new Random();
  		int random = r.nextInt();
  		String id = "P"+random;
  		System.out.println("enter your first name:");
  		String fname = sc.next();
  		System.out.println("enter your last name:");
  		String lname = sc.next();
  		System.out.println("enter your address");
  		sc.nextLine();
  		String add = sc.nextLine();
  		System.out.println("enter your ZIP code");
  		String zip = sc.next();
  		boolean checkRes = checkInt(zip);
  		if(checkRes){
  			Person data = new Person(id,fname,lname,add,Integer.parseInt(zip));
  			Service ser = new Service();
  			ser.addData(data);
  		}else{
  			System.out.println("invalid Entry for zip:");
  		}
  	}//getPerson
  	public static final List getData(){
  		BufferedReader fileReader = null;
  		List<Person> Persons = new ArrayList<Person>();
  		try {
  			String line = "";
  			fileReader = new BufferedReader(new FileReader("AddressBook.csv"));
  			/* Read customer data line by line*/
  			while ((line = fileReader.readLine()) != null) {
  				String[] details = line.split(",");
  				if (details.length > 0) {
  					Person P = new Person(details[0],details[1],details[2],details[3],Integer.parseInt(details[4]));
  					Persons.add(P);
  				}
  			}
  		}catch (Exception e) {
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
  		return Persons;
  	}//getData
  }//class
