package com.myapplicationdev.android.p04_revisionnotes;

public class Note {
    private int id;
    private String stars;
    private String noteContent;
	//What's here?


    public Note(int id, String stars, String noteContent) {
        this.id = id;
        this.stars = stars;
        this.noteContent = noteContent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }
}
