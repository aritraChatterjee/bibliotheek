import { ThemeProvider } from '@material-ui/core';
import React from 'react';
import theme from '../Theme';

export const StoryTemplate: any = (props: any) => {
    return <ThemeProvider theme={theme}>{props.children}</ThemeProvider>;
};
