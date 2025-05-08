package com.odockodock.odockodock_server.adapter.in;


import com.odockodock.odockodock_server.application.port.in.SearchLibraryUseCase;
import com.odockodock.odockodock_server.domain.Book;
import com.odockodock.odockodock_server.domain.Library;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LibraryController {

    private final SearchLibraryUseCase searchLibraryUseCase;

    @GetMapping("/libraries")
    public List<Library> getLibraries(
            @RequestParam("region") String region,
            @RequestParam("dtlRegion") String dtlRegion
    ) {
        System.out.println("호출됨 라이브러리");
        return searchLibraryUseCase.search(region, dtlRegion);
    }

    @GetMapping("book-search")
    public List<Book> getBookList(
            @RequestParam("keyword") String keyword,
            @RequestParam(name = "pageNo", defaultValue = "1") int pageNo,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize
    ){

        return searchLibraryUseCase.bookSearch(keyword,pageNo,pageSize);
    }

    @GetMapping("/access-token")
    public String getConsumerKey(){
        return searchLibraryUseCase.provideAccessToken();
    }
}