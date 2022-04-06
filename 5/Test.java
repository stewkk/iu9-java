import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        FileTree test = new FileTree();
        test.add("/a/b/c/c.test");
        test.add("/a/b/c.aoao");
        test.add("/a/c.aoao");
        test.add("/a/d.aoao");
        test.add("/a/test.test.test12");
        test.add("/a/test");

        test.nameStream("/a/b/c").forEach(System.out::println);
        Optional<Integer> n = test.minDepthContainsOneFile();
        if (n.isPresent()) {
            System.out.println(n.get());
        } else {
            System.out.println("none");
        }
        final ArrayList<String> files = test.nameStream("/a/")
            .map(x -> x.contains(".") ? x : "No extension")
            .map(x -> x.substring(x.lastIndexOf(".")+1))
            .collect(Collectors.toCollection(ArrayList::new));
        files.stream()
            .distinct()
            .forEach(x -> System.out.println(x + ": " + Collections.frequency(files, x)));
    }
}
