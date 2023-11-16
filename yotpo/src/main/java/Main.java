public class Main {

    public static void main(String[] args) {
        FileSystem fileSystemNode = new TreeFileSystem();
        fileSystemNode.addDir("/", "folder1");
        fileSystemNode.addDir("/", "folder2");
        fileSystemNode.addDir("/", "folder3");
        fileSystemNode.addFile("folder2", "names.txt",new Long(1000));
        fileSystemNode.addDir("folder1", "folder999");

        fileSystemNode.delete("folder1");

        fileSystemNode.showFileSystem();
    }
}
