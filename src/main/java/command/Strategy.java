package command;

/**
 * @Author: tongqianwen
 * @Date: 2024/12/3
 */
public interface Strategy {
    /**
     * 处理命令
     * @param input 输入参数
     * @return 打印输出
     */
    String command(String input);
}
