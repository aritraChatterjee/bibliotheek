import { ThemeProvider } from '@material-ui/core';
import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import theme from './Theme';
import Header from './components/page/Header';
import Footer from './components/page/Footer';
import About from './components/page/About';
import Home from './components/page/Home';

function App() {
    return (
        <ThemeProvider theme={theme}>
            <BrowserRouter>
                <Header />
                <Switch>
                    <Route exact path="/" component={About} />
                    <Route exact path="/home" component={Home} />
                    <Route exact path="/about" component={About} />
                </Switch>
            </BrowserRouter>

            <Footer />
        </ThemeProvider>
    );
}

export default App;
