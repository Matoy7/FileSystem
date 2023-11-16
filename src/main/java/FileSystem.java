public interface FileSystem {

    //- adds new file under the parent directory
    void addFile(String parentDirName, String FileName, long FileSize);

    //- adds new directory under the parent directory
    void addDir(String ParentDirName, String DirName);

    //- deletes the dir or the file with this name
    void delete(String Name);

    //- display all files & directories
    // with their hierarchical structure
    // (for file display all file properties and for directory display all directory properties)
    void showFileSystem();
}
