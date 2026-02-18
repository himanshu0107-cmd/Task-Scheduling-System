package com.promanage;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        ProjectDAO dao = new ProjectDAO();

        while (true) {

            System.out.println("\n1. Add Project");
            System.out.println("2. View Projects");
            System.out.println("3. Generate Schedule");
            System.out.println("4. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Deadline (1-5): ");
                    int deadline = sc.nextInt();

                    System.out.print("Revenue: ");
                    int revenue = sc.nextInt();

                    dao.addProject(new Project(title, deadline, revenue));
                    System.out.println("Project Added!");
                    break;

                case 2:
                    for (Project p : dao.getAllProjects()) {
                        System.out.println(p.getId() + " | " +
                                p.getTitle() + " | " +
                                p.getDeadline() + " | " +
                                p.getRevenue());
                    }
                    break;

                case 3:
                    Scheduler.generateSchedule(dao.getAllProjects());
                    break;

                case 4:
                    System.exit(0);
            }
        }
    }
}
