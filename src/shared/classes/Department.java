
package shared.classes;
import java.io.Serializable;
import java.util.ArrayList;
public class Department implements Serializable{
    private String departmentId;
    private String departmentName;
    private ArrayList<Section>sections = new ArrayList<Section>();
    public Department(String depName, String id){
        this.departmentName = depName;
        this.departmentId = id;
    }
    public String getDepartmentId(){
        return this.departmentId;
    }
    public String getDepartmentName(){
        return this.departmentName;
    }
    public ArrayList<Section> getAllSection(){
        return this.sections;
    }
   
    public void setDepartmentName(String name){
        this.departmentName = name;
    }
    public void setDepartmentId(String id){
        this.departmentId = id;
    }
    public void addSection(Section section){
        this.sections.add(section);
    }

    // public void assignTeachertoSection(Teacher teacher,Section section){

    //         section.setTeacher(teacher);
    // }
    // public void assignCoursetoSection(Course course){
    //     for(Section section : this.sections){
    //         section.setCourse(course);
    //     }
    // }
    // public void registerStudent(Student student, Section section){
    //     section.setStudent(student);
    // }
}

