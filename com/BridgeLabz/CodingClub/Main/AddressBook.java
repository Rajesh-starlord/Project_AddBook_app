Skip to content
Search or jump to…

Pull requests
Issues
Marketplace
Explore
 
@Rajesh-starlord 
Rajesh-starlord
/
Project_AddBook_app
1
00
 Code
 Issues 0
 Pull requests 0 Actions
 Projects 0
 Wiki
 Security 0
 Insights
 Settings
Project_AddBook_app/com/BridgeLabz/CodingClub/Main/AddressBooks.java
@Rajesh-starlord Rajesh-starlord trial version added
c10efd8 8 minutes ago
66 lines (63 sloc)  1.69 KB
  
import java.util.*;
import java.io.*;
import com.BridgeLabz.CodingClub;

public class AddressBooks{

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String fname;
		String lname;
		String add;
		int zip;
		Random r = new Random();
		int random = r.nextInt();
		String id = "P"+random;
		System.out.println("OPTIONS:");
		System.out.println("1.ADD  2.OPEN  3.EDIT  4.DELETE  5.EXIT");
		int opt = sc.nextInt();
		while (opt != 5){
			System.out.println("1.ADD  2.OPEN  3.EDIT  4.DELETE  5.EXIT");
			opt = sc.nextInt();
			switch(opt){
				case 1:
						System.out.println("enter your first name:");
						fname = sc.next();
						System.out.println("enter your last name:");
						lname = sc.next();
						System.out.println("enter your address");
						sc.nextLine();
						add = sc.nextLine();
						System.out.println("enter your ZIP code");
						zip = sc.nextInt();
						Person data = new Person(id,fname,lname,add,zip);
						Util ut1 = new Util();
						ut1.addData(data);
						break;
				case 2:
						Util ut2 = new Util();
						ut2.readData();
						break;
				case 3:
						System.out.println("enter id:");
						int id = sc.nextInt();
						Service sr = new Service();
						sr.edit(id);
						break;
				case 4:
						System.out.println("1:Delete All 2:Delete One");
						int op = sc.nextInt();
						if (op == 1){
							Service srv = new Service();
							srv.delete();
						} else {
							System.out.println("Enter id:");
							int delId = sc.nextInt();
							Service srv = new Service();
							srv.delete(delId);
						}
						break;
				case 5: System.exit(0);break;
				default : System.out.println("Enter a valid option:");	
			}//switch
		}//while
	}//main
}//class
				
© 2020 GitHub, Inc.
Terms
Privacy
Security
Status
Help
Contact GitHub
Pricing
API
Training
Blog
About
