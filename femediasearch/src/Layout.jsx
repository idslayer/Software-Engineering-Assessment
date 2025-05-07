import React from 'react';
import Header from './Header';
import Footer from './Footer';

const Layout = ({children, setPage}) => (
    <>
        <main className="main-content">{children}</main>
    </>
);

export default Layout;