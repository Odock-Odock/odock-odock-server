package com.odockodock.odockodock_server.application.service;

import com.odockodock.odockodock_server.application.port.in.SearchLibraryUseCase;
import com.odockodock.odockodock_server.application.port.out.LoadLibraryPort;
import com.odockodock.odockodock_server.domain.Library;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchLibraryService implements SearchLibraryUseCase {

    private final LoadLibraryPort loadLibraryPort;

    @Override
    public List<Library> search(String region, String dtlRegion) {
        System.out.println(loadLibraryPort.loadLibraries(region, dtlRegion));
        return loadLibraryPort.loadLibraries(region, dtlRegion);
    }
}