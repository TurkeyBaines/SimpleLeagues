package org.collab.taskmaster;

import org.collab.taskmaster.tasks.LeagueTaskHandler;
import org.collab.taskmaster.tasks.easy.n00;
import org.data.database.leagues.Leagues;
import simple.hooks.scripts.Category;
import simple.hooks.scripts.ScriptManifest;
import simple.hooks.simplebot.ChatMessage;
import simple.robot.script.Script;

import java.awt.*;
import java.util.HashMap;

@ScriptManifest(description = "to be continued...", version = "1", discord = "", name = "SimpleLeagues", servers = {"Vulcan"}, author = "The Script Writers", category = Category.OTHER)
public class SimpleLeagues extends Script {

    private Leagues leagues;

    @Override
    public void onExecute() {
        HashMap<Integer, LeagueTaskHandler> handlers = new HashMap<>();
        handlers.put(0, new n00()); //This is my handler class for the first task, opening the task interface!

        leagues = new Leagues(handlers);
    }

    @Override
    public void onTerminate() {
        leagues = null;
    }

    @Override
    public void onProcess() {

    }

    @Override
    public void onChatMessage(ChatMessage chatMessage) {

    }

    @Override
    public void paint(Graphics graphics) {

    }
}
