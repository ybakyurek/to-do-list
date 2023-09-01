package com.ybakyurek.business.services.impl;

import com.ybakyurek.bean.ModelMapperBean;
import com.ybakyurek.business.dto.TaskDto;
import com.ybakyurek.business.services.ITaskServices;
import com.ybakyurek.data.entity.TaskEntity;
import com.ybakyurek.data.repository.ITaskRepository;
import com.ybakyurek.exception.ResourceNotFoundException;
import com.ybakyurek.exception.YbakyurekException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

// LOMBOK
@RequiredArgsConstructor
@Log4j2

// SERVICES
@Service
public class TaskServicesImpl implements ITaskServices<TaskDto, TaskEntity> {


    private final ITaskRepository iTaskRepository;
    private final ModelMapperBean modelMapperBean;


    // MODEL MAPPER
    @Override
    public TaskDto entityToDto(TaskEntity taskEntity) {
        return modelMapperBean.modelMapperMethod().map(taskEntity, TaskDto.class);
    }

    @Override
    public TaskEntity dtoToEntity(TaskDto taskDto) {
        return  modelMapperBean.modelMapperMethod().map(taskDto, TaskEntity.class);
    }

    // CREATE
    @Override
    @Transactional // create, delete, update
    public TaskDto taskServiceCreate(TaskDto taskDto) {
        if(taskDto !=null){
            TaskEntity taskEntity =dtoToEntity(taskDto);
            iTaskRepository.save(taskEntity);
            taskDto.setId(taskEntity.getTaskId());
            taskDto.setSystemDate(taskEntity.getSystemDate());
        }else{
            throw  new NullPointerException( " TaskDto null veri");
        }
        return taskDto;
    }

    // LIST
    @Override
    public List<TaskDto> taskServiceList() {
        Iterable<TaskEntity> entityIterable=  iTaskRepository.findAll();
        // Dto To entityb List
        List<TaskDto> taskDtoList =new ArrayList<>();
        for (TaskEntity entity:  entityIterable) {
            TaskDto taskDto =entityToDto(entity);
            taskDtoList.add(taskDto);
        }
        log.info("Liste Sayısı: "+ taskDtoList.size());
        return taskDtoList;
    }

    // FIND
    @Override
    public TaskDto taskServiceFindById(Long id) {

        // 2.YOL (FIND)
        TaskEntity findTaskEntity =  null;
        if(id!=null){
            findTaskEntity =  iTaskRepository.findById(id)
                    .orElseThrow(()->new ResourceNotFoundException(id+" nolu id yoktur"));
        }else if(id==null) {
            throw new YbakyurekException("İd null olarak geldi");
        }
        return entityToDto(findTaskEntity);
    }

    // UPDATE
    @Override
    @Transactional // create, delete, update
    public TaskDto taskServiceUpdate(Long id, TaskDto taskDto) {
        // Önce Bul
       TaskDto taskFindDto= taskServiceFindById(id);
       if(taskFindDto!=null){
           TaskEntity taskEntity =dtoToEntity(taskFindDto);
           taskEntity.setTaskName(taskDto.getTaskName());
           taskEntity.setContent(taskDto.getContent());
           taskEntity.setState(taskDto.getState());
           iTaskRepository.save(taskEntity);
           // Dönüştede ID ve Date Set et
       }
        return taskDto;
    }

    // DELETE
    @Override
    @Transactional // create, delete, update
    public TaskDto taskServiceDeleteById(Long id) {
        // Önce Bul
        TaskDto taskFindDto= taskServiceFindById(id);
        if(taskFindDto!=null){
            iTaskRepository.deleteById(id);
            // Dönüştede ID ve Date Set et
        }
        return taskFindDto;
    }

    //All Delete
    @Override
    @Transactional // create, delete, update
    public void taskServiceDeleteAll() {
        iTaskRepository.deleteAll();
    }

    @Override
    @Transactional // create, delete, update
    public void taskServiceDeleteByState(boolean state) {
        List<TaskEntity> tasksToDelete = iTaskRepository.findByState(state);

        for (TaskEntity taskEntity : tasksToDelete) {
            iTaskRepository.delete(taskEntity);
        }
    }

    public List<TaskDto> taskServiceFindByKeyword(String keyword) {
        // keyword null veya boş ise tüm taskleri döndür
        if (keyword == null || keyword.isEmpty()) {
            return taskServiceList();
        }

        List<TaskEntity> tasksByKeyword = new ArrayList<>();

        // taskName veya content içinde keyword içeren TaskEntity'leri sorgula
        List<TaskEntity> tasksWithKeywordInTaskName = iTaskRepository.findByTaskNameContainingIgnoreCase(keyword);
        List<TaskEntity> tasksWithKeywordInContent = iTaskRepository.findByContentContainingIgnoreCase(keyword);

        // İki listeyi birleştir
        tasksByKeyword.addAll(tasksWithKeywordInTaskName);
        tasksByKeyword.addAll(tasksWithKeywordInContent);

        // TaskEntity listesini TaskDto listesine dönüştür
        List<TaskDto> tasksDto = new ArrayList<>();
        for (TaskEntity taskEntity : tasksByKeyword) {
            tasksDto.add(entityToDto(taskEntity));
        }

        return tasksDto;
    }

    @Override
    @Transactional // create, delete, update
    public TaskDto taskServiceToggleState(Long id) {
        // Önce Bul
        TaskDto taskFindDto = taskServiceFindById(id);
        if (taskFindDto != null) {
            TaskEntity taskEntity = dtoToEntity(taskFindDto);
            taskEntity.toggleState(); // State'i tersine çevir
            iTaskRepository.save(taskEntity);
            // Dönüşte ID ve Date'i ayarla
            taskFindDto.setState(taskEntity.getState());
        }
        return taskFindDto;
    }

} //end class
