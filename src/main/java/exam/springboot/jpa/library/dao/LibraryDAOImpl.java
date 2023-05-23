package exam.springboot.jpa.library.dao;

import exam.springboot.jpa.library.model.Library;
import exam.springboot.jpa.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("lbdao")
public class LibraryDAOImpl implements LibraryDAO {

    @Autowired
    LibraryRepository libraryRepository;

    @Override
    public Map<String, Object> selectLibrary(int cpage) {
        Pageable paging = PageRequest.of(cpage, 25, Sort.by("lbno").descending());

        List<Library> lblist = libraryRepository.findAll(paging).getContent();
        int cntpg = libraryRepository.findAll(paging).getTotalPages();

        Map<String, Object> libs = new HashMap<>();
        libs.put("lblist", lblist);
        libs.put("cntpg", cntpg);

        return libs;
    }

    @Override
    public List<Library> selectLibrary(Map<String, Object> params) {

        String fkey = params.get("fkey").toString();
        String ftype = params.get("ftype").toString();
        int cpage = (int) params.get("stlbno");

        Pageable paging = PageRequest.of(cpage, 25, Sort.Direction.DESC, "lbno");

        List<Library> result = null;

        switch (ftype) {
            case "lbname" : // 제목으로 검색
                result = libraryRepository.findByLbnameContains(paging, fkey); break;

            case "sido" : // 제목 + 본문으로 검색
                result = libraryRepository.findBySidoContains(paging, fkey); break;

            case "gugun" : // 작성자로 검색
                result = libraryRepository.findByGugunContains(paging, fkey);
        }

        return result;
    }

    /*@Override
    public int countLibrary() {
        int allcnt = libraryRepository.countLibraryBy();

        return (int) Math.ceil(allcnt / 25);
    }*/

    @Override
    public int countLibrary(Map<String, Object> params) {

        String fkey = params.get("fkey").toString();
        String ftype = params.get("ftype").toString();

        int cnt = 0;
        switch (ftype) {
            case "lbname" :
                cnt = libraryRepository.countByLbnameContains(fkey); break;

            case "sido" :
                cnt = libraryRepository.countBySidoContains(fkey); break;

            case "gugun" :
                cnt = libraryRepository.countByGugunContains(fkey);
        }

        return (int) Math.ceil(cnt / 25);
    }
}
