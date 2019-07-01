import java.io.File;
import java.util.Objects;

public class 统计做了多少算法题 {
    int count = 0;

    public 统计做了多少算法题(String path, int exclude, int days) {
        File file = new File(path);
        if (!file.isDirectory()) {
            try {
                throw new Exception("请输入目录！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        File[] files = file.listFiles();
        cout(files);
        System.out.println("目前已刷算法题:" + (count - exclude) + '\n' + "理应刷题数：" + days * 7 + '\n' + "需要补上：" + (days * 7 - (count - exclude)));
    }

    public static void main(String[] args) {
        统计做了多少算法题 scanFile = new 统计做了多少算法题("H:\\javaproject\\Leetcdd\\src\\com\\leetcode", 0, 24);
    }

    private void cout(File[] files) {
        for (File file : files) {
            if (!file.isDirectory()) {
                count++;
            } else {
                cout(Objects.requireNonNull(file.listFiles()));
            }
        }
    }

}




