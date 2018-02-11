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
    }
}