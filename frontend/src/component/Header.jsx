
// rcc
import React, { Component } from 'react'

// I18N
import { withTranslation } from 'react-i18next';

// ROUTER
import { Link } from 'react-router-dom';

// Language
import OtherLanguageServices from "../internationalization/OtherLanguageServices";



// CLASS COMPONENT
class Header extends Component {

    // Component görünen ismi
    static displayName = "Blog_Header";

    // Constructor
    constructor(props) {
        super(props);

        // STATE
        this.state = {}

        // BIND
    } //end constructor

    // CDM

    // FUNCTION

    //Bayraklar
    internationalizationLanguage = language => {
        const { i18n } = this.props;
        i18n.changeLanguage(language);

        //Hem java tarafından hemde frontend tarafından değişiklik yaptık.
        OtherLanguageServices.headerLanguageServices(language);
    }

    //RENDER
    render() {

        //RETURN
        return (
            <React.Fragment>
                <nav className="navbar navbar-expand-md navbar-light bg-light">
                    <div className="container">
                        <Link className="navbar-brand" to="/"> <i className={this.props.logo}></i></Link>
                        <button
                            className="navbar-toggler d-lg-none"
                            type="button"
                            data-bs-toggle="collapse"
                            data-bs-target="#collapsibleNavId"
                            aria-controls="collapsibleNavId"
                            aria-expanded="false"
                            aria-label="Toggle navigation"
                        >
                            <span className="navbar-toggler-icon" />
                        </button>
                        <div className="collapse navbar-collapse" id="collapsibleNavId">
                            <ul className="navbar-nav me-auto mt-2 mt-lg-0">
                                <li className="nav-item">
                                    {/* <a className="nav-link active" href="#" aria-current="page">
                                        Home <span className="visually-hidden">(current)</span>
                                    </a> */}
                                </li>
                                <li className="nav-item">
                                    <a className="nav-link" href="/task/list">
                                        Görev Listesi
                                    </a>
                                    
                                </li>
                                <li className="nav-item dropdown">
                                    <a
                                        className="nav-link dropdown-toggle"
                                        href="#"
                                        id="dropdownId"
                                        data-bs-toggle="dropdown"
                                        aria-haspopup="true"
                                        aria-expanded="false"
                                    >
                                        Dil
                                    </a>
                                    <div className="dropdown-menu" aria-labelledby="dropdownId">
                                        <a className="dropdown-item" href="#" onClick={() => this.internationalizationLanguage('tr')}>
                                            TR
                                        </a>
                                        <a className="dropdown-item" href="#" onClick={() => this.internationalizationLanguage('en')}>
                                            EN
                                        </a>
                                    </div>
                                </li>
                            </ul>

                        </div>
                    </div>
                </nav>

            </React.Fragment>
        ) //end return
    } //end render
} //end class

// Higher Order Component
export default withTranslation()(Header);
