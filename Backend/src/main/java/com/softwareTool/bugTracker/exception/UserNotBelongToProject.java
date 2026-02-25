package com.softwareTool.bugTracker.exception;

public class UserNotBelongToProject extends RuntimeException {
    public UserNotBelongToProject(String message) {
        super(message);
    }
}
