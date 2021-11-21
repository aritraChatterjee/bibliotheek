import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import {
    Button,
    Dialog,
    DialogActions,
    DialogContent,
    DialogTitle,
    Table,
    TableBody,
    TableHead,
    TableRow
} from '@material-ui/core';
import BookIcon from '@material-ui/icons/Book';
import CloseIcon from '@material-ui/icons/Close';
import StyledTableCell from './StyledTableCell';
import StyledTableRow from './StyledTableRow';

const useStyles = makeStyles((theme) => ({
    dialogBody: {
        borderRadius: 0
    },
    bookIcon: {
        paddingRight: 10,
        paddingTop: 5,
        float: 'left',
        color: theme.palette.secondary.main
    },
    table: {
        minWidth: 400
    },
    dialogActions: {
        justifyContent: 'center'
    }
}));

const BookInfoDialog = (props: any) => {
    const classes = useStyles();

    const renderDialogContent = () => {
        return (
            <Table
                className={classes.table}
                size="small"
                aria-label="a customized table">
                <TableHead>
                    <TableRow>
                        <StyledTableCell>Title</StyledTableCell>
                        <StyledTableCell align="right">
                            {props.book.title}
                        </StyledTableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    <StyledTableRow>
                        <StyledTableCell>Authors</StyledTableCell>
                        <StyledTableCell align="right">
                            {renderAuthors()}
                        </StyledTableCell>
                    </StyledTableRow>
                    <StyledTableRow>
                        <StyledTableCell>Tags</StyledTableCell>
                        <StyledTableCell align="right">
                            {renderTags()}
                        </StyledTableCell>
                    </StyledTableRow>
                    <StyledTableRow>
                        <StyledTableCell>ISBN</StyledTableCell>
                        <StyledTableCell align="right">
                            {props.book.isbn}
                        </StyledTableCell>
                    </StyledTableRow>
                </TableBody>
            </Table>
        );
    };

    const renderAuthors = () => {
        const authors: string[] = props.book.authors;
        return authors.map((item, i) => {
            if (i === 0) {
                return item;
            }
            return ',' + item;
        });
    };

    const renderTags = () => {
        const authors: string[] = props.book.tags;
        return authors.map((item, i) => {
            if (i === 0) {
                return item;
            }
            return ', ' + item;
        });
    };

    return (
        <>
            <Dialog
                PaperProps={{
                    classes: { root: classes.dialogBody }
                }}
                onClose={props.handleClose}
                aria-labelledby="customized-dialog-title"
                open={props.open}>
                <DialogTitle id="customized-dialog-title">
                    <BookIcon className={classes.bookIcon} />
                    Book Info
                </DialogTitle>
                <DialogContent dividers>{renderDialogContent()}</DialogContent>
                <DialogActions className={classes.dialogActions}>
                    <Button
                        variant={'contained'}
                        color={'primary'}
                        autoFocus
                        onClick={props.handleClose}>
                        Close
                    </Button>
                    <Button
                        variant={'contained'}
                        color={'primary'}
                        onClick={props.handleClose}>
                        Borrow
                    </Button>
                    <Button
                        variant={'contained'}
                        color={'primary'}
                        onClick={props.handleClose}>
                        Add to Wishlist
                    </Button>
                </DialogActions>
            </Dialog>
        </>
    );
};

export default BookInfoDialog;
