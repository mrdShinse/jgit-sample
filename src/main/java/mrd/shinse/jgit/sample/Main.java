package mrd.shinse.jgit.sample;

import java.nio.file.Paths;
import java.util.Optional;
import mrd.shinse.jgit.sample.api.MrdRepository;
import mrd.shinse.jgit.sample.api.MrdRepositoryFactory;

public class Main {

    public static void main(String[] args) {
        MrdRepository repo = MrdRepositoryFactory.create(
                "https://github.com/mrdShinse/Holacracy-Constitution-4.1-Japanese.git",
                Optional.of("userId"),
                Optional.of("password"));

        repo.checkoutHead(Paths.get("./tmp")).ifPresent(path
                -> System.out.println("Success! " + path.toString())
        );
    }
}
