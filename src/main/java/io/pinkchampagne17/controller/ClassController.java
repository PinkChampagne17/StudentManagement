package io.pinkchampagne17.controller;

import io.pinkchampagne17.entity.Class;
import io.pinkchampagne17.exception.BindingResultHasErrorException;
import io.pinkchampagne17.parameter.CreateClassParams;
import io.pinkchampagne17.service.ClassService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/classes")
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @PostMapping()
    public ResponseEntity<Class> createClass(@RequestBody @Valid CreateClassParams params,
                                             @CookieValue("token") String token,
                                             BindingResult bindingResult) throws BindingResultHasErrorException {

        if (bindingResult.hasErrors()) {
            throw new BindingResultHasErrorException(bindingResult);
        }

        params.setCreatorUserId(token);
        Class classInstance = classService.createClass(params);
        return ResponseEntity.status(HttpStatus.CREATED).body(classInstance);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Class> getClass(@PathVariable Long id) {

        Class classInstance = classService.getClassById(id);
        if (classInstance == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(classInstance);
    }
}
