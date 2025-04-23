import React from 'react';
import Header from './Header';
import Footer from './Footer';

const Layout = ({children, setPage}) => (
    <>
        <Header setPage={setPage}/>
        <main className="main-content">{children}</main>
        <Footer/>
    </>
);

export default Layout;