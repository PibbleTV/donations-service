package com.pibbletv.donations_service.business;

public class InputSanitizer {

    public static String sanitizeSearchTerm(String input) {
        if (input == null || input.length() > 100 || !input.matches("[a-zA-Z0-9\\s\\-]{1,50}")) {
            throw new IllegalArgumentException("Invalid input");
        }
        return input.trim();
    }
}