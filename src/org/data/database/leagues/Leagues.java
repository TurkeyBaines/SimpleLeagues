package org.data.database.leagues;

import org.collab.taskmaster.tasks.LeagueTaskHandler;
import org.data.database.leagues.conditions.Condition;
import org.data.database.leagues.conditions.skill.AgilCondition;
import org.data.database.leagues.conditions.skill.WcCondition;
import simple.robot.api.ClientContext;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Leagues {

    private static ClientContext c = ClientContext.instance();

    private ArrayList<LeagueTask> leagueTasks;
    private HashMap<Integer, LeagueTaskHandler> handlerHashMap;

    public Leagues(HashMap<Integer, LeagueTaskHandler> handlers) {
        leagueTasks = new ArrayList<>();
        loadTasks(handlers);
    }

    private void loadTasks(HashMap<Integer, LeagueTaskHandler> handlers) {
        handlerHashMap = handlers;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("sample.txt"));
            String line;
            int id = 0;
            String name = null, difficulty = null, type = null, area = null, description = null, reward = null;
            LeagueTaskHandler lth;
            try {
                 lth = handlerHashMap.get(id);
            } catch (Exception e) {
                lth = null;
            }
            ArrayList<Condition> conditions = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                if (line.equals("{")) {
                    id = -1;
                    name = null;
                    difficulty = null;
                    type = null;
                    area = null;
                    description = null;
                    reward = null;
                    conditions = null;
                } else if (line.contains("ID=")) {
                    id = Integer.parseInt(line.split("=")[1]);

                } else if (line.contains("Name=")) {
                    name = line.split("=")[1];

                } else if (line.contains("Type=")) {
                    type = line.split(": ")[1];

                } else if (line.contains("Area=")) {
                    area = line.split(": ")[1];

                } else if (line.contains("Desc=")) {
                    description = line.split(": ")[1];

                } else if (line.contains("Reward=")) {
                    reward = line.split("=")[1];

                } else if (line.contains("CONDITIONS")) {
                    conditions = new ArrayList<>();

                } else if (line.contains("[SKILL]")) {
                    int lvl = Integer.parseInt(line.split("]")[2].replace("\t", ""));

                    if (line.contains("[WOODCUTTING]")) {
                        conditions.add(new WcCondition(lvl));

                    } else if (line.contains("[AGILITY]")) {
                        conditions.add(new AgilCondition(lvl));
                    }
                } else if (line.contains("}")) {
                    leagueTasks.add(new LeagueTask(id, name, difficulty, type, area, description, reward, lth, conditions.toArray(new Condition[conditions.size()])));
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Something went wrong loading the tasks...");
        }
    }


    public enum Difficulty {
        EASY,
        MEDIUM,
        HARD,
        ELITE,
        MASTER
    }

}
