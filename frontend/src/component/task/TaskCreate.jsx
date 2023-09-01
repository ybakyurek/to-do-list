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
  const [content, setContent] = useState(''); // Yeni content state'i
  const [error, setError] = useState();

  // Dinleyiciler 
  // taskName her hangi bir değişiklik olduğunda error silinsin
  useEffect(() => {
    setError(undefined)
  }, [taskName,content]);


  // CREATE
  const taskCreate = async (event) => {
    // Browser'ın post için durmasını istiyorum
    event.preventDefault();

    // Task object
    const newTask = {
      taskName,
      content
    }
    console.log(newTask);

    setError(undefined);
    // API
    try {
      const response = await TaskApi.taskApiCreate(newTask);
      navigate('/task/list');
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

  const maxLength = 50; // Gösterilecek maksimum karakter sayısı
  const [isTruncated, setIsTruncated] = useState(true);

  const toggleTruncate = () => {
    setIsTruncated(!isTruncated);
  };


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
            name="taskName" // name'i taskName olarak değiştirin
            onChange={taskOnChange}
          />
          {error ? <div className="alert alert-danger" role="alert">
            {error.taskName}
          </div> : ""}
        </div>

        {/* Yeni input alanı */}
        <div className="form-group">
          <span>Content</span>
          <input
            type="text"
            className="form-control"
            placeholder="Content"
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
      <br /><br /><br /><br /><br /><br /><br /><br />
    </React.Fragment>
  ) //end return
} //end fucntion

// i18n wrapper
export default withTranslation()(TaskCreate)