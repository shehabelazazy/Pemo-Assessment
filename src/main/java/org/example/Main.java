package org.example;


public class Main {
    public static void main(String[] args) {
        String inputString = "of 2 Invoices";

        // Split the string by non-digit characters
        String[] parts = inputString.split("\\D+");
        System.out.println(parts[1]);

        // Iterate through the parts and find the first non-empty and non-whitespace part
        for (String part : parts) {
            if (!part.trim().isEmpty()) {
                String extractedNumber = part;
                System.out.println("Extracted Number: " + extractedNumber);
                break; // Exit the loop after the first non-empty part is found
            }
        }
    }}




