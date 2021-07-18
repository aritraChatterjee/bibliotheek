import { TableRow, Theme } from '@material-ui/core';
import { createStyles, withStyles } from '@material-ui/styles';

const StyledTableRow = withStyles((theme: Theme) =>
    createStyles({
        root: {
            '&:nth-of-type(odd)': {
                backgroundColor: theme.palette.action.hover
            }
        }
    })
)(TableRow);

export default StyledTableRow;
