package com.odockodock.odockodock_server.adapter.in;


import com.odockodock.odockodock_server.application.port.in.SearchLibraryUseCase;
import com.odockodock.odockodock_server.domain.Library;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libraries")
@RequiredArgsConstructor
public class LibraryController {

    private final SearchLibraryUseCase searchLibraryUseCase;

    @GetMapping
    public List<Library> getLibraries(
            @RequestParam("region") String region,
            @RequestParam("dtlRegion") String dtlRegion
    ) {
        return searchLibraryUseCase.search(region, dtlRegion);
    }
}