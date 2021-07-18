import AppBar from '@material-ui/core/AppBar';
import { makeStyles } from '@material-ui/core/styles';
import Typography from '@material-ui/core/Typography';
import React from 'react';
import Drawer from '@material-ui/core/Drawer';
import LibraryBooksIcon from '@material-ui/icons/LibraryBooks';

const useStyles = makeStyles(() => ({
    menuHeader: {
        fontSize: '1.8em',
        color: '#fff',
        marginLeft: '20px',
        marginRight: '20px',
        minHeight: '54px',
        paddingTop: '10px',
        paddingLeft: '10px'
    },
    menuList: {
        fontSize: '1.3em',
        listStyleType: 'none',
        listStyle: 'none',
        marginLeft: '-10px'
    },
    menuItem: {},
    menuItemText: {
        marginTop: '-5px',
        paddingLeft: '30px',
        marginBottom: '20px',
        fontWeight: 500
    },
    itemIcon: {
        paddingTop: '5px',
        width: '20px',
        float: 'left'
    },
    menuContainer: {
        width: 200,
        paddingLeft: 20,
        paddingRight: 20
    }
}));

const LeftMenu = (props: any) => {
    const classes = useStyles();

    const menuListItem = () => {
        return (
            <ul className={classes.menuList}>
                <li>
                    <div className={classes.menuItem}>
                        <div className={classes.itemIcon}>
                            <LibraryBooksIcon />
                        </div>
                        <div className={classes.menuItemText}>My Books</div>
                    </div>
                </li>
            </ul>
        );
    };

    return (
        <Drawer
            anchor={'left'}
            open={props.open}
            onClose={props.toggleDrawer(false)}>
            {/* starts leftmenu drawer */}
            <AppBar elevation={0} position="relative">
                <div id="leftMenu" className={classes.menuContainer}></div>
                <Typography className={classes.menuHeader}>
                    bibliotheek
                </Typography>
            </AppBar>
            {menuListItem()}
        </Drawer>
    );
};

export default LeftMenu;
