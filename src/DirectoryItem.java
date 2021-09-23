import java.nio.file.Path;

public class DirectoryItem {
    Path path;
    int depth;

    public DirectoryItem(Path path, int depth) {
        this.path = path;
        this.depth = depth;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


    @Override
    public String toString() {
        return "DirectoryItem{" +
                "path=" + path +
                ", depth=" + depth +
                '}';
    }
}
