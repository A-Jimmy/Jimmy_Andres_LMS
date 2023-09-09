/*
Andres Jimmy
Software Development I - CEN 3024
August 9, 2023
LMS Class that asks for user input for book information
 */

package org.example;

import java.util.Scanner;

public class LMS {
    private int id;

    private String title;
    private String author;

    public LMS() {
        addBook();
    }

    public LMS(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    @Override
    public String toString() {
        return id + "," + title + "," + author;
    }

    /*
    Method name:addBook()
    Takes in user input to set the title and author of class book
    */
    public void addBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter title of book");
        setTitle(input.nextLine());
        System.out.println("Enter author");
        setAuthor(input.nextLine());
    }


}
