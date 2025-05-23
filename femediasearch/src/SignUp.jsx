import React, { useState } from 'react';
import './SignUp.css';
import config from './variable';

const SignUp = ({setPage}) => {
    const [username, setUsername] = useState('');
    const [fullname, setFullname] = useState('');
    const [password, setPassword] = useState('');
    const [message, setMessage] = useState('');
    const [error, setError] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        setMessage('');
        setError('');
        if (!username || !fullname || !password) {
            setError('All fields are required.');
            return;
        }

        try {
            const response = await fetch(`${config.url}/api/openverse/v1/auth/register`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ username, fullName: fullname, password }),
            });

            const data = await response.text();

            if (!response.ok) {
                setError(data); // Display error message from backend
                return;
            }

            alert(data); // Display success message from backend
            setUsername('');
            setFullname('');
            setPassword('');
            setPage('login')
        } catch (err) {
            setError(err.message || 'An error occurred.');
        }
    };

    return (
        <div className="signup-container">
            <h1 className="signup-title">Sign Up</h1>
            <form onSubmit={handleSubmit} className="signup-form">
                <div className="form-group">
                    <label htmlFor="username">Username</label>
                    <input
                        type="text"
                        id="username"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        placeholder="Enter your username"
                        required
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="fullname">Full Name</label>
                    <input
                        type="text"
                        id="fullname"
                        value={fullname}
                        onChange={(e) => setFullname(e.target.value)}
                        placeholder="Enter your full name"
                        required
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="password">Password</label>
                    <input
                        type="password"
                        id="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        placeholder="Enter your password"
                        required
                    />
                </div>
                <button type="submit" className="signup-button">Sign Up</button>
            </form>
            {message && <p className="success-message">{message}</p>}
            {error && <p className="error-message">{error}</p>}
        </div>
    );
};

export default SignUp;