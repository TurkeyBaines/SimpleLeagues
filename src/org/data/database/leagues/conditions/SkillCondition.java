package org.data.database.leagues.conditions;

import org.data.tracker.XPTracker;
import simple.hooks.filters.SimpleSkills;
import simple.robot.api.ClientContext;

public abstract class SkillCondition extends Condition {

    public abstract int skill();
    public abstract int level();

    @Override
    boolean conditionMet() {
        return ClientContext.instance().skills.level(skill()) >= level();
    }

}
