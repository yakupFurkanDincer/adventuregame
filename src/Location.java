public abstract class Location {
    private String name;
    public Player player;

    public Location(Player player) {
        this.player = player;
    }
    public abstract boolean onLocation();
}
