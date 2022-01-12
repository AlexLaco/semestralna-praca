package com.fiit.krizanek.interfc;

import com.fiit.krizanek.Main;
import com.fiit.krizanek.people.Client;
import com.fiit.krizanek.people.Manager;
import com.fiit.krizanek.people.Person;

import java.util.Scanner;

public class Login {

  private static Scanner keyb = new Scanner(System.in);
  private static String opt;

  public Login(){
    String logged = "quest";

    while(true) {
      System.out.println("[1] Client\n[2] Manager");
      opt = keyb.nextLine();

      if (opt.equals("1")) {
        //Napr. INA
        System.out.println("Test client: INA. Type '?' for list of clients");
        System.out.print("Client name: ");
        opt = keyb.nextLine();

        if( !opt.equals("?")){
          Client currClient = null;
          for(Client x: Client.clients){
            if(x.name.equals(opt)) {
              currClient = x;
              break;
            }
          }

          //Ak existuje client
          if(currClient != null)
            Menu.MainMenu(currClient);
          //Ak neexistuje client
          else{
            String newClient = opt;
            System.out.println("Client "+ opt + " doesn't exist. Do you want to create a new user? \n Y-Yes   |   N-No");

            //Create new client
            if((opt = keyb.nextLine()).equals("Y") || opt.equals("y")){
              Client NC = new Client(newClient);
              System.out.println("New Client created");
              Menu.MainMenu(NC);
            }

          }
        }else {
          for(Client x: Client.clients){
            System.out.print(x.name + " | ");
          }
          System.out.println("\n");
        }

      }

      else if (opt.equals("2")) {

        System.out.println("Test manager account: username: PavTok | password: 123");
        System.out.print("Username: ");
        String username = keyb.nextLine();

        System.out.print("Password: ");
        String pass = keyb.nextLine();

        for (Manager x : Manager.managers) {
          if (x.getUsername().equals(username) && x.getPassword().equals(pass)) {
            Menu.MainMenu(x);
          }
        }
        System.out.println("Username or password is incorrect.\n\n");
      }
    }
  }
}
