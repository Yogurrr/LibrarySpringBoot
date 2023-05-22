package exam.springboot.jpa.library.service;

import exam.springboot.jpa.library.dao.LibraryDAO;
import exam.springboot.jpa.library.model.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("lbsrv")
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryDAO lbdao;

    @Override
    public List<Library> readLibrary(int cpage) {

        return lbdao.selectLibrary(cpage);
    }

    @Override
    public List<Library> readLibrary(int cpage, String ftype, String fkey) {
        int stlbno = cpage;

        Map<String, Object> params = new HashMap<>();
        params.put("stlbno", stlbno);
        params.put("ftype", ftype);
        params.put("fkey", fkey);

        return lbdao.selectLibrary(params);
    }

    @Override
    public int countLibrary() {
        return lbdao.countLibrary();
    }

    @Override
    public int countLibrary(String ftype, String fkey) {
        Map<String, Object> params = new HashMap<>();
        params.put("ftype", ftype);
        params.put("fkey", fkey);

        return lbdao.countLibrary(params);
    }
}
