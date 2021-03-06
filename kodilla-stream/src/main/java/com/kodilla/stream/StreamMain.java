package com.kodilla.stream;

import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {

        Forum theForum = new Forum();
        Map<Integer, ForumUser> resultMap = theForum.getUserList().stream()
                .filter(sex -> sex.getSex() == 'M')
                .filter(birthDetails -> Period.between(birthDetails.getBirthDetails(), LocalDate.now()).getYears() >= 20)
                .filter(numberOfPosts -> numberOfPosts.getNumberOfPosts() > 0)
                .collect(Collectors.toMap(ForumUser::getUserID, forumUser -> forumUser));

        System.out.println("# elements: " + resultMap.size());
        resultMap.entrySet().stream()
                .map(entry -> entry.getKey() + " " + entry.getValue())
                .forEach(System.out::println);
    }
}