### 乐淘在线商城
### 技术描述：
该项目基于JavaWeb，前端使用Vue和vue-admin-template模板，后端SpringBoot，通过axios在前后端发送请求
### 登录模块：
前台进行非空验证，后台UserController中@PostMapping("login")接收到用户名和密码，并将用户名和密码传出输到Service层中对应的方法进行逻辑判断。Service中对参数进行非空校验，若是有误返回提示信息，将接收到的参数传递给Dao层查询数据库验证用户存在性和密码的正确性。在Controller中根据service的返回信息判断用户是否登入成功，若是成功将用户信息存储到session中，便于前台获取。
### 初始化模块：
用户访问商城首页时，首页初始化显示热卖商品推荐和商品巡回展示栏。左侧菜单栏可以点击进行分类查询，顶部搜索框可以利用关键字进行查询。页面的动态展示实现于在页面初始化时，后台开始查询数据库，获取到相应的数据，然后将这些数据存储到list中，转为JSON格式的数据，便于前台使用数据进行展示
### 个人中心：
用户登录后直接进入首页，首页动态展示初始化模块。左侧选择栏选择“账户”，可以对个人信息进行修改。同时左侧选择栏可以查看订单信息，购物车信息
### 购物车模块：
用户浏览商品时可以将商品加入购物车，后台将该商品id加入到购物车表，该表是user和商品的中间表，将用户id和商品id关联实现购物车功能
### 后台管理模块：
管理员登录后导航栏出现后台管理按钮，后台有用户模块，对用户信息进行增删改差；商品模块，对商品进行增删该查；类型模块，对商品类型进行管理，同样是增删该查；报表模块，统计商品数据和销售数据，以列表的形式展现。
