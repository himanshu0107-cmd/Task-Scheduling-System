package com.promanage;

import java.util.*;

public class Scheduler {

    public static void generateSchedule(List<Project> projects) {

        int n = projects.size();
        int maxDays = 5;

        int[][] dp = new int[n + 1][maxDays + 1];

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            Project p = projects.get(i - 1);

            for (int d = 1; d <= maxDays; d++) {

                if (p.getDeadline() >= d) {
                    dp[i][d] = Math.max(
                            dp[i - 1][d],
                            p.getRevenue() + dp[i - 1][d - 1]
                    );
                } else {
                    dp[i][d] = dp[i - 1][d];
                }
            }
        }

        System.out.println("\nUsing Dynamic Programming");
        System.out.println("Maximum Revenue Earned: " + dp[n][maxDays]);



        List<Project> selectedProjects = new ArrayList<>();

        int i = n;
        int d = maxDays;

        while (i > 0 && d > 0) {

            if (dp[i][d] != dp[i - 1][d]) {
                Project p = projects.get(i - 1);
                selectedProjects.add(p);
                d = d - 1;
            }

            i--;
        }



        Project[] week = new Project[maxDays];
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        for (Project p : selectedProjects) {

            int lastDay = Math.min(p.getDeadline(), maxDays) - 1;

            for (int j = lastDay; j >= 0; j--) {
                if (week[j] == null) {
                    week[j] = p;
                    break;
                }
            }
        }

        System.out.println("\n Weekly Schedule ");

        for (int k = 0; k < maxDays; k++) {
            if (week[k] != null) {
                System.out.println(days[k] + " -> " +
                        week[k].getTitle() +
                        " (Revenue: " + week[k].getRevenue() + ")");
            } else {
                System.out.println(days[k] + " -> No Project");
            }
        }
    }
}
