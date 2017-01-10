package mrd.shinse.jgit.sample.api;

import java.nio.file.Path;
import java.util.Optional;
import lombok.NonNull;

public interface MrdRepository {

    public Optional<Path> checkoutHead(final @NonNull Path path);
}
