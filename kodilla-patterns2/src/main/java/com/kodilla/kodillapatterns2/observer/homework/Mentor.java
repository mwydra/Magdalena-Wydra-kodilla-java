package com.kodilla.kodillapatterns2.observer.homework;

public class Mentor implements HomeworkObserver{
    private final String mentorName;
    private int updateCount;

    public Mentor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void update(StudentsTasks studentsTasks) {
        System.out.println(mentorName + ": you have new tasks to check from Module " + studentsTasks.getModule() + "\n" +
                " (total tasks: " + studentsTasks.getTasks().size() + " to check)");
        updateCount++;
    }

    public String getMentorName() {
        return mentorName;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
