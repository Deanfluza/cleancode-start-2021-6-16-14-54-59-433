package com.tw.academy.basic.$6_primitive_obsession.practiceOne;

public class Address {
    private final String address;

    public Address(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public boolean isSameCity(Address fromAddress, DeliveryManager deliveryManager) {
        return deliveryManager.getCity(fromAddress.getAddress()).equals(deliveryManager.getCity(getAddress()));
    }

    public boolean isSameProvince(Address fromAddress, DeliveryManager deliveryManager) {
        return deliveryManager.getProvince(getAddress()).equals(deliveryManager.getProvince(fromAddress.getAddress()));
    }
}
