package exam.springboot.jpa.library.controller;

import exam.springboot.jpa.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LibraryController {

    @Autowired
    private LibraryService lbsrv;

    @GetMapping("/list")
    public ModelAndView list(Integer cpg) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/list");
        if (cpg == null || cpg == 0) cpg = 1;

        mv.addObject("lblist", lbsrv.readLibrary(cpg));
        mv.addObject("cpg", cpg);
        mv.addObject("stpg", ((cpg - 1) / 10) * 10 + 1);
        mv.addObject("cntpg", lbsrv.countLibrary());

        return mv;
    }

    // 검색 처리
    @GetMapping("/find")
    public ModelAndView find(int cpg, String ftype, String fkey) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/list");
        mv.addObject("lblist", lbsrv.readLibrary(cpg, ftype, fkey));
        mv.addObject("cpg", cpg);
        mv.addObject("stpg", ((cpg - 1) / 10) * 10 + 1);
        mv.addObject("cntpg", lbsrv.countLibrary(ftype, fkey));

        return mv;
    }
}
