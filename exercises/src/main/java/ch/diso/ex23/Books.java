package ch.diso.ex23;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

/**
 * Domain object representing a collection of books
 */
public class Books {

    /**
     * Apply a mapping of Books to titles (Strings)
     *
     * @param books - books to transform
     * @return list of book titles
     */
    public static List<String> titlesOf(List<Book> books) {
        return books.stream()
                .map(Book::getTitle)
                .collect(toList());
    }

    /**
     * Apply a mapping of Books to their author's full names
     *
     * @param books - books to transform
     * @return list of author full names
     */
    public static List<String> namesOfAuthorsOf(List<Book> books) {
        return books.stream()
                .map(Book::getAuthor)
                .map(Author::fullName)
                .collect(toList());
    }

    /**
     * Apply a mapping of Books to a unique set of their publishers
     *
     * @param books - books to transform
     * @return set of publishers
     */
    public static Set<Publisher> publishersRepresentedBy(List<Book> books) {
        return books.stream()
                .map(Book::getPublisher)
                .collect(toSet());
    }
}