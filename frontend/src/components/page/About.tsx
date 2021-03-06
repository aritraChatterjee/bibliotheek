import React from 'react';
import { Container, Typography } from '@material-ui/core';
import ContainerWithGutter from './ContainerWithGutter';
import { makeStyles } from '@material-ui/core/styles';

const useStyles = makeStyles((theme) => ({
    skills: {
        marginTop: 20
    }
}));

const Home = (props: any) => {
    const classes = useStyles();
    return (
        <Container fixed>
            <ContainerWithGutter>
                <Typography variant="h4" align="center">
                    bibliotheek is a library management app built using
                </Typography>
                <Typography
                    variant="h5"
                    color="secondary"
                    align="center"
                    className={classes.skills}>
                    Spring boot - Hibernate - React - Material UI
                </Typography>
                <br />
                <Typography variant="overline" display="block" align="center">
                    version 0.1.0
                </Typography>
            </ContainerWithGutter>
        </Container>
    );
};

export default Home;
