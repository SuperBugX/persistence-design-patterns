package com.asdt.domain;

import com.asdt.persistence.PersistentObject;

public class Product extends PersistentObject {
    private String description;
    private int price;

    // VIRTUAL PROXY object
    private Manufacturer manufacturer;

    public void setDescription(String d) {
        description = d;
    }

    public void setPrice(int p) {
        price = p;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String toString() {
        return "Product: OID: [" + oid + "] Description: [" + description + "] Price: [" + price + "] Manufacturer: [" + manufacturer + "]";
    }

    public String getManufacturerAddress() {
        return manufacturer.getAddress();
    }

    public void setManufacturer(Manufacturer im) {
        manufacturer = im;
    }

}
