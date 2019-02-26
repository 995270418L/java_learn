# 责任链模式
* 首先得有条链(AbstractChain)
* 请求在链上传递(setAbstractChain方法)
* 请求并不知道链上哪个对象去处理它(setLeave方法判断)