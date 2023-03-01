package src.chapter1.section1;

import java.io.File;

/**
 * Created by Nicholas on 2022/12/3 16:01.
 */
public class FileList<T> {

    LinkListQueue<String> fileList;

    public FileList() {
        fileList = new LinkListQueue<String>();
    }

    public void listFiles(File file, int depth) {
        if (!file.exists()) {
            return;
        }
        addFileToQueue(file, depth);
        File[] fileList = file.listFiles();
        if (fileList != null) {
            for (File f : fileList) {
                if (f.isFile()) {
                    addFileToQueue(f, depth);
                } else if (f.isFile()) {
                    listFiles(f, depth + 1);
                }
            }
        }

    }

    public void addFileToQueue(File file, int depth) {
        StringBuilder fill = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            fill.append(" ");
        }
        fileList.enqueue(file.getName());
        fileList.enqueue(fill.toString());
    }

}
