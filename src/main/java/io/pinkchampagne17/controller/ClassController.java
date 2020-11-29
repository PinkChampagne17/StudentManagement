package io.pinkchampagne17.controller;

import io.pinkchampagne17.entity.Class;
import io.pinkchampagne17.entity.ErrorMessage;
import io.pinkchampagne17.entity.User;
import io.pinkchampagne17.exception.BindingResultHasErrorException;
import io.pinkchampagne17.exception.CustomException;
import io.pinkchampagne17.parameter.CreateClassParams;
import io.pinkchampagne17.service.ClassService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/classes")
public class ClassController {

    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    /**
     * 创建班级
     */
    @PostMapping()
    public ResponseEntity<Class> createClass(@RequestBody @Valid CreateClassParams params,
                                             @CookieValue("token") String userId,
                                             BindingResult bindingResult) throws BindingResultHasErrorException {

        if (bindingResult.hasErrors()) {
            throw new BindingResultHasErrorException(bindingResult);
        }

        params.setCreatorUserId(userId);
        Class classInstance = classService.createClass(params);
        return ResponseEntity.status(HttpStatus.CREATED).body(classInstance);
    }

    @GetMapping
    public ResponseEntity<List<Class>> getClasses(@RequestParam("creatorUserId") String creatorUserId) {

        List<Class> classes = classService.getClassesByCreatorUserId(creatorUserId);

        if (classes == null) {
            return ResponseEntity.ok(new ArrayList<>());
        }
        return ResponseEntity.ok(classes);
    }

    /**
     * 使用id获取班级
     */
    @GetMapping("/{id}")
    public ResponseEntity<Class> getClass(@PathVariable Long id) {

        Class classInstance = classService.getClassById(id);
        if (classInstance == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(classInstance);
    }

    /**
     * 通过id获取班级成员
     * @param id 班级id
     * @return 班级成员
     */
    @GetMapping("/{id}/members")
    public ResponseEntity<List<User>> getUsers(@PathVariable Long id) {
        List<User> users = classService.getMemberById(id);
        return ResponseEntity.ok(users);
    }

    /**
     * 为班级添加新成员
     * @param id 班级id
     * @param userId 用户id
     * @return
     */
    @PostMapping("/{id}/members")
    public ResponseEntity<?> addMember(@PathVariable Long id, @RequestParam("userId") String userId) throws CustomException {

        boolean success = classService.addMember(id, userId);

        if (!success) {
            throw new CustomException(new ErrorMessage() {
                {
                    setMessage("班级不存在");
                    setStatus(HttpStatus.BAD_REQUEST.value());
                }
            });
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 移除班级成员
     * @param id 班级id
     * @param userId 用户id
     * @return
     */
    @DeleteMapping("/{id}/members/{userId}")
    public ResponseEntity<?> removeMember(@PathVariable Long id, @PathVariable String userId) {
        classService.removeMember(userId);
        return ResponseEntity.noContent().build();
    }
}
