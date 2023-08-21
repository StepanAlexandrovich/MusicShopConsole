package org.example.repositories;

import org.example.model.Genre;

import java.util.List;

public interface GenreRepository extends FindAll<Genre>,FindById<Genre> {}
