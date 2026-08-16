package com.timr.api.models;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ModelToStringLogSafetyTest {

    @Test
    void durationToStringIncludesUsefulSummaryFields() {
        String rendered = new Duration()
                .type(DurationType.MINUTES)
                .minutes(42L)
                .minutesRounded(45L)
                .toString();

        assertTrue(rendered.contains("type: minutes"));
        assertTrue(rendered.contains("minutes: 42"));
        assertFalse(rendered.contains("minutesRounded: 45"));
    }

    @Test
    void breakTimeToStringIsNotEmpty() {
        // type() is inherited from BreakTimeBase and returns the base type, so the
        // variant's own setters have to come first for the chain to stay typed.
        String rendered = new BreakTimeManual()
                .durationMinutes(15)
                .type(BreakTimeType.MANUAL)
                .toString();

        assertTrue(rendered.contains("type: manual"));
        assertTrue(rendered.contains("durationMinutes: 15"));
    }

    @Test
    void pagingInformationToStringDoesNotExposePageToken() {
        String rendered = new PagingInformation()
                .nextPageToken("next-page-token")
                .toString();

        assertFalse(rendered.contains("next-page-token"));
    }
}
