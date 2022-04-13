package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {

    }

    //Создание таблицы для User(ов) – не должно приводить к исключению,
    // если такая таблица уже существует
    public void createUsersTable() {
//        String sql = "CREATE TABLE IF NOT EXISTS `user` (" +
//                "`id` int (10) AUTO_INCREMENT,\n" +
//                "`name` varchar(45) NOT NULL,\n" +
//                "`lastName` varchar(45) NOT NULL,\n" +
//                "`age` int (10) NOT NULL,\n" +
//                "PRIMARY KEY (id)\n" +
//                ")";
//        try (Connection connection = Util.getConnection();
//             PreparedStatement ps = connection.prepareStatement(sql)) {
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    //Удаление таблицы User(ов) – не должно приводить к исключению, если таблицы не существует
    public void dropUsersTable() {
//        String sql = "DROP TABLE IF EXISTS `user`";
//        try (Connection connection = Util.getConnection();
//             PreparedStatement ps = connection.prepareStatement(sql)) {
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    //Добавление User в таблицу
    public void saveUser(String name, String lastName, byte age) {
//        String sql = "INSERT INTO `user` (`name`,`lastname`, `age`) VALUES (?,?,?)";
//        try (Connection connection = Util.getConnection();
//             PreparedStatement ps = connection.prepareStatement(sql);) {
//            ps.setString(1, name);
//            ps.setString(2, lastName);
//            ps.setByte(3, age);
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    //Удаление User из таблицы ( по id )
    public void removeUserById(long id) {
//        String sql = "DELETE FROM `user` WHERE `id`= ?";
//        try (Connection connection = Util.getConnection();
//             PreparedStatement ps = connection.prepareStatement(sql);) {
//            ps.setLong(1, id);
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    //Получение всех User(ов) из таблицы
    public List<User> getAllUsers() {
//            List<User> allUsers = new ArrayList<>();
//            String sql = "SELECT * FROM `user`";
//            try (Connection connection = Util.getConnection();
//                 Statement statement = connection.createStatement()) {
//                ResultSet resultSet = statement.executeQuery(sql);
//
//                while (resultSet.next()) {
//                    User user = new User();
//                    user.setId(resultSet.getLong("id"));
//                    user.setName(resultSet.getString("name"));
//                    user.setLastName(resultSet.getString("lastName"));
//                    user.setAge(resultSet.getByte("age"));
//
//                    allUsers.add(user);
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            return allUsers;
        return null;
    }
    //Очистка содержания таблицы
    public void cleanUsersTable() {
//        String sql = "TRUNCATE `user`";
//        try (Connection connection = Util.getConnection();
//             PreparedStatement ps = connection.prepareStatement(sql);) {
//
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
