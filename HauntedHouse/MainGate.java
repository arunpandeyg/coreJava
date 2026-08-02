package HauntedHouse;


import javax.swing.*;

public class MainGate {

    public static String name;

    public static void main(String[] args) {
      name = JOptionPane.showInputDialog(null, "Hay! what is your name?", "The Haunted House", JOptionPane.INFORMATION_MESSAGE );
      ImageIcon mainGate = new ImageIcon("mainGate.jpg") {};
      JOptionPane.showMessageDialog(null, "Welcome to the Haunted House, " + name + "!\nYou have entered through the Main Gate", "Map", JOptionPane.INFORMATION_MESSAGE, mainGate);
      HauntedHouse.startPlease();
    }




static class HauntedHouse{

    public  static void  startPlease(){
       String firstScene = JOptionPane.showInputDialog("You now can either explore the Living Room, the Dining Room or go to the 2nd floor through the stairs area. Enter your choice: "," Living Room/ Dining Room / Stairs Area ");
        if (firstScene.equalsIgnoreCase("Living Room")){
            HauntedHouse.livingRoom();
        }else if (firstScene.equalsIgnoreCase("Dining Room")){
            HauntedHouse.diningRoom();
        }else if (firstScene.equalsIgnoreCase("Stairs Area")){
           HauntedHouse.stairsArea();
        }
    }
    public static void livingRoom(){
        ImageIcon livingRoom = new ImageIcon("livingRoom.jpg");
        JOptionPane.showMessageDialog(null, MainGate.name+ ", You are in the Living Room", "Map", JOptionPane.INFORMATION_MESSAGE, livingRoom);
       String livingRoomScene = JOptionPane.showInputDialog("You now can enter explore the Chest or explore the Bathroom", "Chest/Bathroom");
        if (livingRoomScene.equalsIgnoreCase("Chest")) {
            JOptionPane.showMessageDialog(null, "The Ghost escapes and scares you to Death", "The End", JOptionPane.INFORMATION_MESSAGE, livingRoom);
        }else if (livingRoomScene.equalsIgnoreCase("Bathroom")){
            bathroom();
        }else
            JOptionPane.showMessageDialog(null, "You didn't entered a valid choice", "The End", JOptionPane.INFORMATION_MESSAGE, livingRoom);
    }

    public static void bathroom(){
           ImageIcon bathroom = new ImageIcon("Bathroom.jpg");
           JOptionPane.showMessageDialog(null, MainGate.name + "You are in the Bathroom", "Map", JOptionPane.INFORMATION_MESSAGE, bathroom);
           String bathroomScene = JOptionPane.showInputDialog("You can now either look into the mirror or explore the shower, Enter your choice: ", "Mirror/shower");
           if (bathroomScene.equalsIgnoreCase("Mirror")){
               JOptionPane.showMessageDialog(null, "You watch that an ugly bloody face looking to you", "The End", JOptionPane.INFORMATION_MESSAGE, bathroom);
           }else if (bathroomScene.equalsIgnoreCase("Shower")){
               JOptionPane.showMessageDialog(null, "Room suddenly steams up and you feel fingers touching the back of your neck", "The End", JOptionPane.INFORMATION_MESSAGE, bathroom);
           }else
               JOptionPane.showMessageDialog(null, "You didn't entered a valid choice", "The End", JOptionPane.INFORMATION_MESSAGE, bathroom);
    }
    public static void diningRoom(){
           ImageIcon diningRoom = new ImageIcon("DiningRoom.jpg");
           JOptionPane.showMessageDialog(null, MainGate.name + ", You are in the Dining Room", "Map", JOptionPane.INFORMATION_MESSAGE, diningRoom);
           String diningRoomScene = JOptionPane.showInputDialog("You now can either explore Candelabra or explore the kitchen foe delicious food", "Candelabra/kitchen");
           if (diningRoomScene.equalsIgnoreCase("Candelabra")){
               JOptionPane.showMessageDialog(null, "Candelabra lights up by itself and you watch a death shadow", "The End", JOptionPane.INFORMATION_MESSAGE, diningRoom);
           }else if (diningRoomScene.equalsIgnoreCase("Kitchen")){
               kitchen();
           }else
               JOptionPane.showMessageDialog(null, "You didn't entered a valid choice", "The End", JOptionPane.INFORMATION_MESSAGE, diningRoom);
    }
    public static void kitchen(){
           ImageIcon kitchen = new ImageIcon("Kitchen.jpg");
           JOptionPane.showMessageDialog(null, MainGate.name + ", You are in the kitchen", "Map", JOptionPane.INFORMATION_MESSAGE, kitchen);
           String kitchenScene = JOptionPane.showInputDialog("You now can either explore the refrigerator or the cabinet or the pantry, Enter your choice: ", "Refrigerator/Cabinet/pantry");
           if (kitchenScene.equalsIgnoreCase("Refrigerator")){
               JOptionPane.showMessageDialog(null,"You open it and find out some delicious nice food, cooked for you specially", "The End", JOptionPane.INFORMATION_MESSAGE, kitchen );
           }else if (kitchenScene.equalsIgnoreCase("Cabinet")){
               JOptionPane.showMessageDialog(null, "The dishes and glasses starts flying at you as soon as you open the door, \nYou get hit in the head painfully and feel yourself moving towards a light", "The End", JOptionPane.INFORMATION_MESSAGE, kitchen);
           }else if (kitchenScene.equalsIgnoreCase("Pantry Area")){
               pantryArea();
           }else
               JOptionPane.showMessageDialog(null, "You didn't entered a valid choice", "The End", JOptionPane.INFORMATION_MESSAGE, kitchen);
    }

    public static void pantryArea() {
        ImageIcon pantryArea = new ImageIcon("Pantry Area.jpg");
        JOptionPane.showMessageDialog(null, MainGate.name + ", You are in the Pantry Area", "Map", JOptionPane.INFORMATION_MESSAGE, pantryArea);
        String pantryScene = JOptionPane.showInputDialog("You can either explore the dusty recipe box or the Broom", "Dusty recipe box/Broom");
        if (pantryScene.equalsIgnoreCase("The Dusty Recipe Box")) {
            JOptionPane.showMessageDialog(null, "You now can open it up and the recipe for chocolate devils food cake appears over no where", "The End", JOptionPane.INFORMATION_MESSAGE, pantryArea);
        } else if (pantryScene.equalsIgnoreCase("Broom")) {
            JOptionPane.showMessageDialog(null, "The Broom flies up in the air as soon as you touch it", "The End", JOptionPane.INFORMATION_MESSAGE, pantryArea);
        } else
            JOptionPane.showMessageDialog(null, "You didn't entered a valid choice", "The End", JOptionPane.INFORMATION_MESSAGE, pantryArea);
    }

    public static void stairsArea(){
        ImageIcon secondFloor = new ImageIcon("SecondFloor.jpg");
        JOptionPane.showMessageDialog(null, MainGate.name + ", You are on the second floor of the haunted House", "Map", JOptionPane.INFORMATION_MESSAGE, secondFloor);
        String secondFloorScene = JOptionPane.showInputDialog("You can either explore the Master's Bedroom or bedroom 1 or bedroom 2", "Master's Bedroom/Bedroom 1/Bedroom 2");
        if (secondFloorScene.equalsIgnoreCase("Master Bedroom")){
            masterBedroom();
        }else if (secondFloorScene.equalsIgnoreCase("Bedroom 1")){
            bedroom1();
        }else if (secondFloorScene.equalsIgnoreCase("Bedroom2")){
            bathroom2("bedroom 1");
        }
    }
    public static void masterBedroom(){
          ImageIcon masterBed = new ImageIcon("MasterBed.jpg");
          JOptionPane.showMessageDialog(null, MainGate.name + ", You are in the Master's Bedroom", "Map", JOptionPane.INFORMATION_MESSAGE, masterBed);
          String masterBedScene = JOptionPane.showInputDialog("You can now either look into the expensive jewelry box or explore the master's Bathroom. Enter your choice: ", "Jewelry Box/Master Bathroom");
          if (masterBedScene.equalsIgnoreCase("Jewelry Box")){
              JOptionPane.showMessageDialog(null, "You find the cursed hope diamond and feel your Doom", "The End", JOptionPane.INFORMATION_MESSAGE, masterBed);
          }else if (masterBedScene.equalsIgnoreCase("Master Bathroom")){
              masterBath();
          }else
              JOptionPane.showMessageDialog(null, "You didn't entered a valid choice", "The End", JOptionPane.INFORMATION_MESSAGE, masterBed);
    }
    public static void masterBath(){
          ImageIcon masterBath = new ImageIcon("MasterBath.jpg");
          JOptionPane.showMessageDialog(null, MainGate.name + ", You are in the master bathroom", "Map", JOptionPane.INFORMATION_MESSAGE, masterBath);
          String bathroomScene = JOptionPane.showInputDialog("You can now look into the intricate Oil lamps or explore the Shower. Enter your choice: ", "Intricate Oil Lamp/Shower");
          if (bathroomScene.equalsIgnoreCase("Intricate Oil Lamp")){
              JOptionPane.showMessageDialog(null, "Rub the lamp and a genie pops out who says he'll grant you 3 wishes", "The End", JOptionPane.INFORMATION_MESSAGE, masterBath);
          }else if (bathroomScene.equalsIgnoreCase("Shower")){
              JOptionPane.showMessageDialog(null, "Suddenly hearing, singing in the shower, but no one is there", "The End", JOptionPane.INFORMATION_MESSAGE, masterBath);
          }else
              JOptionPane.showMessageDialog(null, "You didn't entered a valid choice", "The End", JOptionPane.INFORMATION_MESSAGE, masterBath);
    }
    public static void bedroom1(){
          ImageIcon bedroom1 = new ImageIcon("Bedroom1.jpg");
          JOptionPane.showMessageDialog(null, MainGate.name + ", You are in Bedroom 1", "Map", JOptionPane.INFORMATION_MESSAGE, bedroom1);
          String bedroomScene = JOptionPane.showInputDialog("You can now either explore the Rocking Chair or look out side the Window explore the Bathroom. Enter your choice: ", "Rocking Chair/Window/Bathroom");
          if (bedroomScene.equalsIgnoreCase("Rocking Chair")){
              JOptionPane.showMessageDialog(null, "Chair starts rocking by itself having no one in it", "The End", JOptionPane.INFORMATION_MESSAGE, bedroom1);
          }else if (bedroomScene.equalsIgnoreCase("Window")){
              JOptionPane.showMessageDialog(null, "You watching a child outside on a swing who suddenly disappears", "The End", JOptionPane.INFORMATION_MESSAGE, bedroom1);
          }else if (bedroomScene.equalsIgnoreCase("Bathroom")){
              bathroom2("Bedroom 2");
          }else
              JOptionPane.showMessageDialog(null, "You didn't entered a valid choice", "The End", JOptionPane.INFORMATION_MESSAGE, bedroom1);

    }
    public static void bedroom2(){
          ImageIcon bedroom2 = new ImageIcon("Bedroom2.jpg");
              JOptionPane.showMessageDialog(null, MainGate.name + ", You are in Bedroom 2", "Map", JOptionPane.INFORMATION_MESSAGE, bedroom2);
              String bedroomScene = JOptionPane.showInputDialog("You can now either explore the doll house or the Dresser or explore the Bathroom. enter your choice", "Doll House/Dresser/Bathroom");
              if (bedroomScene.equalsIgnoreCase("Doll House")){
                  JOptionPane.showMessageDialog(null,"The Dolls start dancing their own", "The End", JOptionPane.INFORMATION_MESSAGE, bedroom2);
              }else if (bedroomScene.equalsIgnoreCase("Dresser")){
                  JOptionPane.showMessageDialog(null, "A Ghost flies out of the dresser as soon as you open it and goes right through your body", "The End", JOptionPane.INFORMATION_MESSAGE, bedroom2);
              }else if (bedroomScene.equalsIgnoreCase("Bathroom")){
                  bathroom2("Bedroom 1");
              }else
                  JOptionPane.showMessageDialog(null, "You didn't entered a valid choice", "The End", JOptionPane.INFORMATION_MESSAGE, bedroom2);

    }
    public static void bathroom2(String bedroom){
        ImageIcon bathroom = new ImageIcon("Bathroom2.jpg");
        JOptionPane.showMessageDialog(null, MainGate.name + ", You are in the Bathroom", "Map", JOptionPane.INFORMATION_MESSAGE, bathroom);
        String bathroomScene = JOptionPane.showInputDialog("You can now either look into the Mirror or explore the Shower or go to the "+bedroom+". Enter your choice:", "Mirror/Shower/" +bedroom);
        if (bathroomScene.equalsIgnoreCase("Mirror")){
            JOptionPane.showMessageDialog(null, "You watch a clumsy bloody face looking back at you", "The End", JOptionPane.INFORMATION_MESSAGE, bathroom);
        }else if (bathroomScene.equalsIgnoreCase("Shower")){
            JOptionPane.showMessageDialog(null, "Room suddenly steams up and you feels, some fingers touching upon the back of your neck", "The End", JOptionPane.INFORMATION_MESSAGE, bathroom);
        }else if (bedroom.equals("Bedroom 1") && bathroomScene.equals(bedroom)){
            bedroom1();
        }else if (bedroom.equals("Bedroom 2") && bathroomScene.equals(bedroom)){
            bedroom2();
        }else
            JOptionPane.showMessageDialog(null, "You didn't entered a valid choice", "The End", JOptionPane.INFORMATION_MESSAGE, bathroom);
    }

  }

}