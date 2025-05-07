import React, { useEffect, useState } from 'react';
import './Layout.css';
import logo from './logo.jpeg';

const Header = ({username,setUsername, page,setPage }) => {
    const logoutUser = () => {
        localStorage.removeItem("username")
        localStorage.removeItem("token")
        setUsername('')
        setPage("login")
    }
    const checknavigate = (path) => {
        if(username){setPage(path)}  else {
            alert("You need to login to use this feature")
        }
    }
    return (
        <header className="header">
            <div className="header-content">
                <div className="header-logo" onClick={() => setPage('home')}>
                    <img src={logo} alt="Logo" />
                </div>
                <nav className="header-nav">
                    <button className="header-link" onClick={() => setPage('home')}>Home</button>
                    <button className="header-link" onClick={() => checknavigate('images')}>Images</button>
                    <button className="header-link" onClick={() => checknavigate('audios')}>Audios</button>
                    {username ? <><button className="header-link">{username}</button> 
                    <button className="header-link login-button" onClick={() => logoutUser()}>Logout</button></>
                     : 
                     <><button className="header-link signup-button" onClick={() => setPage('signup')}>Sign Up</button>
                        <button className="header-link login-button" onClick={() => setPage('login')}>Login</button></>}
                </nav>
            </div>
        </header>
    )
}


export default Header;