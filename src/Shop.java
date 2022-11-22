import java.util.Scanner;

public class Shop extends NormaLocation {
    public Shop(Player player) {
        super(player, "Shop");
    }

    @Override
    public boolean onLocation() {
        return true;
    }
    {
        onLocation();
        menu();
    }
    public void menu(){
        System.out.print("Welcome to the Shop\n");
        System.out.print("Weapons:\nID:\tName:\tDamage:\tCost:\n");
        System.out.print(
                "1  \tGun  \t2      \t25\n" +
                "2  \tKnife\t3      \t35\n" +
                "3  \tRifle\t7      \t45\n");
        System.out.print("Armors:\nID:\tName:\tDefence:\tCost:\n");
        System.out.print(
                        "1  \tLight \t1      \t15\n" +
                        "2  \tMiddle\t3      \t25\n" +
                        "3  \tHeavy \t5      \t40\n");
        System.out.println("You have: "+player.getCurrentMoney()+" coins.");
        buy();
    }
    public void buy(){
        Scanner sc=new Scanner(System.in);
        System.out.println("What do you want to purchase? (A/W)");
        String choice=sc.next();
        switch (choice){
            case "A":
                System.out.print("Armors:\nID:\tName:\tDefence:\tCost:\n");
                System.out.print(
                        "1  \tLight \t1      \t15\n" +
                                "2  \tMiddle\t3      \t25\n" +
                                "3  \tHeavy \t5      \t40\n");
                System.out.println("You have: "+player.getCurrentMoney()+" coins.");
                System.out.println("What do you want to purchase? Insert ID of armor you want to buy:");
                int choice2=sc.nextInt();
                switch (choice2){
                    case 1:
                        if (player.currentMoney>=15){
                            player.inventory.setArmorName("Light"); player.inventory.setArmorDefence(1);
                            player.currentMoney-=15; break;
                        }
                        else System.out.println("You don't have enough money to buy this product."); break;
                    case 2:
                        if (player.currentMoney>=25){
                            player.inventory.setArmorName("Middle"); player.inventory.setArmorDefence(3);
                            player.currentMoney-=25; break;
                        }
                        else System.out.println("You don't have enough money to buy this product."); break;
                    case 3:
                        if (player.currentMoney>=40){
                            player.inventory.setArmorName("Heavy"); player.inventory.setArmorDefence(5);
                            player.currentMoney-=15;
                            System.out.println(player.getCurrentMoney()+player.inventory.getArmorName()+player.inventory.getArmorDefence());
                            break;
                        }
                        else System.out.println("You don't have enough money to buy this product."); break;
                    default: break;
                    }
                    break;


            case "W":
                System.out.print("Weapons:\nID:\tName:\tDamage:\tCost:\n");
                System.out.print(
                                "1  \tGun  \t2      \t25\n" +
                                "2  \tKnife\t3      \t35\n" +
                                "3  \tRifle\t7      \t45\n");
                int choice3=sc.nextInt();
                switch (choice3){
                    case 1:
                        if (player.currentMoney>=25){
                            player.inventory.setWeaponName("Gun"); player.inventory.setWeaponDamage(2);
                            player.currentMoney-=25;
                        }
                        else System.out.println("You don't have enough money to buy this product."); break;
                    case 2:
                        if (player.currentMoney>=35){
                            player.inventory.setWeaponName("Knife"); player.inventory.setWeaponDamage(3);
                            player.currentMoney-=35;
                        }
                        else System.out.println("You don't have enough money to buy this product."); break;
                    case 3:
                        if (player.currentMoney>=45){
                            player.inventory.setWeaponName("Riffle"); player.inventory.setWeaponDamage(7);
                            player.currentMoney-=45;
                        }
                        else System.out.println("You don't have enough money to buy this product."); break;
                    default: break;
                }
                break;

            default: break;

        }
    }
}
