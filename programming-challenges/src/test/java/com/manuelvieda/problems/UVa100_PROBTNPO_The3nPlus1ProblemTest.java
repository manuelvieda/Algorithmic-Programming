package com.manuelvieda.problems;

import static com.manuelvieda.problems.UVa100_PROBTNPO_The3nPlus1Problem.cycleLength;
import static com.manuelvieda.problems.UVa100_PROBTNPO_The3nPlus1Problem.maxCycleLength;
import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

/**
 * Test cases for  {@linkplain UVa100_PROBTNPO_The3nPlus1Problem}
 *
 * @author Manuel E Vieda (https://manuelvieda.com)
 * @version 1.0
 * @since 1.0
 */
public class UVa100_PROBTNPO_The3nPlus1ProblemTest {

    /**
     * Test case for {@linkplain UVa100_PROBTNPO_The3nPlus1Problem#cycleLength(long) cycleLength} method.
     * Validates the result for already calculated numbers.
     */
    @Test
    public void testCycleLength() {

        assertThat(cycleLength(0)).isEqualByComparingTo(1L);
        assertThat(cycleLength(1)).isEqualByComparingTo(1L);
        assertThat(cycleLength(2)).isEqualByComparingTo(2L);
        assertThat(cycleLength(4)).isEqualByComparingTo(3L);
        assertThat(cycleLength(8)).isEqualByComparingTo(4L);
        assertThat(cycleLength(16)).isEqualByComparingTo(5L);

        assertThat(cycleLength(138)).isEqualByComparingTo(16L);
        assertThat(cycleLength(7980)).isEqualByComparingTo(53L);
        assertThat(cycleLength(1000000)).isEqualByComparingTo(153L);
        assertThat(cycleLength(1234567)).isEqualByComparingTo(112L);

    }

    /**
     * Test case for {@linkplain UVa100_PROBTNPO_The3nPlus1Problem#maxCycleLength(long, long) maxCycleLength}
     * method. Validates the result for already calculated numbers.
     */
    @Test
    public void testMaxCycleLength() {

        assertThat(maxCycleLength(1, 1)).isEqualByComparingTo(1L);

        assertThat(maxCycleLength(1, 9)).isEqualByComparingTo(20L);
        assertThat(maxCycleLength(9, 1)).isEqualByComparingTo(20L);

        assertThat(maxCycleLength(20, 20)).isEqualByComparingTo(8L);

        assertThat(maxCycleLength(724852, 724070)).isEqualByComparingTo(362L);

    }

}