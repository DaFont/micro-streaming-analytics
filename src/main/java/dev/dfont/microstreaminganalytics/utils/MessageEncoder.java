package dev.dfont.microstreaminganalytics.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.dfont.microstreaminganalytics.model.Datapoint;
import dev.dfont.microstreaminganalytics.model.Datastream;
import dev.dfont.microstreaminganalytics.model.Device;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * The type Message builder build a String which contains a Json structure according to OpenGate south API documentation
 * <ul>
 *     <li> https://www.amplia-iiot.com/documentation/latest/api-south/opengate-api-south.html#collect_history
 * 	   <li> http://blog.amplia.es/south/data_collection/data_collection.html
 * </ul>
 */
public class MessageEncoder {

    private static final Logger logger = LoggerFactory.getLogger(MessageEncoder.class);

    /**
     * Create message as json string to use as a byte payload by the rabbitmq client.
     *
     * @return the string
     */
    public static String createMessageAsJsonString() {


        Datapoint datapoint = new Datapoint();
        //Save time event as EPOCH time
        datapoint.setAt(System.currentTimeMillis());


        //Create random values for temperature between 10º and 50ª

        Random r = new Random();
        Double randomValue = 10 + r.nextDouble() * (50 - 10);

        randomValue = Math.floor(randomValue * 100) / 100;

        datapoint.setValue(randomValue);

        List<Datapoint> datapointList = new ArrayList<>();
        datapointList.add(datapoint);


        Datastream datastream = new Datastream();
        datastream.setId("Temperature");
        datastream.setDatapoints(datapointList);


        List<Datastream> datastreamList = new ArrayList<>();
        datastreamList.add(datastream);


        Device device = new Device();

        //This defines the data structure version of OpenGate
        device.setVersion("7.0.0");
        device.setDatastreams(datastreamList);

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(device);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        logger.info("Creating json message");
        logger.debug(jsonString);

        return jsonString;
    }

    /**
     * Create device from string.
     *
     * @return the string
     */

    public static Device createPojoFromMessage(String message) {

        logger.info("Creating Pojo from message");
        ObjectMapper mapper = new ObjectMapper();
        Device device = null;
        try {
            device = mapper.readValue(message, Device.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return device;
    }
}


