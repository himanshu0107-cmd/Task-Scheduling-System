package com.promanage;

import java.sql.*;
import java.util.*;

public class ProjectDAO {

    public void addProject(Project project) throws Exception {

        String sql = "INSERT INTO projects(title, deadline, revenue) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, project.getTitle());
            ps.setInt(2, project.getDeadline());
            ps.setInt(3, project.getRevenue());

            ps.executeUpdate();
        }
    }

    public List<Project> getAllProjects() throws Exception {

        List<Project> list = new ArrayList<>();
        String sql = "SELECT * FROM projects";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Project(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getInt("deadline"),
                        rs.getInt("revenue")
                ));
            }
        }
        return list;
    }
}
