import React from 'react';
import '@testing-library/jest-dom/extend-expect';
import { render, fireEvent } from '@testing-library/react';
import Header from '../components/page/Header';
import { BrowserRouter } from 'react-router-dom';

test('clicking the menu button calls event handler once', () => {
    const mockHandler = jest.fn();
    const component = render(
        <BrowserRouter>
            <Header />
        </BrowserRouter>
    );
    const button = component.getByText('menu');
    fireEvent.click(button);

    expect(mockHandler.mock.calls).toHaveLength(1);
});
