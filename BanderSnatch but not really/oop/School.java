package oop;

public class School extends Player{
    public Stairs stairs = new Stairs();

    //! ETAGE 0
    private Room vorhof;
    private Room deutsch;
    private Room ethik;
    private Library library;
    private Room etageE;
    
    //! ETAGE 1 (O)
    private Room bio;
    private Room physik;
    private Room chemie;
    private Room etageO;

    //! ETAGE -1 (U)
    private Room kunst;
    private Room musik;
    private Room dsp;
    private Room etageU = new Room();


}
