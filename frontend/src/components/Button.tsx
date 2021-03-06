import { Button as MuiButton } from '@material-ui/core';
import React from 'react';

export interface ButtonProps {
    /**
     * Is this the principal call to action on the page?
     */
    color?: 'primary' | 'secondary';

    /**
     * How large should the button be?
     */
    size?: 'small' | 'medium' | 'large';
    /**
     * Button contents
     */
    label: string;
    /**
     * Optional click handler
     */
    onClick?: () => void;
}

export const Button: React.FC<ButtonProps> = (props) => {
    return (
        <MuiButton variant="contained" color={props.color} size={props.size}>
            {props.label}
        </MuiButton>
    );
};
