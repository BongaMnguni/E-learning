package com.elearning.e_learning.ElitVideo;

/**
 * Created by Payghost on 8/7/2017.
 */

public class ElitVideoItems {

    private String subject;
    private String grade;
    private String phase;
    private String category;

    private String title;
    private String producer;
    private String produced_year;
    private String book_type;
    private String file;

    public ElitVideoItems(){}

    public ElitVideoItems(String subject, String grade, String phase, String category, String title, String producer, String produced_year, String book_type, String file) {
        this.subject = subject;
        this.grade = grade;
        this.phase = phase;
        this.category = category;
        this.title = title;
        this.producer = producer;
        this.produced_year = produced_year;
        this.book_type = book_type;
        this.file = file;
    }

    public ElitVideoItems(String title, String producer, String produced_year,String file) {
        this.title = title;
        this.producer = producer;
        this.produced_year = produced_year;
        this.file = file;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getProduced_year() {
        return produced_year;
    }

    public void setProduced_year(String produced_year) {
        this.produced_year = produced_year;
    }

    public String getBook_type() {
        return book_type;
    }

    public void setBook_type(String book_type) {
        this.book_type = book_type;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
