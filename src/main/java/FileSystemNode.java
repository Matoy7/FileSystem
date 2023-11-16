
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class FileSystemNode {
    private String name;
    private long size;
    private Date createdDate;
    private boolean isFile;
    private FileSystemNode parentDir;
    private List<FileSystemNode> children;

    public FileSystemNode(String name, long size, Date createdDate, boolean isFile, List<FileSystemNode> children, FileSystemNode parentDir) {
        this.name = name;
        this.size = size;
        this.createdDate = createdDate;
        this.isFile = isFile;
        this.parentDir = parentDir;
        this.children = children;
    }

    public FileSystemNode(String name,Date createdDate, boolean isFile, FileSystemNode parentDir) {
        this.name = name;
        this.createdDate = createdDate;
        this.isFile = isFile;
        this.parentDir = parentDir;
        this.children = new ArrayList<>();
    }

    public FileSystemNode getParentDir() {
        return parentDir;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setFile(boolean file) {
        isFile = file;
    }

    public void setChildren(List<FileSystemNode> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public boolean isFile() {
        return isFile;
    }

    public List<FileSystemNode> getChildren() {
        return children;
    }
}
