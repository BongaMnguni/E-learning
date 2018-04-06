package com.elearning.e_learning.ElitDigital;

/**
 * Created by Payghost on 8/8/2017.
 */

public class ElitsDigitalItems {

    private String subject;
    private String grade;
    private String phase;
    private String category;
    private String file;
    private String title;
    private String author;
    private String publisher;
    private String date;
    private String place;
    private String type;

    public ElitsDigitalItems(){}

    public ElitsDigitalItems(String subject, String grade, String phase, String category, String file, String title, String author, String publisher, String date, String place, String type) {
        this.subject = subject;
        this.grade = grade;
        this.phase = phase;
        this.category = category;
        this.file = file;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.date = date;
        this.place = place;
        this.type = type;
    }

    public ElitsDigitalItems(String file, String title, String author, String publisher, String date, String place) {
        this.subject = subject;
        this.grade = grade;
        this.phase = phase;
        this.category = category;
        this.file = file;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.date = date;
        this.place = place;
        this.type = type;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
