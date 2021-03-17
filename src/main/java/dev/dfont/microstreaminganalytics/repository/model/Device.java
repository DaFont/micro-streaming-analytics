package dev.dfont.microstreaminganalytics.repository.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * The type Device, using lambok library to generate getter,setter and constructor automatically.
 */
@Getter
@Setter
@NoArgsConstructor
public class Device {

    public String version;
    public List<Datastream> datastreams = null;

}
