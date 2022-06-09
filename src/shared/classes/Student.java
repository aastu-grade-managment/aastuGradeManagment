
package shared.classes;
import java.io.Serializable;
public class Student implements Serializable{
    private String studentId;
    private String firstName;
    private String lastName;
    private String sectionId;

    public Student(String studentId, String firstName, String lastName){
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setStudentId(String studentId){
        this.studentId = studentId;
    }
   
    public void setSectionId(String sectionId){
        this.sectionId = sectionId;
    }
    public String getSectionId(){
        return this.sectionId;
    }
    public String getStudentId(){
        return this.studentId;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    
}

