package springframework.spring6webapp.services;

import springframework.spring6webapp.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
