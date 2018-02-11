package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AdvStatisticsTestSuite {
    private static final double DELTA = 1e-15;

    @Test
    public void testCalculateAdvStatistics() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        AdvStatistics advStatistics = new AdvStatistics(statisticsMock);
        List<String> userNamesTest = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            userNamesTest.add("User " + i);
        }

        when(statisticsMock.usersNames()).thenReturn(userNamesTest);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(500);
        //When
        advStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(10, advStatistics.getPostsPerUsersAv(), DELTA);
        Assert.assertEquals(5, advStatistics.getCommentsPerUsersAv(), DELTA);
        Assert.assertEquals(0.5, advStatistics.getCommentsPerPostsAv(), DELTA);
        advStatistics.ShowStatistics();

        //Given
        when(statisticsMock.postsCount()).thenReturn(0);
        //When
        advStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(0.0, advStatistics.getPostsPerUsersAv(), DELTA);
        Assert.assertEquals(5, advStatistics.getCommentsPerUsersAv(), DELTA);
        Assert.assertEquals(Double.POSITIVE_INFINITY, advStatistics.getCommentsPerPostsAv(), DELTA);
        advStatistics.ShowStatistics();

        //Given
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(0);
        //When
        advStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(10, advStatistics.getPostsPerUsersAv(), DELTA);
        Assert.assertEquals(0, advStatistics.getCommentsPerUsersAv(), DELTA);
        Assert.assertEquals(0, advStatistics.getCommentsPerPostsAv(), DELTA);
        advStatistics.ShowStatistics();

        //Given
        when(statisticsMock.commentsCount()).thenReturn(1500);
        //When
        advStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(10, advStatistics.getPostsPerUsersAv(), DELTA);
        Assert.assertEquals(15, advStatistics.getCommentsPerUsersAv(), DELTA);
        Assert.assertEquals(1.5, advStatistics.getCommentsPerPostsAv(), DELTA);
        advStatistics.ShowStatistics();

        //Given
        List<String> userNamesTest1 = new ArrayList<String>();
        when(statisticsMock.usersNames()).thenReturn(userNamesTest1);
        //When
        advStatistics.calculateAdvStatistics(statisticsMock);
        //Then
        Assert.assertEquals(Double.POSITIVE_INFINITY, advStatistics.getPostsPerUsersAv(), DELTA);
        Assert.assertEquals(Double.POSITIVE_INFINITY, advStatistics.getCommentsPerUsersAv(), DELTA);
        Assert.assertEquals(1.5, advStatistics.getCommentsPerPostsAv(), DELTA);
        advStatistics.ShowStatistics();
    }
}