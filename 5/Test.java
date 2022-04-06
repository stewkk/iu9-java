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
        Map<String, List<String>> files = test.nameStream("/a/")
            .collect(Collectors.groupingBy(x -> x.contains(".") ? (x.substring(x.lastIndexOf(".")+1)) : "No extension"));
        System.out.println(files);
    }
}
