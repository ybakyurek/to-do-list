import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
// import App from './App';
import reportWebVitals from './reportWebVitals';

// Router
import { BrowserRouter } from 'react-router-dom';
import TaskRouter from './TaskRouter';

// Dil seçeneği i18n ekledim
import './internationalization/i18nlanguage';

//ROOT
const root = ReactDOM.createRoot(document.getElementById('root'));

//RENDER
root.render(
  <React.StrictMode>
    <BrowserRouter>
     <TaskRouter/>
    </BrowserRouter> 
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
