package com.bridgelabz.codingclub.Main;
import com.bridgelabz.codingclub.Service.*;
import com.bridgelabz.codingclub.Util.*;
import java.util.*;
import java.io.*;

public class AddressBooks{
	private static Scanner sc = new Scanner(System.in);
	private static final Feature Features = new Feature();
	public static void main(String args[]){
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
							Features.readData();
							break;
					case 3:
							System.out.println("enter id:");
							String idE = sc.next();
							sc.nextLine();
							Features.edit(idE);
							break;
					case 4:
							System.out.println("1:Delete All 2:Delete One");
							int op = sc.nextInt();
							if (op == 1){
								try{
									Features.delete();
								}catch(Exception e){
									e.printStackTrace();
								}
							} else {
								System.out.println("Enter id:");
								String delId = sc.next();
								try{
									Features.deleteOne(delId);
								}catch(Exception e){
									e.printStackTrace();
								}
							}
							break;
					case 5:System.out.println("1.sortBy Fname 2.sortBy lName 3.sortBy zip");
							int sortBy=sc.nextInt();
							if(sortBy == 1){
								Features.sortBy("fName");
							}else if (sortBy == 2){
								Features.sortBy("lName");
							}
							else if(sortBy == 3){
								Features.sortBy("zip");
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
