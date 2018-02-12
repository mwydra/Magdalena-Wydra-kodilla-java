package com.kodilla.testing.library;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BookDirectoryTestSuite {
    @Test
    public void testListBooksWithConditionsReturnList() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret"))
                .thenReturn(resultListOfBooks);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then
        assertEquals(4, theListOfBooks.size());
    }

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<Book>();
        for(int n = 1; n <= booksQuantity; n++){
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<Book>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                .thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FourtyBooks"))
                .thenReturn(resultListOf40Books);

        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FourtyBooks");
        // Then

        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf10Books = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf10Books);

        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        // Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    public void testListBookInHandsIsNull(){
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser user1 = new LibraryUser("Jan", "Jankowski", "90123112345");
        List<Book> resultListOfBooksInHands = new ArrayList<Book>();
        when(libraryDatabaseMock.listBooksInHandsOf(user1)).thenReturn(resultListOfBooksInHands);

        //When
        List<Book> theListOfBooks = bookLibrary.listBooksInHandsOf(user1);

        //Then
        assertEquals(0, resultListOfBooksInHands.size());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf(user1);
    }

    @Test
    public void testListBookInHandsIsOne(){
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser user2 = new LibraryUser("Adam", "Adamski", "80010112345");
        List<Book> resultListOfBooksInHands = new ArrayList<Book>();
        Book book = new Book("Author1", "Title1", 2000);
        resultListOfBooksInHands.add(book);
        when(libraryDatabaseMock.listBooksInHandsOf(user2)).thenReturn(resultListOfBooksInHands);

        //When
        List<Book> theListOfBooks = bookLibrary.listBooksInHandsOf(user2);

        //Then
        assertEquals(1, resultListOfBooksInHands.size());
        assertEquals(Arrays.asList(book), theListOfBooks);
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf(user2);
    }

    @Test
    public void testListBookInHandsIsFive(){
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser user3 = new LibraryUser("Karol", "Karolkiewicz", "70121212345");
        List<Book> resultListOfBooksInHands = Arrays.asList(
                new Book("Author1", "Title1", 2000),
                new Book("Author2", "Title2", 2001),
                new Book("Author3", "Title3", 2002),
                new Book("Author4", "Title4", 2003),
                new Book("Author5", "Title5", 2004));
        when(libraryDatabaseMock.listBooksInHandsOf(user3)).thenReturn(resultListOfBooksInHands);

        //When
        List<Book> theListOfBooks = bookLibrary.listBooksInHandsOf(user3);

        //Then
        assertEquals(5, resultListOfBooksInHands.size());
        assertEquals(resultListOfBooksInHands, theListOfBooks);
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf(user3);
    }
}