import React from 'react';
import { makeStyles } from '@material-ui/core/styles';

const useStyles = makeStyles((theme) => ({
    gutteredContainer: {
        ...theme.mixins.gutters()
    }
}));

const ContainerWithGutter = (props: any) => {
    const classes = useStyles();
    return (
        <div>
            <div className={classes.gutteredContainer}>{props.children}</div>
        </div>
    );
};

export default ContainerWithGutter;
