// AXIOS
import axios from "axios";

// Persist URL 
const TASK_URL = "/task/api/v1"

// CLASS API
class TaskApi {

    taskApiCreate(taskDto) {
        return axios.post(`${TASK_URL}/create`, taskDto)
    };


    taskApiList() {
        return axios.get(`${TASK_URL}/list`)
    }

 
    taskApiFindById(id) {
        return axios.get(`${TASK_URL}/find/${id}`)
    }

  
    taskApiUpdate(id, taskDto) {
        return axios.put(`${TASK_URL}/update/${id}`, taskDto)
    }

    taskApiDeleteById(id) {
        return axios.delete(`${TASK_URL}/delete/${id}`)
    }

} //end class

export default new TaskApi();
