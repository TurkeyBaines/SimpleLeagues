package org.data.database.leagues;

import org.collab.taskmaster.tasks.LeagueTaskHandler;
import org.data.database.leagues.conditions.Condition;

import java.util.ArrayList;

public class LeagueTask {
    int id;
    String name, type, area, description, reward;
    Difficulty difficulty;
    LeagueTaskHandler handler;
    ArrayList<Condition> conditions;

    public LeagueTask(int id, String name, String difficulty, String type, String area, String description, String reward, LeagueTaskHandler handler, Condition... conditions) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.area = area;
        this.description = description;
        this.reward = reward;
        this.handler = handler;
        switch (difficulty) {
            case "Easy": this.difficulty = Difficulty.EASY; break;
            case "Medium": this.difficulty = Difficulty.MEDIUM; break;
            case "Hard": this.difficulty = Difficulty.HARD; break;
            case "Elite": this.difficulty = Difficulty.ELITE; break;
            case "Master": this.difficulty = Difficulty.MASTER; break;
        }
        this.conditions = new ArrayList<>();
        for (Condition c : conditions) { this.conditions.add(c); }
        System.out.println("<" + difficulty.toString() + "> Successfully added a League Task! " + this.id);
    }

    enum Difficulty {
        EASY,
        MEDIUM,
        HARD,
        ELITE,
        MASTER
    }
}
