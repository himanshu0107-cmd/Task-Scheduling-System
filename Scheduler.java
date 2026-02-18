package com.promanage;

import java.util.List;

public class Scheduler {

    public static void generateSchedule(List<Project> projects) {

        int n = projects.size();
        int maxDays = 5;

        
        int[][] dp = new int[n + 1][maxDays + 1];

        
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

        System.out.println("\n Using Dynamic Programming ");
        System.out.println("Maximum Revenue Earned: " + dp[n][maxDays]);
    }
}
