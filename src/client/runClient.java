package client;
public class runClient{
  public static void main(String[] args) {
    try {
        
       ClientApp runApp = new ClientApp();
       //runApp.department();
       //runApp.section();
       //runApp.course();
      //runApp.student();
       runApp.teacher();
        //runApp.grade();
        
    } catch (Exception e) {
        System.out.println(e);
    }
  }
}


