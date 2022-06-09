package shared.classes;

import java.io.Serializable;

public class Course implements Serializable{
    private String courseId;
    private String courseName;
    private int creaditHour;
    private String sectionId;

    public Course(String name, String id, int creaditHour){
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
    public void setSectionId(String sectionId){
        this.sectionId = sectionId;
    }
    
    
    public String getSectiond(){
        return this.sectionId;
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


