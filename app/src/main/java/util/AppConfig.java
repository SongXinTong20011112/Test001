package util;

public class AppConfig {

    public static String Title = "";
    public static String Content = "";
    public static int Image;

    //在使用安卓虚拟器时，默认情况下是无法直接通过 127.0.0.1 访问主机（电脑）的本地服务器的，
    // 因为 127.0.0.1 在虚拟器中指向的是虚拟器本身的回环地址。而是使用 10.0.2.2 来访问主机（电脑）的 127.0.0.1。
//    public static String IP = "10.0.2.2";//本机服务器
//    public static String dk = "8080";//本机
//    public static String IP = "192.168.0.103";//本机服务器(此电脑IPv4)
    public static String IP = "120.27.156.104";//云服务器地址
    public static String dk = "31001";//服务器端口号
    public static String url = "http://" + AppConfig.IP + ":" + AppConfig.dk;
    public static String token = "";
    public static String Address = "http://" + AppConfig.IP + ":" + AppConfig.dk + "";
    public static int newNumber = 0 ;
    public static int pjNewsNumber = 0;
    public static String newType = "";
    public static int pjNewsPosition = 0;
}
