import React from 'react';
import { Container } from '@material-ui/core';
import ContainerWithGutter from './ContainerWithGutter';
import { makeStyles } from '@material-ui/core/styles';

const useStyles = makeStyles((theme) => ({
    skills: {
        marginTop: 20
    }
}));

const Home = (props: any) => {
    return (
        <Container fixed>
            <ContainerWithGutter></ContainerWithGutter>
        </Container>
    );
};

export default Home;
