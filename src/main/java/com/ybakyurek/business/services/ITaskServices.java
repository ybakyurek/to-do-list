package com.ybakyurek.business.services;

import com.ybakyurek.business.dto.TaskDto;

import java.util.List;

// D: Dto
// E: Entity
public interface ITaskServices<D, E> {

    // Model Mapper
    public D entityToDto(E e);

    public E dtoToEntity(D d);

    // C R U D
    // CREATE
    public D taskServiceCreate(D d);

    // LIST
    public List<D> taskServiceList();

    // FIND BY
    public D taskServiceFindById(Long id);

    // UPDATE
    public D taskServiceUpdate(Long id, D d);

    // DELETE
    public D taskServiceDeleteById(Long id);

    // DELETE All
    public void taskServiceDeleteAll();

    // DELETE BY STATE
    public void taskServiceDeleteByState(boolean state);

    //LIST BY KEYWORD
    public List<TaskDto> taskServiceFindByKeyword(String keyword);

    //LIST BY STATE
    public List<TaskDto> taskServiceFindByState(boolean state);

    //SWITCH STATE
    public TaskDto taskServiceToggleState(Long id);
}
