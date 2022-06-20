// package client;
// import shared.remoteInterface.*;
// import shared.classes.*;
// import java.rmi.registry.LocateRegistry;
// import java.rmi.registry.Registry;
// import java.util.ArrayList;

// public class ClientApp {
//     private Registry registry;
//     public ClientApp(){
//         try {
//             registry = LocateRegistry.getRegistry("localhost", 2020);
//         } catch (Exception e) {
//             System.out.println(e);
//         }
//     }
//     public void department() {
//         try {
//             departmentInterface  departmentStub = (departmentInterface) registry.lookup("department");
//             Department dep = new Department("Mechanical", "mech");
//             int row = departmentStub.addDepartment(dep);
//             System.out.println(row+" is affected");
//         } catch (Exception e) {
//             //TODO: handle exception
//         }
//         System.out.println("Hello world");
//     }
//     public void section() {
//         try {
//             sectionInterface  sectionStub = (sectionInterface) registry.lookup("section");
//             Section sec = new Section("A", "mechA");
//             sec.setDepartmentId("mech");
//             int row =  sectionStub.addSection(sec);
//             System.out.println(row+" is affected");

//         } catch (Exception e) {
//             //TODO: handle exception
//         }
//     }
//     public void course() {
//         try {
//             courseInterface  courseStub = (courseInterface) registry.lookup("course");
//             Course cour = new Course("Java", "JA", 4);
//             cour.setSectionId("mechA");
//             int row = courseStub.addCourse(cour);
//             System.out.println(row+" is affected");

//         } catch (Exception e) {
//             //TODO: handle exception
//         }
//     }
//     public void teacher() {
//         try {
//             teacherInterface  teacherStub = (teacherInterface) registry.lookup("teacher");
//             Teacher teach = new Teacher("chere123", "Chere", "Lemma", "chere@gmail");
//             teach.setCourseId("JA");
//             teach.setSectionId("mechA");
//             int row = teacherStub.addTeacher(teach);
//             System.out.println(row+" is affected");

//         } catch (Exception e) {
//             //TODO: handle exception
//         }
//     }
//     public void student() {
//         try {
//             studentInterface  studentStub = (studentInterface) registry.lookup("student");
//             Student stud = new Student("ets0587", "Nurlign", "Desalew");
//             stud.setSectionId("mechA");
//             int row = studentStub.addStudent(stud);
//             System.out.println(row+" is affected");
//         } catch (Exception e) {
//             //TODO: handle exception
//         }
//     }
//     public void grade() {
//         try {
//             gradeInterface  gradeStub = (gradeInterface) registry.lookup("grade");
//             ArrayList<Grade>grades = new ArrayList<>();
//             Grade g1 = new Grade("ets0602", "chere123", 89.6);
//             grades.add(g1);
//             int row = gradeStub.addGrade(grades);
//             System.out.println(row+" is affected");
//         } catch (Exception e) {
//             //TODO: handle exception
//         }
//     }
// }
