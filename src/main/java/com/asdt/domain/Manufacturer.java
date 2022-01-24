package com.asdt.domain;

import com.asdt.persistence.PersistentObject;

public class Manufacturer extends PersistentObject{
    private String address;

    public void setAddress(String a) {
        address = a;
    }

    public String getAddress() {
        return address;
    }

    public String toString() {
        return "Manufacturer: OID: [" + oid + "] address: [" + address + "]";
    }
}
