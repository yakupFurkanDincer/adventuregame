import java.util.Locale;
import java.util.Scanner;

public abstract class BattleLocation extends Location {
    Monster mns = new Monster();

    private String name;

    public BattleLocation(Player player, String name,Monster mns) {
        super(player);
        this.name = name;
        this.mns=mns;
    }int monsterNumber=mns.monsterNumber();


    Scanner scanner = new Scanner(System.in);
    boolean isAlive = true;
    int totalHealth = 0;


    @Override
    public boolean onLocation() {
        System.out.println("You are in " + this.name + "and  " + monsterNumber + " monster live here.");
        /*System.out.println("Press K to run away or press any other key to fight.");
        String chocie = scanner.next().toUpperCase(Locale.ROOT);*/

        if (0>1) return false;
        else {
            if (combat()){
                if (this.name.equals("Cave")) player.getInventory().setFood(true);
                else if (this.name.equals("Forest")) player.getInventory().setLog(true);
                else if (this.name.equals("River")) player.getInventory().setWater(true);
            }
        }
        if (player.getCurrentHealth() <= 0) {
            isAlive = false;
            return isAlive;
        }
        return true;
    }

    public boolean combat() {
        Monster[] dizi = new Monster[monsterNumber];
        for (int i = 0; i < monsterNumber; i++) {
            //dizi[i] = new Monster();   /*    devam et */
            switch (name){
                case "Cave":
                    dizi[i] = new Zombie(); break;
                case "Forest":
                    dizi[i] = new Vampire(); break;
                case "River":
                    dizi[i] = new Bear(); break;
                default: dizi[i] = new Monster();
            }
           // System.out.println(dizi[i].getDamage());
        }

        for (int i = 0; i < monsterNumber; i++) {
                for (Monster gecici :
                    dizi) {
                totalHealth += gecici.getHealth();
                }
                int monsterFirstHealth=dizi[i].getHealth();
                System.out.println("Your health      : "+player.getCurrentHealth());
                System.out.println("Remaining monster: "+(dizi.length-i));
                System.out.println("Press K to run away or press any other key to fight.");
                String chocie = scanner.next().toUpperCase(Locale.ROOT);
                if (chocie.equals("K"))  break;
                while (player.getCurrentHealth() > 0 && dizi[i].getHealth() > 0) {
                    int fortune = (int) Math.random() * 10;
                    if (fortune > 5) {
                        System.out.println("You've been hit");
                        //System.out.println(player.getCurrentHealth());
                        player.setCurrentHealth(player.getCurrentHealth() - dizi[i].getDamage());
                        //System.out.println(player.getCurrentHealth()+" "+dizi[i].getHealth());
                        if (player.getCurrentHealth()<=0) {
                            System.out.println("You died...");
                            break;
                        }
                        if (player.getCurrentHealth() > 0){
                            //System.out.println("You've hit monster.");
                            dizi[i].setHealth(dizi[i].getHealth() - player.getDamage());
                            System.out.println(player.getCurrentHealth()+" "+dizi[i].getHealth()); }

                    } else {
                        System.out.println(player.getCurrentHealth());
                        System.out.println("You've hit monster.");
                        dizi[i].setHealth(dizi[i].getHealth() - player.getDamage());
                        //System.out.println(player.getCurrentHealth()+" "+dizi[i].getHealth());
                        if (dizi[i].getHealth() > 0){
                            System.out.println("You've been hit");
                            player.setCurrentHealth(player.getCurrentHealth() - dizi[i].getDamage());
                            //System.out.println(player.getCurrentHealth()+" "+dizi[i].getHealth());
                            if (player.getCurrentHealth()<=0) {
                                System.out.println("You died...");
                                break;
                            }}
                    }
                }
                if(dizi[i].getHealth()<0) { System.out.println("You've killed a monster ");totalHealth-=monsterFirstHealth; }
                if (player.getCurrentHealth() <= 0) {
                    isAlive = false;
                    break;
                }
            }

        if (totalHealth <= 0) {
                System.out.println("You've killed all monsters.");
                player.setCurrentMoney(player.getCurrentMoney() + monsterNumber * mns.getAward());
        }
        return isAlive;

        }

    }
