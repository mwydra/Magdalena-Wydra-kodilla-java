package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest(){
        //Given
        MedianAdapter medianAdapter = new MedianAdapter();
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("Jerzy Pilch", "Wiele Demonów", 2000, "ISBN 12345"));
        bookSet.add(new Book("Leopold Tyrmand", "Zły", 2010, "ISBN 54321"));
        bookSet.add(new Book("Janusz Głowacki", "Z głowy", 1999, "ISBN 24680"));
        bookSet.add(new Book("Eustachy Rylski", "Warunek", 2005, "ISBN 13579"));
        bookSet.add(new Book("Inga Iwasiów", "Ku słońcu", 1995, "ISBN 21543"));
        //When
        int yearMedian = medianAdapter.publicationYearMedian(bookSet);
        //Then
        System.out.println(yearMedian);
        assertEquals(2000, yearMedian);
    }
}
