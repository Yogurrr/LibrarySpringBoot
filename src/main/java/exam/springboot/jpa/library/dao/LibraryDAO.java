package exam.springboot.jpa.library.dao;

import exam.springboot.jpa.library.model.Library;

import java.util.List;
import java.util.Map;

public interface LibraryDAO {

    List<Library> selectLibrary(int cpage);
    List<Library> selectLibrary(Map<String, Object> params);

    int countLibrary();
    int countLibrary(Map<String, Object> params);
}
