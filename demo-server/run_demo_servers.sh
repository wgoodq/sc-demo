# 查询原有进程
echo 'demo-server threads: '
ps -ef | grep demo-server | grep -Ev 'grep | run_demo_servers.sh'

# 终止原有进程
ps -ef | grep demo-server | grep -Ev 'grep | run_demo_servers.sh' | awk '{print $2}' | xargs kill -9
echo 'killing them...'
sleep 1

# 检查终止结果
echo 'demo-server threads: '
ps -ef | grep demo-server | grep -Ev 'grep | run_demo_servers.sh'
echo ''

# 分割线
echo '------------Closed------------All------------Servers------------'

# 编译工程
gradle clean build

# 启动注册中心集群
nohup java -jar ./build/libs/demo-server-0.0.1.jar --server.port=2101 > ./build/libs/demo_server_1.log 2>&1 &
nohup java -jar ./build/libs/demo-server-0.0.1.jar --server.port=2102 > ./build/libs/demo_server_2.log 2>&1 &
tail -f ./build/libs/demo_server_1.log