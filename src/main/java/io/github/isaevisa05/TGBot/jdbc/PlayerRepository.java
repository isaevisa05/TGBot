package io.github.isaevisa05.TGBot.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
class PlayerRepository {

    private final JdbcTemplate jdbcTemplate;

    public int getBalance(String login) {
        return jdbcTemplate.queryForObject("SELECT `balance` FROM `tgbot`.`accounts` WHERE login = ?", Integer.class, login);
    }

}
