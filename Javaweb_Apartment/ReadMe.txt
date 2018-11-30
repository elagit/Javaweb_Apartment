开发流程

1. 搭建开发环境
	1.1 导入开发包
		mysql驱动
		DBUtils开发包
		JSTL开发包
	1.2 创建程序包
		dao
		dao.impl
		service
		service.impl
		servlet
		model
		utils
		WebContent\view(存放JSP页面)
		WebContent\css(存放CSS页面)
		WebContent\js(存放js页面)
	1.3 创建数据库
		init.sql
	1.4 一些工具类
		DBUtil 			获取数据库连接
		DSUtil 			时间与字符串转换
		PageUtil		分页
		SwitchUtil		Delete选择
2. 实现功能
	2.1 房屋信息的展示，增加，编辑和删除
	2.2 合同信息的展示，增加，编辑和删除
	2.3 租金信息的展示，增加，编辑和删除
	2.4	租户信息的展示，增加，编辑和删除
	2.5 简单的权限设置
		2.5.1 对未登录的用户进行session判断并拦截
		2.5.2 对不具备删除功能的用户进项session判断并拦截
