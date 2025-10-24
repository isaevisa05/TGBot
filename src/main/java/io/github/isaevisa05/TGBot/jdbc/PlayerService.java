package io.github.isaevisa05.TGBot.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    public int getBalance(String login) {
        return playerRepository.getBalance(login);
    }


}
