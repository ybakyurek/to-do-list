package com.ybakyurek.controller.api;

import com.ybakyurek.business.dto.TaskDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ITaskApi<D> {

    // C R U D
    // CREATE
    public ResponseEntity<?> taskApiCreate(D d);

    // LIST
    public ResponseEntity<List<D>> taskApiList();

    // FIND BY
    public ResponseEntity<?> taskApiFindById(Long id);

    // UPDATE
    public ResponseEntity<?> taskApiUpdate(Long id, D d);

    // DELETE
    public ResponseEntity<?> taskApiDeleteById(Long id);

    //////////////////////////////////////
    // ALL DELETE
    public ResponseEntity<String> taskApiAllDelete();

    public ResponseEntity<String> taskApiDeleteByState(boolean state);

    public ResponseEntity<List<TaskDto>> taskApiSearch( String keyword);

    // STATE TOGGLE
    public ResponseEntity<?> taskApiToggleState(Long id);

    // LIST BY STATE
    public ResponseEntity<List<D>> taskApiListByState(boolean state);

}
