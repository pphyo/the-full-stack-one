package tech.codoverse;

public class Player {

    private String name;
    private int no;
    private double wage;

    public Player() {
        IO.println("no arg.");
    }

    public Player(String name, double wage) {
        IO.println("two args.");
    }

    public Player(String name, int no, double wage) {
        IO.println("three args.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    public Player clone() {
        return new Player();
    }

}
