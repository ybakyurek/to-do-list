import React, { Component } from 'react'
import { Link } from 'react-router-dom'
import './main.css';

export default class Main extends Component {
  render() {
    return (
      <React.Fragment >

        {/* <h1 className="display-3">Ana Sayfa</h1>
         <Link className="btn btn-primary mt-5 mb-5" to="task/list">Task - List</Link> */}
        <div className="home-container">
          <h1>Todo Uygulaması</h1>
          <br />
          <p>Hayatınızı düzenlemek için harika bir yol!</p>
          <p>Bu uygulama ile yapılacaklarınızı yönetebilir, görevleri ekleyebilir, işaretleyebilir ve silebilirsiniz.</p>
          <p>Başlayın ve daha organize bir yaşam tarzı oluşturun!</p>
        </div>
      </React.Fragment>
    )
  }
}
