package dev.dfont.microstreaminganalytics.config;

import dev.dfont.microstreaminganalytics.model.Device;
import dev.dfont.microstreaminganalytics.model.Message;
import dev.dfont.microstreaminganalytics.model.Statistics;
import dev.dfont.microstreaminganalytics.repository.MessageRepository;
import dev.dfont.microstreaminganalytics.repository.StatisticsRepository;
import dev.dfont.microstreaminganalytics.utils.MessageEncoder;
import dev.dfont.microstreaminganalytics.utils.StatisticsUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Receiver called by RabbitMqConfig.
 * We use this Receiver to process messages from a RabbitMQ queue, we decide to group this values in groups of 100 elements
 * in order to process the statistic analysis before push the data into our mongoDB repository.
 *
 * Keep in mind that this is POC, un real life there has no sense to process this data in this way, it's better to perform
 * the statistic analysis getting the data already saved in the DB.
 */
public class Receiver {

    public static final String RECEIVE_METHOD_NAME = "receiveMessage";

    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

    List<Double> doubleList = new ArrayList<>();

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private StatisticsRepository statisticsRepository;

    public void receiveMessage(String message) {
        logger.info("[Receiver] message -> \"" + message + '"');
        Message m = new Message();
        m.setText(message);
        messageRepository.save(m);


        Device device = MessageEncoder.createPojoFromMessage(message);
        doubleList.add(device.getDatastreams().get(0).getDatapoints().get(0).value);

        if (doubleList.size() == 100){
            Statistics statistics = StatisticsUtils.proccessData(doubleList);
            logger.info("Saving data into DB");
            statisticsRepository.save(statistics);
            doubleList.clear();
        }


    }
}