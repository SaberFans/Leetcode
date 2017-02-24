package _ARetroPractice;


import java.util.Stack;

/**
 * Created by yang on 2016/12/1.
 */
public class MyPathTest {

    private String path;
    private Stack<String> subPathstk = new Stack<>();
    public MyPathTest(String path) {
        this.path = path;
        for(String sub: path.split("/")){
            if(!sub.isEmpty())
                subPathstk.add(sub);
        }
    }

    public String getPath(){
        return path;
    }

    void evalPath(String[]subpath, Stack<String> pathStk){
        for(String str: subpath){
            if(str.equals("..")&& !pathStk.isEmpty()){
                pathStk.pop();
            }
            else{
                pathStk.add(str);
            }
        }
        this.subPathstk = pathStk;
        StringBuilder builder = new StringBuilder();
        if(subPathstk.isEmpty())
            builder.append("/");
        else {
            for (String sub : subPathstk) {
                builder.append("/").append(sub);
            }
        }
        this.path = builder.toString();
    }

    public MyPathTest cd(String newPath) {
        if(newPath!=null) {
            String[] paths = newPath.split("/");
            if(paths.length>0){
                // absolute path
                if(paths[0].isEmpty()){
                    evalPath(paths, new Stack<String>());
                }
                    else{
                    evalPath(paths, this.subPathstk);
                }
            }
        }
        return this;
    }

    public static void main(String[] args) {
        MyPathTest path = new MyPathTest("/a/b/c/d");
        System.out.println(path.cd("../x").getPath());

    }

}
