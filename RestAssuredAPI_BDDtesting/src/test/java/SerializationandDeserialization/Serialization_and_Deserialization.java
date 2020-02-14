package SerializationandDeserialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Test implements Serializable
{
	int i=10,j=20;
}
//this concept is used to save memory
public class Serialization_and_Deserialization {

	public static void main (String[] args)throws IOException, ClassNotFoundException{
		Test t1=new Test(); //t1 object
		
		//Serialization
		
		FileOutputStream fos=new FileOutputStream("test.txt");//allow us to wrte the file into memory
		ObjectOutputStream oos =new ObjectOutputStream(fos);
		
		oos.writeObject(t1);
		
		//Deserialization
		FileInputStream fis=new FileInputStream("test.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		
		Test t2=(Test)  ois.readObject();//reading and storing
		System.out.println(t2.i+" "+t2.j);
		
	}
}
