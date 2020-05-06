package com.bridgelabz.codingclub.Models;
import java.util.Random;
import java.util.*;

public class Person {
	private String id="";
	private String fname;
	private String lname;
	private String address;
	private int zip;

	Person(String id,String fname, String lname, String address, int zip) {
		this.zip = zip;
		this.fname = fname;
		this.lname = lname;
		this.id = id;
		this.address = address;
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
	public static Comparator<Person> fNameComp = new Comparator<Person>() {
		public int compare(Person p1, Person p2) {
		   String fName1 = p1.getfName().toUpperCase();
		   String fName2 = p2.getfName().toUpperCase();
		   //ascending order
		   return fName1.compareTo(fName2);
  }};
  public static Comparator<Person> ZipComp= new Comparator<Person>() {
		public int compare(Person p1, Person p2) {
		   int zip1 = p1.getZip();
		   int zip2 = p2.getZip();
		   return zip1-zip2;
	}};
	public static Comparator<Person> lNameComp = new Comparator<Person>() {
		public int compare(Person p1, Person p2) {
		   String lName1 = p1.getlName().toUpperCase();
		   String lName2 = p2.getlName().toUpperCase();
		   return lName1.compareTo(lName2);
  }};
	//@Override
	public String toString() {
		return "Customer [id=" + id + ", fname=" + fname +", lname=" + lname+ ", address=" + address + ", zip=" + zip + "]";
	}
}
