package com.example.mygmail.models;


public class EmailModel {
    private String name;
    private String text_letter;
    private String text_subject;
    private String text_content;
    private String text_time;
    private boolean favorite;

    public EmailModel(String name, String text_subject, String text_content, String text_time) {
        this.name = name;
        this.text_subject = text_subject;
        this.text_content = text_content;
        this.text_time = text_time;
        this.text_letter = name.charAt(0) + "";
        this.favorite = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText_subject() {
        return text_subject;
    }

    public void setText_subject(String text_subject) {
        this.text_subject = text_subject;
    }

    public String getText_content() {
        return text_content;
    }

    public void setText_content(String text_content) {
        this.text_content = text_content;
    }

    public String getText_time() {
        return text_time;
    }

    public void setText_time(String text_time) {
        this.text_time = text_time;
    }


    public boolean is_favorite() {
        return favorite;
    }

    public void set_favorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getLetter() {
        return text_letter;
    }
    public boolean searchItem(String textToSearch){
        if(name.contains(textToSearch))
            return true;
        else if(text_content.contains(textToSearch))
            return true;
        else if(text_subject.contains(textToSearch))
            return true;
        else if(text_time.contains(textToSearch))
            return true;
        else return false;
    }
    public boolean searchItemFavorite(String textToSearch){
        if(favorite == false)
            return false;
        else {
            if(name.contains(textToSearch))
                return true;
            else if(text_content.contains(textToSearch))
                return true;
            else if(text_subject.contains(textToSearch))
                return true;
            else if(text_time.contains(textToSearch))
                return true;
            else return false;
        }
    }
}
