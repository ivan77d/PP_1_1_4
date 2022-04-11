package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private Connection connection = null;
    private PreparedStatement ps = null;

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS `user` (" +
                "`id` int (10) AUTO_INCREMENT,\n" +
                "`name` varchar(45) NOT NULL,\n" +
                "`lastName` varchar(45) NOT NULL,\n" +
                "`age` int (10) NOT NULL,\n" +
                "PRIMARY KEY (id)\n" +
                ")";

        try {
        connection = Util.getConnection();
        ps = connection.prepareStatement(sql);
        connection.setAutoCommit(false);
        ps.executeUpdate();
        connection.commit();
        connection.setAutoCommit(true);
        connection.close();


        } catch (Exception e) {
//            try {
//                connection.rollback();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS `user`";
        try {
            connection = Util.getConnection();
            ps = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            ps.executeUpdate();
            connection.commit();
            //connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException e) {
//            try {
//                connection.rollback();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT INTO `user` (`name`,`lastname`, `age`) VALUES (?,?,?)";
        try {
            connection = Util.getConnection();
            ps = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            ps.setString(1, name);
            ps.setString(2, lastName);
            ps.setByte(3, age);
            ps.executeUpdate();
            connection.commit();
            //connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException e) {
//            try {
//                connection.rollback();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM `user` WHERE `id`= ?";
        try {
            connection = Util.getConnection();
            ps = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            ps.setLong(1, id);
            ps.executeUpdate();
            connection.commit();
            //connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException e) {
//            try {
//                connection.rollback();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<>();
        String sql = "SELECT * FROM `user`";
        try {
            connection = Util.getConnection();
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));

                allUsers.add(user);
            }
                connection.commit();
                connection.close();

        } catch (SQLException e) {
//            try {
//                connection.rollback();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
            e.printStackTrace();
        }
        return allUsers;

    }

    public void cleanUsersTable() {
        String sql = "TRUNCATE `user`";
        try {
            connection = Util.getConnection();
            ps = connection.prepareStatement(sql);
            connection.setAutoCommit(false);
            ps.executeUpdate();
            connection.commit();
            //connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException e) {
//            try {
//                connection.rollback();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
            e.printStackTrace();
        }
    }
}
