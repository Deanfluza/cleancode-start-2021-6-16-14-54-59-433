package com.tw.academy.basic.$6_primitive_obsession.practiceOne;

public class DeliveryManager {
    private Address toAddress;
    private Address fromAddress;

    public DeliveryManager(Address fromAddress, Address toAddress) {
        this.toAddress = toAddress;
        this.fromAddress = fromAddress;
    }

    public DeliverCenter allocate(){
        if (getProvince(toAddress.getAddress()).equals(getProvince(fromAddress.getAddress())) && getCity(toAddress.getAddress()).equals(getCity(fromAddress.getAddress()))){
            return DeliverCenter.LOCAL;
        }
        if (getProvince(toAddress.getAddress()).equals(getProvince(fromAddress.getAddress()))) {
            return DeliverCenter.PROVINCE;
        }
        return DeliverCenter.FOREIGN;
    }

    private String getCity(String address) {
        return address.substring(address.indexOf("省") + 1, address.indexOf("市"));
    }

    private String getProvince(String address) {
        return address.substring(0, address.indexOf("省"));
    }
}
