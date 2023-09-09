/*
Andres Jimmy
Software Development I - CEN 3024
August 9, 2023
LMSController class main method for a user to add, remove, and list
books from a text file
 */

package org.example;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class LMSController {

    public static void main(String[] args) throws IOException {

        ArrayList<LMS> collection = new ArrayList<LMS>();

//The scanner s and while loop is used to parse through the file
// and add to the arrayList of LMS objects "collection" for editing
        Scanner s = new Scanner(new File("collection.txt"));
        while (s.hasNext()) {
            String[] split = s.nextLine().split(",");
            collection.add(new LMS(Integer.parseInt(split[0]), split[1], split[2]));
        }


        String menu = "Please pick an option\n" +
                "1. Add a book to collection\n" +
                "2. Remove a book from collection by ID number\n" +
                "3.List all books in collection\n" +
                "4.Exit";

        int menuInput = 0;


        while (menuInput != 4) {
            System.out.println(menu);
            Scanner userSelect = new Scanner(System.in);
            menuInput = userSelect.nextInt();

            switch (menuInput) {
                case 1:
/*Method name:addBookToList(ArrayList<LMS> arrayList);
Uses LMS class to add an object of type LMS to collection ArrayList
*/
                     addBookToList(collection);

//FileWriter fw and for loop is used to write an added book to file
                    FileWriter fw = new FileWriter("collection.txt");
                    for (LMS string : collection) {
                        fw.write(string + System.lineSeparator());
                    }
                    fw.close();
                    break;
                case 2:

                    removeBook(collection);

//FileWriter fw1 is used to rewrite file after removal from list

                    FileWriter fw1 = new FileWriter("collection.txt");
                    for (LMS string : collection) {
                        fw1.write(string + System.lineSeparator());
                    }
                    fw1.close();
                    break;
                case 3:
                    // listBooks(collection);
                    readFile(new File("collection.txt"));
                    break;
                case 4:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Please try again");
                    break;


            }
        }
    }

/*
Method name: addBookToList(ArrayList<LMS> arrayList)
Adds a user entry to an array list of class LMS and sets an id number
 */
    public static void addBookToList(ArrayList<LMS> arrayList) {
        int id;
        arrayList.add(new LMS());
        for (int i = 0; i < arrayList.size(); i++) {
            id = i;
            arrayList.get(i).setId(id);
        }

    }

    /*
    Method name: removeBook(ArrayList<LMS> arrayList)
     If user removes book, asks for ID number and removes from list
     and updates id number
     */
    public static void removeBook(ArrayList<LMS> arrayList) {
        int id;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the ID number of book to remove");
        listBooks(arrayList);
        int bookID = input.nextInt();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getId() == bookID) {
                arrayList.remove(i);
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            id = i;
            arrayList.get(i).setId(id);
        }
    }


    //Unused method to shows contents of array list
    public static void listBooks(ArrayList<LMS> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
            //  System.out.println(arrayList);
        }


    }
    /*Method name: readFile(File fileP)
    Prints out contents from text file
    */
    public static void readFile(File fileP) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileP));
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
    }


    //This code was created for possible future use

/*public static void saveFile(ArrayList<LMS> arrayList) throws IOException {
    FileWriter fw = null;
    try {
        fw = new FileWriter("collection.txt", true);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    for(LMS string: arrayList) {
        fw.write(string + System.lineSeparator());
    }
    fw.close();
    */

}




