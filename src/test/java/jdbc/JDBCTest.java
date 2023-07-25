package jdbc;

import jdbc.dao.AccountDAO;
import jdbc.vo.AccountVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest {
    @Test
    @DisplayName("JDBC 생성 실습")
    void jdbcTest() {

        String url = "jdbc:postgresql://localhost:5432/messenger";
        String username = "temprmn";
        String password = "pass";

        // when
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Connection connection = DriverManager.getConnection(url, username, password);
            String createSql = "CREATE TABLE ACCOUNT (id SERIAL PRIMARY KEY, username varchar(255), password varchar(255))";
            PreparedStatement statement = connection.prepareStatement(createSql);
            statement.execute();

            // 자원 해제
            // statement.close();
            // connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
