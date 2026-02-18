package com.promanage;

import java.util.*;

public class Scheduler {

    public static void generateSchedule(List<Project> projects) {

        projects.sort((a, b) -> b.getRevenue() - a.getRevenue());

        Project[] week = new Project[5];
        int totalRevenue = 0;

        for (Project p : projects) {

            int lastDay = Math.min(p.getDeadline(), 5) - 1;

            for (int j = lastDay; j >= 0; j--) {
                if (week[j] == null) {
                    week[j] = p;
                    totalRevenue += p.getRevenue();
                    break;
                }
            }
        }

        String[] days = {"Monday","Tuesday","Wednesday","Thursday","Friday"};

        System.out.println("\nWeekly Schedule:");
        for (int i = 0; i < 5; i++) {
            if (week[i] != null)
                System.out.println(days[i] + " → " + week[i].getTitle());
            else
                System.out.println(days[i] + " → No Project");
        }

        System.out.println("Total Revenue: " + totalRevenue);
    }
}
