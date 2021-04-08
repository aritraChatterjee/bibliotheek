import AppBar from '@material-ui/core/AppBar';
import { fade, makeStyles } from '@material-ui/core/styles';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import Container from '@material-ui/core/Container';
import React, { useState } from 'react';
import Drawer from '@material-ui/core/Drawer';
import Tabs from '@material-ui/core/Tabs';
import Tab from '@material-ui/core/Tab';
import Link from '@material-ui/core/Link';
import { Link as RouteLink } from 'react-router-dom';
import IconButton from '@material-ui/core/IconButton';
import MenuIcon from '@material-ui/icons/Menu';
import LibraryBooksIcon from '@material-ui/icons/LibraryBooks';
import InputBase from '@material-ui/core/InputBase';
import SearchIcon from '@material-ui/icons/Search';

const useStyles = makeStyles((theme) => ({
    brand: {
        fontSize: '1.9em',
        color: '#fff',
        marginLeft: '20px',
        marginRight: '20px'
    },
    tabContainer: {
        marginLeft: 'auto'
    },
    tab: {
        fontSize: '0.95em',
        textTransform: 'none',
        minWidth: 10,
        marginLeft: '15px',
        letterSpacing: '1px'
    },
    headerMargin: {
        marginTop: 150
    },
    search: {
        position: 'relative',
        borderRadius: theme.shape.borderRadius,
        backgroundColor: fade(theme.palette.common.white, 0.15),
        '&:hover': {
            backgroundColor: fade(theme.palette.common.white, 0.25)
        },
        marginRight: theme.spacing(2),
        marginLeft: 0,
        width: '100%',
        [theme.breakpoints.up('sm')]: {
            marginLeft: theme.spacing(3),
            width: 'auto'
        }
    },
    searchIcon: {
        padding: theme.spacing(0, 2),
        height: '100%',
        position: 'absolute',
        pointerEvents: 'none',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center'
    },
    inputRoot: {
        color: 'inherit'
    },
    inputInput: {
        padding: theme.spacing(1, 1, 1, 0),
        // vertical padding + font size from searchIcon
        paddingLeft: `calc(1em + ${theme.spacing(4)}px)`,
        transition: theme.transitions.create('width'),
        width: '100%',
        [theme.breakpoints.up('md')]: {
            width: '20ch'
        }
    },
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
    menuItem:{
    },
    menuItemText: {
        marginTop: '-5px',
        paddingLeft: '30px',
        marginBottom: '10px'
    },
    itemIcon:{
        paddingTop: '5px',
        width: '20px',
        float: 'left'
    },
    menuItemSize:{
        fontSize: '1.3em'
    },
    menuContainer: {
        width: 200,
        paddingLeft: 20,
        paddingRight: 20
    },
    grow: {
        flexGrow: 1
    }
}));

const Header = () => {
    const classes = useStyles();

    const [value, setValue] = useState(1);

    const [open, isOpen] = useState(false);

    const toggleDrawer = (toggle: any) => (event: any) => {
        if (event && event.type === 'keydown' && (event.key === 'Tab' || event.key === 'Shift')) {
            return;
        }

        isOpen(toggle);
    };

    const preventDefault = () => {
        console.log('[Header] : preventDefault ');
    };

    {/* event is created but never used- should remove or keep it */}
    const handleChange = (event: React.ChangeEvent<{}>, newValue: number) => {
        setValue(newValue);
    };

    return (
        <>
            <AppBar elevation={0} position="fixed">
                <Container fixed>
                    <Toolbar>
                        <IconButton color="inherit" aria-label="menu">
                            <MenuIcon onClick={toggleDrawer(true)} />
                            <div>
                                <React.Fragment key={'left'}>
                                    <Drawer
                                        anchor={'left'}
                                        open={open}
                                        onClose={toggleDrawer(false)}
                                    >
                                        {/* starts leftmenu drawer */}
                                        <AppBar elevation={0} position="relative" >
                                           <div id="leftMenu" className={classes.menuContainer}></div>
                                               <Typography className={classes.menuHeader}>
                                                         bibliotheek
                                               </Typography>
                                        </AppBar> 
                                        <ul className={classes.menuList}>
                                            <li>
                                                <div className={classes.menuItem}>
                                                    <div className={classes.itemIcon}>
                                                        <LibraryBooksIcon/>
                                                    </div>                                                
                                                    <div className={classes.menuItemText}>
                                                        <Typography variant= "h4" className={classes.menuItemSize}>
                                                            My Books
                                                            </Typography>
                                                        </div>  
                                                </div>                                                                                              
                                            </li>
                                        </ul>
                                    </Drawer>
                                </React.Fragment>
                            </div>
                        </IconButton>
                        <Link
                            href="#"
                            onClick={preventDefault}
                            underline="none">
                            <Typography className={classes.brand}>
                                bibliotheek
                            </Typography>
                        </Link>
                        <div className={classes.search}>
                            <div className={classes.searchIcon}>
                                <SearchIcon />
                            </div>
                            <InputBase
                                placeholder="Search…"
                                classes={{
                                    root: classes.inputRoot,
                                    input: classes.inputInput
                                }}
                                inputProps={{ 'aria-label': 'search' }}
                            />
                        </div>
                        <div className={classes.grow} />
                        <Tabs
                            TabIndicatorProps={{
                                style: { backgroundColor: '#fff' }
                            }}
                            className={classes.tabContainer}
                            value={value}
                            onChange={handleChange}>
                            <Tab
                                className={classes.tab}
                                component={RouteLink}
                                to="/home"
                                label="Home"
                            />
                            <Tab
                                className={classes.tab}
                                component={RouteLink}
                                to="/about"
                                label="About"
                            />
                            <Tab
                                className={classes.tab}
                                component={RouteLink}
                                to="/contact"
                                label="Contact"
                            />
                        </Tabs>
                    </Toolbar>
                </Container>
            </AppBar>
            <div className={classes.headerMargin} />
        </>
    );
};

export default Header;
