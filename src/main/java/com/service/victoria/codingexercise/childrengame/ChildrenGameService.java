package com.service.victoria.codingexercise.childrengame;

import com.service.victoria.codingexercise.childrengame.dto.ChildrenGameResponse;
import com.service.victoria.codingexercise.childrengame.validator.ChildrenGameValidator;

import java.util.ArrayList;

/**
 * Service to support various functions for the children game
 */
public class ChildrenGameService {

    /**
     * Method to return the winner and sequence of elimination
     *
     * Note: Few assumptions have been made
     * 1. The index of list is assumed to be the id, it can be made more complex by accepting childern with their ids,
     * but will have to expose an input object for that.
     * @param n - number of children playing the game
     * @param k - position at which the elimination starts
     * @return - {@link ChildrenGameResponse}
     */
    public static ChildrenGameResponse calculateWinnerAndSequence(int n, int k) {

        // validation fails, throw error
        if (!ChildrenGameValidator.isValid(n, k)) {
            throw new IllegalArgumentException("Number and position should be non-negative and greater than zero");
        }

        ArrayList<Integer> children = generateChildrenList(n);
        // executing the loop again, but complexity still remains O(n) as the loops are not nested.
        ArrayList<Integer> eliminationSequence = triggerEliminationProcess(k, children);

        ChildrenGameResponse response = new ChildrenGameResponse();
        response.setEliminationSequence(eliminationSequence);
        response.setWinner(children.get(0));
        return response;
    }

    /**
     * generate the list of children
     * @param n - number of children in the input
     * @return - generated list
     */
    private static ArrayList<Integer> generateChildrenList(int n) {
        ArrayList<Integer> children = new ArrayList<Integer>(n);
        for(int i = 1;i <= n;i++){
            children.add(i);
        }
        return children;
    }

    /**
     * trigger the elimination process
     * @param k - position at which elimination occurs
     * @param children - list of children playing the game
     * @return - sequence of elimination
     */
    private static ArrayList<Integer> triggerEliminationProcess(int k, ArrayList<Integer> children) {
        ArrayList<Integer> eliminationSequence = new ArrayList<Integer>();
        int eliminateIndex = 0;
        while(children.size() > 1){
            eliminateIndex = (eliminateIndex + k - 1) % children.size();
            eliminationSequence.add(children.get(eliminateIndex));
            children.remove(eliminateIndex);
        }
        return eliminationSequence;
    }

}
