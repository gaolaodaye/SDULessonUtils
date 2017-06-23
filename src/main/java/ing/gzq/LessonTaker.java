package ing.gzq;

import com.alibaba.fastjson.JSON;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by gzq on 17-6-22.
 */
public class LessonTaker implements Runnable {


    private String courseId;

    private String courseIndex;

    private CloseableHttpClient client;

    public LessonTaker(CloseableHttpClient client) {
        this.client = client;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int result = takeLesson();
                if (result == 1 || result == 2) break;
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*  return
     *   0 : 选课失败 要重试
     *   1 : 选课成功 不重试
     *   2 : 课程已选过 不重试
     *   3 : 课程不存在 重新输入课程号与课序号
     *   4 : 课程冲突   重新输入课程号与课序号
     *
     *   -1 : 无法处理响应 不重试
     */
    private int takeLesson() throws URISyntaxException, IOException {
        final String currentLessonUri = Value.takeLessonUri.replace("$课程号", courseId).replace("$课序号", courseIndex);
        URI uri = new URIBuilder().setScheme(Value.protocol).setHost(Value.host).setPath(currentLessonUri).build();
        HttpPost takeLessonRequest = new HttpPost(uri);
        CloseableHttpResponse response = client.execute(takeLessonRequest);
        String responseContent = Utils.convertInputStreamToString(response.getEntity().getContent());
        TakeLessonResult takeLessonResult = JSON.parseObject(responseContent, TakeLessonResult.class);
        if ("error".equals(takeLessonResult.getResult())) {
            if (takeLessonResult.getMsg().endsWith("已选!")) {
                System.out.println("选课成功  message : " + takeLessonResult.getMsg());
                return 2;
            }
            if ( takeLessonResult.getMsg().endsWith("失败!")) {
                return 3;
            }
            if(takeLessonResult.getMsg().endsWith("冲突!")) {
                return 4;
            }
            System.out.println("选课失败  caused by : " + takeLessonResult.getMsg());
            return 0;
        } else if ("success".equals(takeLessonResult.getResult())) {
            System.out.println("选课成功 message ： " + takeLessonResult.getMsg());
            return 1;
        } else {
            System.out.println("无法处理响应 : " + responseContent + "出现此问题时请记录使用过程与开发者联系。。。");
            System.out.println("系统退出");
            System.exit(1);
            return -1;
        }
    }

    //输入并测试课程号和序列号是否正确
    public void inputCouseInfoAndTest() throws IOException, URISyntaxException {
        while (true) {
            getCouseInfo();
            System.out.println("正在测试 ...");
            int result = takeLesson();
            if (result == 3) {
                System.out.println("测试未通过 课程不存在 请检查课程号和序列号后重试");
                continue;
            }
            if(result == 4 ){
                System.out.println("测试未通过 课程时间发生冲突 请检查课程号和序列号后重试");
                continue;
            }
            System.out.println("测试成功");
            break;
        }
    }

    private void getCouseInfo() throws IOException {
        System.out.print("请输入课程号:");
        courseId = Utils.getReader().readLine().trim();
        System.out.print("请输入课序号:");
        courseIndex = Utils.getReader().readLine().trim();
    }
}
