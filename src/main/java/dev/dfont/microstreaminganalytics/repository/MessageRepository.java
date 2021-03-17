package dev.dfont.microstreaminganalytics.repository;

import dev.dfont.microstreaminganalytics.repository.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {

    public Message findByText(String text);

}
