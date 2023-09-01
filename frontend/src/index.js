import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';

// Router
import { BrowserRouter } from 'react-router-dom';
import ToDoRouter from './ToDoRouter';

// Dil seçeneği i18n ekledim
import './internationalization/i18nlanguage';

// ROOT
const root = ReactDOM.createRoot(document.getElementById('root'));
// RENDER
root.render(
  <React.StrictMode>
    <BrowserRouter>
     <ToDoRouter/>
    </BrowserRouter>
  </React.StrictMode>
);

reportWebVitals();
