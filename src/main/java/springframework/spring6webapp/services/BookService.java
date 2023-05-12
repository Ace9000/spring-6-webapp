package springframework.spring6webapp.services;

import springframework.spring6webapp.domain.Book;

public interface BookService  {

    Iterable<Book> findAll();
}
