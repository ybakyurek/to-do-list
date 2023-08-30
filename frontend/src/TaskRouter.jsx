
//rcc
import React, { Component } from 'react'


// ROUTER
import { Navigate, Route, Routes } from 'react-router-dom';

// I18N
import { withTranslation } from 'react-i18next';

// HEADER,FOOTER,MAIN
import Header from './component/Header'; // Import the Header component from the correct path
import Main from './component/Main';     // Import the Main component from the correct path
import Footer from './component/Footer'; // Import the Footer component from the correct path

//TASK
import TaskList from './component/task/TaskList';
import TaskCreate from './component/task/TaskCreate';
import TaskView from './component/task/TaskView';
import TaskUpdate from './component/task/TaskUpdate';


//CLASS COMPONENT
export default class TaskRouter extends Component {

    //Component gorunen ismi
    static displayName = "Task_Router";

    //constructor
    constructor(props){
        super(props);

        //state
        this.state={}

        //bind
    }//end constructor
    //RENDER
    render() {

        //RETURN
        return (
            <React.Fragment>
                
                <Header logo="fa-solid fa-warehouse"/> {/* Use the Header component */}
                
                <div className="container">
                    <Routes>
                        <Route path='/' element={<Main />} />
                        {/* Task category */}
                        <Route path='/task/list' element={<TaskList list="task"/>} />
                        <Route path='/task/create' element={<TaskCreate/>} />
                        <Route path='/task/view/:id' element={<TaskView/>} />
                        <Route path='/task/update/:id' element={<TaskUpdate/>} />
                        {/* bad request */}
                        <Route path="*" element={<Navigate to="/" />} />

                    </Routes>
                </div>


                <Footer copy="&copy; 2023" />
                
            </React.Fragment>
        )
    }
}

