package ing.gzq;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import sun.nio.ch.ThreadPool;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by gzq on 17-6-23.
 */
public class Client {

    private String usernanme;

    private String password;

    private LessonTaker[] lessonTaker;

    private int count;

    private ExecutorService threadPool;


    private CloseableHttpClient client = HttpClients.createDefault();

    public void login() throws IOException, URISyntaxException {
        System.out.println("欢迎使用山东大学抢课助手");
        while (true) {
            getUserInfo();
            if (sendLoginRequest(usernanme, password)) break;
            if (!Utils.checkIfContinue()) break;
        }
    }

    public void askHowMuchCourse() throws IOException {
        System.out.print("你要抢几门课:（建议不要超过3门）");
        while (true) {
            try {
                count = Integer.parseInt(Utils.getReader().readLine().trim());
                if (count <= 0) {
                    System.out.print("你还抢不抢？ 请重新输入 :");
                    continue;
                }
                if (count > 3) {
                    System.out.println("说了不超过3门 请重新输入 :");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.print("请输入数字：");
            }
        }
    }

    public void perpare() throws IOException, URISyntaxException {
        assert count > 0 && count <= 3;
        lessonTaker = new LessonTaker[count];
        for (int i = 0; i < lessonTaker.length; i++) {
            System.out.println("配置并测试第 " + (i + 1) + " 个课程");
            lessonTaker[i] = new LessonTaker(client);
            lessonTaker[i].inputCouseInfoAndTest();
        }
        System.out.println("测试完成...即将开始抢课...");
    }

    public void start() {
        System.out.println("开始抢课...");
        threadPool = Executors.newFixedThreadPool(count * 3);
        for (LessonTaker taker : lessonTaker) {
            for (int i = 0; i < 3; i++) {
                threadPool.submit(taker);
            }
        }

    }

    private void getUserInfo() throws IOException {
        System.out.println("请输入山东大学选课系统登录信息");
        System.out.print("username:");
        usernanme = Utils.getReader().readLine().trim();
        System.out.print("password:");
        password = Utils.getReader().readLine().trim();
    }

    private boolean sendLoginRequest(String username, String password) throws IOException, URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder().setScheme(Value.protocol).setHost(Value.host).setPath(Value.loginAjaxUri);
        List<NameValuePair> formparams = new ArrayList<>();
        formparams.add(new BasicNameValuePair("j_username", username));
        formparams.add(new BasicNameValuePair("j_password", password));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
        HttpPost httpPost = new HttpPost(uriBuilder.build());
        httpPost.setEntity(entity);
        CloseableHttpResponse response = client.execute(httpPost);
        String result = Utils.convertInputStreamToString(response.getEntity().getContent()).trim();
        if ("\"success\"".equals(result)) {
            System.out.println("登录成功");
            return true;
        } else if ("\"对不起,用户名或密码错误!\"".equals(result)) {
            System.out.println(result);
            return false;
        }
        return false;
    }
}

