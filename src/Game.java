import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner scan = new Scanner(System.in);

    public void login() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Adventure Game. In order to win this game, you need to collect 3 different pieces(Food,Water,Log) that are being protected in 3 different places(Cave,Forest,River). ");
        System.out.print("Please type your name: ");
        String playerName = scan.nextLine();
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        player = new Player(playerName);
        player.showCharacters();
        System.out.print("Please type Character ID you want to play with: ");
        int secim=scan.nextInt();
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ");
        player.selectCharacter(secim);
        System.out.println(player.getCurrentHealth());
        start();
    }

    public void start() {
        while (1>0) {
            System.out.println();
            System.out.println("=================================================");
            System.out.println();
            System.out.println("Where do you want to go?");
            System.out.println("1. Safe House --> A safe place to refill your health");
            System.out.println("2. Cave       --> A place that you can get some food but be carefully there might be some zombies. ");
            System.out.println("3. Forest     --> A place that you can get some log but be carefully there might be some vampires");
            System.out.println("4. River      --> A place that you can get some water but be carefully there might be some bears");
            System.out.println("5. Shop       --> A safe place that you can purchase armors or weapons");
            System.out.println("Now, where do you want to go?");
            int selLoc = scan.nextInt();
            while (selLoc < 0 || selLoc > 5) {
                System.out.print("Please choose an appropriate destination ID");
                selLoc = scan.nextInt();
            }

            switch (selLoc) {
                case 1:
                    location = new SafeHouse(this.player);
                    break;
                case 2:
                    location = new Cave(player);
                    break;
                case 3:
                    location = new Forest(player);
                    break;
                case 4:
                    location = new River(player);
                    break;
                case 5:
                     location = new Shop(player);

                    break;
                default:
                     location = new SafeHouse(player);
            }

            if (location.getClass().getName().equals("SafeHouse")) {
                if (player.getInventory().isLog() && player.getInventory().isFood() && player.getInventory().isWater()) {
                    System.out.println("Tebrikler Oyunu Kazandýnýz !");
                    break;
                }
            }
            if (!location.onLocation()) {
                System.out.println("Oyun Bitti !");
                break;
            }

        }
    }
}
