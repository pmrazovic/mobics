package se.kth.mrazovic.mobics.model;

import java.util.Date;

/**
 * Created by Petar Mrazovic on 15.06.15..
 */
public class HumanTask {
    private int taskId;
    private String question;
    private String createdAt;
    private int numResponses;
    private int numViews;
    private int userId;
    private String userNick;
    private String userPhotoUrl;
    private String categoryId;
    private String[] tags;
    private String[] sensingList;

    public HumanTask(int taskId, String question, String createdAt, int userId, String userNick, int numResponses, int numViews) {
        this.taskId = taskId;
        this.question = question;
        this.createdAt = createdAt;
        this.userId = userId;
        this.userNick = userNick;
        this.numResponses = numResponses;
        this.numViews = numViews;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public int getNumResponses() {
        return numResponses;
    }

    public void setNumResponses(int numResponses) {
        this.numResponses = numResponses;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getNumViews() {
        return numViews;
    }

    public void setNumViews(int numViews) {
        this.numViews = numViews;
    }
}
