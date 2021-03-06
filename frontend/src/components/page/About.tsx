import React from 'react';
import { Button, Container, Typography } from '@material-ui/core';
import ContainerWithGutter from './ContainerWithGutter';
import { makeStyles } from '@material-ui/core/styles';
import { MoodBadSharp } from '@material-ui/icons';

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
                    Spring boot - Hibernate - React
                    <br />
                    <br />
                    <Button variant={'contained'} color={'primary'}>
                        Hello
                    </Button>
                    <Button variant={'contained'} color={'secondary'}>
                        World
                    </Button>
                </Typography>
            </ContainerWithGutter>
        </Container>
    );
};

export default Home;
