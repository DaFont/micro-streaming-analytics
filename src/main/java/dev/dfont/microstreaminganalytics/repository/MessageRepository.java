package dev.dfont.microstreaminganalytics.repository;

import dev.dfont.microstreaminganalytics.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {

    Message findByText(String text);

}
