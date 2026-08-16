package lk.travelmarket.search_engine.network.commons.util;

import static java.util.Objects.isNull;

public class StringUtils {

    public static final String ALPHA_CHAR_REGEX = "[^0-9]";

    public StringUtils() {

    }

    public static boolean isNotNull( Object value ) { return !isNull(value);}

    public static boolean isNotNullOrEmpty( String value ) { return value != null && value.length() > 0;}
}
