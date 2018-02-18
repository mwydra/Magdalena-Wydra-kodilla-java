package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public class Continent {
    private final List<Country> countries;

    public Continent(final List<Country> countries){
        this.countries = countries;

    }

    public List<Country> getCountries() {
        return new ArrayList<>(countries);
    }
}
