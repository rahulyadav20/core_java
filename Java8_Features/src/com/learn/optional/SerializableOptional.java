package com.learn.optional;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Optional;

public class SerializableOptional {
	
	public static void main(String args[]){
		
		
	SerializeMe obj = new SerializeMe("Jack", Optional.of("Maryland"));
	
	try {
        FileOutputStream fileOut =
        new FileOutputStream("C://employee.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(obj);
        out.close();
        fileOut.close();
        System.out.printf("Serialized data is saved in /tmp/employee.ser");
     } catch (IOException i) {
        i.printStackTrace();
     }
	
	try {
        FileInputStream fileIn = new FileInputStream("C://employee.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        SerializeMe e = (SerializeMe) in.readObject();
        in.close();
        fileIn.close();
        
        System.out.println(e.getAddress());
     } catch (IOException exc) {
    	 exc.printStackTrace();
        return;
     } catch (ClassNotFoundException c) {
        System.out.println("Employee class not found");
        c.printStackTrace();
        return;
     }
	
	}

}


class SerializeMe implements java.io.Serializable{
	
	String name;
	Optional<String> address;
	
	public SerializeMe(String name, Optional<String> address){
		
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Optional<String> getAddress() {
		return address;
	}

	public void setAddress(Optional<String> address) {
		this.address = address;
	}
	
	
}
