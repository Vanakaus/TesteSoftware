package com.example;

import java.util.List;

import com.example.planningpoker.Estimate;
import com.example.planningpoker.PlanningPoker;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Estimate> estimates = List.of(
            new Estimate("Alice", 5),
            new Estimate("Bob", 3),
            new Estimate("Charlie", 8)
        );

        PlanningPoker planningPoker = new PlanningPoker();
        List<String> extremes = planningPoker.identifyExtremes(estimates);

        System.out.println("Lowest estimate: " + extremes.get(0));
        System.out.println("Highest estimate: " + extremes.get(1));
    }
}