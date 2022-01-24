package com.asdt.domain;

import com.asdt.persistence.OID;
import com.asdt.persistence.PersistenceFacade;

public class ManufacturerProxy extends Manufacturer {
    // VIRTUAL PROXY pattern
	
	//Removed manufacturer object to avoid delegation, The ManufacturerProxy class IS a manufacturer

    private OID realSubjectOID;

    public ManufacturerProxy(OID oid) {
        realSubjectOID = oid;
    }

    private void getRealSubject() {
    	//Get the full original Manufacturer Object
    	Manufacturer realSubject = (Manufacturer) PersistenceFacade.getInstance().get(realSubjectOID, Manufacturer.class);
    	
    	//Set ALL of the variables of the Proxy Class using the new Object
    	//By using setAddress I am using the (parent) manufacturers original method implementation
    	this.setAddress(realSubject.getAddress());
    }

    //Override getAddress to accomplish Proxy functionality
    @Override
    public String getAddress() {
    	//Use the parent getAddress class, exploiting inheritance and reusing code
    	String address = super.getAddress();
    	if(address == null) {
    		//Get real manufacturer
    		this.getRealSubject();
    		//Get the address again using the manufacturers getAddress method
    		address = super.getAddress();
    	}
        return address;
    }

    public String toString() {
        return "ManufacturerProxy: OID: [" + realSubjectOID + "] Manufacturer: Address: [" + this.getAddress() + "]";
    }    
}
