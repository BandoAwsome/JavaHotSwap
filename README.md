# JavaHotSwap
Java热更新Demo，基于agentmain。
## 工程说明
JavaAgent - 代理，需要通过maven package 和 maven install至本地，里面包含agentmain入口  
JavaHotSwap - 测试热更工程
## 启动方式
1.mvn package & mvn install JavaAgent, 配置agentmain.jar路径和需要最后替换的目标.class文件  
2.启动JavaHotSwap中Main类  
3.启动JavaHotSwap中HotSwap类，动更完成

