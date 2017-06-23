package ing.gzq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by gzq on 17-6-22.
 */
public class Utils {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static BufferedReader getReader(){
        return reader;
    }

    public static boolean checkIfContinue() throws IOException {
        System.out.print("是否重试？（y or n）");
        while (true) {
            switch (reader.readLine()) {
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    System.out.print("输入不合法,请重新输入:");
                    break;
            }
        }
    }

    public static String convertInputStreamToString(InputStream in) throws IOException {
        StringBuilder sb = new StringBuilder();
        byte[] buf = new byte[1024];
        int length = 0;
        while ((length = in.read(buf)) != -1) {
            sb.append(new String(buf));
        }
        return sb.toString();
    }
}
