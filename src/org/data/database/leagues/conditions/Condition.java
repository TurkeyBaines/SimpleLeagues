package org.data.database.leagues.conditions;

public abstract class Condition {

    abstract boolean conditionMet();

    public boolean isMet() {
        return conditionMet();
    }

}
