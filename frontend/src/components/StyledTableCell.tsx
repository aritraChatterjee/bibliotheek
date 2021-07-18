import { createStyles, TableCell } from '@material-ui/core';
import { withStyles } from '@material-ui/styles';

const StyledTableCell = withStyles(() =>
    createStyles({
        head: {
            fontWeight: 700
        },
        body: {
            fontSize: 14
        }
    })
)(TableCell);

export default StyledTableCell;
