package com.learningspringboot.finsmart.dto;

public class RegexRules {
    public static String AT_LEAST_ONE_LETTER = ".*[a-zA-Z].*";
    public static String AT_LEAST_ONE_UPPERCASE = ".*[A-Z].*";
    public static String AT_LEAST_ONE_LOWERCASE = ".*[a-z].*";
    public static String AT_LEAST_ONE_NUMBER = ".*[0-9].*";
    public static String AT_LEAST_SPECIAL_CHARACTERS = ".*[^a-zA-Z0-9].*";
}
