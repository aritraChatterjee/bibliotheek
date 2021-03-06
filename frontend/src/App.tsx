import { ThemeProvider } from '@material-ui/core';
import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import theme from './Theme';
import Header from './components/Header';
import Footer from './components/Footer';
import About from './components/About';

function App() {
    return (
        <ThemeProvider theme={theme}>
            <BrowserRouter>
                <Header />
                <Switch>
                    <Route exact path="/" component={About} />
                    <Route exact path="/about" component={About} />
                </Switch>
            </BrowserRouter>

            <Footer />
        </ThemeProvider>
    );
}

export default App;
