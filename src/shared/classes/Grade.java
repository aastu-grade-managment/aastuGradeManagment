
package shared.classes;
import java.io.Serializable;
public class Grade implements Serializable{

    private Double value;
    private String courseId;
    private String studentId;
    
    public Grade(String studentId , String courseId, Double value){
          this.courseId = courseId;  
          this.studentId = studentId;
          this.value = value;  
    }
    public void setValue(Double value){
        this.value = value;
    }

    public String getCourseId() {
        return this.courseId;
    }
    public String getStudentId() {
        return this.studentId;
    }
    public Double getValue() {
        return this.value;
    }
}



