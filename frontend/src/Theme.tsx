import { createMuiTheme } from '@material-ui/core/styles';

const theme = createMuiTheme({
    palette: {
        primary: {
            main: '#212121'
        },
        secondary: {
            main: '#ee0000'
        }
    },
    overrides: {
        MuiAppBar: {
            colorDefault: {
                backgroundColor: '#fff',
                color: '#000',
                padding: '25px 0'
            }
        },
        MuiButton: {
            root: {
                borderRadius: 0, //buttons without rounded corners
                textTransform: 'none', //button label is case sensitive
                margin: '2px'
            }
        },
        MuiLink: {
            underlineNone: {
                color: '#2c3e50',
                '&:hover': {
                    color: '#077761'
                }
            }
        }
    }
});

export default theme;
