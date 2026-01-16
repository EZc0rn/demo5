package com.du.demo5.service;

import com.du.demo5.util.Sha512Util;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final JdbcTemplate jdbcTemplate;

    public AuthService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean login(String id, String pw) {
        String sql = """
            SELECT password, salt
            FROM user_table
            WHERE user_id = ?
        """;

        return jdbcTemplate.query(sql, rs -> {
            if (!rs.next()) return false;

            String dbHash = rs.getString("password");
            String salt = rs.getString("salt");

            String inputHash = Sha512Util.hash(salt + pw);
            return dbHash.equals(inputHash);
        }, id);
    }
}


