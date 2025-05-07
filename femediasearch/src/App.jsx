import {use, useState} from 'react';
import './App.css';
import Images from './Images';
import Audios from './Audio';
import Layout from './Layout';
import SignUp from './SignUp';
import LogIn from './LogIn';
import Header from './Header';
import Footer from './Footer';
import config from './variable';

function App() {
    const [page, setPage] = useState('home');
    const [localUsername,setUsername] = useState('')
    const token = localStorage.getItem("token")
    const fetchUserName = async() => {
        try {
            const response = await fetch(`${config.url}/api/openverse/v1/current-user`, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${token}`
                },
            });

            if (!response.ok) {
                const errorText = await response.text();
                setError(errorText);
                return;
            } else {
                const {username} = await response.json()
                setUsername(username)
                localStorage.setItem('username',username)
            }
        } catch (err) {
            setError(err.message || 'An error occurred.');
        }
    }
    if(token){
        fetchUserName()
    }
    let content;
    if (page === 'images') {
        content = <Images/>;
    } else if (page === 'audios') {
        content = <Audios/>;
    } else if (page === 'signup') {
        content = <SignUp setPage={setPage}/>;
    } else if (page === 'login') {
        content = <LogIn setPage={setPage}/>;
    } else {
        content = (
            <div
                className="main-page"
                style={{backgroundImage: "url('https://source.unsplash.com/random/1920x1080?technology')"}}
            >
                <div className="main-text">
                    <h1>Welcome to Media Search </h1>
                </div>
            </div>
        );
    }

    return <Layout setPage={setPage}><Header setUsername={setUsername} username={localUsername} page={page} setPage={setPage}/>{content}<Footer/></Layout>;
}

export default App;