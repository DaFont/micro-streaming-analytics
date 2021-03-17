package dev.dfont.microstreaminganalytics.repository.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Datapoint, using lambok library to generate getter,setter and constructor automatically.
 */
@Getter
@Setter
@NoArgsConstructor
public class Datapoint {

    public Long at;
    public Double value;

}
