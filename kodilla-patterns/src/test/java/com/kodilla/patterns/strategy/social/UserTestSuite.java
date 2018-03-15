package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies(){
        //Given
        User adam = new Millenials("Adam");
        User bryan = new YGeneration("Bryan");
        User kevin = new ZGeneration("Kevin");
        //When
        String adamsSocialPublisher = adam.sharePost();
        String bryansSocialPublisher = bryan.sharePost();
        String kevinsSocialPublisher = kevin.sharePost();
        //Then
        Assert.assertEquals("Facebook", adamsSocialPublisher);
        Assert.assertEquals("Twitter", bryansSocialPublisher);
        Assert.assertEquals("Snapchat", kevinsSocialPublisher);
    }

    @Test
    public void testIndividualSharingStrategy(){
        //Given
        User mike = new ZGeneration("Mike");
        //When
        mike.setSocialPublisher(new FacebookPublisher());
        String mikesSocialPublisher = mike.sharePost();
        //Then
        Assert.assertEquals("Facebook", mikesSocialPublisher);
    }
}
