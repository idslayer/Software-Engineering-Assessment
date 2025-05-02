import {useState} from 'react';
import './App.css';
import Images from './Images';
import Audios from './Audio';
import Layout from './Layout';
import SignUp from './SignUp';

function App() {
    const [page, setPage] = useState('home');

    let content;
    if (page === 'images') {
        content = <Images/>;
    } else if (page === 'audios') {
        content = <Audios/>;
    } else if (page === 'signup') {
        content = <SignUp/>;
    } else {
        content = (
            <div
                className="min-h-screen flex items-center justify-center bg-cover bg-center"
                style={{backgroundImage: "url('https://source.unsplash.com/random/1920x1080?technology')"}}
            >
                <div className="text-center space-y-6 bg-white bg-opacity-80 p-8 rounded-lg shadow-lg">
                    <h1 className="text-4xl font-extrabold text-gray-800">Welcome to Media Search EDITED</h1>
                    <audio controls className="mt-4">
                        <source src="https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3" type="audio/mpeg"/>
                        Your browser does not support the audio element.
                    </audio>
                    <div className="space-x-4 mt-6">
                        <button
                            className="px-6 py-2 bg-blue-600 text-white rounded-lg hover:bg-blue-700"
                            onClick={() => setPage('images')}
                        >
                            Images
                        </button>
                        <button
                            className="px-6 py-2 bg-purple-600 text-white rounded-lg hover:bg-purple-700"
                            onClick={() => setPage('audios')}
                        >
                            Audios
                        </button>
                    </div>
                </div>
            </div>
        );
    }

    return <Layout setPage={setPage}>{content}</Layout>;
}

export default App;