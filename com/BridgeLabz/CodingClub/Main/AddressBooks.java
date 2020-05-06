package com.bridgelabz.codingclub.Main;
import com.bridgelabz.codingclub.service.*;
import com.bridgelabz.codingclub.utils.*;
import java.util.*;
import java.io.*;

public class AddressBooks{

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String opt;
		int option = 0;
		System.out.println("OPTIONS:");
		do {
			System.out.println("1.ADD  2.OPEN  3.EDIT  4.DELETE  5.SORT  6.EXIT");
			opt = sc.next();
			boolean checkResult = Util.checkInt(opt);
			if (checkResult){
				option = Integer.parseInt(opt);
				switch(option){
					case 1:
							Util.getPerson();
							break;
					case 2:
							Service service = new Service();
							service.readData();
							break;
					case 3:
							System.out.println("enter id:");
							String idE = sc.next();
							sc.nextLine();
							Service sr = new Service();
							sr.edit(idE);
							break;
					case 4:
							System.out.println("1:Delete All 2:Delete One");
							int op = sc.nextInt();
							if (op == 1){
								Service srv = new Service();
								try{
									srv.delete();
								}catch(Exception e){
									e.printStackTrace();
								}
							} else {
								System.out.println("Enter id:");
								String delId = sc.next();
								Service srv = new Service();
								try{
									srv.deleteOne(delId);
								}catch(Exception e){
									e.printStackTrace();
								}
							}
							break;
					case 5:System.out.println("1.sortBy Fname 2.sortBy lName 3.sortBy zip");
							int sortBy=sc.nextInt();
							Service srv = new Service();
							if(sortBy == 1){
								srv.sortBy("fName");
							}else if (sortBy == 2){
								srv.sortBy("lName");
							}
							else if(sortBy == 3){
								srv.sortBy("zip");
							}else{
								 System.out.println("Enter a valid option:");
							}
							break;
					case 6: System.exit(0);break;
					default : System.out.println("Enter a valid option:");
				}//switch
			}else{
				System.out.println("Enter a valid number:");
			}
		}while(option != 6);//while
	}//main
}//class
