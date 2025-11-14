package com.jac.alexandria.Alexandria.Library.config;

import com.jac.alexandria.Alexandria.Library.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BookInitializer implements CommandLineRunner {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void run(String... args) {
        // Only insert if there are no books
        Long count = entityManager.createQuery("SELECT COUNT(b) FROM Book b", Long.class).getSingleResult();
        if (count == 0) {
            Book[] books = new Book[] {
                new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "978-0439708180", "AVAILABLE"),
                new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", "978-0439064873", "AVAILABLE"),
                new Book("The Hobbit", "J.R.R. Tolkien", "978-0547928227", "AVAILABLE"),
                new Book("The Lord of the Rings", "J.R.R. Tolkien", "978-0618640157", "AVAILABLE"),
                new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084", "AVAILABLE"),
                new Book("1984", "George Orwell", "978-0451524935", "AVAILABLE"),
                new Book("Pride and Prejudice", "Jane Austen", "978-1503290563", "AVAILABLE"),
                new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565", "AVAILABLE"),
                new Book("Moby Dick", "Herman Melville", "978-1503280786", "AVAILABLE"),
                new Book("The Catcher in the Rye", "J.D. Salinger", "978-0316769488", "AVAILABLE")
            };
            for (Book book : books) {
                entityManager.persist(book);
            }
        }
    }
}