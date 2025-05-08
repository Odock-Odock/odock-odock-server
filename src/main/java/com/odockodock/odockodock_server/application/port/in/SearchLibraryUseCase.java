package com.odockodock.odockodock_server.application.port.in;

import com.odockodock.odockodock_server.domain.Book;
import com.odockodock.odockodock_server.domain.Library;

import java.util.List;

public interface SearchLibraryUseCase {
    List<Library> search(String region, String dtlRegion);
    String provideAccessToken();
    List<Book> bookSearch(String keyword, int pageNo, int pageSize);
}
