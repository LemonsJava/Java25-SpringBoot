package org.example.movieapp.service;

import lombok.RequiredArgsConstructor;
import org.example.movieapp.entity.Country;
import org.example.movieapp.repository.ICountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {
    private final ICountryRepository countryRepository;

    public List<Country> findAllCountries() {
        return countryRepository.findAll();
    }
}
