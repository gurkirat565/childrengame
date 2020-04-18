package com.service.victoria.codingexercise.childrengame;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import com.service.victoria.codingexercise.childrengame.dto.ChildrenGameResponse;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ChildrenGameServiceTest {

    @Test
    public void testInvalidInput() throws Exception {
        assertThatThrownBy(() -> ChildrenGameService.calculateWinnerAndSequence(0,0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Number and position should be non-negative and greater than zero");
    }

    @Test
    public void testValidInputChildren14AndPosition2() {
        ChildrenGameResponse response = ChildrenGameService.calculateWinnerAndSequence(14, 2);
        validateResponse(response, 13, Arrays.asList(2, 4, 6, 8, 10, 12, 14, 3, 7, 11, 1, 9, 5));
    }

    @Test
    public void testValidInputChildren1AndPosition1() {
        ChildrenGameResponse response = ChildrenGameService.calculateWinnerAndSequence(1, 1);
        validateResponse(response, 1, Collections.emptyList());
    }

    @Test
    public void testValidInputChildren5AndPosition3() {
        ChildrenGameResponse response = ChildrenGameService.calculateWinnerAndSequence(5, 3);
        validateResponse(response, 4, Arrays.asList(3, 1, 5, 2));
    }

    private void validateResponse(ChildrenGameResponse actualResponse, int expectedWinner, List<Integer> expectedEliminationSequence) {
        assertThat(actualResponse).isNotNull();
        assertThat(actualResponse.getWinner()).isEqualTo(expectedWinner);
        assertThat(actualResponse.getEliminationSequence()).containsSequence(expectedEliminationSequence);
    }
}
