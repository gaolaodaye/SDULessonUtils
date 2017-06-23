package ing.gzq;

/**
 * Created by gzq on 17-6-23.
 */
public class TakeLessonResult {

    private String result;

    private String msg;

    private Object object;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "TakeLessonResult{" +
                "result='" + result + '\'' +
                ", msg='" + msg + '\'' +
                ", object=" + object +
                '}';
    }
}
