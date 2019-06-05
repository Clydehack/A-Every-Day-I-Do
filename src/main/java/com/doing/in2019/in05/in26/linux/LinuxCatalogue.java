package com.doing.in2019.in05.in26.linux;

/**
 * 目录：是使用操作系统时经常涉及的基本工作
 */
public class LinuxCatalogue {

	/**
	 * 文件系统默认目录及功能
	 * 
	 * 		/					Linux文件系统的最上层根目录，其他所有目录军事该目录的子目录
	 * 		/bin				Binary，存放用户的可执行程序，例如cp、mv等；也存放shell，例如bash、csh；（不应把该目录放到一个单独的分区中！）
	 * 		/boot				操作系统启动时使用，Don't touch anything
	 * 		/dev				设备文件目录，（/dev/sda表示第一块SCSI设备）（/dev/hda表示第一块IDE设备）
	 * 		/etc				有关系统设置与管理的（配置）文件，包括密码、守护程序及X-Window相关的配置。可以用VIM打开并编辑相关的配置文件
	 * 		/etc/X11			X-Window System的配置目录
	 * 		/home				普通用户的主目录，或FTP站点目录（一般存放在/home目录下）
	 * 		/lib				存放共享函数库（library）
	 * 		/mnt				文件系统挂载点，（光盘的挂载点可以是/mnt/cdrom）（软盘的挂载点可以是/mnt/floppy）（ZIP驱动器为/mnt/zip）
	 * 		/opt				通常提供给较大型的第三方应用程序使用，装到/opt目录下的程序，它所有的数据、库文件等等都是放在同个目录下面。删除的时候，只需删除/opt/xxx目录即可，非常简单。
	 * 		/proc				保存了目前系统内核和程序执行的相关信息，（/proc/interrupts保存了当前分配的中断请求端口号）（/proc/cpuinfo保存了当前处理器信息）
	 * 		/root				根目录主目录
	 * 		/sbin				System Binary，存放系统启动时所需执行的系统程序
	 * 		/tmp				temporary，用来存放临时文件的目录
	 * 		/usr				存放用户使用的系统命令和应用程序
	 * 		/usr/bin			存放用户可执行的程序，例如OpenOffice的可执行程序
	 * 		/usr/doc			存放各种文档的目录
	 * 		/usr/include		存放C语言用到的头文件
	 * 		/usr/include/X11	存放X-Window程序使用的头文件
	 * 		/usr/info			存放GNU稳定的目录
	 * 		/usr/lib			函数库
	 * 		/usr/lib/X11		X-Window的函数库
	 * 		/usr/local			提供自动安装的应用程序位置
	 * 		/usr/man			存放在线手册的目录
	 * 		/usr/sbin			存放用户经常使用的程序
	 * 		/usr/src			此目录用于保存程序的源文件，（一般系统的内核源码存放在/usr/src/Linux）
	 * 		/usr/X11R6/bin		存放X-Window的可执行程序
	 * 		/var				variable，存放日志、邮件等经常变化的文件。/var目录的大小经常变动，建议将/var安装到独立分区上，避免侵占其他目录需要的空间
	 */
}