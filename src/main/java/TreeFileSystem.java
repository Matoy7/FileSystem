import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeFileSystem implements FileSystem {

    public static final String FILE_NOT_EXIST_ERROR_MESSAGE = "The path does not exist in the file system";

    private FileSystemNode root;
    private Map<String, FileSystemNode> nodesInFileSystem = new HashMap<>();


    public TreeFileSystem() {
        this.root = new FileSystemNode("/", new Date(), false, null);
        nodesInFileSystem.put("/", root);
    }

    // parentDirName - relative path to be added to the file system
    @Override
    public void addFile(String parentDirName, String fileName, long fileSize) {
        FileSystemNode parentDir = nodesInFileSystem.get(parentDirName);
        if (parentDir == null) {
            throw new IllegalArgumentException(FILE_NOT_EXIST_ERROR_MESSAGE);
        }
        FileSystemNode fileToBeAdded = new FileSystemNode(fileName, fileSize, new Date(), true, null, parentDir);
        parentDir.getChildren().add(fileToBeAdded);
        nodesInFileSystem.put(fileName, fileToBeAdded);
    }

    @Override
    public void addDir(String parentDirName, String dirName) {
        FileSystemNode parentDir = nodesInFileSystem.get(parentDirName);
        if (parentDir == null) {
            throw new IllegalArgumentException(FILE_NOT_EXIST_ERROR_MESSAGE);
        }
        FileSystemNode dirToBeAdded = new FileSystemNode(dirName, new Date(), false, parentDir);
        parentDir.getChildren().add(dirToBeAdded);
        nodesInFileSystem.put(dirName, dirToBeAdded);

    }

    // /folder1/folder2/folder3
    // /folder1/folder2/folder4
    @Override
    public void delete(String name) {
        FileSystemNode nodeToBeDeleted = nodesInFileSystem.get(name);
        if (nodeToBeDeleted == null) {
            throw new IllegalArgumentException(FILE_NOT_EXIST_ERROR_MESSAGE);
        }
        FileSystemNode parentDir = nodeToBeDeleted.getParentDir();
        parentDir.getChildren().remove(nodeToBeDeleted);
        nodesInFileSystem.remove(nodeToBeDeleted.getName());
        removeNodeAndSubNodesFromMap(nodeToBeDeleted);
    }

    //display all files & directories with their hierarchical structure
    // (for file display all file properties and for directory display all directory properties)
    @Override
    public void showFileSystem() {
        showFileSystemFromNode(root,new StringBuilder(""));
    }

    private void showFileSystemFromNode(FileSystemNode fileSystemNode, StringBuilder parentPath) {
        // handle file
        if (fileSystemNode.isFile()) {
            System.out.println(parentPath+fileSystemNode.getName());
            return;
        }
        // handle dir
        else {
            if (!fileSystemNode.getName().equals("/")) {
                parentPath.append(fileSystemNode.getName() + "/");
            }
            else{
                parentPath.append("/");
            }
            System.out.println(parentPath);
            List<FileSystemNode> children = fileSystemNode.getChildren();
            for (FileSystemNode child : children) {
                showFileSystemFromNode(child, new StringBuilder(parentPath));
            }
        }
    }


    private void removeNodeAndSubNodesFromMap(FileSystemNode nodeToBeDeleted) {
        List<FileSystemNode> fileSystemNodeList = nodeToBeDeleted.getChildren();
        for (FileSystemNode fileSystemNode : fileSystemNodeList) {
            removeNodeAndSubNodesFromMap(fileSystemNode);
        }
        nodesInFileSystem.remove(nodeToBeDeleted.getName());
    }
}
