package org.example.models;

public class ModelAttendance {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ModelAttendance(int id, int classId, int userId) {
        this.id = id;
        this.classId = classId;
        this.userId = userId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private int id;
private int classId;
private int userId;

}
