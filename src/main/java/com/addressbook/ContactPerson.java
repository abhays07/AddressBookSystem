package com.addressbook;

import java.util.Objects;

public class ContactPerson {
	String firstName;
    String lastName;
    String address;
    String city;
    String state;
    int zip;
    String phoneNumber;
    String email;
    
    
    @Override
    public boolean equals(Object obj) {
    	if(this == obj)
    		return true;
    	
    	if(obj==null || getClass() != obj.getClass())
    		return false;
    	
    	ContactPerson person = (ContactPerson) obj;
    	
    	return firstName.equals(person.firstName) && lastName.equals(person.lastName);
    	
    }
    
    @Override
    public int hashCode() {
    	return Objects.hash(firstName,lastName);
    }
}
