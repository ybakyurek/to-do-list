import React, { Component } from 'react'
import { Link } from 'react-router-dom'
import './main.css';
import mountain from "../img/pngwing.com-2.png";


export default class Main extends Component {
  render() {
    return (
      <React.Fragment >

        {/* <h1 className="display-3">Ana Sayfa</h1>
         <Link className="btn btn-primary mt-5 mb-5" to="task/list">Task - List</Link> */}
        <div className="home-container">
          <h1>TODO</h1>
          <br />
          <p>Hayatınızı düzenlemek için harika bir yol!</p>
          <p>Bu uygulama ile yapılacaklarınızı yönetebilir, görevleri ekleyebilir, işaretleyebilir ve silebilirsiniz.</p>
          <p>Başlayın ve daha organize bir yaşam tarzı oluşturun!</p>
          {/* <img src={mountain} alt="" /> */}
          <img src={mountain} alt="" style={{width: 80,height: 80}} />
        <Link className="btn btn-primary mt-5 mb-5" to="task/list">Görev Listesi İçin Tıklayınız</Link>
          
        </div>

      </React.Fragment>
    )
  }
}
