
// rcc
import React, { Component } from 'react'

// I18N
import { withTranslation } from 'react-i18next';

// Footer Css
import './footer.css';

// CLASS COMPONENT
class Footer extends Component {

    // Component görünen ismi
    static displayName = "Blog_Footer";

    // Constructor
    constructor(props) {
        super(props);

        // STATE
        this.state = {}

        // BIND
    } //end constructor

    // CDM

    // FUNCTION

    //RENDER
    render() {

        //RETURN
        return (
            <React.Fragment>
                <footer className='footer'>
  {/* Grid container */}

  {/* Grid container */}
  {/* Copyright */}
  <div
    className="text-center text-dark p-3"
    style={{ backgroundColor: "rgba(0, 0, 0, 0.2)" }}
  >
    {/* © 2020 Copyright: */}
    {this.props.copy}
    <a className="text-white" style={{ backgroundColor: "rgba(0, 0, 0, 0.7)" }}  href="https://google.com/">
      ToDoList
    </a>
  </div>
  {/* Copyright */}
</footer>

            </React.Fragment>
        ) //end return
    } //end render
} //end class

// Higher Order Component
export default withTranslation()(Footer);
