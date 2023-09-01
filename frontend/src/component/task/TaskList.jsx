//import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { withTranslation } from 'react-i18next';
import { Link, useNavigate } from 'react-router-dom'
import TaskApi from '../../services/TaskApi';
import '/Users/yba/Documents/GitHub/to-do-list/frontend/src/component/main.css';

// FUNCTION
function TaskList({ t, i18n, props }) {

  // REDIRECT
  let navigate = useNavigate();

  // STATE
  const [TaskStateApi, setTaskStateApi] = useState([]);
  const [taskStates, setTaskStates] = useState([]);
  const [taskName, setTaskName] = useState('');
  const [state, setState] = useState('');
  const [content, setContent] = useState('');
  const [error, setError] = useState();

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

  // CREATE
  const taskCreate = async (event) => {

    // Task object
    const newTask = {
      taskName,
      content,
      state: false

    }
    console.log(newTask);

    setError(undefined);
    // API
    try {
      const response = await TaskApi.taskApiCreate(newTask);
      navigate("/task/list");
    } catch (err) {

      setError(err.response.data.validationErrors);
    }

  }

  // CHANGE
  const taskOnChange = (event) => {
    const { name, value } = event.target;

    if (name === 'taskName') {
      setTaskName(value);
    } else if (name === 'content') { // content için değişiklikleri alın
      setContent(value);

    }
  }

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

  // DELETE BY STATE
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

  const maxLength = 25; // Gösterilecek maksimum karakter sayısı
  const [isTruncated, setIsTruncated] = useState(true);

  const toggleTruncate = () => {
    setIsTruncated(!isTruncated);
  };

  // Tüm görevleri gösterme işlevi
  const resetTaskList = () => {
    setTaskStateApi(taskStates);
  };

  // Filtreleme işlevi
  const filterDoneTasks = () => {
    setTaskStateApi(taskStates);
    const filteredTasks = TaskStateApi.filter((data) => data.state === true);
    setTaskStateApi(filteredTasks);
  };

  // Filtreleme işlevi
  const filterUnDoneTasks = () => {
    setTaskStateApi(taskStates);
    const filteredTasks = TaskStateApi.filter((data) => data.state === false);
    setTaskStateApi(filteredTasks);

  };


  //RETURN
  return (
    <React.Fragment>


      <form className="mt-5">
        <h3>{t("new_task")}</h3>
        <div className="form-group">
          <span>{t('task_name')}</span>
          <input
            type="text"
            className="form-control"
            placeholder={t('task_name')}
            required={true}
            autoFocus={true}
            id="task_data"
            name="taskName"
            onChange={taskOnChange}
          />
          {error ? <div className="alert alert-danger" role="alert">
            {error.taskName}
          </div> : ""}
        </div>
        {/* content*/}
        <div className="form-group">
          <span>{t("content")}</span>
          <input
            type="text"
            className="form-control"
            placeholder={t("content")}
            required={true}
            name="content"
            onChange={taskOnChange}
          />
          {error ? <div className="alert alert-danger" role="alert">
            {error.content}
          </div> : ""}
        </div>

        <button
          type='submit'
          className="btn btn-primary mt-3"
          onClick={taskCreate}>
          {t('create')}

        </button>

      </form>


{/**************  ALL, DONE, UNDONE **************************/}
      <h1 className="text-center display-3">{t("task_list")} </h1>
      <span>
        <button
          className="btn btn-primary"
          onClick={() =>
            resetTaskList()
          }
        >
          {t("all")}
        </button>

        <button
          className="btn btn-primary"
          onClick={() => {
            resetTaskList();
            filterDoneTasks();
          }}
        >
          {t("done")}
        </button>
        <button
          className="btn btn-primary"
          onClick={() => {
            resetTaskList();
            filterUnDoneTasks();
          }}

        >
          {t("todo")}
        </button>

      </span>

{/**************  TABLE **************************/}

      <table>
        <thead>
          <tr>
            <th>{t("task_name")}</th>
            <th>{t("content")}</th>
            <th>{t("state")}</th>
            <th>{t("update")}</th>
            <th>{t("view")}</th>
            <th>{t("delete")}</th>
          </tr>
        </thead>
        <tbody>
          {
            TaskStateApi.map((data) =>
              <tr key={data.id}>

                <td>
                  <span style={{ textDecoration: data.state ? 'line-through' : 'none', color: data.state ? 'red' : 'black' }}>
                    {data.taskName}
                  </span>
                </td>
                <td>
                  <span style={{ textDecoration: data.state ? 'line-through' : 'none', color: data.state ? 'red' : 'black' }}>
                    {isTruncated ? data.content.slice(0, maxLength) + '' : data.content}
                    {data.content.length > maxLength && (
                      <btx onClick={toggleTruncate} style={{ color: 'blue' }}>
                        {isTruncated ? '...(+)' : '(-)'}
                      </btx>
                    )}
                  </span>
                </td>

                <td>
                  <input
                    type="checkbox"
                    checked={data.state}
                    onChange={() => setStatus(data.id)}
                  />
                </td>
                <td>
                  <Link to={`/task/update/${data.id}`}>
                    <i onClick={() => setUpdateTask(data)} className="fa-regular fa-pen-to-square" style={{ color: "#000000", }}></i>
                  </Link>
                </td>

                <td>
                  <Link to={`/task/view/${data.id}`}>
                    <i onClick={() => setViewTask(data.id)} className="fa-solid fa-circle-info" style={{ color: "#00a3d7", }}></i>
                  </Link>
                </td>

                <td>
                  <Link to={`/task/delete}`}>
                    <i onClick={() => setDeleteTask(data.id)} className="fa-regular fa-trash-can" style={{ color: "#b51a00" }} ></i>
                  </Link>
                </td>
              </tr>
            )
          }
        </tbody>
      </table>

      <Link to={`/task/delete/all`}>
        <i onClick={() => setDeleteAllTask()} className="btn btn-primary" style={{ background: "red", borderColor: 'red' }} >{t('deleteAll')}
        </i>
      </Link>
      <Link to={`/task/delete/true`}>
        <i onClick={() => setDeleteTaskbyState()} className="btn btn-primary" style={{ background: "red", borderColor: 'red' }}>{t('deleteDone')}
        </i>
      </Link>

    </React.Fragment>
  )
}

//i18n
export default withTranslation()(TaskList); 