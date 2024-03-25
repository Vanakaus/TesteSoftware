package com.example.planningpoker;

public class Estimate {
    private String developer;
    public Estimate(String developer, int estimate) {
        this.developer = developer;
        this.estimate = estimate;
    }
    public String getDeveloper() {
        return developer;
    }
    public void setDeveloper(String developer) {
        this.developer = developer;
    }
    private Integer estimate;
    public Integer getEstimate() {
        return estimate;
    }
    public void setEstimate(Integer estimate) {
        this.estimate = estimate;
    }
}
