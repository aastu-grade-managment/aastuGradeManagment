package shared.classes;

import java.io.Serializable;

public class Course implements Serializable{
    private String courseId;
    private String courseName;
    private int creaditHour;
    private String departmentId;

    public Course(String id, String name, int creaditHour){
        this.courseId = id;
        this.courseName = name;
        this.creaditHour = creaditHour;
    }
    public void setCourseName(String name){
        this.courseName = name;
    }
    public void setCourseId(String id){
        this.courseId = id;
    }
    public void setCreaditHour(int creaditHour){
        this.creaditHour = creaditHour;
    }
    public void setDepartmentId(String departmentId){
        this.departmentId = departmentId;
    }
    

    public String getDepartmentId(){
        return this.departmentId;
    }
    public String getCourseName(){
        return this.courseName;
    }
    public String getCourseId(){
        return this.courseId;
    }
    public int getCreaditHour(){
        return this.creaditHour;
    }
}


