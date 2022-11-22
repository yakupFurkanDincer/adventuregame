public class SafeHouse extends NormaLocation{
    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        player.setCurrentHealth(player.getStartingHealth());
        return true;
    }
    {
        onLocation();
    }
}
