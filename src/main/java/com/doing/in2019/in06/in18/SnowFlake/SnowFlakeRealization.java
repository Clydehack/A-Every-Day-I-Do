package com.doing.in2019.in06.in18.SnowFlake;

/**
 * 雪花算法 - 生成分布式唯一标识的实现，"世界上没有一片雪花是相同的"，这大概是snowflake名字的由来吧。还 可在此基础上进一步优化。
 */
public class SnowFlakeRealization {

	/**
	 * 跑起来一测
	 */
	public static void main(String[] args) {
		SnowFlakeRealization snowFlake = new SnowFlakeRealization(2, 3);

		for (int i = 0; i < (1 << 12); i++) {
			System.out.println(snowFlake.nextId());
		}

	}

	/**
	 * 起始的时间戳（最后的时间 = 当前时间戳 - 起始的时间戳)
	 */
	private final static long START_STMP = 1480166465631L;

	/**
	 * 每一部分占用的位数
	 */
	private final static long SEQUENCE_BIT = 12; 	// 序列号占用的位数
	private final static long MACHINE_BIT = 5; 		// 机器标识占用的位数
	private final static long DATACENTER_BIT = 5;	// 数据中心占用的位数

	/**
	 * 每一部分的最大值
	 */
	private final static long MAX_DATACENTER_NUM = -1L ^ (-1L << DATACENTER_BIT);
	private final static long MAX_MACHINE_NUM = -1L ^ (-1L << MACHINE_BIT);
	private final static long MAX_SEQUENCE = -1L ^ (-1L << SEQUENCE_BIT);

	/**
	 * 每一部分向左的位移
	 */
	private final static long MACHINE_LEFT = SEQUENCE_BIT;
	private final static long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
	private final static long TIMESTMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;

	private long datacenterId; 		// 数据中心
	private long machineId; 		// 机器标识
	private long sequence = 0L; 	// 序列号
	private long lastStmp = -1L; 	// 上一次时间戳

	public SnowFlakeRealization(long datacenterId, long machineId) {
		// 校验datacenterId长度超过范围就抛异常
		if (datacenterId > MAX_DATACENTER_NUM || datacenterId < 0) {
			throw new IllegalArgumentException("datacenterId can't be greater than MAX_DATACENTER_NUM or less than 0");
		}
		// 校验machineId长度超过范围就抛异常
		if (machineId > MAX_MACHINE_NUM || machineId < 0) {
			throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
		}
		this.datacenterId = datacenterId;
		this.machineId = machineId;
	}

	/**
	 * 产生下一个ID
	 *
	 * @return
	 */
	public synchronized long nextId() {
		long currStmp = getNewstmp();
		if (currStmp < lastStmp) {
			throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
		}

		if (currStmp == lastStmp) {
			// 相同毫秒内，序列号自增
			sequence = (sequence + 1) & MAX_SEQUENCE;
			// 同一毫秒的序列数已经达到最大
			if (sequence == 0L) {
				currStmp = getNextMill();
			}
		} else {
			// 不同毫秒内，序列号置为0
			sequence = 0L;
		}

		lastStmp = currStmp;
		// 使用二进制的"|"运算符将4部分的值整合成我们需要的id
		return (currStmp - START_STMP) << TIMESTMP_LEFT 	// 时间戳部分
				| datacenterId << DATACENTER_LEFT 			// 数据中心部分
				| machineId << MACHINE_LEFT 				// 机器标识部分
				| sequence; 								// 序列号部分
	}

	// 如果当前毫秒值下的序列号用完，就循环获取下个毫秒值，如果没有获取到下个毫秒值就
	// 一直循环下去
	private long getNextMill() {
		long mill = getNewstmp();
		while (mill <= lastStmp) {
			mill = getNewstmp();
		}
		return mill;
	}

	private long getNewstmp() {
		return System.currentTimeMillis();
	}
}
