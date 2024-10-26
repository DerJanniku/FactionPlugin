
package com.factionplugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.representer.Representer;

public class ProfileStorage {
    private static final String PROFILE_DIR = "profiles/";

    public static void saveProfile(UUID uuid, PlayerProfile profile) throws IOException {
        File dir = new File(PROFILE_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        DumperOptions options = new DumperOptions();
        options.setIndent(2);
        options.setPrettyFlow(true);
        Yaml yaml = new Yaml(options);
        String yamlString = yaml.dump(profile);

        Files.write(Paths.get(PROFILE_DIR + uuid.toString() + ".yml"), yamlString.getBytes());
    }

    public static PlayerProfile loadProfile(UUID uuid) throws IOException {
        File file = new File(PROFILE_DIR + uuid.toString() + ".yml");
        if (!file.exists()) {
            return null;
        }

        // FIXME: Resolve the issue with incompatible types for Yaml constructor
        Yaml yaml = new Yaml(new Constructor(PlayerProfile.class), new Representer());
        return yaml.load(Files.newInputStream(file.toPath()));
    }
}
