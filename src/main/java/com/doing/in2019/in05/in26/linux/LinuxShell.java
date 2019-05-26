package com.doing.in2019.in05.in26.linux;

/**
 * @author Clyde
 * 2018-1-24
 * 
 * Shell 是什么？
 * 		shell 程序： 
 * 			1.接收键盘输入的命令
 * 			2.将命令传给操作系统执行
 * 
 * 用图形用户界面时
 * 		terminal 终端仿真器（也是shell程序）
 * 
 * 命令 是什么？
 * 		1.可执行程序
 * 		2.shell内置命令，例如 cd
 * 		3.shell函数
 * 		4.alias命令
 * 
 * 文件系统树
 * 		所有程序都视为一个文件
 * 
 * 多重任务
 * 		Linux 使用进程来管理多重任务同时执行
 */
public class LinuxShell {
	
	/**
	 * 命令  *
	 * 		exit	退出终端
	 * 
	 * 		q		退出当前命令
	 * 
	 * 		help	显示帮助文档
	 * 
	 * 		echo	显示一行文本				（第七章 透过 shell 看世界）
	 * 
	 * 		clear	清屏
	 * 
	 * 		history	显示历史列表的记录			（第八章 高级键盘技巧  -- 快捷键和组合按键）
	 * 
	 * 		pwd		显示当前工作目录
	 * 		ls		显示当前目录列表				（ls -x    or   ls ~/xx        or   ls -help 	or ls *c*）
	 * 		cd		改变目录					（ cd xxx   or   cd xxx/xx/x    or   cd .    or   cd .. ）
	 * 
	 * 		date	显示系统时间日期
	 * 		cal		显示当月日历
	 * 
	 * 		df		显示磁盘可用空间
	 * 		free	显示可用内存
	 * 		lsof	用于查看某一端口的占用情况				（lsof -i: ）
	 * 		netstat	网络工具，用于查看指定的端口号的进程情况	（netstat -tunlp |grep 8000）
	 * 
	 * 		file	查看文件类型
	 * 		less	查看文件内容
	 * 	
	 * 		w		查看当前有哪些用户登录，以及正在做什么操作
	 * 		who		查看系统当前有哪些用户登录
	 * 		last	查看最近有哪些用户登录过系统
	 * 		ac		查看系统总的连接时间
	 * 
	 * 
	 * 压缩命令：
	 * 		tar cvf		压缩打包（tar cvf example.tar *）
	 * 		tar xvf		解压文件（tar xvf example.tar）
	 * 		tar -tf		查看tar包中的内容（tar -tf example.tar）
	 * 		（gzip有高压缩率，但是只能逐个压缩，所以经常和tar配合使用；通常生成 .tar.gz 或 .tgz 后缀的文件）
	 * 		gzip file			将file文件压缩成file.gz
	 * 		gunzip file.gz		解压file.gz
	 * 
	 * 		（zip是windows系统广泛使用的压缩格式）
	 * 		zip file.zip		将file文件压缩成file.zip
	 * 		unzip file.zip		解压file.zip
	 * 
	 * 	
	 * 用户权限  *
	 * 		su		以另一用户身份运行shell		（su root 管理员权限 ）
	 * 		sudo	一另一用户身份执行命令
	 * 		passwd	更改用户密码		
	 * 		id		显示用户身份标识
	 * 		chmod	更改文件的模式，使用此命令进行权限设置
	 * 		umask	设置文件的默认权限	
	 * 		chown	更改文件所有者
	 * 		chgrp	更改文件所属群组
	 * 
	 * 
	 * 操作文件和文件夹  *
	 * 		fdisk	磁盘分区工具
	 * 		mkfs	将分区进行格式化
	 * 		mount	对创建的磁盘分区进行挂载
	 * 		cp		复制文件、文件夹
	 * 		mv		移动或重命名文件、文件夹
	 * 		mkdir	创建文件夹
	 * 		rm		移除文件、文件夹			（慎重使用rm，因为Linux不包含还原删除操作的命令! rm -rf xxx）
	 * 
	 * 		ln		?
	 * 
	 * 
	 * 命令。。。。。  *
	 * 		type		显示命令的类型				（type xx）
	 * 		which		显示会执行哪些可执行的程序
	 * 		man			显示命令的手册页				（man xx）
	 * 		apropos		显示一系列合适的命令			（apropos xx）
	 * 		info		显示命令的info条目
	 * 		whatis		显示一条命令的简述			（whatis xx）
	 * 
	 * 		alias		创建命令的别名				（即 定义自己的命令）
	 * 
	 * 		more		一次显示一屏信息
	 * 
	 * 
	 * I/O重定向  *
	 *		cat			合并文件		（例如cat /home，查看文件系统的类型）
	 * 		sort		对文本行排序
	 * 		uniq		报告或删除文件中的重复的行
	 * 		wc			打印文件中的换行符、字和字节的个数
	 * 		grep		打印匹配行，在文件中搜索指定的字符串
	 * 		head		输出文件的第一部分内容
	 * 		tail		输出文件的最后一部分内容		（tail ）
	 * 		tee			读取标准输入的内容，并将其内容输出到标准输出和文件中
	 * 
	 * 
	 * 进程  *		第十章 进程
	 * 		ps			显示当前所有运行进程
	 *		top			实时显示当前所有任务的资源占用情况
	 *		jobs		列出所有活动作业的状态信息
	 * 		bg			设置在后台中运行作业
	 *		fg			设置在前台中运行作业
	 * 		kill		发送信号给某个进程				?
	 * 		killall		杀死指定名字的进程				?
	 * 		shutdown	关机或重启系统
	 * 
	 * 
	 * 进程  *	
	 * 		printenv	打印部分或全部的环境信息
	 * 		set			设置shell选项
	 * 		export		将环境导出到随后要运行的程序中
	 * 
	 */
}
