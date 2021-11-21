import React, { useState } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import { Grid, Typography } from '@material-ui/core';
import LibraryBooksIcon from '@material-ui/icons/LibraryBooks';
import BookInfoDialog from './BookInfoDialog';
import BookCard from './BookCard';
import { Book } from '../models/book';

const useStyles = makeStyles((theme) => ({
    sectionHeading: {
        marginTop: 20,
        marginBottom: 20
    },
    bookContainer: {
        // background: '#f5f5f7',
        padding: 5
    },
    itemIcon: {
        paddingRight: 10,
        paddingTop: 5,
        float: 'left',
        color: theme.palette.secondary.main
    }
}));

const BookShelf = (props: any) => {
    const classes = useStyles();
    const [bookInfoDialogOpen, setBookInfoDialogOpen] = useState(false);
    const [book, setBook] = useState<Book>({
        title: '',
        authors: [],
        tags: [],
        isbn: ''
    });

    const books: Book[] = props.books;

    const openBookInfoDialog = (book: Book) => {
        setBookInfoDialogOpen(true);
        setBook(book);
    };

    const handleBookInfoDialogClose = () => {
        setBookInfoDialogOpen(false);
    };

    const renderBooks = () => {
        return books.map((book, i) => {
            return (
                <Grid item xs={6} md={3} lg={2}>
                    <BookCard
                        key={i}
                        book={book}
                        readMore={openBookInfoDialog}
                    />
                </Grid>
            );
        });
    };

    return (
        <>
            <div className={classes.itemIcon}>
                <LibraryBooksIcon />
            </div>
            <Typography
                className={classes.sectionHeading}
                variant="h5"
                color="primary">
                {props.name}
            </Typography>

            <Grid container className={classes.bookContainer} spacing={2}>
                {renderBooks()}
            </Grid>
            <BookInfoDialog
                open={bookInfoDialogOpen}
                handleClose={handleBookInfoDialogClose}
                book={book}
            />
        </>
    );
};

export default BookShelf;
