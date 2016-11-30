package ch.diso.q08;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Q004 {

    public static void main(String[] args) {
        Path path1 = Paths.get("MyDir", "hello.java");
        Path path2 = Paths.get("FrienDir", "code");
        Path path3 = path1.relativize(path2);

        for (Path path : path3) {
            System.out.println(path);
        }
    }
}
