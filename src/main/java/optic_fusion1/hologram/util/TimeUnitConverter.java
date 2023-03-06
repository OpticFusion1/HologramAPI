package optic_fusion1.hologram.util;

import java.util.concurrent.TimeUnit;

/**
 * The TimeUnitConverter class provides a method for converting seconds to ticks.
 */
public class TimeUnitConverter {

    /**
     * The constant TICKS_PER_SECOND is the number of ticks in a second.
     */
    private static final long TICKS_PER_SECOND = 20L;

    /**
     * Converts a given number of seconds to ticks.
     *
     * @param seconds The number of seconds to be converted to ticks.
     * @return The equivalent number of ticks.
     */
    public static long toTicks(long seconds) {
        return TimeUnit.SECONDS.toSeconds(seconds) * TICKS_PER_SECOND;
    }
}
