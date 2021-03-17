package dev.dfont.microstreaminganalytics.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The type Statistics, using lambok library to generate getter,setter and constructor automatically.
 */
@Getter
@Setter
@NoArgsConstructor
@Document("statistics")
public class Statistics {

    @Id
    public String id;

    private double max;
    private double min;
    private double mean;
    private double variance;
    private double std;
    private double quartile25;
    private double quartile50;
    private double quartile75;

}
