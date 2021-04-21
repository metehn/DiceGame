package metehanersoy.dicegame;

public class Player {
    int score=0;
    int number=0;
    boolean count= true;

    public Player() {

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isCount() {
        return count;
    }

    public void setCount(boolean count) {
        this.count = count;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
