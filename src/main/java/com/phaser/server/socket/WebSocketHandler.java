package com.phaser.server.socket;

import com.phaser.server.database.user.UserRepository;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WebSocketHandler extends TextWebSocketHandler {
    private final UserRepository userRepository;

    public WebSocketHandler(@NonNull UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected void handleTextMessage(
            @NonNull WebSocketSession session,
            @NonNull TextMessage message
    ) {
        var user = userRepository.findById(1L)
                .orElseThrow(
                        () -> new RuntimeException("User not found")
                );


        user.setPassword(message.getPayload());

        userRepository.save(user);

        log.info(user.getPassword());
    }
}
