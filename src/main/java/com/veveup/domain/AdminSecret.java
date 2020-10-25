package com.veveup.domain;

public class AdminSecret {
    private String id;
    private String secret;
    private Boolean enable;

    @Override
    public String toString() {
        return "AdminSecret{" +
                "id='" + id + '\'' +
                ", secret='" + secret + '\'' +
                ", enable=" + enable +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
