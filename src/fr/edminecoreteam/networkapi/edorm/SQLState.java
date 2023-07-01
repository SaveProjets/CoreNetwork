package fr.edminecoreteam.networkapi.edorm;

public enum SQLState
{
    DISCONECTED("DISCONECTED", 0),
    CONECTED("CONECTED", 1);

    private SQLState(String name, int ordinal) {}
}
