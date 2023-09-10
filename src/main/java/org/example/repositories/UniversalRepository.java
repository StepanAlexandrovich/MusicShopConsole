package org.example.repositories;

import org.example.repositories.functional.DeleteById;
import org.example.repositories.functional.FindAll;
import org.example.repositories.functional.FindById;

public interface UniversalRepository<T> extends FindAll<T>, FindById<T>, DeleteById<T> {
}
