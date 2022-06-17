package com.model;

public class Email {
    private String languages;
    private String page;
    private boolean enableSpam;
    private String signature;

    public Email() {
    }

    public Email(String languages, String page, boolean enableSpam, String signature) {
        this.languages = languages;
        this.page = page;
        this.enableSpam = enableSpam;
        this.signature = signature;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public boolean isEnableSpam() {
        return enableSpam;
    }

    public void setEnableSpam(boolean enableSpam) {
        this.enableSpam = enableSpam;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
