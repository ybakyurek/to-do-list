package com.ybakyurek.controller.api.impl;

import com.ybakyurek.assist.FrontendUrl;
import com.ybakyurek.business.dto.TaskDto;
import com.ybakyurek.business.services.ITaskServices;
import com.ybakyurek.controller.api.ITaskApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// LOMBOK
@RequiredArgsConstructor
@Log4j2

// API
@RestController
@CrossOrigin(origins = FrontendUrl.REACT_URL) // http://localhost:3000
@RequestMapping("/task/api/v1")
public class TaskApiImpl implements ITaskApi<TaskDto> {

    // Injection
    private final ITaskServices iTaskServices;

    // CREATE
    // http://localhost:4444/task/api/v1/create
    @Override
    @PostMapping("/create")
    public ResponseEntity<?> taskApiCreate(@Valid @RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(iTaskServices.taskServiceCreate(taskDto));
    }

    // LIST
    // http://localhost:4444/task/api/v1/list
    @Override
    @GetMapping(value="/list")
    public ResponseEntity<List<TaskDto>> taskApiList() {
        return ResponseEntity.status(HttpStatus.OK).body(iTaskServices.taskServiceList());
    }

    // FIND
    // http://localhost:4444/task/api/v1/find/1
    @Override
    @GetMapping(value="/find/{id}")
    public ResponseEntity<?> taskApiFindById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.status(200).body(iTaskServices.taskServiceFindById(id));
    }

    // UPDATE
    // http://localhost:4444/task/api/v1/update/1
    @Override
    @PutMapping(value="/update/{id}")
    public ResponseEntity<?> taskApiUpdate(@PathVariable(name = "id") Long id, @Valid @RequestBody TaskDto taskDto) {
        return ResponseEntity.ok().body(iTaskServices.taskServiceUpdate(id, taskDto));
    }

    // DELETE BY ID
    // http://localhost:4444/task/api/v1/delete/1
    @Override
    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<?> taskApiDeleteById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(iTaskServices.taskServiceDeleteById(id),HttpStatus.OK);
    }

    ///////////////////////////////////////////////////////
    // ALL DELETE
    @Override
    @DeleteMapping(value="/delete/all")
    public ResponseEntity<String> taskApiAllDelete() {
        iTaskServices.taskServiceDeleteAll(); // Tüm verileri silmek için servis metodu çağrılır.
        return ResponseEntity.ok("Tüm veriler silindi.");
    }

    @Override
    @DeleteMapping(value="/delete/by-state/{state}")
    public ResponseEntity<String> taskApiDeleteByState(@PathVariable(name = "state") boolean state) {
        iTaskServices.taskServiceDeleteByState(state);
        return ResponseEntity.ok("Belirtilen state değerine sahip Task'ler silindi.");
    }

    @Override
    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<TaskDto>> taskApiSearch(@PathVariable(name = "keyword") String keyword) {
        List<TaskDto> tasks = iTaskServices.taskServiceFindByKeyword(keyword);
        return ResponseEntity.status(HttpStatus.OK).body(tasks);
    }

    @Override
    @PutMapping(value = "/toggle-state/{id}")
    public ResponseEntity<?> taskApiToggleState(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(iTaskServices.taskServiceToggleState(id));
    }


} //end class
