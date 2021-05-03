import React from 'react';
import '@testing-library/jest-dom/extend-expect';
import { render } from '@testing-library/react';
import Footer from '../components/page/Footer';

test('renders cnw link in footer', () => {
    // creates test to find cnw link using qa-attr
    const component = render(<Footer />);
    const linkElement = component.container.querySelector(
        '[qa-attr="link-cnw"]'
    );
    expect(linkElement).toBeInTheDocument();
    expect(linkElement).toHaveTextContent('codesandwires.com');
});

test('renders react link in footer', () => {
    // creates test to find react link using qa-attr
    const component = render(<Footer />);
    const linkElement = component.container.querySelector(
        '[qa-attr="link-react"]'
    );
    expect(linkElement).toBeInTheDocument();
    expect(linkElement).not.toHaveStyle('display: none');
});
