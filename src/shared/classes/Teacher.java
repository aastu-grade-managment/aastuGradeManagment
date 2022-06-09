
package shared.classes;
import java.io.Serializable;

public class Teacher implements Serializable{
    private String teacherId;
    private String firstName;
    private String lastName;
    private String courseId;
    private String email;
    private String sectionId;

    public Teacher(String teacherId, String firstName, String lastName, String email){
        this.teacherId = teacherId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    public void setcourseId(String courseId){
        this.courseId = courseId;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setTeacherId(String teacherId){
        this.teacherId = teacherId;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setCourseId(String courseId){
        this.courseId = courseId;
    }
    public void setSectionId(String sectionId){
        this.sectionId = sectionId;
    }
    
    public String getCourseId(){
        return this.courseId;
    }
    public String getSectionId(){
        return this.sectionId;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public String getLastName(){
        return this.lastName;
    }
    public String getTeacherId(){
        return this.teacherId;
    }
    public String getEmail(){
        return this.email;
    }
   
}
