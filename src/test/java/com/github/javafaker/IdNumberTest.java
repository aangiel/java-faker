package com.github.javafaker;

import com.github.javafaker.idnumbers.PlPesel;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Locale;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.junit.Assert.assertThat;

public class IdNumberTest extends AbstractFakerTest {

    @Test
    public void testValid() {
        assertThat(faker.idNumber().valid(), matchesRegularExpression("[0-8]\\d{2}-\\d{2}-\\d{4}"));
    }

    @Test
    public void testInvalid() {
        assertThat(faker.idNumber().invalid(), matchesRegularExpression("[0-9]\\d{2}-\\d{2}-\\d{4}"));
    }

    @Test
    public void testSsnValid() {
        assertThat(faker.idNumber().valid(), matchesRegularExpression("[0-8]\\d{2}-\\d{2}-\\d{4}"));
    }

    @Test
    public void testValidSwedishSsn() {
        final Faker f = new Faker(new Locale("sv_SE"));
        for (int i = 0; i < 100; i++) {
            assertThat(f.idNumber().valid(), matchesRegularExpression("\\d{6}[-+]\\d{4}"));
        }
    }

    @Test
    public void testInvalidSwedishSsn() {
        final Faker f = new Faker(new Locale("sv_SE"));
        for (int i = 0; i < 100; i++) {
            assertThat(f.idNumber().invalid(), matchesRegularExpression("\\d{6}[-+]\\d{4}"));
        }
    }

    @Test
    public void testPolishPesel() {
        final Faker f = new Faker(Locale.forLanguageTag("pl"));
        assertThat(f.idNumber().plPesel().build().valid(), matchesRegularExpression(""));
    }

    @Test
    public void testPolishPeselWithGender() {
        final Faker f = new Faker(Locale.forLanguageTag("pl"));
        assertThat(f.idNumber().plPesel().withGender(PlPesel.Sex.MALE).build().valid(), matchesRegularExpression(""));
    }

    @Test
    public void testPolishPeselWithBirthDate() {
        final Faker f = new Faker(Locale.forLanguageTag("pl"));
        assertThat(f.idNumber().plPesel().withBirthDate(LocalDate.of(1990, 5, 24)).build().valid(), matchesRegularExpression(""));
    }

    @Test
    public void testPolishPeselWithGenderAndBirthDate() {
        final Faker f = new Faker(Locale.forLanguageTag("pl"));
        assertThat(f.idNumber().plPesel().withGender(PlPesel.Sex.MALE).withBirthDate(LocalDate.of(1990, 5, 24)).build().valid(), matchesRegularExpression(""));
    }
}
