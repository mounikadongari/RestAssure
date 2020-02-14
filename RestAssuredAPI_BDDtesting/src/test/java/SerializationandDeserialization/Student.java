package SerializationandDeserialization;

import java.util.ArrayList;
import java.util.List;

public class Student {

	public Integer id;
	public String firstName;
	public String lastName;
	public String email;
	public String programme;
	
	List<String> courses; //it stores the different values
	
	public int getSID() {
		return id;
	}
	
	public void setSID(Integer id) {
		this.id =id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	
	public String getlastName() {
		return lastName;
	}
	public void setlastName(String lastName) {
		this.lastName=lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getprogramme() {
		return programme;
	}
	
	public void setprogramme(String programme) {
		this .programme=programme;
	}
	
	public List<String> getCourses(){
		
		return courses;
	}
public void setCourses(List<String> courses) {
	this.courses=courses;
}

public String getStudentRecord() {
	return(this.id+" "+this.firstName+" "+this.lastName+" "+this.email+" "+this.programme+" "+this.courses);
}


}
