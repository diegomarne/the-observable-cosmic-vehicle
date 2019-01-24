package gov.nasa.theobersvablecosmicvehicle.model;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MarsRover {

    public static final String CURIOSITY = "curiosity";
    public static final String OPPORTUNITY = "opportunity";
    public static final String SPIRIT = "spirit";

    public static final String LANDING_EARTH_DATE_CURIOSITY = "2012-8-6";
    public static final String LANDING_EARTH_DATE_OPPORTUNITY = "2004-1-25";
    public static final String LANDING_EARTH_DATE_SPIRIT = "2004-1-4";


    @StringDef({CURIOSITY, OPPORTUNITY, SPIRIT})
    @Retention(RetentionPolicy.SOURCE)
    public @interface RoverName {
    }
}
