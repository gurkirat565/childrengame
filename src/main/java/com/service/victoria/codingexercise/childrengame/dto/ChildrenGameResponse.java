package com.service.victoria.codingexercise.childrengame.dto;

import java.util.List;

public class ChildrenGameResponse {

    private List<Integer> eliminationSequence;
    private int winner;

    public List<Integer> getEliminationSequence() {
        return eliminationSequence;
    }

    public void setEliminationSequence(List<Integer> eliminationSequence) {
        this.eliminationSequence = eliminationSequence;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }
}
