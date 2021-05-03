import React from 'react';
import { Button, Container, Typography } from '@material-ui/core';
import ContainerWithGutter from './ContainerWithGutter';
import { makeStyles } from '@material-ui/core/styles';

const useStyles = makeStyles((theme) => ({
    skills: {
        marginTop: 20
    }
}));

const About = (props: any) => {
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
                    <Button
                        variant={'contained'}
                        color={'primary'}
                        qa-attr="button-hello">
                        Hello
                    </Button>
                    <Button
                        variant={'contained'}
                        color={'secondary'}
                        qa-attr="button-world">
                        World
                    </Button>
                </Typography>
            </ContainerWithGutter>
        </Container>
    );
};

export default About;
