import React from 'react';
// also exported from '@storybook/react' if you can deal with breaking changes in 6.1
import { Story, Meta } from '@storybook/react/types-6-0';

import { Button, ButtonProps } from '../components/Button';
import { StoryTemplate } from './StoryTemplate';

export default {
    title: 'Example/Button',
    component: Button
} as Meta;

const Template: Story<ButtonProps> = (args) => {
    return (
        <StoryTemplate>
            <Button {...args} />
        </StoryTemplate>
    );
};

export const Primary = Template.bind({});
Primary.args = {
    color: 'primary',
    label: 'Button'
};

export const Secondary = Template.bind({});
Secondary.args = {
    color: 'secondary',
    label: 'Button'
};

export const Large = Template.bind({});
Large.args = {
    size: 'large',
    color: 'primary',
    label: 'Button'
};

export const Small = Template.bind({});
Small.args = {
    size: 'small',
    color: 'primary',
    label: 'Button'
};
