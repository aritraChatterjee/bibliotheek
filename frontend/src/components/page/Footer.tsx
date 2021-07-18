import React from 'react';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faReact } from '@fortawesome/free-brands-svg-icons/faReact';

import Container from '@material-ui/core/Container';
import Link from '@material-ui/core/Link';

import Tooltip from '@material-ui/core/Tooltip';

const useStyles = makeStyles((theme) => ({
    footer: {
        top: 'auto',
        bottom: 0,
        margin: '20px auto'
    },
    buildText: {
        fontSize: 12,
        fontWeight: 700
    },
    reactIcon: {
        fontSize: 30,
        color: '#0AAB8B'
    }
}));

const Footer = () => {
    const classes = useStyles();
    return (
        <AppBar
            position="fixed"
            color="default"
            elevation={0}
            className={classes.footer}>
            <Container fixed>
                <Typography
                    align="center"
                    className={classes.buildText}
                    gutterBottom={true}>
                    This website is built with{' '}
                    <Tooltip title="React">
                        <Link
                            href="https://reactjs.org/"
                            target="_blank"
                            underline="none">
                            <FontAwesomeIcon
                                className={classes.reactIcon}
                                icon={faReact}
                            />
                        </Link>
                    </Tooltip>
                    and maintained by &nbsp;
                    <Link href="#" target="_blank" underline="none">
                        codesandwires.com
                    </Link>
                </Typography>
            </Container>
        </AppBar>
    );
};

export default Footer;
