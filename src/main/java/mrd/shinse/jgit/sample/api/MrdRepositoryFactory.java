package mrd.shinse.jgit.sample.api;

import java.nio.file.Path;
import java.util.Optional;
import lombok.NonNull;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

public class MrdRepositoryFactory {

    public static MrdRepository create(
            final @NonNull String url,
            final Optional<String> userId,
            final Optional<String> pass
    ) {
        return new MrdRepositoryGit(url);
    }
}

class MrdRepositoryGit implements MrdRepository {

    final String url;

    public MrdRepositoryGit(
            final @NonNull String url
    ) {
        this.url = url;
    }

    @Override
    public Optional<Path> checkoutHead(Path path) {
        try {
//            Repository localRepo = new FileRepository(path.resolve(".git").toFile());
//            Git git = new Git(localRepo);
            Git.cloneRepository().setURI(this.url).setDirectory(path.toFile()).call();
            return Optional.ofNullable(path);
        } catch (GitAPIException e) {
            return Optional.empty();
        }
    }
}
