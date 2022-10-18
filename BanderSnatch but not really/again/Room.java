public class Room {
    private String desc;
    private int level;

    public Room(String desc, int level) {
        this.desc = desc;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
    public String getDesc() {
        return desc;
    }
}