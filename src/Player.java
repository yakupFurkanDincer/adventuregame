import java.util.Scanner;

public class Player {
    protected int damage;
    protected int startingHealth;
    public int currentHealth;
    public int currentMoney=100;
    protected String name;
    Scanner sc=new Scanner(System.in);
    protected int id;
    Inventory inventory=new Inventory();

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
        setCurrentHealth(getStartingHealth());
    }
    public int getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(int currentMoney) {
        this.currentMoney = currentMoney;
    }

    public int startingMoney;

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }



    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getStartingHealth() {
        return startingHealth;
    }

    public void setStartingHealth(int startingHealth) {
        this.startingHealth = startingHealth;
    }

    public int getStartingMoney() {
        return startingMoney;
    }

    public void setStartingMoney(int startingMoney) {
        this.startingMoney = startingMoney;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void selectCharacter(int id) {
        this.id=id;
        switch (this.id){
            case 1:
                //name="Samurai";damage=5+inventory.getWeaponDamage(); startingHealth =21+inventory.getArmorDefence(); startingMoney =15; break;
                setName("Samurai");setDamage(5+getInventory().getWeaponDamage()); setStartingHealth(21+getInventory().getArmorDefence()); setCurrentMoney(15);setCurrentHealth(getStartingHealth()); break;
            case 2:
                setName("Archer"); setDamage(7+getInventory().getWeaponDamage()); setStartingHealth(18+getInventory().getArmorDefence());setCurrentMoney(20);setCurrentHealth(getStartingHealth()); break;
                //name="Archer";damage=7+inventory.getWeaponDamage(); startingHealth =18+inventory.getArmorDefence(); startingMoney =20; break;
            case 3:
                setName("Knight");setDamage(8+getInventory().getWeaponDamage() );setStartingHealth(24+inventory.getArmorDefence()); setCurrentMoney(30);setCurrentHealth(getStartingHealth()); break;
                //name="Knight";damage=8+getInventory().getWeaponDamage(); startingHealth =24+inventory.getArmorDefence(); startingMoney =100; break;
            default: new IllegalArgumentException("Incorrect choice");
        }/*
        name="Knight";
        damage=8+getInventory().getWeaponDamage(); startingHealth =24+inventory.getArmorDefence(); startingMoney =100;*/

    }
    public void showCharacters(){
        System.out.println("[ID]  Name   \tFirst Damage\tFirst Health\tStarting Money");
        System.out.println("[1]   Samurai\t5            \t21            \t15");
        System.out.println("[2]   Archer \t7            \t18            \t23");
        System.out.println("[3]   Knight \t8            \t24            \t10");

    }



}
