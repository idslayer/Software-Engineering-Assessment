import { useState } from 'react';
import './App.css';
import Images from './Images'; // Make sure this file exists in src/

function App() {
  const [page, setPage] = useState('home'); // 'home' or 'images'

  const handleSignIn = () => {
    console.log('Sign In clicked');
  };

  const handleSignUp = () => {
    console.log('Sign Up clicked');
  };

  if (page === 'images') {
    return <Images />;
  }

  return (
    <div className="min-h-screen flex items-center justify-center bg-gray-100">
      <div className="text-center space-y-6">
        <h1 className="text-3xl font-bold">Welcome</h1>
        <div className="space-x-4">
          <button
            className="px-6 py-2 bg-blue-600 text-white rounded-lg hover:bg-blue-700"
            onClick={handleSignIn}
          >
            Sign In
          </button>
          <button
            className="px-6 py-2 bg-green-600 text-white rounded-lg hover:bg-green-700"
            onClick={handleSignUp}
          >
            Sign Up
          </button>
          <button
            className="px-6 py-2 bg-purple-600 text-white rounded-lg hover:bg-purple-700"
            onClick={() => setPage('images')}
          >
            Images
          </button>
        </div>
      </div>
    </div>
  );
}

export default App;
