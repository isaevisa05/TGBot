package io.github.isaevisa05.TGBot.repository;

import io.github.isaevisa05.TGBot.entity.ActiveChat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ActiveChatRepositoryTest {

    @Autowired
    private ActiveChatRepository activeChatRepository;

    public static final Long testChatId = 12345L;


    @Test
    public void testRepo_found() {
        final ActiveChat activeChat = new ActiveChat();
        activeChat.setChatId(testChatId);
        activeChatRepository.save(activeChat);
        Optional<ActiveChat> activeChatByChatId = activeChatRepository.findActiveChatByChatId(testChatId);
        assertTrue(activeChatByChatId.isPresent());
        assertEquals(testChatId, activeChatByChatId.get().getChatId());
    }

    @Test
    public void testRepo_notFound() {
        final ActiveChat activeChat = new ActiveChat();
        activeChat.setChatId(testChatId);
        activeChatRepository.save(activeChat);
        Optional<ActiveChat> activeChatByChatId = activeChatRepository.findActiveChatByChatId(testChatId);
        assertFalse(activeChatByChatId.isEmpty());
    }

}