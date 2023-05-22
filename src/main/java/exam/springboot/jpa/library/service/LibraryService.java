package exam.springboot.jpa.library.service;

import exam.springboot.jpa.library.model.Library;

import java.util.List;

public interface LibraryService {
    List<Library> readLibrary(int cpage);
    List<Library> readLibrary(int cpage, String ftype, String fkey);
    int countLibrary();
    int countLibrary(String ftype, String fkey);
}
