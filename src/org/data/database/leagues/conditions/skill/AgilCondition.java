package org.data.database.leagues.conditions.skill;

import org.data.database.leagues.conditions.SkillCondition;

public class AgilCondition extends SkillCondition {

    int skillID, levelReq;
    public AgilCondition(int levelReq) {
        this.skillID = 16;
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
