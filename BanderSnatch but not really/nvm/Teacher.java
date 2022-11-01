package nvm;

public class Teacher {
    Util util = new Util();
    protected int xp = 0;
    private String name = "-1";
    private Room room;

    public Teacher(Room room, String name) {
        this.room = room;
        this.name = name;
    }

    public int getXp(){return xp;}
    public void setXp(int value) {xp += value;}
    public void discuss() {
        util.println("yes?");
        if((int) (Math.random() * 101) < 50) {
            xp += 5;
            util.println("uwu");
        } else {
            xp--;
            util.println("qwq");
        }
    }
    public String getName() {return name;}
}
