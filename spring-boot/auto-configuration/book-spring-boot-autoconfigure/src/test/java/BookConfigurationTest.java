import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jongmin.auto.app.book.Book;
import com.jongmin.auto.app.book.BookConfiguration;

public class BookConfigurationTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner();

    @Test
    public void whenDependentClassIsNotPresent_thenBeanCreated() {
        final String bookName = "spring";
        final int bookPrice = 30000;

        final Map<String, Object> property = new HashMap();
        property.put("book.name", bookName);
        property.put("book.price", bookPrice);
        final String[] properties = property.entrySet()
                                            .stream()
                                            .map(e -> e.getKey() + "=" + e.getValue())
                                            .toArray(String[]::new);

        this.contextRunner.withPropertyValues(properties)
                          .withUserConfiguration(BookConfiguration.class)
                          .run((context -> {
                              assertThat(context).hasSingleBean(Book.class);
                              assertThat(context).getBean("book").isSameAs(context.getBean(Book.class));

                              final Book book = (Book) context.getBean("book");
                              assertThat(book.getName()).isEqualTo(bookName);
                              assertThat(book.getPrice()).isEqualTo(bookPrice);
                          }));
    }

    @Test
    public void whenDependentClassIsPresnet_thenBeanNotCreated() {
        this.contextRunner.withUserConfiguration(TestConfiguration.class, BookConfiguration.class).run(
                context -> {
                    assertThat(context).hasSingleBean(Book.class);
                    assertThat(context).getBean("book").isSameAs(context.getBean(Book.class));

                    final Book book = (Book) context.getBean("book");
                    assertThat(book.getName()).isEqualTo(TestConfiguration.bookName);
                    assertThat(book.getPrice()).isEqualTo(TestConfiguration.bookPrice);
                });
    }

    @Configuration
    public static class TestConfiguration {

        public static String bookName = "testBook";
        public static int bookPrice = 1000;

        @Bean
        public Book book() {
            return new Book(bookName, bookPrice);
        }
    }
}
