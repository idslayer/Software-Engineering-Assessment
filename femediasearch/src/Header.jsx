import React from 'react';
import './Layout.css';
import logo from './logo.jpeg';
const Header = ({ setPage }) => (
    <header className="header">
        <div className="header-content">
            <div className="header-logo" onClick={() => setPage('home')}>
                <img src={logo} alt="Logo" />
            </div>
            <nav className="header-nav">
                <button className="header-link" onClick={() => setPage('home')}>Home</button>
                <button className="header-link" onClick={() => setPage('images')}>Images</button>
                <button className="header-link" onClick={() => setPage('audios')}>Audios</button>
                <button className="header-link signup-button" onClick={() => setPage('signup')}>Sign Up</button>
            </nav>
        </div>
    </header>
);

export default Header;