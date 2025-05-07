import React, {useEffect, useRef, useState} from 'react';
import './Audio.css';
import config from './variable';

const LOCAL_STORAGE_KEY = 'recent_audio_searches';

const Audios = () => {
    const [query, setQuery] = useState('');
    const [lastSearchedQuery, setLastSearchedQuery] = useState('');
    const [audios, setAudios] = useState([]);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);
    const [page, setPage] = useState(1);
    const [totalPages, setTotalPages] = useState(1);
    const [recentSearches, setRecentSearches] = useState([]);
    const [showDropdown, setShowDropdown] = useState(false);
    const inputRef = useRef(null);
    const [username,setUsername] = useState('')


    useEffect(() => {
        let storedSearches = [];
        if(username) storedSearches = JSON.parse(localStorage.getItem(username + LOCAL_STORAGE_KEY)) || [];
        setRecentSearches(storedSearches);
    }, []);

    useEffect(() => {
        const handleClickOutside = (event) => {
            if (inputRef.current && !inputRef.current.contains(event.target)) {
                setShowDropdown(false);
            }
        };
        document.addEventListener('mousedown', handleClickOutside);
        return () => {
            document.removeEventListener('mousedown', handleClickOutside);
        };
    }, []);

    const updateRecentSearches = (term) => {
        const updated = [term, ...recentSearches.filter((t) => t !== term)].slice(0, 5);
        setRecentSearches(updated);
        username && localStorage.setItem(username + LOCAL_STORAGE_KEY, JSON.stringify(updated));
    };

    const deleteSearchTerm = (term) => {
        const updated = recentSearches.filter((t) => t !== term);
        setRecentSearches(updated);
        username && localStorage.setItem(username + LOCAL_STORAGE_KEY, JSON.stringify(updated));
    };

    const fetchAudios = async (q = query, pg = page) => {
        setLoading(true);
        setError(null);
        try {
            const searchParam = q ? `q=${encodeURIComponent(q)}&` : '';
            const res = await fetch(`${config.url}/api/openverse/v1/audios?${searchParam}page=${pg}`);
            if (!res.ok) throw new Error('Failed to fetch audios');
            const data = await res.json();
            setAudios(data.results || []);
            setTotalPages(data.page_count || 1);
        } catch (err) {
            setError(err.message);
        } finally {
            setLoading(false);
        }
    };


    const handleSearch = (e) => {
        e.preventDefault();
        setUsername(localStorage.getItem("username"))
        if(query) {
            setPage(1);
            setLastSearchedQuery(query);
            updateRecentSearches(query);
            fetchAudios(query, 1);
            setShowDropdown(false);
        };
    };

    const handleRecentClick = (term) => {
        setQuery(term);
        setPage(1);
        setLastSearchedQuery(term);
        fetchAudios(term, 1);
        setShowDropdown(false);
    };

    const handleClearSearches = () => {
        localStorage.removeItem(username + LOCAL_STORAGE_KEY);
        setRecentSearches([]);
    };

    useEffect(() => {
        fetchAudios();
    }, [page]);

    return (
        <div className="images-container">
            <h1 className="images-title">Audio Search</h1>
            <form onSubmit={handleSearch} className="images-form" ref={inputRef}>
                <div className="search-wrapper">
                    <input
                        type="text"
                        placeholder="Search for audios..."
                        value={query}
                        onChange={(e) => setQuery(e.target.value)}
                        onFocus={() => setShowDropdown(true)}
                        className="images-input"
                    />
                    {showDropdown && recentSearches.length > 0 && (
                        <div onClick={()=>{
                            console.log(recentSearches)
                        }} className="dropdown">
                            {recentSearches.map((term, idx) => (
                                <div key={idx} className="dropdown-item-wrapper">
                                    <div
                                        className="dropdown-item"
                                        onClick={() => handleRecentClick(term)}
                                    >
                                        {term}
                                    </div>
                                    <button
                                        className="dropdown-delete"
                                        onClick={(e) => {
                                            e.stopPropagation();
                                            deleteSearchTerm(term);
                                        }}
                                    >×
                                    </button>
                                </div>
                            ))}
                            <div className="dropdown-clear" onClick={handleClearSearches}>Clear All</div>
                        </div>
                    )}
                </div>
                <button type="submit" className="images-button">
                    Search
                </button>
            </form>

            {loading && <p className="images-status">Loading...</p>}
            {error && <p className="images-error">{error}</p>}

            <div className="images-grid">
                {audios.map((audio) => (
                    <div key={audio.id} className="image-card">
                        <img src={audio.thumbnail} alt={audio.title || 'Audio Thumbnail'} className="audio-thumbnail"/>
                        <div className="image-details">
                            <h2 className="image-title">{audio.title || 'Untitled'}</h2>
                            <audio controls>
                                <source src={audio.url} type="audio/mpeg"/>
                                Your browser does not support the audio element.
                            </audio>
                        </div>
                    </div>
                ))}
            </div>

            {totalPages > 1 && (
                <div className="pagination">
                    <button
                        onClick={() => setPage((prev) => Math.max(prev - 1, 1))}
                        disabled={page === 1}
                    >
                        Previous
                    </button>
                    <span>Page {page} of {totalPages}</span>
                    <button
                        onClick={() => setPage((prev) => Math.min(prev + 1, totalPages))}
                        disabled={page === totalPages}
                    >
                        Next
                    </button>
                </div>
            )}
        </div>
    );
};

export default Audios;
