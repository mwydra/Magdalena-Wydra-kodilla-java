package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity(){
        //Given
        List<Country> europe = new ArrayList<Country>();
        europe.add(new Country("Poland", new BigDecimal("23434656878988987")));
        europe.add(new Country("France", new BigDecimal("345786897764567865")));
        europe.add(new Country("Germany", new BigDecimal("124365887987565346")));
        europe.add(new Country("Spain", new BigDecimal("5465757867654547654")));
        Continent Europe = new Continent(europe);
        List<Country> asia = new ArrayList<Country>();
        asia.add(new Country("China", new BigDecimal("53253346547687645656")));
        asia.add(new Country("India", new BigDecimal("4365475689679789875")));
        asia.add(new Country("Japan", new BigDecimal("347568769634535654657")));
        asia.add(new Country("Thailand", new BigDecimal("3453645768765453534")));
        Continent Asia = new Continent(asia);
        List<Country> africa = new ArrayList<Country>();
        africa.add(new Country("Egypt", new BigDecimal("32353465478976764")));
        africa.add(new Country("Sudan", new BigDecimal("3457568879876445")));
        africa.add(new Country("Libya", new BigDecimal("14235476667876443")));
        africa.add(new Country("Somalia", new BigDecimal("2143656898787644")));
        Continent Africa = new Continent(africa);
        List<Country> americaPn = new ArrayList<Country>();
        americaPn.add(new Country("Canada", new BigDecimal("4365476643546646")));
        americaPn.add(new Country("UnitedStatesOfAmerica", new BigDecimal("3645767687643365475")));
        americaPn.add(new Country("Mexico", new BigDecimal("43658768764534657547")));
        americaPn.add(new Country("Cuba", new BigDecimal("3645768657644357658545")));
        Continent AmericaPN = new Continent(americaPn);

        List<Continent> continents = new ArrayList<Continent>();
        continents.add(Europe);
        continents.add(Asia);
        continents.add(Africa);
        continents.add(AmericaPN);
        World world = new World(continents);

        //When
        BigDecimal totalPeopleQuantity = world.getPeopleQuantity();

        //Then
        BigDecimal expectedTotalPeopleQuantity = new BigDecimal("4107730332692058959083");
        Assert.assertEquals(expectedTotalPeopleQuantity, totalPeopleQuantity);
    }

}

