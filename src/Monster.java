import java.util.Random;
import java.lang.Math;

public class Monster {
    private int id,damage,health,award;
    private String name;

    public int monsterNumber(){
        Random rnd=new Random();
        int donen=(int)(Math.random()*10);
        return donen;
        //return rnd.nextInt(3)+1;
    }
    public  Monster() {}
    public Monster(int id, int damage, int health, int award, String name) {
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.award = award;
        this.name = name;
    }
    public void reduceHealth(int hit){
        this.health-=hit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
