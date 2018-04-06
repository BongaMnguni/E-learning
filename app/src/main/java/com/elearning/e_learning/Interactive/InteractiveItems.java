package com.elearning.e_learning.Interactive;

/**
 * Created by Payghost on 8/4/2017.
 */

public class InteractiveItems {

    private String subject;
    private String grade;
    private String phase;
    private String category;
    private String file;

    public InteractiveItems(){}

    public InteractiveItems(String subject, String grade, String phase, String category, String file) {
        this.subject = subject;
        this.grade = grade;
        this.phase = phase;
        this.category = category;
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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
