package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> forumUsers = new ArrayList<>();

    public Forum() {
        forumUsers.add(new ForumUser(1, "aadamski", 'M', LocalDate.of(1965, 1, 1), 0));
        forumUsers.add(new ForumUser(2, "aadamska", 'K', LocalDate.of(1970, 2, 2), 5));
        forumUsers.add(new ForumUser(3, "bbartoszewski", 'M', LocalDate.of(1975, 3, 3), 10));
        forumUsers.add(new ForumUser(4, "bbartoszewska", 'K', LocalDate.of(1980, 4, 4), 15));
        forumUsers.add(new ForumUser(5, "ffilipowski", 'M', LocalDate.of(1985, 5, 5), 20));
        forumUsers.add(new ForumUser(6, "ffilipowska", 'K', LocalDate.of(1990, 6, 6), 25));
        forumUsers.add(new ForumUser(7, "jjankowski", 'M', LocalDate.of(1995, 7, 7), 30));
        forumUsers.add(new ForumUser(8, "jjankowska", 'K', LocalDate.of(2000, 8, 8), 35));
        forumUsers.add(new ForumUser(9, "llechowski", 'M', LocalDate.of(2005, 9, 9), 40));
        forumUsers.add(new ForumUser(10, "llechowska", 'K', LocalDate.of(2010, 10, 10), 45));
    }


    public List<ForumUser> getUserList(){
        return new ArrayList<>(forumUsers);
    }
}
