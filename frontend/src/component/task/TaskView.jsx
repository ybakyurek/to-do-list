import React, { useEffect, useState } from 'react'
import { useNavigate, useParams, Link } from 'react-router-dom'
import TaskApi from '../../services/TaskApi';
//import axios from 'axios';


// FUNCTION
export default function TaskView() {

  // REDIRECT
  let navigate = useNavigate();

  // STATE
  const [viewApi, setViewApi] = useState([]);
  const [id, setID] = useState(null);



  // PARAMS
  const viewID = useParams();

  //UPDATE
  const setUpdateTask = (data) => {
    let { id, taskName, systemDate } = data;
    localStorage.setItem("task_update_id", id);
    localStorage.setItem("task_update_task_name", taskName);
    localStorage.setItem("task_update_task_date", systemDate);
  }

  // DELETE
  const setDeleteTask = ((id) => {
    if (window.confirm("Silmek istediğinizden emin misiniz ?")) {
      TaskApi.taskApiDeleteById(id)
        .then(() => {
          navigate("/task/list");
        })
    } else {
      alert("Silinmedi.")
    }
    navigate("/task/view/{id}");
  });


  // EFFECT
  useEffect(() => {
    //1.YOL (ID)
    setID(localStorage.getItem("task_view_id"));

    TaskApi.taskApiFindById(viewID.id)

      .then((response) => {
        console.log(response.data);
        setViewApi(response.data)
      })
      .catch((err) => {
        console.error(err);
      });
  }, [])//end effect

  return (
    <React.Fragment>
      <div class="card">
        <div class="card-body text-center">
          <h5 class="card-title"> {viewApi.id}</h5>
          <p class="card-title"> {viewApi.taskName}</p>
          <p class="card-content"> {viewApi.content}</p>
          <p class="card-text">  {viewApi.systemDate}</p>
          <Link to={`/task/update/${viewID.id}`} className="btn btn-primary">
            Update
          </Link>

          {/* Delete Button */}
          <button
            type='button'
            className="btn btn-primary"
            onClick={() => setDeleteTask(viewID.id)}
          >
            Delete
          </button>

        </div>
      </div>
    </React.Fragment>

  )
}
