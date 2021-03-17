package dev.dfont.microstreaminganalytics.utils;


import dev.dfont.microstreaminganalytics.model.Statistics;
import org.apache.commons.math3.stat.StatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;


/**
 * The type Statistics utils to process groups of data using Apache Common Stat library to get statistic analysis values.
 */
public class StatisticsUtils {

    private static final Logger logger = LoggerFactory.getLogger(StatisticsUtils.class);

    /**
     * Proccess data statistics.
     *
     * @param doubleList the double list
     * @return the statistics
     */
    public static Statistics proccessData(List<Double> doubleList) {


        Statistics statistics = new Statistics();

        //Current timestamp
        statistics.setTimestamp(Instant.now());

        //Mapping data from list to array of doubles to use Apache Commons Stat library
        double[] doubles = doubleList.stream().mapToDouble(Double::doubleValue).toArray();

        //Max
        logger.info("Calculate statistic analysis");

        logger.info(String.valueOf(StatUtils.max(doubles)));
        statistics.setMax(StatUtils.max(doubles));

        //Min
        logger.info(String.valueOf(StatUtils.min(doubles)));
        statistics.setMin(StatUtils.min(doubles));

        //Mode
        logger.info(Arrays.toString(StatUtils.mode(doubles)));

        //Media
        logger.info(String.valueOf(StatUtils.mean(doubles)));
        statistics.setMean(StatUtils.mean(doubles));


        //Varianza
        logger.info(String.valueOf(StatUtils.variance(doubles)));
        statistics.setVariance(StatUtils.variance(doubles));

        //Desviacion tipica
        logger.info(String.valueOf(Math.sqrt(StatUtils.variance(doubles))));
        statistics.setStd(Math.sqrt(statistics.getVariance()));


        logger.info(String.valueOf(StatUtils.percentile(doubles, 25)));
        statistics.setQuartile25(StatUtils.percentile(doubles, 25));

        logger.info(String.valueOf(StatUtils.percentile(doubles, 50)));
        statistics.setQuartile50(StatUtils.percentile(doubles, 50));


        logger.info(String.valueOf(StatUtils.percentile(doubles, 75)));
        statistics.setQuartile75(StatUtils.percentile(doubles, 75));

        return statistics;
    }

}
