package exam.springboot.jpa.library.repository;

import exam.springboot.jpa.library.model.Library;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface LibraryRepository extends PagingAndSortingRepository<Library, Long> {

    int countLibraryBy();

    List<Library> findByLbnameContains(Pageable paging, String fkey);
    List<Library> findBySidoContains(Pageable paging, String fkey);
    List<Library> findByGugunContains(Pageable paging, String fkey);

    int countByLbnameContains(String fkey);
    int countBySidoContains(String fkey);
    int countByGugunContains(String fkey);

}