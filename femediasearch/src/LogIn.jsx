import React, { useState } from 'react';
import config from './variable';

const LogIn = ({setPage}) => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const setToken = (token) => {
        localStorage.setItem('token',token)
    }
    const handleSubmit = async (e) => {
        e.preventDefault();
        setError('');

        if (!username || !password) {
            setError('Both fields are required.');
            return;
        }

        try {
            const response = await fetch(`${config.url}/api/openverse/v1/auth/login`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                    // 'Authorization': `Bearer ${token}`
                },
                body: JSON.stringify({ username, password }),
            });

            if (!response.ok) {
                const errorText = await response.text();
                setError(errorText);
                return;
            }
            alert('Login Success !!!')
            const { token } = await response.json();
            setToken(token); // Pass the token to the parent component or store it
            setPage('images')
        } catch (err) {
            setError(err.message || 'An error occurred.');
        }
    };

    return (
        <div className="login-container">
            <h1>Login</h1>
            <form onSubmit={handleSubmit}>
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
                <button type="submit">Login</button>
            </form>
            {error && <p className="error-message">{error}</p>}
        </div>
    );
};

export default LogIn;