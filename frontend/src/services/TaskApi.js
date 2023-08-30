import axios from "axios";

const TASK_URL = "/task/api/v1"


class TaskApi {

    // CREATE
    // http://localhost:4444/task/api/v1/create
    // @PostMapping("/create")</TaskDto>
    taskApiCreate(taskDto) {
        return axios.post(`${TASK_URL}/create`)
    };

    // LIST
    // http://localhost:4444/task/api/v1/list
    // @GetMapping(value="/list")
    taskApiList() {
        return axios.get(`${TASK_URL}/list`)
    };

    // FIND
    // http://localhost:4444/task/api/v1/find/1
    // @GetMapping(value = "/find/{id}")
    taskApiFindById(id) {
        return axios.get(`${TASK_URL}/find/${id}`)
    }

    // UPDATE
    // http://localhost:4444/task/api/v1/update/1 
    // @PutMapping(value = "/update/{id}")
    taskApiUpdate(id, taskDto) {
        return axios.get(`${TASK_URL}/update/${id}`)
    }

    // DELETE BY ID
    // http://localhost:4444/task/api/v1/delete/1
    // @DeleteMapping(value = "/delete/{id}")
    taskApiDeleteById(id) {
        return axios.get(`${TASK_URL}/delete/${id}`)
    }

    ///////////////////////////////////////////////////////
    // ALL DELETE
    // @Override
    // taskApiAllDelete() {
    //     return null;
    // }


} //end class
export default new TaskApi();