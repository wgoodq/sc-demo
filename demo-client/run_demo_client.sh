# 查询原有进程
echo 'demo-client threads: '
ps -ef | grep demo-client | grep -Ev 'grep | run_demo_client.sh'

# 终止原有进程
ps -ef | grep demo-client | grep -Ev 'grep | run_demo_client.sh' | awk '{print $2}' | xargs kill -9
echo 'killing them...'
sleep 1

# 检查终止结果
echo 'demo-client threads: '
ps -ef | grep demo-client | grep -Ev 'grep | run_demo_client.sh'
echo ''

# 分割线
echo '------------Closed------------All------------Servers------------'

# 编译工程
gradle clean build

# 启动注册中心集群
nohup java -jar ./build/libs/demo-client-0.0.1.jar > ./build/libs/demo_client_1.log 2>&1 &
tail -f ./build/libs/demo_client_1.log