/**
 * Ability to create Contacts in Address Book with first and last names, address, city, state, zip, phone number and email.
 * Ability to Edit Contact using first name.
 * Ability to Delete contact using first name.
 */
package com.bridgelabz.addressbook;

import java.util.*;

public class AddressBookMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        Map<String, AddressBook> addressBookMap = new HashMap<String,AddressBook>();
        while (true) {
            System.out.println("\n--------------------------Welcome to Address Book System--------------------------");
            System.out.println("1. New Address Book");
            System.out.println("2. Select Address Book");
            System.out.println("3. Delete Address Book");
            System.out.println("4. Search Contact Data");
            System.out.println("5. View Contact Data");
            System.out.println("6. Count Contacts ");
            System.out.println("7. Exit");
            System.out.print("Enter Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter Name of new Address Book: ");
                    String bookName = sc.next();
                    sc.nextLine();
                    //adding bookname as a key and vlue is allocating memory for addressbook obj
                    addressBookMap.put(bookName, new AddressBook());
                    //call addressbookoption method with passing key of hashmap
                    addressBook.addressBookOptions(addressBookMap.get(bookName));
                    break;
                case 2:
                    System.out.println("List of available Address Book : ");
                    //retrived keys from hashmap to show addressbooklist
                    Set keys = addressBookMap.keySet();
                    Iterator i = keys.iterator();
                    while (i.hasNext()){
                        System.out.println(i.next());
                    }
                    System.out.println("Enter Address Book name you want to Open : ");
                    String name = sc.nextLine();
                    System.out.println("Current Address Book is : " + name);
                    //call method with passing address book name
                    addressBook.addressBookOptions(addressBookMap.get(name));
                    break;
                case 3:
                    System.out.println("List of available Address Book : ");
                    Set keys1 = addressBookMap.keySet();
                    //retrived keys from hashmap to show addressbooklist
                    Iterator i1 = keys1.iterator();
                    while (i1.hasNext()){
                        System.out.println(i1.next());
                    }
                    System.out.println("Enter Address Book name to be delete: ");
                    name = sc.nextLine();
                    //delete hashmap using remove fun
                    addressBookMap.remove(name);
                    break;
                case 4:
                    System.out.println("Welcome to the search option:");
                    addressBook.searchByOptions();
                    break;
                case 5:
                    System.out.println("Welcome to view By Option:");
                    addressBook.viewByOption(addressBookMap);
                    break;
                case 6:
                    System.out.println("Welcome to the couter");
                    addressBook.countByOption();
                    break;
                case 7:
                    sc.close();//for closing the programme
                    return;
                default:
                    System.out.println("You Entered Invalid Choice....!");
                    break;
            }
        }
    }
}