public class Stats {
    private String name = "";
    private String level = "eg";
    private int wooziness = 0;
    private int hour = 7;
    private int min = 0;
    private int fatigue = 0;
    private int day = 1;
    private int hp = 100;
    private int stress = 0;
    private int bladder = 0;
    private int philo = 0;
    private int acting = 0;
    private int math = 0;
    private int ger = 0;
    private int eng = 0;
    private int biology = 0;
    private int physics = 0;
    public boolean hasMouse = false;
    public boolean hasGivenTeacher = false;
    public boolean hasReadBook = false;
    public boolean hasToldTeacher = false;
    public boolean hasPattedFox = false;
    public Stats(String name) {name = this.name;}
    public void resetAll() {
        name = "";
        level = "eg";
        wooziness = 0;
        hour = 7;
        min = 0;
        fatigue = 0;
        day = 1;
        hp = 100;
        stress = 0;
        bladder = 0;
        philo = 0;
        acting = 0;
        math = 0;
        ger = 0;
        eng = 0;
        biology = 0;
        physics = 0;
    }
    public void set(String option, int value) {
        switch(option) {
            case "wooziness": wooziness = value;
            case "hour": hour = value;
            case "min": min = value;
            case "fatigue": fatigue = value;
            case "day": day = value; 
            case "hp": hp = value;
            case "stress": stress = value; 
            case "bladder": bladder = value;
            case "philo": philo = value;
            case "acting": acting = value;
            case "math": math = value;
            case "ger": ger = value;
            case "eng": eng = value;
            case "biology": biology = value;
            case "physics":physics = value;
        }
    }
    
    public String getName() {return name;}
    public String getLevel() {return level;}
    public int getWooziness() {return wooziness;}
    public int getHour() {return hour;}
    public int getMin() {return min;}
    public int getFatigue() {return fatigue;}
    public int getDay() {return day;}
    public int getHp() {return hp;}
    public int getStress() {return stress;}
    public int getBladder() {return bladder;}
    public int getPhilo() {return philo;}
    public int getActing() {return acting;}
    public int getMath() {return math;}
    public int getGer() {return ger;}
    public int getEng() {return eng;}
    public int getBiology() {return biology;}
    public int getPhysics() {return physics;}

    public void setLevel    (String newValue) {level = newValue;}
    public void addWooziness(int newValue) {wooziness += newValue;}
    public void addHour     (int newValue) {hour += newValue;}
    public void addMin      (int newValue) {min += newValue;}
    public void addFatigue  (int newValue) {fatigue += newValue;}
    public void addDay      (int newValue) {day += newValue;}
    public void addHp       (int newValue) {hp += newValue;}
    public void addStress   (int newValue) {stress += newValue;}
    public void addBladder  (int newValue) {bladder += newValue;}
    public void addPhilo    (int newValue) {philo += newValue;}
    public void addActing   (int newValue) {acting += newValue;}
    public void addMath     (int newValue) {math += newValue;}
    public void addGer      (int newValue) {ger += newValue;}
    public void addEng      (int newValue) {eng += newValue;}
    public void addBiology  (int newValue) {biology += newValue;}
    public void addPhysics  (int newValue) {physics += newValue;}
}