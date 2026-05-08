module.exports = { // actcampus
	PROJECT_COLOR: '#A1185E',
	NAV_COLOR: '#ffffff',
	NAV_BG: '#A1185E',

	// setup
	SETUP_CONTENT_ITEMS: [
		{ title: '关于我们', key: 'SETUP_CONTENT_ABOUT' },
		{ title: '用户注册使用协议', key: 'SETUP_YS' }
	],

	// 用户 
	USER_FIELDS: [

	],


	NEWS_NAME: '公告',
	NEWS_CATE: [
		{ id: 1, title: '通知公告' },
		{ id: 2, title: '会员风采' },
		{ id: 3, title: '会员推荐' },
		{ id: 4, title: '会员之星' },
	],
	NEWS_FIELDS: [
		{ mark: 'desc', type: 'textarea', title: '简介', must: true, min: 2, max: 200 },
		{ mark: 'content', title: '详细内容', type: 'content', must: true },
		{ mark: 'cover', type: 'image', title: '封面图', must: true, min: 1, max: 1 },
	],


	ACTIVITY_NAME: '活动',
	ACTIVITY_CATE: [
		{ id: 1, title: '入会申请' },
		{ id: 2, title: '活动报名' },
		{ id: 3, title: '讲座培训' },
		{ id: 4, title: '公益活动' },

	],
	ACTIVITY_FIELDS: [
		{ mark: 'cover', title: '活动封面', type: 'image', min: 1, max: 1, must: true },
		{ mark: 'desc', title: '活动内容', type: 'content', must: true },
	],
	ACTIVITY_JOIN_FIELDS: [
		{ mark: 'name', type: 'text', title: '姓名', must: true, max: 30 },
    { mark: 'phone', type: 'mobile', title: '手机', must: true, edit: false },
    { mark: 'company', type: 'text', title: '公司', must: true, edit: false },
    { mark: 'position', type: 'text', title: '职位', must: true, edit: false },
    { mark: 'email', type: 'text', title: '邮箱', must: true, edit: false },
    { mark: 'numbers', type: 'int', title: '参与人数', must: true, edit: false, val:1 },
    {
      mark: 'require',                    // 字段标识
      type: 'checkbox',                 // 类型为复选框
      title: '服务需求',                 // 字段标题
      must: true,                       // 是否必填
      checkBoxLimit: 1,                 // 至少选择数量
      disabled: false,                  // 是否禁用
      selectOptions: [                   // 选项数据源
        { label: '用餐（如有忌口或特殊饮食要求，请在备注中说明）', val: 'eat', disabled: false },
        { label: '住宿（如需协助预订酒店，请在备注中注明房型及入住日期）', val: 'acco', disabled: false },
        { label: '接送（如需安排接驳，请在备注中注明抵达时间、地点）', val: 'pick', disabled: false },  // 可单独禁用某个选项
      ],
      val: ['eat', 'acco','pick'],        // 当前选中的值（数组）
      ext: {
        show: 'row',                     // 显示方式：'row' 行内显示，不设置则列显示
        multiModeLabelMark: 'label',      // 显示的文本字段名，默认'label'
        multiModeValMark: 'val',          // 值的字段名，默认'val'
        hint: ''         // 提示信息
      },
      focus: ''              // 错误提示
    },

    { mark: 'remark', type: 'textarea', title: '备注/具体需求', must: true, edit: false },
  ],
  //会员入会信息
  VIP_ACTIVITY_JOIN_FIELDS: [
		{ mark: 'name', type: 'text', title: '姓名', must: true, max: 30 },
    { mark: 'phone', type: 'mobile', title: '手机', must: true, edit: false },
    { mark: 'company', type: 'text', title: '公司', must: true, edit: false },
    { mark: 'position', type: 'text', title: '职位', must: true, edit: false },
    { mark: 'email', type: 'text', title: '邮箱', must: true, edit: false },
	],
}