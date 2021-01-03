package bloom;

/**
 * @Author zhangyu
 * @Date 2020/6/7
 * @Description
 **/

public class Main {

    public static void main(String[] args) {
        long l = WorkerID.nextId();
        System.out.println(l);
    }
}


class WorkerID {

    //序列化
    private static int serialId;
    //机器编号
    private static int machineId = 1;
    //当前时间戳
    private static long curTimestamp;
    //上一个时间戳
    private static long lastTimestamp;

    //序列化阈值
    private final static int threshold = 4095;

    public static long nextId() {
        if (curTimestamp == lastTimestamp) {
            curTimestamp = System.currentTimeMillis();
            serialId = 0;
        } else {
            if (serialId > threshold) {
                curTimestamp = System.currentTimeMillis();
                serialId = 0;
            } else {
                serialId++;
            }
        }
        lastTimestamp = curTimestamp;

        return (curTimestamp << 22 | machineId << 12 | serialId);
    }


}
