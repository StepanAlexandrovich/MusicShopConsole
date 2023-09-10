package org.example.repositories;

import java.util.List;

public interface ManyToForeignKey {
    List list(int foreignKeyPosition,int foreignKeyId);
    List list(String foreignKeyName,int foreignKeyId);
}
