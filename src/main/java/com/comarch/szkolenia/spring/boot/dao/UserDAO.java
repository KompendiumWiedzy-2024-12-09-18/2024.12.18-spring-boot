package com.comarch.szkolenia.spring.boot.dao;

import com.comarch.szkolenia.spring.boot.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserDAO implements IUserDAO {

    private final Connection connection;

    @Override
    public void insert(User user) {
        try {
            String sql = "INSERT INTO tuser (name, surname) VALUES (?,?)";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("nie dziala !!");
        }
    }

    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();

        try {
            String sql = "SELECT * FROM tuser";
            PreparedStatement ps = this.connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");

                User user = new User(id, name, surname);
                result.add(user);
            }
        } catch (SQLException e) {

        }

        return result;
    }

    @Override
    public void delete(int id) {
        try {
            String sql = "DELETE FORM tuser WHERE id = ?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {

        }
    }

    @Override
    public void update(User user) {
        try {
            String sql = "UPDATE tuser SET name = ?, surname = ? WHERE id = ?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setInt(3, user.getId());

            ps.executeUpdate();
        } catch (SQLException e) {

        }
    }
}
