package com.mp.piu_mobile_test;

import java.util.ArrayList;

public class Sheet {
    private String level_s;
    //private int[] level_d;
    private String bpm;
    private String title;
    private String artist;
    private String liftingInfo;
    private String album;
    private String profile;

    public String getLevel_s() {
        return level_s;
    }

    public void setLevel_s(String level_s) {
        this.level_s = level_s;
    }

    public String getBpm() {
        return bpm;
    }

    public void setBpm(String bpm) {
        this.bpm = bpm;
    }

//    public void setLevel_d(int[] level_d) {
//        this.level_d = level_d;
//    }
//
//    public int[] getLevel_d() {
//        return level_d;
//    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setLiftingInfo(String liftingInfo) {
        this.liftingInfo = liftingInfo;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }



    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getLiftingInfo() {
        return liftingInfo;
    }

    public String getAlbum() {
        return album;
    }

    public String getProfile() {
        return profile;
    }
}
