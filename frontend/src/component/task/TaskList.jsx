//import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { withTranslation } from 'react-i18next';
import { Link, useNavigate } from 'react-router-dom'
import TaskApi from '../../services/TaskApi';

// FUNCTION
function TaskList({ t, i18n, props }) {

  // REDIRECT
  let navigate = useNavigate();

  // STATE
  const [TaskStateApi, setTaskStateApi] = useState([]);
  const [taskStates, setTaskStates] = useState([]);


  // I18N

  // USEEFFECT
  useEffect(() => {
    TaskApi.taskApiList()
      .then((response) => {
        console.log(response.data);
        setTaskStateApi(response.data);
        setTaskStates(response.data);
        fetchTaskList();
      })
      .catch((err) => { console.error(err); });
  }, []);




  const fetchTaskList = async () => {
    try {
      const response = await TaskApi.taskApiList();
      setTaskStates(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  const toggleTaskState = async (taskId) => {
    try {
      await TaskApi.toggleTaskState(taskId);
      fetchTaskList();
    } catch (error) {
      console.error(error);
    }
  };




  // LIST
  const getListTask = (() => {
    //axios.get("http://localhost:4444/task/api/v1/list")
    TaskApi.taskApiList()
      .then((response) => {
        console.log(response.data);
        setTaskStateApi(response.data);
      })
      .catch((err) => { console.error(err); });
  });

  // DELETE
  const setDeleteTask = ((id) => {
    if (window.confirm("Silmek istediğinizden emin misiniz ?")) {
      //axios.delete("http://localhost:4444/task/api/v1/delete/" + id)
      TaskApi.taskApiDeleteById(id)
        .then(() => {
          getListTask();
          navigate("/task/list");
        })
    } else {
      alert("Silinmedi.")
    }
    navigate("/task/list");
  });

  // DELETE ALL
  const setDeleteAllTask = (() => {
    if (window.confirm("Silmek istediğinizden emin misiniz ?")) {
      TaskApi.taskApiDeleteAll()
        .then(() => {
          getListTask();
          navigate("/task/list");
        })
    } else {
      alert("Silinmedi.")
    }
    navigate("/task/list");
  });

  // DELETE state
  const setDeleteTaskbyState = (() => {
    if (window.confirm("Yapılan İşleri Silmek İstediğinize Emin Misiniz ?")) {
      TaskApi.taskApiDeleteByState(1)
        .then(() => {
          getListTask();
          navigate("/task/list");
        })
    } else {
      alert("Silinmedi.")
    }
    navigate("/task/list");
  });




  //UPDATE
  const setUpdateTask = (data) => {
    let { id, taskName, systemDate } = data;
    localStorage.setItem("task_update_id", id);
    localStorage.setItem("task_update_task_name", taskName);
    localStorage.setItem("task_update_task_date", systemDate);
  }


  // Update Toggle
  const setStatus = ((id) => {
    TaskApi.taskApiSwitchToggle(id)
      .then(() => {
        getListTask();
        navigate("/task/list");
      })
    navigate("/task/list");
  });

  //VIEW
  const setViewTask = (id) => {
    localStorage.setItem("task_view_id", id);
  }

  //RETURN
  return (
    <React.Fragment>
      <h1 className="text-center display-3">{t("task_list")} </h1>
      <Link to="/task/create" className="btn btn-primary">{t("create")}</Link>
      <Link to={`/task/delete/all`}>
        <i onClick={() => setDeleteAllTask()} className="btn btn-primary">Delete All</i>
      </Link>
      <Link to={`/task/delete/true`}>
        <i onClick={() => setDeleteTaskbyState()} className="btn btn-primary">Delete Done</i>
      </Link>

      <table className="table table-striped table-hover table-responsive">
        <thead>
          <tr>
            <th>{t('id')}</th>
            <th>{t("task_name")}</th>
            <th>{t("content")}</th>
            <th>{t("state")}</th>
            <th>{t("StateCheck")}</th>
            <th>{t("update")}</th>
            <th>{t("view")}</th>
            <th>{t("delete")}</th>
          </tr>
        </thead>
        <tbody>
          {
            TaskStateApi.map((data) =>
              <tr key={data.id}>
                <td>{data.id}</td>
                <td>
                  <span style={{ textDecoration: data.state ? 'line-through' : 'none', color: data.state ? 'red' : 'black' }}>
                    {data.taskName}
                  </span>
                </td>

                <td>{data.content}</td>
                <td>{data.state ? t("Tamamlandi") : t("Tamamlanmadi")}</td>
                <td>
                  <input
                    type="checkbox"
                    checked={data.state}
                    onChange={() => setStatus(data.id)}
                  />
                </td>


                <td>
                  <Link to={`/task/update/${data.id}`}>
                    <i onClick={() => setUpdateTask(data)} className="fa-solid fa-pen-to-square text-primary"></i>
                  </Link>
                </td>

                <td>
                  <Link to={`/task/view/${data.id}`}>
                    <i onClick={() => setViewTask(data.id)} className="fa-solid fa-expand text-warning"></i>
                  </Link>
                </td>

                <td>
                  <Link to={`/task/delete}`}>
                    <i onClick={() => setDeleteTask(data.id)} className="fa-solid fa-trash text-danger"></i>
                  </Link>
                </td>
              </tr>
            )
          }
        </tbody>
      </table>
    </React.Fragment>
  )
}

//i18n
export default withTranslation()(TaskList); 