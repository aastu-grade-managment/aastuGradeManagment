package client;

import client.controllers.LandingPage;

public class runClient{
  public static void main(String[] args) {
    try {
      LandingPage land = new LandingPage();
      land.getFrame().setVisible(true);

    } catch (Exception e) {
        System.out.println(e);
    }
  }
}


