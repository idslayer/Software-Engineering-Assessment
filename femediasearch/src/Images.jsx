import React, {useEffect, useRef, useState} from 'react';
import './Images.css';

const LOCAL_STORAGE_KEY = 'recent_searches';

const Images = () => {
    const [query, setQuery] = useState('');
    const [images, setImages] = useState([]);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);
    const [page, setPage] = useState(1);
    const [totalPages, setTotalPages] = useState(1);
    const [recentSearches, setRecentSearches] = useState([]);
    const [showDropdown, setShowDropdown] = useState(false);
    const inputRef = useRef(null);

    useEffect(() => {
        const storedSearches = JSON.parse(localStorage.getItem(LOCAL_STORAGE_KEY)) || [];
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
        localStorage.setItem(LOCAL_STORAGE_KEY, JSON.stringify(updated));
    };

    const deleteSearchTerm = (term) => {
        const updated = recentSearches.filter((t) => t !== term);
        setRecentSearches(updated);
        localStorage.setItem(LOCAL_STORAGE_KEY, JSON.stringify(updated));
    };

    const fetchImages = async () => {
        setLoading(true);
        setError(null);
        try {
            const res = await fetch(`http://localhost:8080/api/openverse/v1/images?q=${encodeURIComponent(query)}&page=${page}`);
            if (!res.ok) throw new Error('Failed to fetch images');
            const data = await res.json();
            setImages(data.results || []);
            setTotalPages(data.page_count || 1);
        } catch (err) {
            setError(err.message);
        } finally {
            setLoading(false);
        }
    };

    const handleSearch = (e) => {
        e.preventDefault();
        setPage(1);
        updateRecentSearches(query);
        fetchImages();
        setShowDropdown(false);
    };

    const handleRecentClick = (term) => {
        setQuery(term);
        setPage(1);
        fetchImages();
        setShowDropdown(false);
    };

    const handleClearSearches = () => {
        localStorage.removeItem(LOCAL_STORAGE_KEY);
        setRecentSearches([]);
    };

    useEffect(() => {
        if (query) {
            fetchImages();
        }
    }, [page]);

    return (
        <div className="images-container">
            <h1 className="images-title">Image Search</h1>
            <form onSubmit={handleSearch} className="images-form" ref={inputRef}>
                <div className="search-wrapper">
                    <input
                        type="text"
                        placeholder="Search for images..."
                        value={query}
                        onChange={(e) => setQuery(e.target.value)}
                        onFocus={() => setShowDropdown(true)}
                        className="images-input"
                    />
                    {showDropdown && recentSearches.length > 0 && (
                        <div className="dropdown">
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
                {images.map((image) => (
                    <div key={image.id} className="image-card">
                        <img src={image.url} alt={image.title} className="image-thumb"/>
                        <div className="image-details">
                            <h2 className="image-title">{image.title}</h2>
                            <p className="image-creator">
                                By: <a href={image.creator_url} target="_blank" rel="noreferrer">{image.creator}</a>
                            </p>
                            <a href={image.foreign_landing_url} target="_blank" rel="noreferrer" className="image-link">
                                View on source
                            </a>
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

export default Images;