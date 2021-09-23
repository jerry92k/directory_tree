import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Deque;
import java.util.LinkedList;

public class DirectoryTree {

    public static void main(String[] args){
        DirectoryTree directoryTree=new DirectoryTree();
        directoryTree.outputTreeList();
    }
    
    public void outputTreeList(){
        Deque<DirectoryItem> directories=new LinkedList<>();

        Path rootPath=Paths.get("");
        System.out.println("CWD : "+rootPath.toAbsolutePath().toString());

        pushChildDirectories( directories, rootPath,1);
        while(!directories.isEmpty()){
            // 가장 위에 있는 directory를 pop 해서 출력
            DirectoryItem curDir=directories.pop();
            outputCurDir(curDir);

            // 하위 디렉토리들을 Collection에 push
            pushChildDirectories( directories, curDir.getPath(),curDir.getDepth()+1);
        }
    }

    public void outputCurDir(DirectoryItem curDir){
        StringBuilder sb=new StringBuilder();
                for(int i=0; i<curDir.getDepth(); i++){
            sb.append("\t");
        }
        /* Stream을 이용한 방법
        StringBuilder sb = IntStream.range(0,curDir.getDepth())
                .collect(StringBuilder::new
                        ,(tempSb,i)-> tempSb.append("\t")
                        , (tempSb1,tempSb2)-> tempSb1.append(tempSb2));
        */
        sb.append("+-- ");
        sb.append(curDir.getPath().getFileName().toString());

        System.out.println(sb.toString());
    }

    public void pushChildDirectories(Deque<DirectoryItem> directories, Path curPath, int nextDepth){
        try {
                Files.list(curPath)
                        .filter(path-> Files.isDirectory(path))
                        .map(path -> new DirectoryItem(path,nextDepth))
                        .forEach(dir->directories.push(dir));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
