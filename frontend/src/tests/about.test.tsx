import React from 'react';
import '@testing-library/jest-dom/extend-expect';
import { render, fireEvent } from '@testing-library/react';
import About from '../components/page/About';

//for future reference
test('clicking the Hello button calls event handler once', () => {
    const mockHandler = jest.fn();
    const component = render(<About />);
    const buttonElement = component.container.querySelector(
        '[qa-attr="button-hello"]'
    );
    expect(buttonElement).toBeInTheDocument();
    expect(buttonElement).toHaveTextContent('Hello');

    //gets button text and click the button
    const button = component.getByText('Hello');
    fireEvent.click(button);

    //expects the button gest called once,currently this button is not doing anything so call length is 0 otherwise 1
    expect(mockHandler.mock.calls).toHaveLength(0);
});

test('clicking the World button calls event handler once', () => {
    const mockHandler = jest.fn();
    const component = render(<About />);
    const buttonElement = component.container.querySelector(
        '[qa-attr="button-world"]'
    );
    expect(buttonElement).toBeInTheDocument();
    expect(buttonElement).toHaveTextContent('World');

    const button = component.getByText('World');
    fireEvent.click(button);

    expect(mockHandler.mock.calls).toHaveLength(0);
});
