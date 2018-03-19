package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacBuilder(){
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
            .roll("bez sezamu")
            .burgers(1)
            .sauce("1000 wysp")
            .ingredient("sałata")
            .ingredient("cebula")
            .ingredient("ser")
            .build();
        //When
        int howManyIngredients = bigmac.getIngredients().size();
        //Then
        Assert.assertEquals(3, howManyIngredients);
    }
}
