package com.bridgelabz.codingclub.Service;
import com.bridgelabz.codingclub.Models.*;
import com.bridgelabz.codingclub.Utils.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.Scanner;
import java.util.*;
/*
*service class to provide all curd opertions to an AddressBook
*/

public class Service implements Iserv{
	private static Scanner sc = new Scanner(System.in);
	//@Override
	public void addData(Person P){
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("AddressBook.csv",true);
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
		List<Person> Persons = Util.getData();
		for (Person Per : Persons) {
			System.out.println(Per);
		}
	}//function_readData

	public void edit(String id){
		BufferedReader fileReader = null;
		int found = 0;
		try {
			List<Person> Persons = new ArrayList<Person>();
			String line = "";
			fileReader = new BufferedReader(new FileReader("AddressBook.csv"));
			while ((line = fileReader.readLine()) != null) {
				String[] details = line.split(",");
				if (details.length > 0) {
					if(details[0].equals(id)){
						System.out.println("Enter an option:");
						System.out.println("1.Address 2.zip");
						int op = sc.nextInt();
						found = 1;
						switch(op){
							case 1:System.out.println("Enter new address:");
								sc.nextLine();
								String add = sc.nextLine();
								Person P1 = new Person(details[0],details[1],details[2],add,Integer.parseInt(details[4]));
								Persons.add(P1);
								break;
							case 2:boolean flag;
								do{
									System.out.println("Enter new zip:");
									String zip = sc.next();
									flag = Util.checkInt(zip);
										if(flag){
											Person P2 = new Person(details[0],details[1],details[2],details[3],Integer.parseInt(zip));
											Persons.add(P2);
										}else{
											System.out.println("invalid Entry for zip:");
										}
								}while(flag == false);
								break;
							default :System.out.println("Enter a valid option:");
						}
					}else{
						Person P = new Person(details[0],details[1],details[2],details[3],Integer.parseInt(details[4]));
						Persons.add(P);
					}
				}
			}//while
			for (Person p : Persons){
				System.out.println(p);
			}
			if(found == 1){
				try{
					delete();
					for (Person p : Persons){
						addData(p);
					}
					System.out.println("Data Updated Successfully.....");
				}catch(Exception e){
					e.printStackTrace();
				}
			}else{
				System.out.println("ID Not Found!.....");
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}//functionEdit

	public void sortBy(String sortBy){
		List<Person> listPersons = Util.getData();
		switch(sortBy){
			case "fName":
					Collections.sort(listPersons, Person.fNameComp);
					for(Person p: listPersons){
						System.out.println(p);
					}
					break;
			case "lName":
					Collections.sort(listPersons, Person.lNameComp);
					for(Person p: listPersons){
						System.out.println(p);
					}
					break;
			case "zip":
					Collections.sort(listPersons, Person.ZipComp);
					for(Person p: listPersons){
						System.out.println(p);
					}
					break;
			default :System.out.println("can't sort by "+sortBy);
		}
	}//sortData

	public void deleteOne(String id){
		BufferedReader fileReader = null;
		int found = 0;
		try {
			List<Person> PersonList = new ArrayList<Person>();
			String line = "";
			fileReader = new BufferedReader(new FileReader("AddressBook.csv"));
			while ((line = fileReader.readLine()) != null) {
				String[] details = line.split(",");
				if (details.length > 0) {
					if(details[0].equals(id)){
						//skip data...
						found = 1;
					}else{
						Person P = new Person(details[0],details[1],details[2],details[3],Integer.parseInt(details[4]));
						PersonList.add(P);
					}
				}
			}//while
			if(found == 1){
				try{
					delete();
					for (Person p : PersonList){
						addData(p);
					}
				System.out.println("Data Deleted Successfully.....");
				}catch(Exception e){
					e.printStackTrace();
				}
			}else{
				System.out.println("ID Not Found!.....");
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}//deleteOne

	public void delete(){
		try{
			FileWriter fwriter = new FileWriter("AddressBook.csv",false);
			BufferedWriter write = new BufferedWriter(fwriter);
			write.write("");
			write.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}//delete
}//class
