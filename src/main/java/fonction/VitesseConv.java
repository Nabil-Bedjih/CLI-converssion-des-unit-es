package fonction;

import java.util.ArrayList;
import java.util.List;
public class VitesseConv {
    public static List<List<Double>> convert(String unitFrom, List<String> unitsTo, List<Double> values) {
        List<List<Double>> result = new ArrayList<>();
        for (String unitTo : unitsTo) {
            List<Double> conversions = new ArrayList<>();
            for (Double value : values) {
                double convertedValue = convertSingle(unitFrom, unitTo, value);
                conversions.add(convertedValue);
            }
            result.add(conversions);
        }
        return result;
    }
    public static double convertSingle(String unitFrom, String unitTo, double value) {
        if ("m/s".equals(unitFrom)) {
            if ("km/h".equals(unitTo)) {
                return value * 3.6;
            } else if ("mph".equals(unitTo)) {
                return value * 2.23694;
            } else if ("noeuds".equals(unitTo)) {
                return value * 1.94384;
            }
        } else if ("km/h".equals(unitFrom)) {
            if ("m/s".equals(unitTo)) {
                return value / 3.6;
            } else if ("mph".equals(unitTo)) {
                return value / 1.60934;
            } else if ("noeuds".equals(unitTo)) {
                return value / 1.852;
            }
        } else if ("mph".equals(unitFrom)) {
            if ("m/s".equals(unitTo)) {
                return value / 2.23694;
            } else if ("km/h".equals(unitTo)) {
                return value * 1.60934;
            } else if ("noeuds".equals(unitTo)) {
                return value / 1.15078;
            }
        } else if ("noeuds".equals(unitFrom)) {
            if ("m/s".equals(unitTo)) {
                return value / 1.94384;
            } else if ("km/h".equals(unitTo)) {
                return value * 1.852;
            } else if ("mph".equals(unitTo)) {
                return value * 1.15078;
            }
        }
        throw new IllegalArgumentException("Conversion non supportée");
    }
}
