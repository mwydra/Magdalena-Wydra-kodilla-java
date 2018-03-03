package com.kodilla.good.patterns.food2door;

public class Provider {
    private String providerName;
    private int nip;

    public Provider(String providerName, int nip) {
        this.providerName = providerName;
        this.nip = nip;
    }

    public String getProviderName() {
        return providerName;
    }
    public int getNip() {
        return nip;
    }
}
