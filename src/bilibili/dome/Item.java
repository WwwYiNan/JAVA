package bilibili.dome;

public class Item {
    private String title;
    private int playingTime;
    private boolean gotIt = false;
    private String comment;



    public Item() {
    }

    public Item(String title, int playingTime, boolean gotIt, String comment) {
        this.title = title;
        this.playingTime = playingTime;
        this.gotIt = gotIt;
        this.comment = comment;
    }

    public void print() {
        System.out.println(title);
    }
}
