package org.example.controls;

import java.util.TreeSet;

public class PlayList extends Miusic{

    private TreeSet<Miusic> playList = new TreeSet<Miusic>();

    public TreeSet<Miusic> getPlayList() {
        return playList;
    }

    public void setPlayList(TreeSet<Miusic> playList) {
        this.playList = playList;
    }
    void addMiusicToPlayList(String name, String localization){
        playList.add(new Miusic(name, localization));
    }

}
