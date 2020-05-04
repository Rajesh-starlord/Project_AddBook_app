import java.util.Random;
import com.BridgeLabz.CodingClub;
import java.util.regex.*;
public class Person {
	private final String FNAME_PAT = "^[A-Z]{1}{3,}$";
	private final String LNAME_PAT = "^[A-Z]{1,}{3,}$";
	
	private String id="";
	private String fname;
	private String lname;
	private String address;
	private int zip;
 
	Person(String id,String fname, String lname, String address, int zip) {
		if(Pattern.matches(FNAME_PAT,fname)){
			this.fname = fname;
			System.exit(0);
		}else{
			System.out.println("Enter a valid first name:");
		}
		if(Pattern.matches(LNAME_PAT,lname)){
			this.lname = lname;
			System.exit(0);
		}else{
			System.out.println("Enter a valid last name:");
		}
		if(zip >99999 && zip <= 999999){
			this.zip = zip;
			System.exit(0);
		}else{
			System.out.println("Enter a valid zip code:");
		}
		this.id = id;
		this.address = address;
		System.out.println("Persons data successfully generated:");
	}
  
	public void setId(String id) {
		this.id = id;
	}
	  public String getId() {
		return id;
	  }
	  
	  public String getfName() {
		return fname;
	  }
	 
	  public void setfName(String name) {
		this.fname = fname;
	  }
	  public String getlName() {
		return lname;
	  }
	 
	  public void setlName(String name) {
		this.lname = lname;
	  }
	 
	  public String getAddress() {
		return address;
	  }
	 
	  public void setAddress(String address) {
		this.address = address;
	  }
	 
	  public int getZip() {
		return zip;
	  }
	 
	  public void setAge(int zip) {
		this.zip = zip;
	  }
	  //@Override
	  public String toString() {
		return "Customer [id=" + id + ", fname=" + fname +", lname=" + lname+ ", address=" + address + ", zip=" + zip + "]";
	  }
	 
}