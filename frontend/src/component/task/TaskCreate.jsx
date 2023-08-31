// REACT
import React, { useEffect, useState } from 'react'

// LANGUAGE
import { withTranslation } from 'react-i18next'

// ROUTER 
import { useNavigate } from 'react-router-dom'

// API
import TaskApi from '../../services/TaskApi';

// FUNCTION
function TaskCreate({ t }) {

  // REDIRECT
  const navigate = useNavigate();

  // STATE
  const [taskName, setTaskName] = useState('');
  const [error, setError] = useState();

  // Dinleyiciler 
  // taskName her hangi bir değişiklik olduğunda error silinsin
  useEffect(() => {
    setError(undefined)
  }, [taskName]);


  // CREATE
  const taskCreate = async (event) => {
    // Browser'ın post için durmasını istiyorum
    event.preventDefault();

    // Task object
    const newTask = {
      taskName
    }
    console.log(newTask);

    setError(undefined);
    // API
    try {
      const response = await TaskApi.taskApiCreate(newTask);
    } catch (err) {

      setError(err.response.data.validationErrors);
    }

  }


  // CHANGE
  const taskOnChange = (event) => {
    const { name, value } = event.target;
    //console.log(`${name} => ${value}`);

    // onChange
    setTaskName(value)
  }


  // RETURN
  return (
    <React.Fragment>
      <form>
        <h2 className="display-3 mt-4">{t('task_name')}</h2>
        <div className="form-group">
          <span>{t('task_name')}</span>
          <input
            type="text"
            className="form-control"
            placeholder={t('task_name')}
            required={true}
            autoFocus={true}
            id="task_data"
            name="task_data"
            onChange={taskOnChange}
          />
          {/* state hatayı bootstrap ile alert ekrana basma */}
          {error ? <div className="alert alert-danger" role="alert">
            {error.taskName}
          </div> : ""}
        </div>
        <button
          type='submit'
          className="btn btn-primary mt-3"
          disabled={!true}
          onClick={taskCreate}>{t('create')}</button>
      </form>
      <br /><br /><br /><br /><br /><br /><br /><br />
    </React.Fragment>
  ) //end return
} //end fucntion

// i18n wrapper
export default withTranslation()(TaskCreate)