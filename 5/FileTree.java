import java.util.*;
import java.util.stream.Stream;

public class FileTree {
    private Directory root = new Directory("", 0);
    private int maxDepthContainsTwoFiles = 0;
    private int maxDepth = 0;

    private class Directory {
        private Set<String> files;
        private HashMap<String, Directory> next;
        private String name;
        private int depth;

        public Directory(String name, int depth) {
            this.name = name;
            this.files = new HashSet<String>();
            this.next = new HashMap<String, Directory>();
            this.depth = depth;
            maxDepth = java.lang.Math.max(depth, maxDepth);
        }

        public Directory go(String name) {
            if (!next.containsKey(name)) {
                Directory newDir = new Directory(name, this.depth+1);
                next.put(name, newDir);
                return newDir;
            }
            return next.get(name);
        }

        public void addFile(String name) {
            files.add(name);
            if (files.size() > 1 && this.depth > maxDepthContainsTwoFiles) {
                maxDepthContainsTwoFiles = this.depth;
            }
        }
    }

    public void add(String path) {
        int nameIndex = path.lastIndexOf("/");
        String name = path.substring(nameIndex+1);
        path = path.substring(0, nameIndex);
        Directory dir = findDir(path);
        dir.addFile(name);
    }

    public Directory findDir(String path) {
        Directory dir = root;
        for (String x : path.substring(1).split("/")) {
            dir = dir.go(x);
        }
        return dir;
    }

    public Stream<String> nameStream(String path) {
        Directory dir = findDir(path);
        return dir.files.stream();
    }

    public Optional<Integer> minDepthContainsOneFile() {
        if (maxDepthContainsTwoFiles == maxDepth) {
            return Optional.empty();
        }
        return Optional.of(maxDepthContainsTwoFiles+1);
    }
}
