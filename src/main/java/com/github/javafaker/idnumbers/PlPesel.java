package com.github.javafaker.idnumbers;

import java.time.LocalDate;

public final class PlPesel {
    private final LocalDate birthDate;
    private final Sex gender;

    public PlPesel(Builder builder) {
        this.birthDate = builder.birthDate;
        this.gender = builder.gender;
    }

    public String valid() {
        return "";
    }

    public enum Sex {
        MALE, FEMALE
    }

    public static final class Builder {
        private LocalDate birthDate;
        private Sex gender;

        public Builder withBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder withGender(Sex gender) {
            this.gender = gender;
            return this;
        }

        public PlPesel build() {
            return new PlPesel(this);
        }
    }
}
