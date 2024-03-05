package org.data.database.leagues.conditions.skill;

import org.data.database.leagues.conditions.SkillCondition;

public class WcCondition extends SkillCondition {

    int skillID, levelReq;
    public WcCondition(int levelReq) {
        this.skillID = 8;
        this.levelReq = levelReq;
    }

    @Override
    public int skill() {
        return skillID;
    }

    @Override
    public int level() {
        return levelReq;
    }
}
