package dev.dfont.microstreaminganalytics.repository.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * The type Datastream, using lambok library to generate getter,setter and constructor automatically.
 */
@Getter
@Setter
@NoArgsConstructor

public class Datastream {

    public String id;
    public List<Datapoint> datapoints = null;

}
