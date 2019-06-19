package com.doing.in2019.in06.in02.OOP_OOAD;

public class ReadMe {

	/**
	 * 使用UML进行设计
	 * 
	 * 
	 * OO	- 面向对象（ Object-Orientation）
	 * 		- 是一种系统建模技术
	 * 
	 * 
	 * OOP	- 面向对象编程（ Object-Orientation Programming）
	 * 		- 是按照OO的方法学来开发程序的过程
	 * 		- 通过分析系统内对象的交互来描述或建模一个系统
	 * 		- 交互的对象最终以类的形式组织
	 * 				1.抽象 - 忽略掉一个对象或实体的细节，只关注其本质特征的过程；帮助用户与对象交互
	 * 				2.封装 - 提供公共方法供用户调用功能，对象的两种视图（--外部视图：对象能做的工作  --内部视图：对象如何完成工作）
	 * 				3.继承 - 通常在两个类型之间存在“is a”或“kind of”这样的关系（苹果“is a”水果），通过继承可实现代码重用
	 * 				4.多态 - 一个名称，多种形式（调用方法时根据所给的对象的不同选择不同的处理方式）（Football—play()-使用脚来完成   Basketball—play()-使用手来完成）
	 * 				5.关联 - 当一个对象通过另一个对象的引用去使用另一个对象的服务或操作时，两个对象之间便产生了关联（person使用computer，person与computer之间就存在了关联关系）
	 * 				6.聚合 - 一个对象成为另外一个对象的组成部分（汽车与轮胎，汽车可以换新轮胎，轮胎也可以卸下来给其它汽车使用）
	 * 				7.组合 - 一个对象包含另一个对象，关联关系中最为强烈的一种（电视机与显示屏，显示屏离开电视机没有作用）
	 * 		- 域模型（设计模型）
	 * 				- 具有状态和行为
	 * 				- 域对象之间的关系（多对一单向关联，一对多单向关联，一对多双向关联 ）
	 * 				内聚：度量一个类独立完成某项工作的能力。
	 * 				耦合：度量系统内或系统之间依赖关系的复杂度。
	 *				设计原则：增加内聚，减少耦合（高内聚，低耦合）
	 * 
	 * 
	 * OOAD	- 是根据OO的方法学，对软件系统进行分析和设计的过程
	 * 		- OOA 分析阶段（此阶段要解决的核心问题是“What to do?”）
	 * 				1.列出系统必须完成的核心任务
	 * 				2.针对问题域建立公共词汇表
	 * 				3.列出针对此问题的最佳解决方案
	 * 		- OOD 设计阶段（此阶段要解决的核心问题是“How to do?”）
	 * 				1.如何解决具体的业务问题
	 * 				2.引入系统工作所需的支持元素
	 * 				3.定义系统的实现策略
	 * 		- OOAD的开发过程
	 * 				1.大项目分解为一些子项目
	 * 				2.使用UML工具
	 * 				3.统一软件开发过程是一个迭代、递增的开发过程。
	 * 					- 选择并分析相关用例
	 * 					- 根据所选架构进行设计
	 * 					- 在组件层次实现设计
	 * 					- 验证组件满足用例的需要
	 * 
	 * 
	 * Domain Model	- 面向对象架构模式之：领域模型
	 * 		- 四色原型模式分析模式能够让我们找出业务当中的核心模型，通过核心模型具备的共性特征将其提取出来，这样将能达到业务层的高度抽象。
	 * 		- 可以将一个复杂的系统划分成一块一块，从而有助于设计实现，当我们一个系统有好几百个类图时，如果不采取四色原型进行归类...
	 * 		- 面向对象的一个很重要的点就是：“把事情交给最适合的类去做”，即：“你得在一个个领域类之间跳转，才能找出他们如何交互”
	 * 		- DDD
	 * 
	 * 
	 * 方法都差不多：
	 * 		1.用一段话描述业务
	 * 		2.对业务进行抽象（使用名词动词方法）
	 * 		3.画出抽象实体间的关系
	 * 		4.将DM模型映射成ER表
	 * 		5.敲代码
	 * 		6.代码可维护，健壮，尽可能简单，即可！
	 * 
	 * 
	 * 传统开发过程（瀑布模型）
	 * 统一软件开发过程（USDP）
	 * 
	 * 
	 * 其他：
	 * 	
	 * 		初始化阶段：
	 * 			项目启动
	 * 			建立业务
	 * 			定义业务问题域
	 * 			找出主要的风险因素
	 * 			定义项目需求的外延
	 * 			创建业务问题域的相关说明文档
	 * 
	 * 		细化阶段：
	 * 			高层的分析与设计
	 * 			建立项目的基础框架
	 * 			监督主要的风险因素
	 * 			制订达成项目目标的创建计划
	 * 			
	 * 		构建阶段：
	 * 			代码及功能的实现
	 * 			
	 * 		移交阶段：
	 * 			向用户发布产品
	 * 			beta测试
	 * 			执行性能调优，用户培训和接收测试
	 * 			
	 * 		每一个阶段所含工作流：
	 * 			每一次递增都由5部分工作流组成
	 * 			需求与初始分析
	 * 			分析
	 * 			设计
	 * 			实现
	 * 			测试
	 * 			每一次迭代执行工作流的深度不同
	 * 			早期的迭代在深度上覆盖初始工作流，后期迭代在深度上覆盖后期工作流。
	 * 			80/20原则
	 * 			
	 * 		迭代、递增生命周期的优势：
	 * 			降低成本
	 * 			便于更好地维护项目进度
	 * 			便于团队的协作开发
	 * 			便于适应用户需求的动态变化
	 */
}