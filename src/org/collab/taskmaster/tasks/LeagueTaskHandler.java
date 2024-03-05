package org.collab.taskmaster.tasks;

import simple.robot.api.ClientContext;

public abstract class LeagueTaskHandler {
    public ClientContext c = ClientContext.instance();
    public abstract void runLeagueTask();
}
