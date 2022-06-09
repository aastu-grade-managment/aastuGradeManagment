
// package shared.classes;
// import java.util.*;
// import java.util.function.Function;

// public class MangmentClass {
    
//     public static void main(String[] args){
//         Department software = new Department("Software","soft12");

//         Section A = new Section("A", "1A");
//         Section B = new Section("B", "1B");
       
//         ArrayList<Section>sections = new ArrayList();
        
//         sections.add(B);
//         sections.add(A);
        
//         Course internet = new Course("Internet","int",3);
//         Course java = new Course("Java","jav",4);
        
        
//         Teacher chere = new Teacher("Chere","che","che","jav");
//         Teacher abdi = new Teacher("Abdi","abd","abd","int");
        
       
//         ArrayList<Course>courses = new ArrayList();
//         courses.add(java);
//         courses.add(internet);
        
//         Student selamu = new Student("ets0602","Selamu", "Dawit");
//         Student samuel = new Student("ets0585","Samuel", "Noah");

//         A.setCourse(java);
//         A.setCourse(internet);
//         A.setStudent(samuel);
//         A.setStudent(selamu);
//         A.setTeacher(abdi);
//         A.setTeacher(chere);

//         software.addSection(sections.get(0));
//         software.addSection(sections.get(0));
        
//         Grade grade1 = new Grade("ets0602","Chere",85.4);
//         Grade grade2 = new Grade("ets0585", "Chere",78.5);
        
    
//         System.out.println("Name: "+ software.getAllSection().get(0).getAllStudent().get(0).getFirstName());
//         System.out.println("Name: "+ software.getAllSection().get(0).getAllStudent().get(1).getFirstName());
        
//         System.out.println(software.getAllSection().get(0).getAllCourse().get(0).getCourseName()+ ": ");
//         System.out.println(software.getAllSection().get(0).getAllCourse().get(1).getCourseName()+ ": ");

//         System.out.println(software.getAllSection().get(0).getAllTeacher().get(0).getFirstName());
//         System.out.println(software.getAllSection().get(0).getAllTeacher().get(1).getFirstName());
 
//     }
//     Function<Double,Double> convertGrade = (grade)->{
//            if(grade>=90){
//                return 4.0;
//            } 
//            else if(grade<90&&grade>=85){
//                return 4.0;
//            }
//            else if(grade<85&&grade>=80){
//                return 3.75;
//            }
//            else if(grade<80&&grade>=75){
//                return 3.5;
//            }
//            else if(grade<75&&grade>=70){
//                return 3.0;
//            }
//            else if(grade<70&&grade>=65){
//                return 2.75;
//            }
//            else if(grade<65&&grade>=60){
//                return 2.5;
//            }
//            else if(grade<60&&grade>=55){
//                return 2.0;
//            }
//            else if(grade<55&&grade>=50){
//                return 1.75;
//            }
//            else if(grade<50&&grade>=40){
//                return 1.0;
//            }
//            else{
//                return 0.0;
//            }
//         };
// }
