package com.tw.academy.basic.$6_primitive_obsession.practiceOne;

public class DeliveryManager {
    private Address toAddress;
    private Address fromAddress;

    public DeliveryManager(Address fromAddress, Address toAddress) {
        this.toAddress = toAddress;
        this.fromAddress = fromAddress;
    }

    public DeliverCenter allocate(){
        boolean isSameProvince = toAddress.isSameProvince(fromAddress,this);
        boolean isSameCity = toAddress.isSameCity(fromAddress, this);
        if (isSameProvince && isSameCity){
            return DeliverCenter.LOCAL;
        }
        if (isSameProvince) {
            return DeliverCenter.PROVINCE;
        }
        return DeliverCenter.FOREIGN;
    }

    public String getCity(String address) {
        return address.substring(address.indexOf("省") + 1, address.indexOf("市"));
    }

    public String getProvince(String address) {
        return address.substring(0, address.indexOf("省"));
    }
}
