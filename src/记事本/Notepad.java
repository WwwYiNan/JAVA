package 记事本;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Notepad {
    private static String filePath;
    private static String message = "";

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("--1:新建文件 2:打开文件 3:修改文件 4:保存 5:退出--");
        while (true) {
            System.out.println("请输入操作指令：");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    createFile();
                    break;
                case 2:
                    openFile();
                    break;
                case 3:
                    editFile();
                    break;
                case 4:
                    saveFile();
                    break;
                case 5:
                    exit();
                    break;
                default:
                    System.out.println("您输入的指令错误！");
                    break;
            }
        }
    }

    //新建文件  从控制台获取内容
    private static void createFile() {
        message = "";//新建文件时，暂存文件内容清空
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入内容，停止编写请输入\"stop\":");
        StringBuffer stb = new StringBuffer();//用于后期输入内容的拼接
        String inputMessage = "";
        while (!inputMessage.equals("stop")) {
            if (stb.length() > 0) {
                stb.append("\r\n");//追加换行符
            }
            stb.append(inputMessage);//拼接输入信息
            inputMessage = sc.nextLine();//获取输入信息
        }
        message = stb.toString();//将输入内容暂存
    }

    //打开文件
    private static void openFile() throws Exception {
        message = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入打开文件的位置：");
        filePath = sc.next();//获取打开文件的路径
        //控制台只能输入txt格式的文件路径
        if (filePath != null && !filePath.endsWith(".txt")) {
            System.out.print("请选择文本文件！！");
            return;
        }
        FileReader in = new FileReader(filePath);//实例化一个FileReader对象
        char[] charArry = new char[1024];//缓冲数组
        int len = 0;
        StringBuffer sb = new StringBuffer();
        //循环读取，一次读取一个字符数组
        while ((len = in.read(charArry)) != -1) {
            sb.append(charArry);
        }
        message = sb.toString();//将打开文件内容暂存
        System.out.println("打开内容为：" + "\r\n" + message);
        in.close();//释放资源

    }


    //修改文件内容  通过字符串替换的形式
    private static void editFile() {
        if (message == "" && filePath == null) {
            System.out.println("请先新建文件或者打开文件");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的内容（以\"修改的目标文字：修改后的文字\"格式）," + "停止修改请输入\"stop\":");
        String inputMessage = "";
        while (!inputMessage.equals("stop")) {                      //当输入stop时，停止修改
            if (inputMessage != null && inputMessage.length() > 0) {
                //将输入的文字根据“:” 拆分成数组
                String[] editMessage = inputMessage.split(":");
                if (editMessage != null && editMessage.length > 1) {
                    //根据输入的信息将文件中内容替换
                    message = message.replace(editMessage[0], editMessage[1]);
                }
            }
        }
        System.out.println("修改后的内容:" + "\r\n" + message);
    }

    //保存， 新建文件存在用户输入的路径  打开的文件将原文件覆盖
    private static void saveFile() throws Exception {
        Scanner sc = new Scanner(System.in);
        FileWriter out = null;
        if (filePath != null) {                                 //文件是由“打开”载入的
            out = new FileWriter(filePath);
        } else {                                                //新建文件
            System.out.println("请输入文件保存的绝对路径");
            String path = sc.next();                            //获取文件保存的路径
            filePath = path;
            //将输入路径中大写字母替换成小写字母后判断是不是文本格式
            if (!filePath.toLowerCase().endsWith(".txt")) {
                filePath += ".txt";
            }
            out = new FileWriter(filePath);//构造输出流
        }
        out.write(message); //写入暂存的内容
        out.close();        //关闭输出流
        message = "";       //修改文件前现将写入内容置空
        filePath = null;    //将文件路径至null
    }

    //退出
    private static void exit() {
        System.out.println("您已退出系统，谢谢使用！");
        System.exit(0);
    }
}
