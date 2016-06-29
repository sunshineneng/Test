import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestFile {
    public static void main(String[] args) {
        /*Date date = new Date(); // 新建一个日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 格式化日期
        String beforeDate = sdf.format(getDateBefore(date, 30));
        System.out.println(beforeDate);
        String afterDate = sdf.format(getDateAfter(date, 10));
        System.out.println(afterDate);*/

        String originalStr = "中国人民银行授权中国外汇交易中心公布，2016年6月27日银行间外汇市场人民币汇率中间价为：" +
                "1美元对人民币6.6375元，1欧元对人民币7.3184元，100日元对人民币6.5042元，1港元对人民币0.85522元，" +
                "1英镑对人民币8.9194元，1澳大利亚元对人民币4.9384元，1新西兰元对人民币4.7149元，1新加坡元对人民币4.8883元，" +
                "1瑞士法郎对人民币6.8279元，1加拿大元对人民币5.0850元，人民币1元对0.61570林吉特，人民币1元对9.8737俄罗斯卢布, " +
                "人民币1元对2.2855南非兰特，人民币1元对176.31韩元。";
        String str = originalStr.substring(originalStr.indexOf("美元") + 2, originalStr.length());
        String exchangeRateOfDollar = str.substring(4, str.indexOf("元"));
        //System.out.println(exchangeRateOfDollar);
        //str =  originalStr;
        str = originalStr.substring(originalStr.indexOf("欧元") + 2, originalStr.length());
        String exchangeRateOfEUR = str.substring(4, str.indexOf("元"));
        //System.out.println(exchangeRateOfEUR);
        str = originalStr.substring(originalStr.indexOf("港元") + 2, originalStr.length());
        String exchangeRateOfHK = str.substring(4, str.indexOf("元"));
        System.out.println(exchangeRateOfHK);
    }

    /**
     * 得到几天前的时间
     */

    public static Date getDateBefore(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return now.getTime();
    }

    /**
     * 得到几天后的时间
     */

    public static Date getDateAfter(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return now.getTime();
    }


    public static boolean compareDate(String DATE1, String DATE2) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() >= dt2.getTime()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception exception) {
            return false;
        }
    }
}