package nvm;

public class School {
    Teacher[] teacherList = new Teacher[10];
    Room[] roomList = new Room[6];
    
    
    public School() {
        roomList[0] = new Room("entrance");
        roomList[1] = new Room("hallway");
        roomList[2] = new Room("csgo");
        roomList[3] = new Room("math");
        roomList[4] = new Room("ger");
        roomList[5] = new Room("mensa");
        teacherList[0] = new GerTeacher(roomList[0], "Frau Hanno");
        teacherList[1] = new MathTeacher(roomList[0], "Frau Beyer");
    }
    

}