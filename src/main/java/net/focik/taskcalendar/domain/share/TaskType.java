package net.focik.taskcalendar.domain.share;

public enum TaskType {
    GAS_MAIN("gazociag"),
    GAS_CONNECTION("przylacze"),
    GAS_INNER("wewnetrzna"),
    OTHER("inne");

    private String dbValue;

    TaskType(String dbValue) {
        this.dbValue = dbValue;
    }


    public String getDbValue() {
        return dbValue;
    }

    public void setDbValue(String dbValue) {
        this.dbValue = dbValue;
    }

    public static TaskType fromDbValue(String dbValue){
        switch (dbValue){
            case "gazociag":
                return TaskType.GAS_MAIN;
            case "przylacze":
                return TaskType.GAS_CONNECTION;
            case "wewnetrzna":
                return TaskType.GAS_INNER;
            case "inne":
                return TaskType.OTHER;
            default:
                throw new IllegalArgumentException("Value [" + dbValue
                        + "] not supported.");
        }
    }
}
