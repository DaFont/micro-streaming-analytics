package dev.dfont.microstreaminganalytics.utils;


import dev.dfont.microstreaminganalytics.model.Statistics;
import org.apache.commons.math3.stat.StatUtils;

import java.util.Arrays;
import java.util.List;

public class StatisticsUtils {


    public static Statistics proccessData(List<Double> doubleList) {


        Statistics statistics = new Statistics();

        //media, mediana, moda, desviación típica, cuartiles, valor máximo y valor mínimo.
        double[] doubles = doubleList.stream().mapToDouble(Double::doubleValue).toArray();

        //Max
        System.out.println(StatUtils.max(doubles));
        statistics.setMax(StatUtils.max(doubles));

        //Min
        System.out.println(StatUtils.min(doubles));
        statistics.setMin(StatUtils.min(doubles));

        //Mode
        System.out.println(Arrays.toString(StatUtils.mode(doubles)));

        //Media
        System.out.println(StatUtils.mean(doubles));
        statistics.setMean(StatUtils.mean(doubles));


        //Varianza
        System.out.println(StatUtils.variance(doubles));
        statistics.setVariance(StatUtils.variance(doubles));

        //Desviacion tipica
        System.out.println(Math.sqrt(StatUtils.variance(doubles)));
        statistics.setStd(Math.sqrt(statistics.getVariance()));


        System.out.println(StatUtils.percentile(doubles, 25));
        statistics.setQuartile25(StatUtils.percentile(doubles, 25));

        System.out.println(StatUtils.percentile(doubles, 50));
        statistics.setQuartile50(StatUtils.percentile(doubles, 50));


        System.out.println(StatUtils.percentile(doubles, 75));
        statistics.setQuartile75(StatUtils.percentile(doubles, 75));

        return statistics;
    }

}
