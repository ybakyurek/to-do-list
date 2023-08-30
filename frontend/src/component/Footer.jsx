
//rcc
import React, { Component } from 'react'


// I18N
import { withTranslation } from 'react-i18next';

//footer css
import "./footer.css" ;


//CLASS COMPONENT
class Footer extends Component {

    //Component gorunen ismi
    static displayName = "Task_Footer";

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
                <footer>
  {/* Grid container */}
  <div className="container pt-4">
    {/* Section: Social media */}
    <section className="mb-4">
      {/* Facebook */}
      <a
        className="btn btn-link btn-floating btn-lg text-dark m-1"
        href="#!"
        role="button"
        data-mdb-ripple-color="dark"
      >
        <i className="fab fa-facebook-f" />
      </a>
      {/* Twitter */}
      <a
        className="btn btn-link btn-floating btn-lg text-dark m-1"
        href="#!"
        role="button"
        data-mdb-ripple-color="dark"
      >
        <i className="fab fa-twitter" />
      </a>
      {/* Google */}
      <a
        className="btn btn-link btn-floating btn-lg text-dark m-1"
        href="#!"
        role="button"
        data-mdb-ripple-color="dark"
      >
        <i className="fab fa-google" />
      </a>
      {/* Instagram */}
      <a
        className="btn btn-link btn-floating btn-lg text-dark m-1"
        href="#!"
        role="button"
        data-mdb-ripple-color="dark"
      >
        <i className="fab fa-instagram" />
      </a>
      {/* Linkedin */}
      <a
        className="btn btn-link btn-floating btn-lg text-dark m-1"
        href="#!"
        role="button"
        data-mdb-ripple-color="dark"
      >
        <i className="fab fa-linkedin" />
      </a>
      {/* Github */}
      <a
        className="btn btn-link btn-floating btn-lg text-dark m-1"
        href="#!"
        role="button"
        data-mdb-ripple-color="dark"
      >
        <i className="fab fa-github" />
      </a>
    </section>
    {/* Section: Social media */}
  </div>
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
        )
    }
}

// Higher Order Component
export default withTranslation()(Footer);