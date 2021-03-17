package dev.dfont.microstreaminganalytics.config;

import dev.dfont.microstreaminganalytics.model.Message;
import dev.dfont.microstreaminganalytics.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class Receiver {

    public static final String RECEIVE_METHOD_NAME = "receiveMessage";

    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

    @Autowired
    private MessageRepository messageRepository;

    public void receiveMessage(String message) {
        logger.info("[Receiver] message -> \"" + message + '"');
        Message m = new Message();
        m.setText(message);
        messageRepository.save(m);

    }
}