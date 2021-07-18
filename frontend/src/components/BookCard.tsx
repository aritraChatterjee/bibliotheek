import React from 'react';
import { makeStyles, Theme, withStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Typography from '@material-ui/core/Typography';
import { Chip, Tooltip } from '@material-ui/core';
import { Button } from '@material-ui/core';
import InfoIcon from '@material-ui/icons/InfoOutlined';
import PeopleIcon from '@material-ui/icons/People';
import PersonIcon from '@material-ui/icons/Person';

const useStyles = makeStyles({
    root: {
        width: 250,
        margin: 10,
        height: 170,
        borderRadius: 8,
        borderWidth: 0,
        float: 'left'
    },
    title: {
        fontSize: 16,
        fontWeight: 700,
        marginBottom: 5
    },
    content: {
        height: 100
    },
    actions: {
        height: 30
    },
    pos: {
        fontSize: 14
    },
    authors: {
        height: 20,
        marginBottom: 5
    },
    tag: {
        margin: 3
    },
    authorIcon: {
        float: 'right'
    }
});

const CardTooltip = withStyles((theme: Theme) => ({
    tooltip: {
        backgroundColor: theme.palette.primary.light,
        fontSize: 14
    }
}))(Tooltip);

const BookCard = (props: any): JSX.Element => {
    const classes = useStyles();

    const handleReadMore = () => {
        props.readMore(props.book);
    };

    return (
        <Card className={classes.root}>
            <CardContent className={classes.content}>
                <CardTooltip title={props.book.title}>
                    <Typography
                        className={classes.title}
                        noWrap
                        variant="h6"
                        component="h2">
                        {props.book.title}
                    </Typography>
                </CardTooltip>
                <Authors authors={props.book.authors} />
                <Tags tags={props.book.tags} />
            </CardContent>
            <CardActions className={classes.actions}>
                <Button
                    variant={'contained'}
                    color={'primary'}
                    size={'small'}
                    startIcon={<InfoIcon />}
                    onClick={handleReadMore}>
                    Learn more
                </Button>
            </CardActions>
        </Card>
    );
};

const Authors = (props: any): JSX.Element => {
    const classes = useStyles();
    const authors: string[] = props.authors;
    return (
        <div className={classes.authors}>
            {authors.length > 1 ? (
                <CardTooltip title={'This book has mutiple authors'}>
                    <PeopleIcon className={classes.authorIcon} />
                </CardTooltip>
            ) : (
                <CardTooltip title={'This book has one author'}>
                    <PersonIcon className={classes.authorIcon} />
                </CardTooltip>
            )}
            <Typography className={classes.pos} color="textSecondary">
                {authors[0]}
            </Typography>
        </div>
    );
};

const Tags = (props: any): JSX.Element => {
    const classes = useStyles();
    const tags: string[] = props.tags;

    const handleClick = () => {
        console.log('in handleClick');
    };

    return (
        <>
            {tags.map((item, i) => {
                return (
                    <Chip
                        className={classes.tag}
                        size="small"
                        key={i}
                        label={item}
                        color="secondary"
                        onClick={handleClick}
                    />
                );
            })}
        </>
    );
};

export default BookCard;
