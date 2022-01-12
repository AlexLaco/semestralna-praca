package com.fiit.krizanek.interfc;
import com.fiit.krizanek.buildings.Economics;
import com.fiit.krizanek.data.Destinations;
import com.fiit.krizanek.people.Client;
import com.fiit.krizanek.people.Driver;
import com.fiit.krizanek.people.Manager;
import com.fiit.krizanek.vehicle.Vehicle;

import java.util.Scanner;

public class Menu {
  private static String input;

  private static Scanner keyb = new Scanner(System.in);

  ///MANAGER
  public static void MainMenu(Manager mng){
    clearConsole();
    System.out.println("Manager: " + mng.name);
    Menu.Options(0);

    while(true){
      System.out.print("\nOption: ");
      Scanner keyb = new Scanner(System.in);
      String input = keyb.nextLine();

      switch (input){
        case "0":
        case "?":   Menu.Options(0); break;
        case "1":   Menu.DriverOptionsMenu(); break;
        case "2":   Menu.VehicleOptionsMenu(); break;
        case "3":   Menu.ManagerOptionsMenu(); break;
        case "4":   Menu.ClientsOptionsMenu(); break;
        case "5":   System.out.println(Economics.getBalance() + "€"); break;
        case "6":   new Login(); clearConsole(); break;
        case "7":   System.exit(0); break;
        default: Menu.Options(-1);
      }
    }
  }

  ///CLIENT
  public static void MainMenu(Client currClient){
    clearConsole();
    System.out.println("Welcome " + currClient.name);
    int TextIndex = 4;
    Menu.Options(TextIndex);
    while(true){
      System.out.print("\n Client option: ");
      input = keyb.nextLine();
      switch (input){
        case "0":
        case "?": Menu.Options(TextIndex); break;
        case "1": currClient.NewPackage(currClient); break;
        case "2": currClient.MyPackages(currClient); break;
        case "3": new Login(); clearConsole(); break;
        case "4": System.exit(0); break;
        default: Menu.Options(-1);
      }
    }
  }


  public static void DriverOptionsMenu(){
    clearConsole();
      int TextIndex = 1;
      Menu.Options(TextIndex);
      do {
        System.out.print("\n Driver option: ");
        input = keyb.nextLine();
        switch (input){
          case "0":
          case "?": Menu.Options(TextIndex); break;
          case "1": Driver.ListOfDrivers(); break;
          case "2": Driver.NewDriver(); break;
          case "3": Driver.DeleteDriver(); break;
          case "4": Driver.SetVehicle(null); break;
          case "5": Driver.EditDriver(); break;
          case "6": Driver.DetailedInfo(); break;
          case "7": Menu.Options(0); break;
          default: Menu.Options(-1);
        }
      }while(!input.equals("7"));
    }



  public static void VehicleOptionsMenu(){
    clearConsole();
    int TextIndex = 2;
    Menu.Options(TextIndex);
    do {
      System.out.print("\n Vehicle option: ");
      input = keyb.nextLine();
      switch (input){
        case "0":
        case "?": Menu.Options(TextIndex); break;
        case "1": Vehicle.ListOfVehicles(0); break;
        case "2": Vehicle.NewVehicle(); break;
        case "3": Vehicle.DeleteVehicle(); break;
        case "4": Driver.SetVehicle(null); break;
        case "5": Menu.Options(0); break;
        default: Menu.Options(-1);
      }
    }while(!input.equals("5"));
  }

  private static void ManagerOptionsMenu() {
    clearConsole();
    int TextIndex = 3;
    Menu.Options(TextIndex);
    do {
      System.out.print("\n Manager option: ");
      input = keyb.nextLine();
      switch (input){
        case "0":
        case "?": Menu.Options(TextIndex); break;
        case "1": Manager.ListOfManagers(); break;
        case "2": Manager.NewManager(); break;
        case "3": Menu.Options(0); break;
        default: Menu.Options(-1);
      }
    }while(!input.equals("3"));
  }

  private static void ClientsOptionsMenu(){
    clearConsole();
    int TextIndex = 5;
    Menu.Options(TextIndex);
    do {
      System.out.print("\n Clients option: ");
      input = keyb.nextLine();
      switch (input){
        case "0":
        case "?": Menu.Options(TextIndex); break;
        case "1": Manager.ListOfClients(); break;
        case "2": Manager.Packages(); break;
        case "3": Manager.SendPackage(); break;
        case "4": Manager.TrackContracts(); break;
        case "5": Menu.Options(0); break;
        default: Menu.Options(-1);
      }
    }while(!input.equals("5"));
  }


  public static void Options(int opt) {
    String TextArray[][] = {
           /*0*/ {"Driver Options", "Vehicle Options", "Manager Options", "Clients Options","Company balance","Logout","Quit"},
           /*1*/ {"List of drivers",  "Hire driver","Fire driver", "Set Vehicle", "Edit Driver", "Detailed info", "Back"},
           /*2*/ {"List of vehicles", "New vehicle", "Delete vehicle", "Set Driver", "Back"},
           /*3*/ {"List of managers", "New manager", "Back"},
           /*4*/ {"New package", "My packages", "Logout", "Quit"},
           /*5*/ {"List of clients", "All packages", "Send package", "Ongoing contracts", "Back"}
    };

    if(opt != -1){

      for(int i=0; i < TextArray[opt].length; i++){
        System.out.println("["+(i+1)+"] "+TextArray[opt][i]);
      }
    }else System.out.println("Bad selection. Type [?] for help.");
  }


  public static void clearConsole() {
    for(int i=0; i<=6; i++) System.out.println("\n");
  }
}
