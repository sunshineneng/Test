import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 16-6-28
 * Time: 下午6:06
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    public static void main(String[] args) {
        String str = "import java.util.HashMap;";
        int lasindex = str.lastIndexOf(".");

        System.out.println(str.substring(lasindex+1,str.length()-1));

    }

    public static void processFile() throws FileNotFoundException, IOException, IOException {
        StringBuffer strSb = new StringBuffer(); //String is constant， StringBuffer can be changed.
        InputStreamReader inStrR = new InputStreamReader(new FileInputStream("access_log.log")); //byte streams to character streams
        BufferedReader br = new BufferedReader(inStrR);
        String line = br.readLine();
        while (line != null) {
            strSb.append("ip ").append(line).append("\r\n");
            line = br.readLine();
        }

        FileWriter fileWritter = new FileWriter(new File("access_log.log").getName());
        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
        bufferWritter.write(strSb.toString());
        bufferWritter.flush();
        bufferWritter.close();
    }
}
