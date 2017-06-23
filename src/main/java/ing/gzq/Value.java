package ing.gzq;

/**
 * Created by gzq on 17-6-23.
 */
public interface Value {

    String protocol = "http";

    String host = "bkjwxk.sdu.edu.cn";

    String loginAjaxUri = "/b/ajaxLogin";

    //根据实际情况替换$课程号和$课序号
    String takeLessonUri = "/b/xk/xs/add/$课程号/$课序号";


}
