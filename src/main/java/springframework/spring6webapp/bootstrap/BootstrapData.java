package springframework.spring6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.spring6webapp.domain.Author;
import springframework.spring6webapp.domain.Book;
import springframework.spring6webapp.domain.Publisher;
import springframework.spring6webapp.repositories.AuthorRepository;
import springframework.spring6webapp.repositories.BookRepository;
import springframework.spring6webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author anastas = new Author();
        anastas.setFirstname("Anastas");
        anastas.setLastname("Acevski");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("1234");

        Author anastasSaved = authorRepository.save(anastas);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstname("Rod");
        rod.setLastname("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle(" J2EE Development without EJB");
        noEJB.getIsbn("45432");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        anastasSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);

        authorRepository.save(anastasSaved);
        authorRepository.save(rodSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count:" + authorRepository.count());
        System.out.println("Book Count:" + bookRepository.count());

        Publisher publisher = new Publisher();
        publisher.setPublisherName("My Publisher");
        publisher.setAddress("123 Main");
        publisherRepository.save(publisher);

        System.out.println(" Publisher Count: " +publisherRepository.count());


    }
}
