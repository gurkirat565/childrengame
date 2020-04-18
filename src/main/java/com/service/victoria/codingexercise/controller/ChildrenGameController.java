package com.service.victoria.codingexercise.controller;

import com.service.victoria.codingexercise.childrengame.ChildrenGameService;
import com.service.victoria.codingexercise.childrengame.dto.ChildrenGameResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Endpoint to get input from source
 */
@RestController
public class ChildrenGameController {

    @GetMapping(value = "/game/{children}/{position}")
    @ResponseBody
    public ResponseEntity<ChildrenGameResponse> executeGame(@PathVariable int children, @PathVariable int position) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(ChildrenGameService.calculateWinnerAndSequence(children, position));
    }

    @ExceptionHandler({ IllegalArgumentException.class })
    @ResponseBody
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
