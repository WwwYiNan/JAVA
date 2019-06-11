package bilibili.dome;

public class CD extends Item {
    private String artist;

    private int numofTracks;

    public CD(String title, String artist, int numofTracks, int playingTime, String comment) {
        super(title,playingTime,false,comment);
        //this.title = title;

        this.artist = artist;
        this.numofTracks = numofTracks;

       // this.playingTime = playingTime;
        //this.comment = comment;

    }

    public static void main(String[] args) {
        CD cd = new CD("a","aaa",40,20,"...");
        cd.print();
    }
   /* public void print() {
        System.out.println("CD:"+title+":"+artist);
    }*/
}
