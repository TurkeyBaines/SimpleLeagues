package org.collab.taskmaster.tasks.easy;

import org.collab.taskmaster.tasks.LeagueTaskHandler;

public class n00 extends LeagueTaskHandler {
    @Override
    public void runLeagueTask() {
        c.menuActions.sendAction(57, -1, 35913793, 1, "Character Summary", "");
        c.sleep(50);
        c.menuActions.sendAction(57, -1, 41222167, 1, "Character Summary", "");
        c.sleep(50);
        c.menuActions.sendAction(57, -1, 48234521, 1, "Character Summary", "");
        c.sleep(2000);

    }
}
