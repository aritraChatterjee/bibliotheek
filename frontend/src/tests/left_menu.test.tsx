import React from 'react';
import '@testing-library/jest-dom/extend-expect';
import { render, fireEvent, RenderResult } from '@testing-library/react';
import LeftMenu from '../components/page/LeftMenu';

//not yet completed the testing
describe('<LeftMenu />', () => {
    let component: RenderResult<
        typeof import('@testing-library/dom/types/queries')
    >;

    beforeEach(() => {
        component = render(
            <LeftMenu toggleDrawer="toggleDrawer">
                <div className="testDiv" />
            </LeftMenu>
        );
    });

    test('renders its children', () => {
        expect(component.container.querySelector('.testDiv')).toBeDefined();
    });

    test('at start the children are not displayed', () => {
        const div = component.container.querySelector('.menuContainer');

        expect(div).toHaveStyle('display: none');
    });

    test('after clicking the button, children are displayed', () => {
        const button = component.getByText('leftMenu');
        fireEvent.click(button);

        const div = component.container.querySelector('.menuContainer');
        expect(div).not.toHaveStyle('display: none');
    });
});
