package hash.bloom_filter;

import com.google.common.hash.Funnels;
import com.google.common.hash.Hashing;
import redis.clients.jedis.Jedis;

import java.nio.charset.Charset;

/**
 * @Author zhangyu
 * @Date 2020/6/13
 * @Description
 **/

public class BloomFilterRedis {
    /**
     * 要插入多少数据
     */
    static final int expectedInsertions = 100;
    /**
     * 期望的误判率
     */
    static final double fpp = 0.01;
    /**
     * bit数组长度
     */
    private static long numBits;
    /**
     * hash函数数量
     */
    private static int numHashFunctions;

    static {
        numBits = optimalNumOfBits(expectedInsertions, fpp);
        numHashFunctions = optimalNumOfHashFunctions(expectedInsertions, numBits);
    }

    /**
     * @return long[]
     * @Title 根据key获取bitmap下标
     * @Description 根据key获取bitmap下标
     * @Author long.yuan
     * @Date 2020/2/15 23:28
     * @Param [key]
     **/
    private static long[] getIndexs(String key) {
        long hash1 = hash(key);
        long hash2 = hash1 >>> 16;
        //构建哈希函数数量大小的数组，单个数据插入到BitMap多个位置
        long[] result = new long[numHashFunctions];
        for (int i = 0; i < numHashFunctions; i++) {
            long combinedHash = hash1 + i * hash2;
            if (combinedHash < 0) {
                //取反运算
                combinedHash = ~combinedHash;
            }
            //取模运算到BitMap位置中
            result[i] = combinedHash % numBits;
        }
        return result;
    }

    /**
     * @return long
     * @Title Hash方法
     * @Description Hash方法
     * @Author long.yuan
     * @Date 2020/2/15 23:28
     * @Param [key]
     **/
    private static long hash(String key) {
        Charset charset = Charset.forName("UTF-8");
        return Hashing.murmur3_128().hashObject(key, Funnels.stringFunnel(charset)).asLong();
    }

    /**
     * @return int
     * @Title 计算hash函数个数
     * @Description 计算hash函数个数
     * @Author long.yuan
     * @Date 2020/2/15 23:28
     * @Param [n, m]
     **/
    private static int optimalNumOfHashFunctions(long n, long m) {
        return Math.max(1, (int) Math.round((double) m / n * Math.log(2)));
    }

    /**
     * @return long
     * @Title 计算bit数组长度
     * @Description 计算bit数组长度
     * @Author long.yuan
     * @Date 2020/2/15 23:28
     * @Param [n, p]
     **/
    private static long optimalNumOfBits(long n, double p) {
        if (p == 0) {
            p = Double.MIN_VALUE;
        }
        return (long) (-n * Math.log(p) / (Math.log(2) * Math.log(2)));
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.auth("连接密码");
        for (int i = 0; i < 100; i++) {
            long[] indexs = getIndexs(String.valueOf(i));
            for (long index : indexs) {
                //将当前数据匹配的哈希位置设值到Redis库中
                jedis.setbit("felix:hash_table.bloom", index, true);
            }
        }
        for (int i = 0; i < 100; i++) {
            long[] indexs = getIndexs(String.valueOf(i));
            for (long index : indexs) {
                Boolean isContain = jedis.getbit("felix:hash_table.bloom", index);
                if (!isContain) {
                    System.out.println(i + "肯定没有重复");
                }
            }
            System.out.println(i + "可能重复");
        }
    }
}