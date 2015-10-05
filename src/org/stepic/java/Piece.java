package org.stepic.java;

public class Piece {
    private static String[] roles = {"Городничий", "Аммос Федорович", "Артемий Филиппович", "Лука Лукич"};
    private static String[] textLines = {
            "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
            "Аммос Федорович: Как ревизор?",
            "Артемий Филиппович: Как ревизор?",
            "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
            "Аммос Федорович: Вот те на!",
            "Артемий Филиппович: Вот не было заботы, так подай!",
            "Лука Лукич: Господи боже! еще и с секретным предписаньем!"
    };

    private static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder[] textByRoles = new StringBuilder[roles.length];
        for (int i = 0; i < roles.length; i++) {
            textByRoles[i] = new StringBuilder(roles[i] + ":");
        }

        for (int i = 0; i < textLines.length; i++) {
            String[] splitLine = textLines[i].split(": ", 2);
            String role = splitLine[0];
            String text = splitLine[1];

            int j = 0;
            while (!roles[j].equals(role)) {
                j++;
            }
            textByRoles[j].append("\n" + (i + 1) + ") " + text);
        }

        String result = "";
        for (StringBuilder line : textByRoles) {
            result += line + "\n\n";
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(printTextPerRole(roles, textLines));
    }
}
