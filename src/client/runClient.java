package client;

import client.controllers.LandingPage;

public class runClient{
  public static void main(String[] args) {
    try {
        new LandingPage();
        
    } catch (Exception e) {
        System.out.println(e);
    }
  }
}


