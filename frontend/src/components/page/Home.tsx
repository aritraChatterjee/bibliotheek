import React from 'react';
import { Container } from '@material-ui/core';
import ContainerWithGutter from './ContainerWithGutter';
import BookShelf from '../BookShelf';
import { Book } from '../../models/book';

const Home = (props: any) => {
    // static books list for testing purposes, will be replaced by REST api call
    const books: Book[] = [
        {
            title: 'The Jungle Book',
            authors: ['Rudyard Kipling'],
            tags: ['Fiction', 'Adventure'],
            isbn: ''
        },
        {
            title: 'Twenty Thousand Leagues Under the Sea',
            authors: ['Jules Verne'],
            tags: ['Science Fiction', 'Adventure'],
            isbn: ''
        },
        {
            title: 'Good Omens',
            authors: ['Neil Gaiman', 'Terry Pratchett'],
            tags: ['Fiction'],
            isbn: ''
        }
    ];
    return (
        <Container fixed>
            <ContainerWithGutter>
                <BookShelf name="Recently Added Books" books={books} />
            </ContainerWithGutter>
        </Container>
    );
};

export default Home;
