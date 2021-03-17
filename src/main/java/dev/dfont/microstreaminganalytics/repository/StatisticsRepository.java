package dev.dfont.microstreaminganalytics.repository;


import dev.dfont.microstreaminganalytics.model.Statistics;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StatisticsRepository  extends MongoRepository<Statistics, String> {


}