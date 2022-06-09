
package shared.classes;
import java.io.Serializable;
import java.util.ArrayList;
public class Section implements Serializable{
    
    private String sectionId;
    private String sectionName;
    private String departmentId;

    private ArrayList<Course>courses = new ArrayList<Course>();
    private ArrayList<Teacher>teachers = new ArrayList<Teacher>();
    private ArrayList<Student>students = new ArrayList<Student>();
    
    
    
    public Section(String sectionName, String sectionId){
        this.sectionId = sectionId;
        this.sectionName = sectionName;
    }
    public void setSectionName(String sectionName){
        this.sectionName = sectionName;
    }
    public void setSectionId(String sectionId){
        this.sectionId = sectionId;
    }
    public void setDepartmentId(String departmentId){
        this.departmentId = departmentId;
    }
    public String getSectionId(){
        return this.sectionId;
    }
    public String getSectionName(){
        return this.sectionName;
    }
    public String getDepartmentId(){
        return this.departmentId;
    }

    public void setTeacher(Teacher teacher){
        this.teachers.add(teacher);
    }
    public void setCourse(Course course){
        this.courses.add(course);
    }
    public void setStudent(Student student){
        this.students.add(student);
    }
    
    public ArrayList<Teacher> getAllTeacher(){
        return this.teachers;  
    }
    
    public ArrayList<Student> getAllStudent(){
        return this.students;
    }
    public ArrayList<Course> getAllCourse(){
        return this.courses;
    }

    // public Student getStudent(String studentId){
    //     for(Student student : this.students){
    //         if(studentId.equals(student.getStudentId()))               
    //     }
    //     return this.students.get(0);
    // }
    // public Teacher getTeacher(String teacherId){
       
    //     for(Teacher teacher : this.teachers){
    //         if(teacherId.equals(teacher.getTeacherId()))
    //            tempTeacher = teacher;
    //     }
    //     return tempTeacher;
    // }
    // public Course getCourse(String courseId){
    //     Course tempCourse = new Course("s","d",2);
    //     for(Course course : this.courses){
    //         if(courseId.equals(course.getCourseId()))
    //            tempCourse = course;
    //     }
    //     return tempCourse;
    // }
}