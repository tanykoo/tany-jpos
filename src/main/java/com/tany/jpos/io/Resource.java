package com.tany.jpos.io;

import java.net.URL;
import java.nio.file.Path;

public interface Resource {
    URL getUrl();
    Path getPath();
}
