package com.service.victoria.codingexercise.childrengame.validator;

import com.service.victoria.codingexercise.childrengame.ChildrenGameService;

/**
 *
 * Validate the input data.
 *
 * Note: This method could be part of the {@link ChildrenGameService},
 * but validator is added to separate the concern. Also the assumption is to use primitive and use index as id of child.
 * If more complex object are needed, then it make sense to have separate validator.
 */
public class ChildrenGameValidator {

    /**
     * validate the data. Created a static method as the requirement is to
     * make caller method is static, else spring dependency injection can be used
     * @param number - number of children
     * @param position - position at which the elimination occurs.
     * @return
     */
    public static boolean isValid(int number, int position) {
        // to avoid arrayindexOutOfBoundException and IllegalCapacityException
        return number > 0 && position > 0;
    }
}
