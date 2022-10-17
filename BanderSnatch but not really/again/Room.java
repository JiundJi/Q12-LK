public class Room extends Etage {
    private String desc;

    public Room(String desc) {
        this.desc = desc;
    }

    public int getLevel() {
        return level;
    }
    public String getDesc() {
        return desc;
    }
}