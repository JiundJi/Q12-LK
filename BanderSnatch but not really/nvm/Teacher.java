package nvm;

public class Teacher {
    protected int xp = 0;
    protected String name = "-1";
    protected Room room;

    public Teacher(Room room, String name) {
        this.room = room;
        this.name = name;
    }
    public Teacher() {

    }

    public int getXp(){return xp;}
    public void setXp(int value) {xp += value;}
    public String getName() {return name;}
}