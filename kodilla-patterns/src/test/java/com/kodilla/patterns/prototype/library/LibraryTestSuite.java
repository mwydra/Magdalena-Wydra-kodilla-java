package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    public void testGetBooks(){
        //Given
        Library library = new Library("Biblioteka 1: \n");
        Book book1 = new Book("Encyklopedia, Tom 1", "PWN", LocalDate.of(2000, 01, 01));
        Book book2 = new Book("Encyklopedia, Tom 2", "PWN", LocalDate.of(2000, 01, 01));
        Book book3 = new Book("Encyklopedia, Tom 3", "PWN", LocalDate.of(2000, 01, 01));
        Book book4 = new Book("Encyklopedia, Tom 4", "PWN", LocalDate.of(2000, 01, 01));
        Book book5 = new Book("Encyklopedia, Tom 5", "PWN", LocalDate.of(2000, 01, 01));
        library.books.add(book1);
        library.books.add(book2);
        library.books.add(book3);
        library.books.add(book4);
        library.books.add(book5);

        Library clonedLibrary = null;
        try{
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Biblioteka 2: \n");
        }
        catch (CloneNotSupportedException e){
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try{
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Biblioteka 3: \n");
        }
        catch (CloneNotSupportedException e){
            System.out.println(e);
        }

        //When
        System.out.println(library.name + library.getBooks().toString());
        System.out.println(clonedLibrary.name + clonedLibrary.getBooks().toString());
        System.out.println(deepClonedLibrary.name + deepClonedLibrary.getBooks().toString());
        //Then
        Assert.assertEquals(library.getBooks(), clonedLibrary.getBooks());
        Assert.assertEquals(library.getBooks(), deepClonedLibrary.getBooks());
        Assert.assertEquals(clonedLibrary.getBooks(), deepClonedLibrary.getBooks());
    }
}
