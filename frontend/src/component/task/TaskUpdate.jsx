
// REACT
import React, { useEffect, useState } from 'react'

// LANGUAGE
import { withTranslation } from 'react-i18next'

// ROUTER 
import { useNavigate, useParams } from 'react-router-dom'

// API
import TaskApi from '../../services/TaskApi';


// FUNCTION
 function TaskUpdate({t}) {

  // REDIRECT
  const navigate=useNavigate();

  // STATE
  const [taskName, setTaskName] = useState('');
  const [state, setState] = useState('');
  const [content, setContent] = useState(''); 
  const [id, setID] = useState(null);

  // PARAMS
    const updateID = useParams();
  
  // USEEFFECT
    useEffect(() => {
      setID(updateID.id);

      //FIND
      TaskApi.taskApiFindById(updateID.id)
      .then((response) => {
        console.log(response.data);
        setTaskName(response.data.taskName)
        setContent(response.data.content)
        setState(response.data.state)
      })
      .catch((err) => {
        console.error(err);
      });
    },[])//end effect
  

  // POST
  const taskUpdate= async (event)=>{
    // Browser'ın post için durmasını istiyorum
    event.preventDefault();
    const updatedTaskName = taskName === '' ? undefined : taskName;

    // Task object
    const newTask={
      taskName,
      content,
      state
    }
    console.log(newTask);

    // API
   try {
      const response= await TaskApi.taskApiUpdate(id,newTask)
      if (response.status===200){
        navigate('/task/list');
      }
   } catch (err) {
    console.error(err);
   }
  }

  // RETURN
  return (
    <React.Fragment>
      <form>
        <h2 className="display-3 mt-4">{t('task_update')}</h2>
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
          onChange={(event)=>{setTaskName(event.target.value)}}
          value={taskName}
          />
          </div>
          <div className="form-group">
          <span>{t('content')}</span>
          <input 
            type="text" 
            className="form-control" 
            placeholder="Content" 
            required={true}
            name="content"
            onChange={(event) => { setContent(event.target.value) }}
            value={content}
          />
        </div>
          <button type='submit' className="btn btn-primary mt-3" onClick={taskUpdate}>{t('update')}</button>
      </form>
      <br /><br /><br /><br /><br /><br /><br /><br />
    </React.Fragment>
  ) //end return
} //end fucntion

// i18n wrapper
export default withTranslation()(TaskUpdate)
