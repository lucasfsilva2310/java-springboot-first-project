package dev.lucas.runnerz.user;

public record Address(
        String street,
        String suite,
        String city,
        String zipcode,
        Geo geo,
        String phone,
        String website,
        Company company) {
}
