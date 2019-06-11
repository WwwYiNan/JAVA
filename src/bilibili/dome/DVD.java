package bilibili.dome;

public class DVD extends Item{
    private String director;

    public DVD(String title, String director, int playingTime, String comment) {
       super(title,playingTime,false,comment);
       // this.title = title;

        this.director = director;

        //this.playingTime = playingTime;
        //this.comment = comment;
    }

    public void print() {
        System.out.print("DVD:");
        super.print();
        System.out.print(director);
    }
}
